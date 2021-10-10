package com.myproject.myproject.edu_user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

	// user [회원가입] 추가
	@Insert("insert into edu_user(num, user_id, password, class_number, user_name, user_year) "
			+ "values(#{num},#{userId},#{password},#{classNum},#{userName},#{userYear})")
	@Options(useGeneratedKeys = true, keyProperty = "num")
	public int insertUser(User user);
}
