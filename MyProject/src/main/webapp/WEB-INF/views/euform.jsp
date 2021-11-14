<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 추가</title>
<link href="/resources/css/euform.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<form action="/user_class/add" method="post">
	<h1>교과목 추가 페이지</h1>
	<h2 style="color:Tomato">강좌번호와 성적을 입력하세요</h2>
	<input type="hidden" class="userNum" name="classNumber" value="${user.classNumber }">
		<table border="1" style="text-align:center">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>트랙</th>
					<th>학년</th>
					<th>과목명</th>
					<th>학점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='list' items="${classlist }">
					<tr>	
						<td style="background-color:Tomato">${list.num }</td>
						<td>${list.track }</td>
						<td>${list.year }</td>
						<td>${list.className }</td>
						<td>${list.credit }</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<input type="number" class="classNum" min="12" max="52" name="num" value="${list.num }" placeholder="번호" required>
		<span class="class_ok">추가 가능한 과목입니다.</span>
		<span class="class_not_ok">존재하는 과목입니다.</span><br>
		
		<input type="number" min="0" max="4.5" step="0.5" name="userGrade" value="${list.userGrade }" placeholder="성적" required>
		
		<input type="submit" id="submit_btn" value="제출">
		
		<button type="button" onclick="location.href='/edu_user/main'">메인으로 돌아가기</button> 			 	
</form>
<script>
// 과목 중복 검사
// 실시간 감지
$(".classNum").on("propertychange change keyup paste input", function(){
	
	var userNum = $('.userNum').val();				
	var classNum = $('.classNum').val();

	//console.log(userNum);
	//console.log(classNum);
	
	$.ajax({
		type : "post",
		url : "/user_class/classChk",
		data : {
			classNumber : userNum,
			num : classNum
		},
		success : function(result){
			console.log("성공 여부 : " + result);
			if(result != '실패'){
				$('.class_ok').css("display","inline-block");
				$('.class_not_ok').css("display", "none");
				$('#submit_btn').attr("disabled",false);
			} else {
				$('.class_not_ok').css("display","inline-block");
				$('.class_ok').css("display", "none");
				$('#submit_btn').attr("disabled",true);
			}
		}
	}); 
});
</script>
</body>
</html>