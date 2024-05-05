package com.blog.app.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.payload.UserDto;
import com.blog.app.service.UserService;
import com.ems.Ems.dto.EmployeeDto;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/users")

public class UserController {
	
	@Autowired
	private UserService userService;
	//POST- create
	@PostMapping(path="/insert") 
	
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		System.out.println("dto: "+new Gson().toJson(userDto));
	UserDto dto	=userService.createUser(userDto);
    
	return new ResponseEntity<>(dto,HttpStatus.CREATED);
		
	}
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Integer uid ,@RequestBody UserDto userDto)
	{
	UserDto updatedUser=userService.updateUser(userDto, uid);
	return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer uid)
	{
	UserDto user=	userService.getUser(uid);
	return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<java.util.List<UserDto>> getAllUser(){
	java.util.List<UserDto> dto= userService.getAllUser();
	return ResponseEntity.ok(dto);
	
		}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid)
	{
		userService.deleteUser(uid);
		return  ResponseEntity.ok("User Deleted");
	}
}
