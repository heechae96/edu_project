<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>교과목 추가 페이지</h1>
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
						<td>${list.num }</td>
						<td>${list.track }</td>
						<td>${list.year }</td>
						<td>${list.className }</td>
						<td>${list.credit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>  	
</body>
</html>