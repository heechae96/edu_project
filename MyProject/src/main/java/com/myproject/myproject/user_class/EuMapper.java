package com.myproject.myproject.user_class;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	// 과목명이 필요한데 과목명은 다른 테이블에서 가져오자
	@Select("select * from user_class where class_number=#{classNumber} order by user_class.num asc")
	public List<Eu> showClassByNum(String classNumber);
	
	// 과목명을 가져오는 메소드
	// 조인연산자 사용!
	// where절 위치 주의!
	@Select("select * from edu_class inner join user_class on edu_class.num = user_class.num where class_number=#{classNumber} order by edu_class.num asc")
	public List<UserClass> selectClassName(String classNumber);
	
	
	
	
	// 과목코드를 통해 추가한 과목을 가져올것.
	@Select("select * from user_class where num=#{num}")
	public List<Eu> selectEuByNum(int num);
	
	// 과목을 num으로 가져오는 메소드
	@Select("select * from user_class where num=#{num}")
	public Eu selectByNum(int num);
	
	// 과목코드를 통해 과목을 수정
	@Update("update user_class set user_grade=#{userGrade} where num=#{num} and class_number=#{classNumber}")
	public int updateClass(Eu eu);
	
	// 과목코드를 통해 과목을 삭제
	@Delete("delete from user_class where num=#{num}")
	public int deleteClass(int num);

}
