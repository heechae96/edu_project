package com.myproject.myproject.edu_class;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("edu_class")
public class ClassController {
	
	@Autowired
	ClassService classService;
	
	@GetMapping("list")
	public String boardList(@RequestParam(defaultValue = "0") int pageN, Model m){
		
		// 여기에서 서비스를 이용하여 화면에 보여줄 데이터를 가져온다.
		BoardListView boardListView = classService.getBoardListView(pageN);
		
		// 화면에 보내기 위해 모델에 넣어준다.
		m.addAttribute("boardListView", boardListView);
		
		return "classlist";
	}
	
	// 상세보기
	@GetMapping("detail")
	public String boardDetail(int num, Model m) {
		// 서비스를 통해서 해당되는 게시글 정보를 가져와 화면에 보내준다.
		UserClass userclass = classService.getBoard(num);
		m.addAttribute("board", userclass);
		
		return "classdetail";
	}
	
	// 수정화면으로 가기
	@GetMapping("update")
	public String boardUpdateForm(int num, Model m) {
		UserClass userclass = classService.getBoard(num);
		m.addAttribute("board", userclass);
		
		return "classupdate";
	}
	
	// 수정
	@PostMapping("update")
	public String boardUpdate(UserClass userclass) {
		
		System.out.println("받은 내용 : "+userclass);
		
		// 서비스로 과목을 수정작업을 필요로함!
		classService.updateBoard(userclass);
		
		// 매핑기준!
		return "redirect:list";
	}
	
//	// 삭제화면으로 가기
//	@GetMapping("delete")
//	public String boardDelete(int num, Model m) {
//		UserClass userclass = classService.getBoard(num);
//		m.addAttribute("board", userclass);
//		
//		return "classlist";
//	}
	
	// 삭제
	@PostMapping("delete")
	public String boardDelete(int num, RedirectAttributes re) {
		System.out.println("num: "+num);
		String result = classService.deleteBoard(num);
		
		re.addFlashAttribute("result", result);
		
		return "redirect:list";
	}
	
	@GetMapping("write")
	public String boardWrite() {		
		return "classwrite";
	}
	
	@PostMapping("write")
	public String boardWrite(UserClass userclass, RedirectAttributes re) {
		System.out.println("받은 내용: "+userclass);
		
		String result = classService.insertboard(userclass);	
		re.addFlashAttribute("result", result);
		
		return "redirect:list";
	}
	
}
