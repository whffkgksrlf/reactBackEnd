package com.common.login.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.login.service.LoginService;
import com.common.login.service.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	@Override
	public Map userLogin(Map map) throws Exception {
		
		String username = map.get("username").toString();
		String password = map.get("password").toString();
		
		
		
		
		
		
		return null;
	}


}



