package com.myproject.myproject.user_class;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.myproject.myproject.edu_class.UserClass;
import com.myproject.myproject.edu_user.User;

@Mapper
public interface EuMapper {
	
	// 조회[과목코드]
	// 과목을 조회하기 위해
	@Select("select * from edu_class order by num asc")
	public List<UserClass> selectClass();
	
	
	
	// 과목코드와 학번을 받아 등록하는 메소드
	// 여러개의 값을 받아야 하는데?
	// -> param으로 지정해서 보내기
	@Insert("insert into user_class(index_num, class_number, num, user_grade) "
			+"values(#{indexNum}, #{classNumber}, #{num}, #{userGrade})")
	public int insertdb(@Param("indexNum")int indexNum, @Param("classNumber")String classNumber, 
						@Param("num")int num, @Param("userGrade")double userGrade);
				
	
	// 추가한 과목 정보를 학번을 통해 보여주는 메소드
	// 강좌번호와 학점밖에 없다
	// 강좌명은 다른 테이블에서 조회
	@Select("select * from user_class where class_number=#{classNumber}")
	public List<Eu> showClassByNum(String classNumber);
	
}
