package com.myproject.myproject.edu_user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		System.out.println("메인 페이지로 이동");
		return "main";
	}
	
	// 회원가입 페이지로 이동
	@GetMapping("join")
	public String userJoin() {
		logger.info("회원가입 페이지로 이동");	
		System.out.println("회원가입 페이지로 이동");
		return "join";
	}
	
	// 회원가입
	// 위랑 파라미터가 다르기 때문에 상관x
	@PostMapping("join")
	public String userJoin(User user, RedirectAttributes re) {
		logger.info("메인 페이지로 이동");
		System.out.println("메인 페이지로 이동");
		
		// 회원가입 서비스 실행
		String result = userService.insertUser(user);
		re.addFlashAttribute("result", result);
		
		logger.info("회원가입 서비스 성공");
		System.out.println("회원가입 서비스 성공");
		
		return "redirect:main";	
	}
	
	//로그인 페이지 이동
	@GetMapping("login")
	public String userLogin() {	
		logger.info("로그인 페이지로 진입");
		System.out.println("로그인 페이지로 진입");
		return "login";
	}
	
	// 추가 페이지로 이동
	@GetMapping("add")
	public String userAdd() {
		logger.info("추가 페이지로 진입");
		System.out.println("추가 페이지로 진입");
		return "add";
	}
	// 시작 페이지로 이동
	@GetMapping("start")
	public String userStart() {
		logger.info("시작 페이지로 진입");
		System.out.println("시작 페이지로 진입");
		return "start";
	}
}
