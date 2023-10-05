package com.hotel.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;
	
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(int hotelId) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Resource wiht given id does not exist"));
	}
	

}
