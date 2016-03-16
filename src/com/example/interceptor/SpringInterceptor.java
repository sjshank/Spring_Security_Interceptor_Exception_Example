/**
 * 
 */
package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.exception.CustomException;
import com.example.exception.ValidationException;
import com.example.util.ExceptionConstants;

/**
 * @author sjshank
 *	Spring Interceptor for request handler. This will check user name for request everyone made to server
 */
@Component
public class SpringInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	// Request Pre handler
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("In preHandle");
		try{
			UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!StringUtils.endsWithIgnoreCase(details.getUsername(), ExceptionConstants.USER_NAME)){
				throw new ValidationException("Unauthorized User");
			}
		}catch(Exception e){
			throw new CustomException("Something went wrong with service. Please try after sometime.");
		}
		return true;
	}

}
