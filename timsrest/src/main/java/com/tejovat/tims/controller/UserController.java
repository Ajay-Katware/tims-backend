package com.tejovat.tims.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tejovat.tims.assembler.EmailAssembler;
import com.tejovat.tims.dto.UploadFileResponse;
import com.tejovat.tims.model.MyUser;
import com.tejovat.tims.service.EmailService;
import com.tejovat.tims.service.MyUserService;
import com.tejovat.tims.util.PasswordUtils;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private MyUserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EmailAssembler emailAssembler;


	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Iterable<MyUser> getAllUsers() {
		return userService.getUsers();
	}

	//User Registration
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MyUser> createUser(@RequestBody MyUser user, HttpServletRequest request) {
		if(user.getId()!=null && user.getId()>0) {
			MyUser user2 =  userService.getUser(user.getId());
			user.setUserpwd(user2.getUserpwd());
			MyUser newuser = userService.saveUser(user);
			return ResponseEntity.ok().body(newuser);
		}else {
			@SuppressWarnings("static-access")
			String password = new PasswordUtils().generateRandomPassword();
			user.setUserpwd(password);
			MyUser newuser = userService.saveUser(user);
			String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort()+"/tims/";
			String emailContaint = emailAssembler.registerEmail(newuser.getFirstname(),newuser.getUsername(),newuser.getUserpwd(),appUrl);
			try {
				emailService.sendEmailHtml(emailContaint, newuser.getUseremail(), "TIMS Tejovat - Account Details");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok().body(newuser);
		}
	}

	@PostMapping("/uploadImage/{id}")
	public UploadFileResponse uploadFile(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
		MyUser user = userService.storeFile(id, file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/users/downloadFile/")
				.path(user.getId().toString())
				.toUriString();

		return new UploadFileResponse(user.getFilename(), fileDownloadUri,
				file.getContentType(), file.getSize());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ResponseEntity<MyUser> getUserByUserId(@PathVariable("id") Integer id) {
		MyUser user = userService.getUser(id);
		return ResponseEntity.ok().body(user);
	}

	@RequestMapping(value = "/checkUserByEmail", method = RequestMethod.GET,consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<Boolean> checkUseremail(@RequestParam("userEmail") String userEmail) {
		MyUser user = userService.findUserByUseremail(userEmail);
		if(user!=null) {
			return ResponseEntity.ok().body(true);
		}
		return ResponseEntity.ok().body(false);
	}

	@RequestMapping(value = "/checkUserByUsername", method = RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<Boolean> checkUsername(@RequestParam("username") String username) {
		return ResponseEntity.ok().body(userService.findByUsername(username));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
	}
	
   /*@PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Integer id) {
        // Load file from database
    	MyUser dbFile = userService.getFile(id);
    	System.out.println("\n\n\n\n"+dbFile.toString()+"\nn\n\n");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFiletype()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFilename() + "\"")
                .body(new ByteArrayResource(dbFile.getPicture()));
    }
    
	@RequestMapping(value = "/checkUserByToken", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ResponseEntity<MyUser> getUserByUserResetToken(@RequestParam("resetToken") String resetToken) {
		MyUser user = userService.findUserByResetToken(resetToken);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value = "/setpassword", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<MyUser> updateUserPassword(@RequestBody MyUser user, HttpServletRequest request) throws FileNotFoundException {
		MyUser user2 =  userService.getUser(user.getId());
		user2.setUserpwd(user.getUserpwd());
		user2.setResettoken("-");
		MyUser updatedUser = userService.saveUser(user2);
		return ResponseEntity.ok().body(updatedUser);
	}
}

