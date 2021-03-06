<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- css를 적용한것! -->
<link href="/resources/css/user/join.css" rel="stylesheet">
</head>
<body>
	<main class="con">
		<h1>회원가입을 통해 서비스를 이용하세요</h1>
		<form id="join_form" action="/edu_user/join" method="post">
			
			<label>아이디</label>
			<!-- jquery에서 사용하려고 class추가.. -->
			<input type="text" class= "userId" name="userId" placeholder="qwer1234" required="required"><br>
			<span class="id_ok">사용 가능한 아이디입니다.</span>
			<span class="id_not_ok">존재하는 아이디입니다.</span><br>
			
			<label>비밀번호</label>
			<input type="password" name="password" placeholder="zxcv1234" required="required"><br><br>
			
			<label>이름</label>
			<input type="text" name="userName" placeholder="홍길동" required="required"><br><br>
			
			<label>학번</label>
			<input type="text" name="classNumber" placeholder="60181234" required="required"><br><br>
				
			<label>학년</label>
			<input type="text" name="userYear" placeholder="4" required="required"><br><br>
					
			<input type="submit" id="submit_btn" value="제출">
			
		</form>
	</main>
<script>
// 아이디 중복 검사
// 실시간 감지
$(".userId").on("propertychange change keyup paste input", function(){

	// console.log("테스트");	
	
	var userId = $('.userId').val();			
	var data = {userId : userId}				
	
	$.ajax({
		type : "post",
		url : "/edu_user/userIdChk",
		data : data,
		success : function(result){
			console.log("성공 여부 : " + result);
			if(result != '실패'){
				$('.id_ok').css("display","inline-block");
				$('.id_not_ok').css("display", "none");	
				$('#submit_btn').attr("disabled",false);
			} else {
				$('.id_not_ok').css("display","inline-block");
				$('.id_ok').css("display", "none");	
				$('#submit_btn').attr("disabled",true);
			}
		}
	}); 
});

</script>
</body>
</html>