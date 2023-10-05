package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
   
	@Autowired
	RatingService ratingService;
	
	//create rating
	@PostMapping("/createRating")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		Rating ratingobj = ratingService.create(rating);
		return new ResponseEntity<Rating>(ratingobj,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> allRatings = ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(allRatings,HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatingByUserId/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Integer userId){
		List<Rating> ratingsByUserId = ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingsByUserId,HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatingByHotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Integer hotelId){
		List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingByHotelId,HttpStatus.OK);
	}
	
	
}
