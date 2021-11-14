package com.myproject.myproject.user_class;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		// 화면에 보내기 위해 모델에 넣어준다.
		m.addAttribute("classlist", classlist);	
		
		System.out.println("classlist: "+classlist);
		
		return "euform";
		
	}
	
	@PostMapping("add")
	public String selectClass(RedirectAttributes re ,Eu eu, User user, UserClass userclass) {
		String result = euservice.insertUser(eu, user, userclass);
		re.addFlashAttribute("result", result);
		
		return "redirect:/edu_user/main";
	}
	
	// 과목 중복 검사
	// 성공 여부를 확인하기 위해 produces = "application/text; charset=utf8" 추가했다!
	@PostMapping(value = "classChk", produces = "application/text; charset=utf8")
	@ResponseBody	// euform.jsp로 메서드의 결과를 반환하기 위함
	public String classChk(String classNumber, int num) {
		System.out.println("--유저 체크--");
		
		int result = euservice.classChk(classNumber, num);
		
		System.out.println("결과값 : " + result);
		
		if(result != 0) {
			System.out.println("실패");
			return "실패";	// 중복 과목 존재
			
		} else {
			System.out.println("성공");
			return "성공";	// 중복 과목 x
			
		}
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
		
		List<UserClass> classlist = euservice.getClassName(num);
		m.addAttribute("classlist", classlist);
		System.out.println(classlist);		
		
		return "euform_ok";
	}
	
	@GetMapping("detail")
	public String detailClass(Model m, int num, String classNumber, HttpServletRequest req) {
		// 성적을 수정 및 삭제하기 위해
		String number = req.getParameter("num");
		num = Integer.parseInt(number);
		System.out.println("받아온 과목코드: "+num);
		classNumber= req.getParameter("class_number");
		System.out.println("받아온 학번 :"+classNumber);
		List<Eu> eu = euservice.getEu(num, classNumber);
		m.addAttribute("eu", eu);
		System.out.println(eu);
		
		// ★중요★
		// 버튼에서 사용함..
 		Eu list = euservice.getNum(num, classNumber);
		m.addAttribute("lst", list);
		
		return "euform_detail";
	}
	
	@PostMapping("delete")
	public String deleteForm(int num, RedirectAttributes re) {
		System.out.println("num: "+num);
		String result = euservice.deleteClass(num);
		
		re.addFlashAttribute("result", result);
		
		return "redirect:/edu_user/main";
	}
	
	@GetMapping("update")
	public String updateClass(int num, String classNumber, Model m, HttpServletRequest req) {
		// 만들어진 과목테이블을 보여주기 위하여
		List<UserClass> classlist = euservice.selectClass();	
		m.addAttribute("classlist", classlist);
		
		String number = req.getParameter("num");
		num = Integer.parseInt(number);
		System.out.println("받아온 과목코드: "+num);
		classNumber= req.getParameter("class_number");
		System.out.println("받아온 학번 :"+classNumber);
		
		Eu list = euservice.getNum(num, classNumber);
		m.addAttribute("lst", list);
		
		
		return "euform_update";
	}
	
	@PostMapping("update")
	public String boardUpdate(Eu eu, RedirectAttributes re) {
		
		System.out.println("받은 내용 : "+eu);
		
		// 서비스로 과목을 수정작업을 필요로함!
		String result = euservice.updateClass(eu);
		re.addFlashAttribute("result", result);

		return "redirect:/edu_user/main";
	}
	
	
	
	
	
	
	
		
}
