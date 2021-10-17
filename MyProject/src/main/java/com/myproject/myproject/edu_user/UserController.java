package com.myproject.myproject.edu_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	// 아이디 중복 검사
	// 성공 여부를 확인하기 위해 produces = "application/text; charset=utf8" 추가했다!
	@PostMapping(value = "userIdChk", produces = "application/text; charset=utf8")
	@ResponseBody	// join.jsp로 메서드의 결과를 반환하기 위함
	public String userIdChk(String userId) {
		logger.info("유저 체크");
		System.out.println("유저 체크");
		
		int result = userService.userIdChk(userId);
		
		logger.info("결과값 : " + result);
		System.out.println("결과값 : " + result);
		
		if(result != 0) {
			System.out.println("실패");
			return "실패";	// 중복 아이디가 존재
			
		} else {
			System.out.println("성공");
			return "성공";	// 중복 아이디 x
			
		}
	}
		
	//로그인 페이지 이동
	@GetMapping("login")
	public String userLogin() {	
		logger.info("로그인 페이지로 진입");
		System.out.println("로그인 페이지로 진입");
		return "login";
	}
	
	// 로그인
	@PostMapping("login")
	public String loginPost(HttpServletRequest req, User user , RedirectAttributes re) {
		
		System.out.println("로그인 메소드");
		System.out.println("전달된 데이터: "+user);
		
		// 로그인이 되었다는 것은 세션에 사용자의 정보를 저장하였다는 의미!
		HttpSession session = req.getSession();
		User new_user = userService.userLogin(user);
		
		if(new_user == null) {	// 일치하지 않는 아이디, 비밀번호 입력 경우		                                   
            int result = 0;
            re.addFlashAttribute("result", result);
            return "redirect:/edu_user/login";           
        }
        
        session.setAttribute("user", new_user);	// 일치하는 아이디, 비밀번호 경우 (로그인 성공)             
        
        return "redirect:/edu_user/main";		
		
	}
	
	// 비밀번호 페이지로 이동
	// ★PwChk: 주소 password: jsp명
	@GetMapping("pwChk")
	public String userPwChk() {	
		logger.info("비밀번호 조회 페이지로 진입");
		System.out.println("비밀번호 조회 페이지로 진입");
		return "password";
	}
	
	// 비밀번호 제공을 위한 확인 페이지
	// 성공 여부를 확인하기 위해 produces = "application/text; charset=utf8" 추가했다!
	// produces application/text에서 text/plain로 변경하면서
	// 파일 자동으로 다운로드 되는걸 막았다!!
	@PostMapping(value = "pwChk", produces = "text/plain; charset=utf8")
	@ResponseBody	// password.jsp로 메서드의 결과를 반환하기 위함
	public String userPwChk(String userId, String classNumber, String userName) {
//		System.out.println("유저 체크");
//		System.out.println("유저 아이디"+userId);
//		System.out.println("학번"+classNumber);
//		System.out.println("이름"+userName);
		
		int result = userService.userPwChk(userId, classNumber, userName);
		
		System.out.println("결과값 : " + result);
		
		if(result == 0) {
			System.out.println("실패");
			return "no";	// 등록되지 않은 정보
			
		} else {
			System.out.println("성공");
			return "yes";	// 등록된 정보
			
		}
	}
	
	// 비밀번호 제공 페이지
	@GetMapping("okpw")
	public String okpw() {	
		logger.info("비밀번호 제공 페이지 진입");
		System.out.println("비밀번호 제공 페이지 진입");
		return "find_pw";
	}
	
	// 비밀번호를 직접 뿌려주는 페이지
	@PostMapping("pwChk")
	public String pwPost(HttpServletRequest req, User user , RedirectAttributes re) {
		
		System.out.println("로그인 메소드");
		System.out.println("전달된 데이터: "+user);
		
		HttpSession session = req.getSession();
		User new_user = userService.userPw(user);
		
		if(new_user == null) {	// 일치하지 정보가 없는 경우		                                   
            int result = 0;
            re.addFlashAttribute("result", result);
            return "redirect:/edu_user/pwChk";           
        }
        
        session.setAttribute("user", new_user);	// 일치하는 정보 존재             
        
        return "redirect:/edu_user/okpw";		
		
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String userLogout(HttpServletRequest req) {	
		logger.info("로그아웃");
		System.out.println("로그아웃");
		
		// 로그아웃은 세션에 저장되어 있는 사용자의 정보를 지우는 작업을 의미!
		HttpSession session = req.getSession();
		
		// 세션 전체를 무효화
		session.invalidate();
		
		return "redirect:/edu_user/main";	
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
