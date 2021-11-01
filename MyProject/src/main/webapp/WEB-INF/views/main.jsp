<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 사용하기 위하여.. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
		// body에서 직접하기 위해 제거!
		
		// 추가
		// body에서 직접하기 위해 제거!
		
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
			<!-- <button id=join>회원가입</button> -->
			<!-- <button id=login>로그인</button> -->
			
			<!-- 로그인 하지 않은 상태 -->
            <c:if test = "${ user == null}">
                <span id=login><a href="/edu_user/login">로그인</a></span>
                <span id=join><a href="/edu_user/join"></a>회원가입</span>                
            </c:if>
            
            <!-- 로그인한 상태 -->
            <c:if test="${ user != null }">
	            <div class="login_success_area">
	                <span>${user.userName}님</span><br>
	                <a href="/edu_user/logout">로그아웃</a><br>
	                <a href="/edu_user/change?num=${user.num}">정보수정</a><br>
	            </div>
        	</c:if>
			
		</div>
		<h1>내 미래 직업은?</h1>
		<div class="logo_img">이미지</div>
		<div id="btn2">
			<c:if test="${ user != null }">   
	                <a href="/user_class/add?class_number=${user.classNumber }">추가</a><br>
			</c:if>
			<c:if test="${ user != null }">   
	                <a href="/user_class/select?class_number=${user.classNumber }">조회</a><br>
			</c:if>
			<button id=start>시작</button>
		</div>		
	</div>
</body>
</html>