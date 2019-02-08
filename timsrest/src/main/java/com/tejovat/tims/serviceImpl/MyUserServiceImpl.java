package com.tejovat.tims.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tejovat.tims.exception.TIMSException;
import com.tejovat.tims.exception.FileStorageException;
import com.tejovat.tims.model.MyUser;
import com.tejovat.tims.repository.UserRepository;
import com.tejovat.tims.service.MyUserService;


@Service
public class MyUserServiceImpl implements MyUserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<MyUser> getUsers() {
		Iterable<MyUser> user = userRepository.findAll();
		return user;
	}

	@Override
	public MyUser saveUser(MyUser user) {
		return userRepository.save(user);
	}

	@Override
	public MyUser updateUser(MyUser user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		MyUser user  = getUser(id);
		if(user!=null) {
			userRepository.delete(user);
		}
	}

	@Override
	public MyUser getUser(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public MyUser loginUser(String username, String password) {
		MyUser user = userRepository.findByUsername(username);
		if(user == null) {
			throw new TIMSException("Couldn't find your tejovat account.");
		}else {
			if(user.getUserpwd().equals(password)) {
				return user;
			}
			throw new TIMSException("Wrong password. Try again or click Forgot password to reset it.");	
		}
	}

	@Override
	public MyUser findUserByUseremail(String userEmail) {
		MyUser user = userRepository.findByUseremail(userEmail);
		if(user == null) {
			throw new TIMSException("Couldn't find your tejovat account.");
		}
		return user;
	}

	@Override
	public Boolean findByUsername(String username) {
		MyUser user = userRepository.findByUsername(username);
		if(user == null) {
			throw new TIMSException("Couldn't find your tejovat account");
		}else {
			return true;	
		}
	}

	@Override
	public Integer getCount() {
		return (int) userRepository.count();
	}

	@Override
	public MyUser storeFile(Integer id, MultipartFile file) {
		MyUser user = getUser(id);
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
	public MyUser getFile(Integer fileId) {
		return userRepository.findOne(fileId);
	}

	@Override
	public MyUser findUserByResetToken(String resetToken) {
		MyUser user = userRepository.findByResettoken(resetToken);
		if(user == null) {
			throw new TIMSException("Oops!  This is an invalid password reset link.");
		}else {
			return user;	
		}
	}

}

