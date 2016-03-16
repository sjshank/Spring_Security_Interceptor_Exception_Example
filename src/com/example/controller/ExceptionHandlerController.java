package com.example.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.ExceptionHandlerService;

@Controller
@RequestMapping(value = "/handler")
public class ExceptionHandlerController {
	
	@Autowired
	private ExceptionHandlerService handlerService;
	
	//Request handler for displaying login page
	@RequestMapping(value = "/getLogin")
	public ModelAndView getIndex(){
		return new ModelAndView("index","index", "Spring Interceptor, Spring Security and Exception Handling Example");
	}
	
	//Request handler for login operation
	@RequestMapping(value = "/login.json")
	public ModelAndView doLogin(@RequestParam Map<String, String> requestMap) throws Exception{
		return new ModelAndView("view","user", handlerService.doLogin(requestMap));	
	}
}