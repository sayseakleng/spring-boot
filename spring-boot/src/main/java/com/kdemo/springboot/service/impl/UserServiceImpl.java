package com.kdemo.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdemo.springboot.dao.UserDao;
import com.kdemo.springboot.dto.UserDto;
import com.kdemo.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserDto> findUsers() {
		return userDao.findUsers();
	}

}
