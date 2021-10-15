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
<link href="/resources/css/user/login.css" rel="stylesheet">
</head>
<body>
	<h1>로그인을 통해 서비스를 이용하세요</h1>
	<form id="login_form" action="/edu_user/login" method="post">
	
		<label>아이디</label>
		<input type="text" class="userId" name="userId" placeholder="qwer1234"><br><br>
		
		<label>비밀번호</label>
		<input type="text" name="password" placeholder="zxcv1234"><br><br>
		
		<c:if test = "${result == 0 }">
			<div class="login_warning">사용자 ID 또는 비밀번호를 잘못 입력하였습니다.</div><br>			
		</c:if>
				
		<input type="button" class="pw_btn" value="비밀번호 조회">
		<input type="button" class="login_btn" value="로그인">	
	
	</form>
<script>

	// 로그인 버튼
	$(".login_btn").click(function(){
		// alert("로그인 버튼 작동")
		
		// 로그인 메소드 서버 요청
		$("#login_form").attr("action", "/edu_user/login");
		$("#login_form").submit();
		
	});
	
	// 비밀번호 조회 버튼	
</script>
</body>
</html>