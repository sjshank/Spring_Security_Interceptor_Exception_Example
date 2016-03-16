package com.example.repository;

import java.util.Map;

public interface ExceptionRepositoryInterface {
	public boolean verifyLogin(Map<String, String> map) throws Exception;
}
