package com.myproject.myproject.edu_user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	// 삽입[회원가입]
	@Insert("insert into edu_user(num, user_id, password, class_number, user_name, user_year) "
			+ "values(#{num},#{userId},#{password},#{classNumber},#{userName},#{userYear})")
	public int insertUser(User user);	
	
	// 아이디 중복 검사
	@Select("select count(*) from edu_user where user_id=#{userId}")
	public int userIdChk(String userId);
	
	// 로그인
	// 아이디랑 비밀번호만 받는다!
	// ★이름은 조회만 되는것!!★
	@Select("select user_id, password, user_name from edu_user where user_id=#{userId} and password=#{password}")
	public User userLogin(User user);
	
	// 비밀번호 조회
	@Select("select count(*) from edu_user where user_id=#{userId} and class_number=#{classNumber} and user_name=#{userName}")
	public int pwChk(String userPw);
	
	
	
}
