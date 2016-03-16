package com.example.exception;


/*
 * ValidationException class extending Exception.
 * This will handle all exception thrown by ValidationException
 */
@SuppressWarnings("serial")
public class ValidationException extends Exception{

	public ValidationException(){
		super();
	}
	
	public ValidationException(String message){
		super(message);
	}
}
