<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 수정</title>
</head>
<body>
	<h1>교과목 수정 페이지</h1>
	<form action="/user_class/update" method="post">
		<h2 style="color:Tomato">강좌번호와 성적을 입력하세요</h2>
		<input type="hidden" name="classNumber" value="${user.classNumber }">
			<table border="1" style="text-align:center">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>과목명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='list' items="${classlist }">
					<tr>	
						<td>${list.num }</td>
						<td>${list.className }</td>
					</tr>
				</c:forEach>
			</tbody>		
			</table>
			<br>
			<table border="1" style="text-align:center">
				<thead>
					<tr>
						<th>강좌번호</th>
						<th>변경전 성적</th>
					</tr>
				</thead>
				<tbody>
					<tr style="background-color:Tomato">	
						<td>${lst.num }</td>
						<td>${lst.userGrade }</td>
					</tr>
				</tbody>
			</table>
			<br>
			<input type="text" size="3" name="num" value="${lst.num }" placeholder="번호" readonly="readonly">
			<input type="number" min="0" max="4.5" step="0.5" name="userGrade" placeholder="성적" required>
			<input type="submit" value="제출">
			<button type="button" onclick="location.href='/edu_user/main'">메인으로 돌아가기</button>
		</form>
</body>
</html>