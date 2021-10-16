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
<!-- css를 적용한것! -->
<link href="/resources/css/user/pw.css" rel="stylesheet">
</head>
<body>
	<h1>비밀번호를 조회하세요</h1>
		<form id="pw_form" action="/edu_user/pwChk" method="post">
		
			<label>아이디</label>
			<input type="text" class="userId" name="userId" placeholder="qwer1234"><br><br>
			
			<label>학번</label>
			<input type="text" class="classNumber" name="classNumber" placeholder="60181234"><br><br>
			
			<label>이름</label>
			<input type="text" class="userName" name="userName" placeholder="홍길동"><br><br>
			
			<input type="button" class="real" value="존재?">			
			<input type="button" class="pw_btn" value="비밀번호 조회">	
		
		</form>
<script>

// 비밀번호 조회 버튼
$(document).ready(function(){
	// 비밀번호 조회 작동
	$(".pw_btn").click(function(){
		$("#pw_form").attr("action","/edu_user/pwChk");
		$("#pw_form").submit();
	})
});

//비밀번호 조회 버튼	
$(".real").on("propertychange change keyup paste input", function(){
	// alert("비밀번호 조회 버튼 작동")
	var userId = $('.userId').val();
	var classNumber = $('.classNumber').val();
	var userName = $('.userName').val();
	var data = {userDB : userDB}				
	
	$.ajax({
		type : "post",
		url : "/edu_user/pwChk",
		data : data,
		success : function(result){
			console.log("성공 여부 : " + result);
			if(result != '실패'){
				location.href = "/edu_user/okpw";
								
			} else {
				alert("조회된 정보가 없습니다. 다시 입력하세요");				
			}
		}
	});

});
</script>
</body>
</html>