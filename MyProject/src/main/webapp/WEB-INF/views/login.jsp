<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css를 적용한것! -->
<link href="/resources/css/user/login.css" rel="stylesheet">
</head>
<body>
	<h1>로그인을 통해 서비스를 이용하세요</h1>
	<form action="/user/?" method="post">
	
		<label>아이디</label>
		<input type="password" name="password" placeholder="zxcv1234"><br><br>
		
		<label>비밀번호</label>
		<input type="text" name="userName" placeholder="홍길동"><br><br>
		
		<input type="submit" value="비밀번호 조회">
		<input type="submit" value="로그인">
	
	</form>
</body>
</html>