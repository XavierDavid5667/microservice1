package com.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	//Here you can implement custom method or query
}
