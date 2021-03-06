package com.kdemo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdemo.springboot.dto.UserDto;
import com.kdemo.springboot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDto> findUsers() {
		return userService.findUsers();
	}
	
}
