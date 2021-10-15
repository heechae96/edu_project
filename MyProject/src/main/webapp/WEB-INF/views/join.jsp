<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- css를 적용한것! -->
<link href="/resources/css/user/join.css" rel="stylesheet">
</head>
<body>
	<h1>회원가입을 통해 서비스를 이용하세요</h1>
	<form id="join_form" action="/edu_user/join" method="post">
		
		<label>아이디</label>
		<!-- jquery에서 사용하려고 class추가.. -->
		<input type="text" class= "userId" name="userId" placeholder="qwer1234"><br>
		<span class="id_ok">사용 가능한 아이디입니다.</span>
		<span class="id_not_ok">존재하는 아이디입니다.</span><br>
		
		<label>비밀번호</label>
		<input type="password" name="password" placeholder="zxcv1234"><br><br>
		
		<label>이름</label>
		<input type="text" name="userName" placeholder="홍길동"><br><br>
		
		<label>학번</label>
		<input type="text" name="classNumber" placeholder="60181234"><br><br>
			
		<label>학년</label>
		<input type="text" name="userYear" placeholder="4"><br><br>
				
		<input type="button" class="submit" value="가입하기">
		
	</form>
<script>
	
// 회원가입 버튼
$(document).ready(function(){
	// 회원가입 작동
	$(".submit").click(function(){
		$("#join_form").attr("action","/edu_user/join");
		$("#join_form").submit();
	})
});

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
			} else {
				$('.id_not_ok').css("display","inline-block");
				$('.id_ok').css("display", "none");				
			}
		}
	}); 

});
</script>
</body>
</html>