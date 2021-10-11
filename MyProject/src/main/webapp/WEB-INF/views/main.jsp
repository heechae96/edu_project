<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<!-- css를 적용한것! -->
<link href="/resources/css/user/main.css" rel="stylesheet">
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded", function() {
		// 회원가입
		var btn_join = document.querySelector("#join");
		btn_join.onclick = function() {
			location.href = "/edu_user/join"	
		}
		
		// 로그인
		var btn_login = document.querySelector("#login");
		btn_login.onclick = function() {
			location.href = "/edu_user/login"	
		}
		
		// 추가
		var btn_add = document.querySelector("#add");
		btn_add.onclick = function() {
			location.href = "/edu_user/add"	
		}
		
		// 시작
		var btn_start = document.querySelector("#start");
		btn_start.onclick = function() {
			location.href = "/edu_user/start"	
		}
	});
</script>
</head>
<body>
	<div id="full">
		<div id="btn1">
			<button id=join>회원가입</button>
			<button id=login>로그인</button>
		</div>
		<h1>내 미래 직업은?</h1>
		<div class="logo_img">이미지</div>
		<div id="btn2">
			<button id=add>추가</button>
			<button id=start>시작</button>
		</div>		
	</div>
</body>
</html>