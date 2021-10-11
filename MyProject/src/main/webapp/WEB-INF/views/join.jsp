<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css를 적용한것! -->
<link href="/resources/css/user/join.css" rel="stylesheet">
</head>
<body>
	<h1>회원가입을 통해 서비스를 이용하세요</h1>
	<form action="/user/join" method="post">
		
		<label>아이디</label>
		<input type="text" name="userId" placeholder="qwer1234">
		<button class="ok">중복확인</button><br><br>
		
		<label>비밀번호</label>
		<input type="password" name="password" placeholder="zxcv1234"><br><br>
		
		<label>이름</label>
		<input type="text" name="userName" placeholder="홍길동"><br><br>
		
		<label>학번</label>
		<input type="text" name="classNumber" placeholder="60181234"><br><br>
			
		<label>학년</label>
		<input type="text" name="userYear" placeholder="4"><br><br>
				
		<input type="submit" value="가입하기">
		
	</form>
</body>
</html>