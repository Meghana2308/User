package com.cts.onlinedonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.onlinedonation.service.JpaUserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="The UserController", description="Rest controller for user")
public class UserController {
	@Autowired
	public JpaUserDetailsService userService;
	@ApiOperation(value="Post all user",
	produces="A list of user",
	notes="Hit this URL to get all user details"
	)
//	  @PostMapping("/user")
//	    public void addProduct(@RequestBody String username) {
//		  userService.loadUserByUsername(username);    
//	    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
//	@PostMapping("/login")
//	public void addDetails(@RequestBody String username) {
//		 userService.loadUserByUsername(username);
//	}
}
