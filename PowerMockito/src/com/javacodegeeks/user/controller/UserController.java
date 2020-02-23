package com.javacodegeeks.user.controller;

import java.util.UUID;

import com.javacodegeeks.user.domain.User;
import com.javacodegeeks.user.service.UserService;

/**
 * Controller class handling the user operations
 * @author Meraj
 *
 */
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public UserController() {
		
	}
	
	public Long getUserCount() {
		return userService.getUserCount();
	}
	
	public String getGreetingText(User user) {
		return String.format(getGreetingFormat(), user.getFirstName(), user.getSurname());
	}
	
	private String getGreetingFormat() {
		return "Hello %s %s";
	}
	
	public String createUserId(User user) {
		return String.format("%s_%s", user.getSurname(), UUID.randomUUID().toString());
	}

}
