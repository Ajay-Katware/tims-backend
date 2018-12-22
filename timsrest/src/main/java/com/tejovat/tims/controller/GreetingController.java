package com.tejovat.tims.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.TEXT_PLAIN_VALUE })
	public @ResponseBody String test() {
		String msg = "Success\nDate: " + new Date().toString();
		return msg;
	}
    
}