/**
 * 
 */
package com.example.repository;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.example.exception.ValidationException;
import com.example.util.ExceptionConstants;


/**
 * @author sjshank
 *
 */
@Repository("handlerRepo")
public class ExceptionHandlerRepository implements ExceptionRepositoryInterface{
	
	// verify user submitted login details.
	@Override
	public boolean verifyLogin(Map<String, String> requestMap) throws Exception{
		System.out.println("In Repo : "+requestMap.get("userName"));
		if(!(StringUtils.equalsIgnoreCase(requestMap.get("userName"), ExceptionConstants.USER_NAME)
			&&	StringUtils.equalsIgnoreCase(requestMap.get("password"), ExceptionConstants.PASSWORD))){
			throw new ValidationException("Login denied. Invalid credentials");
		}
		return true;
	}
}
