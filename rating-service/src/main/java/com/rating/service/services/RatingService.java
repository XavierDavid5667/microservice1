package com.rating.service.services;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	//getAllRatings
	List<Rating> getAllRatings();
	
	//getAllByUserIdId
	List<Rating> getRatingsByUserId(Integer userId);
	
	//getAllByHotel
	List<Rating> getRatingByHotelId(Integer hotelId);

}
