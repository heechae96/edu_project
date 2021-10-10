package com.myproject.myproject.edu_user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("edu_user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	// 메인 페이지로 이동
	@GetMapping("main")
	public String userMain() {
		logger.info("메인 페이지로 이동");	
		return "main";
	}
	
	// 회원가입 페이지로 이동
	@GetMapping("join")
	public String userJoin() {
		logger.info("회원가입 페이지로 이동");	
		return "join";
	}
	
	//로그인 페이지 이동
	@GetMapping("login")
	public String userLogin() {	
		logger.info("로그인 페이지로 진입");
		return "login";
	}
	
	// 추가 페이지로 이동
	@GetMapping("add")
	public String userAdd() {
		logger.info("추가 페이지로 진입");
		return "add";
	}
	// 시작 페이지로 이동
	@GetMapping("start")
	public String userStart() {
		logger.info("시작 페이지로 진입");
		return "start";
	}
}
