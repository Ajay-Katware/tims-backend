package com.tejovat.tims.repository;

import org.springframework.data.repository.CrudRepository;

import com.tejovat.tims.model.MyUser;


public interface UserRepository extends CrudRepository<MyUser, Integer>{
	MyUser findByUsername(String username);
	MyUser findByUseremail(String email);
	MyUser findByResettoken(String token);
}
