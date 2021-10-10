package com.myproject.myproject.edu_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
		
	@Autowired
	private UserMapper userMapper;
	
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
}
