package com.board.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.api.service.ApiService;

@Controller
public class BoardController {
	
	@Autowired
	private ApiService apiService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@RequestMapping( value="/getApiq", method = RequestMethod.GET)
	@ResponseBody
	public String getByIdInJSON22(Map map) throws Exception{

		Map testMap = apiService.selectBeakUser(map);
		return "api return : " + testMap.get("US_CD") + " -- "  +  testMap.get("US_NM");
	}
	
}



