package com.example.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CustomException;
import com.example.exception.ValidationException;
import com.example.repository.ExceptionHandlerRepository;

@Service("handlerService")
public class ExceptionHandlerService implements ExceptionHandlerInterface {

	@Autowired
	private ExceptionHandlerRepository handlerRepo;
	
	@Override
	public boolean doLogin(Map<String, String> requestMap) throws Exception{
		if(requestMap == null){
			throw new CustomException("Login Request is empty");
		}
		// Server side validation
		if(StringUtils.isEmpty(requestMap.get("userName"))){
			throw new ValidationException("User name required");
		}
		if(StringUtils.isEmpty(requestMap.get("password"))){
			throw new ValidationException("Password required");
		}
		return handlerRepo.verifyLogin(requestMap);
	}
}
