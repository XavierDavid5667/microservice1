package com.hotel.service.controller;

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

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	//create
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createHotel = hotelService.createHotel(hotel);
		return  new ResponseEntity<Hotel>(createHotel,HttpStatus.CREATED);
	}
	
	//getSingle
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel>getHotel(@PathVariable Integer hotelId){
		Hotel hotel = hotelService.get(hotelId);
		return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
	}

	//getAll
	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>>getAllHotels(){
		List<Hotel> list = hotelService.getAll();
		return new ResponseEntity<List<Hotel>>(list,HttpStatus.OK);
	}

}
