package com.example.exception;

/*
 * CustomException class extending Exception.
 * This will handle all exception thrown by customException
 */
@SuppressWarnings("serial")
public class CustomException extends Exception{

	public CustomException(){
		super();
	}
	
	public CustomException(String message){
		super(message);
	}
}
