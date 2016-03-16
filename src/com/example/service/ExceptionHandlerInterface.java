/**
 * 
 */
package com.example.service;

import java.util.Map;

/**
 * @author sjshank
 *
 */
public interface ExceptionHandlerInterface {
	public boolean doLogin(Map<String, String> map) throws Exception;
}
