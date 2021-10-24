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
	<form action="/edu_class/add" method="post" id="class_add"></form>
	<fieldset>
		<legend>트랙선택</legend>
		<label><input type="radio" name="track" value="class1" checked>인공지능</label>
		<label><input type="radio" name="track" value="class2">IoT통신네트워크</label>
		<label><input type="radio" name="track" value="class3">공통</label>
	</fieldset>
	
	<fieldset>
		<legend>과목의 해당 학년</legend>
		<label><input type="radio" name="year" value="1" checked> 1학년</label>
        <label><input type="radio" name="year" value="2"> 2학년</label>
        <label><input type="radio" name="year" value="3"> 3학년</label>
        <label><input type="radio" name="year" value="4"> 4학년</label>
	</fieldset>	
	
	<fieldset>
		<legend>과목의 해당 학점</legend>
		<label><input type="radio" name="credit" value="1"> 1학년</label>
        <label><input type="radio" name="credit" value="2"> 2학년</label>
        <label><input type="radio" name="credit" value="3" checked> 3학년</label>
	</fieldset>
	
	<fieldset>
		<legend>과목명</legend>
		<input list="className" name="className">	  	
	  	<datalist id="className">
		    <option value="파이썬프로그래밍">
		    <option value="사물인터넷기초">
		    <option value="회로이론">
		    <option value="컴퓨터네트워크">
	    	<option value="정보통신응용프로그래밍">
	    	<option value="디지털논리회로">
	    	<option value="데이터구조">
	    	<option value="자바프로그래밍">
	    	<option value="전자회로">
	    	<option value="마이크로프로세서">
	    	<option value="전자기학">
	    	<option value="기계학습개론">
	    	<option value="임베디드시스템">
	    	<option value="컴퓨터구조">
	    	<option value="통신이론">
	    	<option value="확률 및 랜덤프로세스">
	    	<option value="정보보안">
	    	<option value="신호 및 시스템"> 
	    	<option value="IT신기술세미나1">
	    	<option value="기계학습응용">
	    	<option value="데이터마이닝 및 시각화">
	    	<option value="센서기반사물인터넷">
	    	<option value="IoT보안">
	    	<option value="디지털통신">
	    	<option value="통신네트워크">
	    	<option value="디지털신호처리"> 
	    	<option value="IT신기술세미나2">
	    	<option value="데이터베이스">
	    	<option value="알고리즘">
	    	<option value="모바일프로그래밍">
	    	<option value="차세대이동통신">
	    	<option value="초고속광네트워크">
	    	<option value="캡스톤디자인1">
	    	<option value="인터넷프로그래밍">
	    	<option value="ICT창업">
	    	<option value="빅데이터분석">
	    	<option value="사물인터넷SoC">
	    	<option value="무선네트워크">
	    	<option value="캡스톤디자인2">
	    	<option value="영상처리">
	    	<option value="산학협력">	    		
	  	</datalist>	  	
	</fieldset>
</body>
</html>