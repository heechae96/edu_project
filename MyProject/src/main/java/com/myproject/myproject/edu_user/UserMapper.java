package com.myproject.myproject.edu_user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	// ★이름은 메인에서 보여줄려고 추가★
	// num은 정보수정에 쓰려고 추후에 추가한것.
	@Select("select num, user_id, password, user_name from edu_user where user_id=#{userId} and password=#{password}")
	public User userLogin(User user);
	
	// 비밀번호 조회
	// 해당 db가 존재하는지..
	// Mybatis의 SQL 문장에 다수의 파라미터를 전달할 때는 전달되는 변수들에 꼭 @Param 어노테이션을 붙여줘야한다.
	@Select("select count(*) from edu_user where user_id=#{userId} and class_number=#{classNumber} and user_name=#{userName}")
	public int pwChk(@Param("userId") String userId, @Param("classNumber") String classNumber, @Param("userName") String userName);
	
	// 비밀번호 제공
	@Select("select user_id, class_number, user_name, password from edu_user where user_id=#{userId} and class_number=#{classNumber} and user_name=#{userName}")
	public User pwPost(User user);
	
	// 정보수정 [정보 변경]
	@Update("update edu_user set password=#{password}, class_number=#{classNumber}, user_name=#{userName}, user_year=#{userYear} where num=#{num}")
	public void userCh(User user);
	
	// 정보수정 [num으로 접근]
}
