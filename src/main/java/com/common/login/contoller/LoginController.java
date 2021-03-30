package com.common.login.contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.login.service.LoginService;
import com.common.login.service.MemberService;

@Controller
@RequestMapping(value="/")
public class LoginController {
	
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String homeView() {
        return "login/home";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login/login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "login/signup";
    }

    @PostMapping("/signup")
    public String signup(Map memberTO) {
        memberService.save(memberTO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "login/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "login/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "login/denied";
    }
    
	@RequestMapping( value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(Map map) throws Exception{
		
		Map test = loginService.userLogin(map);
		
		//Map testMap = apiService.updateUser(map);
		
		return "api return : test" ;
	}

    
    
	
}
