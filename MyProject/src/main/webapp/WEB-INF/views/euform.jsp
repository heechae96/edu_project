<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// result가 
	// 비어있지 않은 경우 -> true
	// 비어있는 경우 -> false
	var result = ${not empty result}

	if(result){
		alert("${result}");
	}
</script>
</head>
<body>
<form action="/user_class/add" method="post">
	<h1>교과목 추가 페이지</h1>
	<h2 style="color:Tomato">강좌번호와 성적을 입력하세요</h2>
	<a href="/user_class/select?class_number=${user.classNumber }">교과목 조회하기</a><br>
	<input type="hidden" name="classNumber" value="${user.classNumber }">
		<table border="1" style="text-align:center">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>트랙</th>
					<th>학년</th>
					<th>과목명</th>
					<th>학점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='list' items="${classlist }">
					<tr>	
						<td style="background-color:Tomato">${list.num }</td>
						<td>${list.track }</td>
						<td>${list.year }</td>
						<td>${list.className }</td>
						<td>${list.credit }</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<input type="number" min="12" max="52" name="num" value="${list.num }" placeholder="번호" required>
		<input type="number" min="0" max="4.5" step="0.5" name="userGrade" value="${list.userGrade }" placeholder="성적" required><br>
		<br>
		<input type="submit" value="제출">			 	
</form>
</body>
</html>