package com.common.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.login.service.LoginService;
import com.common.login.service.dao.LoginDAO;
import com.common.util.CommonUtil;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	@Override
	public Map userLogin(Map map) throws Exception {
		
		Map resultMap = new HashMap();
		
		String enpassword = CommonUtil.encryptPassword(map.get("password").toString(), map.get("username").toString());
		map.put("userId", map.get("username"));
		map.put("password", enpassword);
		
		int loginCnt = loginDAO.userLoginCnt(map);
		
		if(loginCnt <= 0) {
			resultMap.put("status", 401);
			resultMap.put("error", "로그인실패찡");
		}else {
			resultMap = map;
		}
		
		return resultMap;
	}

	@Override
	public Map userCheck(Map map) throws Exception {
		
		Map resultMap = new HashMap();
		
		if(map.get("username") == null) {
			resultMap.put("status", 401);
			resultMap.put("error", "체크실패");
		}
		
		return resultMap;
	}


}



