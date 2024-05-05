package com.blog.app.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourseNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	long fieldvalue;
	public ResourseNotFoundException(String resourceName, String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s : %l", resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	
	

}
