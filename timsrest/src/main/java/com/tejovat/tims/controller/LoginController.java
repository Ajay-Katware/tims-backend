package com.tejovat.tims.controller;
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

import com.tejovat.tims.model.MyUser;
import com.tejovat.tims.service.EmailService;
import com.tejovat.tims.service.MyUserService;

@RestController
public class LoginController {

	@Autowired
	private MyUserService userService;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MyUser> createHotel(@RequestBody MyUser user) {
		String username = user.getUsername();
		String password = user.getUserpwd();
		MyUser user2 = userService.loginUser(username, password);
		return ResponseEntity.ok().body(user2);
	}


	@RequestMapping(value="/update/{id}",method=RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<MyUser> updatePassword(@PathVariable("id") Integer id, @RequestParam("password") String password) throws Exception {
		MyUser user = userService.getUser(id);
		if(user != null) {
			user.setUserpwd(password);
			userService.updateUser(user);
			return ResponseEntity.ok().body(user);
		}else {
			return ResponseEntity.ok().body(null);
		}
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"} )
	public ResponseEntity<MyUser> processForgotPasswordForm(@RequestParam("userEmail") String userEmail, HttpServletRequest request) throws Exception {
		MyUser user = userService.findUserByUseremail(userEmail);
		if (user!=null) {
			user.setResettoken(UUID.randomUUID().toString());
			userService.updateUser(user);
			String appUrl = "http://13.233.124.20:7001/admin/setpassword;resetToken="+user.getResettoken();
			String emailContaint = "<html><body>"
					+ "<h3>Hi"+user.getFirstname()+",</h3>"
					+ "<br/>"
					+ "To reset your password, click the link below: <br/>"
					+ "<a href='"+appUrl+"'>"+appUrl+"</a>"
					+ "<br/><br/>"
					+ "Thanks,<br/>"
					+ "Rigelix Team"
					+ "</body></html>";
			try {
				emailService.sendEmailHtml(emailContaint, user.getUseremail(), "Password Reset Request");
				System.out.println("--------------MAIL SENT To--------------"+userEmail);
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
		MyUser user = userService.getUser(id);
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

