<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>본인의 정보를 수정하세요</h1>
		<form id="change_form" action="/edu_user/change" method="post">
			<!-- hidden으로 해서 안보이게 설정 -->
			<!-- 로그인 관련해서 user를 가져온것! -->
			<input type="hidden" name="num" value="${user.num}" readonly="readonly">
			
			<label class="pw">비밀번호</label>
			<input class="pw" type="password" name="password" placeholder="zxcv1234"><br><br>
			
			<label>학번</label>
			<input type="text" name="classNumber" placeholder="60180000"><br><br>
			
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