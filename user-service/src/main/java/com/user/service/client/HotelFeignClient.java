package com.user.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelFeignClient {
	
	@GetMapping("/hotels/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable Integer hotelId);
		
		
	

}
