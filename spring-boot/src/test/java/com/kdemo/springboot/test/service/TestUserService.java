package com.kdemo.springboot.test.service;

import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kdemo.springboot.app.Application;
import com.kdemo.springboot.dto.UserDto;
import com.kdemo.springboot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		
		List<UserDto> findUsers = userService.findUsers();
		
		assertNotSame(findUsers.size(), 0);
		
		System.out.println(findUsers);
	}

}
