package com.user.service.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.User;
import com.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User>createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User>getSingleUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	
	

}
