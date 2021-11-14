<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자)교과목 추가</title>
</head>
<body>
<form id="class_add_form" action="edu_class/add" method="post">
	<h1>교과목 추가 페이지</h1>
		<table border="1" style="text-align:center">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>트랙</th>
					<th>학년</th>
					<th>과목명</th>
					<th>학점</th>
					<th>성적</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='list' items="${classlist }">
					<tr>	
						<td>${list.num }</td>
						<td>${list.track }</td>
						<td>${list.year }</td>
						<td>${list.className }</td>
						<td>${list.credit }</td>
						<td><input type="text" name="userGrade" value="${list.userGrade }"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<input type="submit" value="제출">	
</form>
</body>
</html>