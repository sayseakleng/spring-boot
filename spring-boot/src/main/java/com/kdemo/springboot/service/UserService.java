package com.kdemo.springboot.service;

import java.util.List;

import com.kdemo.springboot.dto.UserDto;

public interface UserService {
	List<UserDto> findUsers();
}
