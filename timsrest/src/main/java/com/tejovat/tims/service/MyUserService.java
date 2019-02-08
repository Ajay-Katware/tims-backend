package com.tejovat.tims.service;

import org.springframework.web.multipart.MultipartFile;

import com.tejovat.tims.model.MyUser;

public interface MyUserService {
	public Iterable<MyUser> getUsers();
	public MyUser saveUser(MyUser user);
	public MyUser updateUser(MyUser user);
	public void deleteUser(Integer id);
	public MyUser getUser(Integer id);
	public MyUser loginUser(String username, String password);
	public MyUser findUserByUseremail(String userEmail);
	public MyUser findUserByResetToken(String resetToken);
	public Boolean findByUsername(String username);
	public Integer getCount();
	public MyUser storeFile(Integer id, MultipartFile file);
	public MyUser getFile(Integer fileId);
	
}
