package com.user.service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.client.HotelFeignClient;
import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
   
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelFeignClient hotelFeignClient;
	
	private Logger log=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {	

		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		//get User from database with the help of user repositroy
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource with "+userId+" does not exit"));
		
		//fetch rating of the above user from rating service
		//http://localhost:8083/ratings/getAllRatingByUserId/2
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/getAllRatingByUserId/"+user.getUserId(), Rating[].class);
		log.info("{} ", ratingsOfUser);
		List<Rating> ratings= Arrays.stream(ratingsOfUser).collect(Collectors.toList());
		
		
		
		//update ratingList with hotel information
		List<Rating> ratingList = ratings.stream().map(rating->{
			//api call to hotel service to get the hotel
			//http://localhost:8082/hotels/getHotel/1
			
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotel/"+rating.getHotelId(), Hotel.class);
		   //Hotel hotel = forEntity.getBody();
			
			Hotel hotel = hotelFeignClient.getHotel(rating.getHotelId());
			
			
			
			//set the hotel to rating
			rating.setHotel(hotel);
			//return the rating
			return rating;
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
	
		return user;
	}

}
