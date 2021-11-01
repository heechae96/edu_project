package com.myproject.myproject.user_class;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.myproject.edu_class.UserClass;
import com.myproject.myproject.edu_user.User;

@Controller
@RequestMapping("user_class")
public class EuController {

	@Autowired
	Euservice euservice;
	
	@GetMapping("add")
	public String selectClass(Model m) {
				
	// 다른 테이블로부터 조회하는 작업
		
		// 여기에서 서비스를 이용하여 화면에 보여줄 데이터를 가져온다.
		List<UserClass> classlist = euservice.selectClass();
		// List<User> userlist = euservice.selectUser();
		
		// 화면에 보내기 위해 모델에 넣어준다.
		m.addAttribute("classlist", classlist);	
		// m.addAttribute("userlist", userlist);
		
		System.out.println("classlist: "+classlist);
		//System.out.println("userlist: "+userlist);
		
		return "euform";
		
	}
	
	@PostMapping("add")
	public String selectClass(RedirectAttributes re ,Eu eu, User user, UserClass userclass) {
		String result = euservice.insertUser(eu, user, userclass);
		re.addFlashAttribute("result", result);
		
		System.out.println("디비 등록 성공");
		
		//return "redirect:/user_class/add";
		return "redirect:add";
	}
	
	@GetMapping("select")
	public String showClass(Model m, String num, HttpServletRequest req) {		
		// 학번을 어떻게 가져올까??
		String classNumber = req.getParameter("class_number");
		num = classNumber;
		System.out.println(num);
		List<Eu> eu = euservice.getUserClass(num);
		m.addAttribute("eu",eu);
		System.out.println(eu);
		
		return "euform_ok";
	}
	
	
	
	
		
}
