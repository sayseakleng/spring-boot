package com.kdemo.springboot.dao;

import java.util.List;

import com.kdemo.springboot.dto.UserDto;

public interface UserDao {
	List<UserDto> findUsers();
}
