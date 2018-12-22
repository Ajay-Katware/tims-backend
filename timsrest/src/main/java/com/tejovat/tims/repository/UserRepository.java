package com.tejovat.tims.repository;

import org.springframework.data.repository.CrudRepository;

import com.tejovat.tims.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);
	User findByUseremail(String email);
	User findByResettoken(String token);
}
