package com.myproject.myproject.user_class;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myproject.edu_class.UserClass;
import com.myproject.myproject.edu_user.User;

@Service
public class Euservice {

	@Autowired
	private EuMapper eumapper;
	
	// 학번 조회
	// 학번은 url을 통해 넘겨받았음
	// -> 필요없다.
	
	// 과목 조회
	// 과목 추가에 쓰기위해
	public List<UserClass> selectClass() {
		
		List<UserClass> classlist = null;		
		classlist = eumapper.selectClass();		
		return classlist;		
	}
		
	// 과목코드, 학번 삽입
	public String insertUser(Eu eu, User user, UserClass userclass) {
		
		System.out.println("아래부터 서비스단 작업물");
		int indexnum = eu.getIndexNum();
		int num = userclass.getNum();
		String classNumber = user.getClassNumber();
		double grade = userclass.getUserGrade();
		
		System.out.println("인덱스 :"+indexnum);
		System.out.println("과목코드 :"+num);
		System.out.println("학번 :"+classNumber);
		System.out.println("성적 :"+grade);
		
		int rows = eumapper.insertdb(indexnum, classNumber, num, grade);
		
		if(rows > 0) {
			return "삽입 성공";
		}else {
			return "삽입 실패";
		}
	}

	// 조회에 사용
	public List<Eu> getUserClass(String num) {
		List<Eu> eulist = eumapper.showClassByNum(num);
		return eulist;
	}
	
	// 조회에 사용
	public List<UserClass> getClassName(String num){
		List<UserClass> classList = eumapper.selectClassName(num);
		return classList;
	}
	
	
	
	
	
	
	// 수정 및 삭제에 사용
	public List<Eu> getEu(int num) {
		
		return eumapper.selectEuByNum(num);
	}
	
	// 수정 및 삭제에 사용
	public Eu getNum(int num) {
		
		return eumapper.selectByNum(num);
	}
		
	// 과목 성적을 수정하는 로직
	public String updateClass(Eu eu) {
		
		int row = eumapper.updateClass(eu);
		
		if(row > 0) {
			return "수정 성공";
		}else {
			return "수정 실패";
		}
	}
	
	// 과목을 삭제하는 로직
	public String deleteClass(int num) {
		int row = eumapper.deleteClass(num);
		
		if(row > 0) {
			return "삭제 성공";
		}else {
			return "삭제 실패";
		}
		
	}


}
