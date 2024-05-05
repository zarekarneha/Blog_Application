package com.blog.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.blog.app.exception.*;
import com.blog.app.entity.User;
import com.blog.app.mapper.UserMapper;
import com.blog.app.payload.UserDto;
import com.blog.app.repository.UserRepo;
import com.blog.app.service.UserService;
@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user= UserMapper.maptoUser(userDto);
		User savedUser=userRepo.save(user);
		
		return UserMapper.mapToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user= userRepo.findById(userId)
		.orElseThrow(()-> new ResourseNotFoundException("user","id" ,+userId ));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser= userRepo.save(user);
		
		return UserMapper.mapToUserDto(updatedUser);
	}

	@Override
	public UserDto getUser(Integer userId) {
		User user= userRepo.findById(userId)
				.orElseThrow(()-> new ResourseNotFoundException("user","id" ,+userId ));

		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> userList=userRepo.findAll();
		return userList.stream().map(user->UserMapper.mapToUserDto(user)).collect(Collectors.toList());
	}
	@Override
	public void deleteUser(Integer userId) {
		User user= userRepo.findById(userId)
				.orElseThrow(()-> new ResourseNotFoundException("user","id" ,+userId ));
		
		userRepo.deleteById(userId);
	}	
}