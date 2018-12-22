package com.tejovat.tims.controller;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.assembler.EmailAssembler;
import com.tejovat.tims.model.User;
import com.tejovat.tims.service.EmailService;
import com.tejovat.tims.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailAssembler emailAssembler;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createHotel(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getUserpwd();
		User user2 = userService.loginUser(username, password);
		return ResponseEntity.ok().body(user2);
	}


	@RequestMapping(value="/update/{id}",method=RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public Map<String, String> updatePassword(@PathVariable("id") Integer id, @RequestParam String password) throws Exception {
		User user = userService.getUser(id);
		if(user!=null) {
			user.setUserpwd(password);
			userService.updateUser(user);
			return Collections.singletonMap("success", "Password updated successfully");
		}
		return Collections.singletonMap("fail", "Somthing is wrong");
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"} )
	public ResponseEntity<User> processForgotPasswordForm(@RequestParam("userEmail") String userEmail, HttpServletRequest request) throws Exception {
		User user = userService.findUserByUseremail(userEmail);
		if (user!=null) {
			user.setResettoken(UUID.randomUUID().toString());
			userService.updateUser(user);
			String appUrl = "http://localhost:4200/admin/setpassword;resetToken="+user.getResettoken();
			String emailContaint = emailAssembler.forgotEmail(user.getFirstname(), appUrl);
			try {
				emailService.sendEmailHtml(emailContaint, user.getUseremail(), "Password Reset Request");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok().body(user);	
		}else {
			return ResponseEntity.ok().body(user);
		}
	}
	
	@RequestMapping(value="/reset/{id}",method=RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"} )
	public Boolean setNewPassword(@PathVariable("id") Integer id, @RequestParam String password) throws Exception {
		User user = userService.getUser(id);
		if(user!=null) {
			user.setUserpwd(password);
			user.setResettoken(null);
			userService.updateUser(user);
			return true;
		}else {
			return false;
		}
	}

}

