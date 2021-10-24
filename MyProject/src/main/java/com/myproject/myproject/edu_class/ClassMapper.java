package com.myproject.myproject.edu_class;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClassMapper {
	
	// 추가
	@Insert("insert into edu_class(num, track, year, class_name, credit) "
			+ "values(#{num}, #{track}, #{year}, #{className}, #{credit})")
	public int insertBoard(UserClass userclass);
	
	// 조회[리스트 형태로]
	@Select("select num, track, year, class_name, credit "
			+ "from edu_class order by num desc limit #{startRow},#{boardCountPerPage}")
	public List<UserClass> selectBoard(@Param("startRow")int startRow, @Param("boardCountPerPage")int boardCountPerPage);
	
	// 전체개수를 조회
	@Select("select count(*) from edu_class")
	public int selectTotalCnt();
	
	// 과목을 num으로 가져오는 메소드
	@Select("select num, track, year, class_name, credit "
			+ "from edu_class where num=#{num}")
	public UserClass selectUserClassById(int num);
	
	// 과목을 수정하는 메소드
	@Update("update edu_class set track=#{track}, class_name=#{className}, year=#{year}, credit=#{credit}"
			+ " where num=#{num}")
	public void updateBoard(UserClass userclass);
	
	// 과목을 삭제하는 메소드
	@Delete("delete from edu_class where num=#{num}")
	public int deleteBoard(int num);
	
	
}
