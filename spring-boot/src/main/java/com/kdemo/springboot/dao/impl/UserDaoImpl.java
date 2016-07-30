package com.kdemo.springboot.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kdemo.springboot.dao.UserDao;
import com.kdemo.springboot.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	private List<UserDto> users = new ArrayList<>();
	
	public UserDaoImpl() {
		UserDto userDto = new UserDto();
		userDto.setUserId("13");
		userDto.setUsername("Dara");
		users.add(userDto);
	}
	
	@Override
	public List<UserDto> findUsers() {
		return users;
	}

}
