package com.myproject.myproject.edu_user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	// 삽입
	@Insert("insert into edu_user(num, user_id, password, class_number, user_name, user_year, track, year, class_name, credit, user_grade) "
			+ "values(#{num},#{userId},#{password},#{classNum},#{userName},#{userYear},#{track},#{year},#{className},#{credit},#{userGrade})")
	public int insertUser(User user);
}
