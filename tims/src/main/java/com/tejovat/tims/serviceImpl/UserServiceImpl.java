package com.tejovat.tims.serviceImpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tejovat.tims.exception.FileStorageException;
import com.tejovat.tims.exception.MyFileNotFoundException;
import com.tejovat.tims.model.User;
import com.tejovat.tims.repository.UserRepository;
import com.tejovat.tims.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> getUsers() {
		Iterable<User> user = userRepository.findAll();
		return user;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		User user  = getUser(id);
		if(user!=null) {
			userRepository.delete(user);
		}
	}

	@Override
	public User getUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			User user1 = user.get();
			return user1;
		}else {
			return null;
		}
	}

	@Override
	public User loginUser(String username, String password) {
		User user = userRepository.findByUsername(username);
			if(user.getUserpwd().equals(password)) {
				return user;
		}
			return null;
	}

	@Override
	public User findUserByUseremail(String userEmail) {
		User user = userRepository.findByUseremail(userEmail);
		return user;
	}

	@Override
	public Boolean findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			return false;
		}else {
			return true;	
		}
	}

	@Override
	public Integer getCount() {
		return (int) userRepository.count();
	}

	@Override
	public User storeFile(Integer id, MultipartFile file) {
		User user = getUser(id);
		if(file!=null) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }
	            user.setPicture(file.getBytes());
	            user.setFilename(fileName);
	            user.setFiletype(file.getContentType());
	            return saveUser(user);
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
		}else {
			return user;
		}
	}

	@Override
	public User getFile(Integer fileId) {
        return userRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}
	
}

