package com.tejovat.tims.service;

import org.springframework.web.multipart.MultipartFile;

import com.tejovat.tims.model.User;

public interface UserService {
	public Iterable<User> getUsers();
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(Integer id);
	public User getUser(Integer id);
	public User loginUser(String username, String password);
	public User findUserByUseremail(String userEmail);
	public User findUserByResetToken(String resetToken);
	public Boolean findByUsername(String username);
	public Integer getCount();
	public User storeFile(Integer id, MultipartFile file);
	public User getFile(Integer fileId);
	
}
