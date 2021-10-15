package com.myproject.myproject.edu_user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	// 삽입
	@Insert("insert into edu_user(num, user_id, password, class_number, user_name, user_year) "
			+ "values(#{num},#{userId},#{password},#{classNumber},#{userName},#{userYear})")
	public int insertUser(User user);
	
	
	// 아이디 중복 검사
	@Select("select count(*) from edu_user where user_id=#{userId}")
	public int userIdChk(String userId);
	
	// 로그인
	@Select("select user_id, password from edu_user where user_id=#{userId} and password=#{password}")
	public User userLogin(User user);
	
}
