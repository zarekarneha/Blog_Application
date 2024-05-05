package com.blog.app.mapper;

import com.blog.app.entity.User;
import com.blog.app.payload.UserDto;

public class UserMapper {
	public static UserDto mapToUserDto(User user)
	{
		return new UserDto(user.getId(),
				user.getName(),
				user.getEmail(),
				user.getPassword(),
				user.getAbout());
	}
	
	public static User maptoUser(UserDto userDto)
	{
		return new User(userDto.getId(),
				userDto.getName(),
				userDto.getEmail(),
				userDto.getPassword(),
				userDto.getAbout());
				
	}

}
