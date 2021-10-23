<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>본인의 정보를 수정하세요</h1>
		<form id="change_form" action="/edu_user/change" method="post">
			
			<label>비밀번호</label>
			<input type="password" name="password" placeholder="zxcv1234"><br><br>
			
			<label>학번</label>
			<input type="text" name="classNumber" placeholder="60181234"><br><br>
			
			<label>이름</label>
			<input type="text" name="userName" placeholder="홍길동"><br><br>
			
			<label>학년</label>
			<input type="text" name="userYear" placeholder="4"><br><br>
					
			<input type="submit" class="submit" value="수정완료">			
		</form>
<script>
$(".submit").click(function(){
	alert("정보수정 완료");
});
</script>
</body>
</html>