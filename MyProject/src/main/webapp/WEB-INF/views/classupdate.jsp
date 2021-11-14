<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자)수정</title>
</head>
<body>
	<h1>교과목 수정 페이지</h1>
	<form action="/edu_class/update" method="post" id="class_update">
		<fieldset>
			<legend>num</legend>
			<input type="text" name="num" value="${board.num }" readonly="readonly">
		</fieldset>
		
		<fieldset>
		<legend>트랙선택</legend>
		<label><input type="radio" name="track" value="인공지능">인공지능</label>
		<label><input type="radio" name="track" value="IoT통신네트워크">IoT통신네트워크</label>
		<label><input type="radio" name="track" value="공통">공통</label>
		</fieldset>
		
		<fieldset>
			<legend>과목의 해당 학년</legend>
			<label><input type="radio" name="year" value="1">1학년</label>
	        <label><input type="radio" name="year" value="2">2학년</label>
	        <label><input type="radio" name="year" value="3">3학년</label>
	        <label><input type="radio" name="year" value="4">4학년</label>
		</fieldset>	
		
		<fieldset>
			<legend>과목의 해당 학점</legend>
			<label><input type="radio" name="credit" value="1">1학점</label>
	        <label><input type="radio" name="credit" value="2">2학점</label>
	        <label><input type="radio" name="credit" value="3">3학점</label>
		</fieldset>
		
		<fieldset>
			<legend>과목명</legend>
			<input type="text" name="className" value="${board.className }" readonly="readonly">	  	
		</fieldset>
		
		<br>
		
		<input type="submit" value="수정">
	</form>
</body>
</html>