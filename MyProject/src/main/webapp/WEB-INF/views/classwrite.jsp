<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>교과목 추가 페이지</h1>
	
	<form action="/edu_class/write" method="post" id="class_add">
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
		<input type="text" name="className">	  	
	</fieldset>
	
	<br>
	
	<input type="submit" value="제출">
	</form>
	
	
</body>
</html>