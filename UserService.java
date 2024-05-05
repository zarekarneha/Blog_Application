package com.blog.app.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.blog.app.entity.User;
import com.blog.app.payload.UserDto;
@Repository
public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUser(Integer userId);
	List<UserDto> getAllUser();
	public void deleteUser(Integer userId);

}
