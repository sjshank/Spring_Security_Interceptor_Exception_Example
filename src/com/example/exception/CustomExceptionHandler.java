package com.example.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.json.JsonExceptionHandler;

public class CustomExceptionHandler implements JsonExceptionHandler{

	private static final String ERROR_MESSAGE = "errMsg";
	private static final String VALIDATION_MESSAGE = "validationMsg";
	
	@SuppressWarnings("unchecked")
	@Override
	public void triggerException(Exception e, Map map,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		
		//Check if thrown exception is a kind of validation
		if(e instanceof ValidationException){
			ValidationException ve = (ValidationException) e;
			map.put(VALIDATION_MESSAGE, ve.getMessage());
		}
		//Check if thrown exception is a customize one
		if(e instanceof CustomException){
			CustomException ce = (CustomException) e;
			map.put(ERROR_MESSAGE, ce.getMessage());
		}
		
	}

}
