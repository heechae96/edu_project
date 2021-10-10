<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded", function() {
		var btn_ok = document.querySelector(".ok");
		btn_ok.onclick = function() {
			location.href = "/edu_user/join_ok"	
		}
	}
</script>
<body>
	<h1>회원가입을 통해 서비스를 이용하세요</h1>
	<form action="/user/input" method="post">
		<input type="text" name="userId" placeholder="아이디">
		<button class="ok">중복확인</button><br>
		<input type="password" name="password" placeholder="비밀번호"><br>
		<input type="text" name="classNumber" placeholder="학번"><br>
		<input type="text" name="userName" placeholder="이름"><br>
		<input type="text" name="classYear" placeholder="학년"><br>		
		<input type="submit" value="가입하기">
	</form>
</body>
</html>