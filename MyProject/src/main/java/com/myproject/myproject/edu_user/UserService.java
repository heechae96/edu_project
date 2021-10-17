package com.myproject.myproject.edu_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
		
	@Autowired
	private UserMapper userMapper;
	
	// 회원가입
	public String insertUser(User user) {
			
			System.out.println("디비 삽입 전 user객체");
			System.out.println(user);
			
			int rows = userMapper.insertUser(user);
			
			System.out.println("디비 삽입 후 user객체");
			System.out.println(user);
			
			if(rows > 0) {
				return "삽입 성공";
			}else {
				return "삽입 실패";
			}
		}
	
	// 아이디 중복 검사
	public int userIdChk(String userId) {
		return userMapper.userIdChk(userId);
	}
	
	
	// 로그인
	public User userLogin(User user) {
		
		return userMapper.userLogin(user);
		
	}
	
	// 비밀번호 조회
	public int userPwChk(String userId, String classNumber, String userName) {
		return userMapper.pwChk(userId, classNumber, userName);
	} 
	
	// 비밀번호 제공
	public User userPw(User user) {
		return userMapper.pwPost(user);
	}
	

	
}
