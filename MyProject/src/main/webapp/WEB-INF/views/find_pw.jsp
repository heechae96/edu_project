<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 사용하기 위하여.. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 조회완료</title>
<!-- css를 적용한것! -->
<link href="/resources/css/user/pwok.css" rel="stylesheet">
<style>
body{
	text-align: center;
}
</style>
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded", function() {
		// 돌아가기
		var back = document.querySelector(".back");
		back.onclick = function() {
			location.href = "/edu_user/login"	
		}
		
	});
</script>
</head>
<body>
	<main class="con">	
		<h1>비밀번호 찾기 완료</h1>
		<div id="full">
		        <!-- 비밀번호가 조회된 상태 -->
			    <c:if test="${ user != null }">
			    <div class="comment">당신의 비밀번호는 아래와 같습니다.    
			        	<div class="pwbox">
			        		<span>"${user.password}"입니다</span><br>	 
			        	</div>	                          
			    </div>
			    </c:if>	
		       	
		       	<!-- 비밀번호가 조회되지 않은 상태 -->
		        <c:if test="${ user == null }">
		        <div class="comment">조회된 정보가 없습니다.
				       	<div class="pwbox">
				       		<span>다시 한번 확인 후 조회하세요</span><br>	 
				       	</div>	                          
		      	</div>		
		      	</c:if>	
		</div><br>
		<button class="back">돌아가기</button>
	</main>
</body>
</html>