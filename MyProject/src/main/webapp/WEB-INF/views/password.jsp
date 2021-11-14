<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 사용하기 위하여.. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
body{
	text-align: center;
}
</style>
</head>
<body>
	<h1>비밀번호를 조회하세요</h1>
		<form id="pw_form" action="/edu_user/pwChk" method="post">
		
			<label>아이디</label>
			<input type="text" class="userId" name="userId" placeholder="qwer1234" required="required"><br><br>
			
			<label>학번</label>
			<input type="text" class="classNumber" name="classNumber" placeholder="60180000" required="required"><br><br>
			
			<label>이름</label>
			<input type="text" class="userName" name="userName" placeholder="홍길동" required="required"><br><br>
						
			<input type="button" class="pw_btn" value="비밀번호 조회"><br><br>
		
		</form>
<script>
//비밀번호 조회 버튼	
$(".pw_btn").click(function(){
	
	$("#pw_form").attr("action","/edu_user/pwChk");
	$("#pw_form").submit();
		
	var userId = $('.userId').val();
	var classNumber = $('.classNumber').val();
	var userName = $('.userName').val();
	
	// 한개의 객체로..
	// var userDb = [userId, classNumber, userName];
	
	// key value..
	// var data = {userDb : userDb}				
	
	$.ajax({
		type : "post",
		url : "/edu_user/pwChk",
		data : {
			// 한개의 객체로 -> 키 와 값
			userId : userId,
			classNumber : classNumber,
			userName : userName
		},
		success : function(result){
			console.log("성공 여부 : " + result);
			if(result == "yes"){	
				console.log("성공");
			} else {	
				console.log("실패");				
			}
		}
	}); 
});
</script>
</body>
</html>