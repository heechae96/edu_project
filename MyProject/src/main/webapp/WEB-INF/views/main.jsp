<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 사용하기 위하여.. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>	
var result = ${not empty result}

if(result){
	alert("${result}");
}
</script>
<!-- css를 적용한것! -->
<link href="/resources/css/user/main.css" rel="stylesheet">
</head>
<body>
	<div id="full">
		<div id="btn1">			
			<!-- 로그인 하지 않은 상태 -->
	           <c:if test = "${ user == null}">
	           	<div class="login_fail_area">
		           	<button type="button" onclick="location.href='/edu_user/login'">로그인</button>
		           	<button type="button" onclick="location.href='/edu_user/join'">회원가입</button>         
	           	</div>
	           </c:if>
	           
	           <!-- 로그인한 상태 -->
	           <c:if test="${ user != null }">
	            <div class="login_success_area">
	                <span>${user.userName}님</span>
	                <button type="button" onclick="location.href='/edu_user/logout'">로그아웃</button>
	           		<button type="button" onclick="location.href='/edu_user/change?num=${user.num}'">정보수정</button>	                
	            </div>
	       	</c:if>		
		</div>
		
	<main class="con">
		<p>나는 어떤 분야가 잘 맞을까?</p>
		<h3>직군 테스트</h3>
		<div class="logo_img">
			<img class="logo" src="/images/main_img.png">
		</div><br>
		<div id="btn2">
			<c:if test="${ user != null }">   
	                <button class="btn" type="button" onclick="location.href='/user_class/add?class_number=${user.classNumber }'"><span class="span_btn">과목 추가</span></button><br>
	                <button class="btn" type="button" onclick="location.href='/user_class/select?class_number=${user.classNumber }'"><span class="span_btn">과목 조회</span></button><br>
					<button class="btn" type="button" onclick="location.href='/user_class/result?class_number=${user.classNumber }'"><span class="span_btn">결과 조희</span></button>
			</c:if>
		</div>	
	</main>	
	</div>	
</body>
</html>