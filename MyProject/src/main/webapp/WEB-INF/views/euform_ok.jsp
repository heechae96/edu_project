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
	<c:if test="${eu == null }">
		<h1>추가한 과목이 없습니다.</h1>
		<a href="/user_class/add?class_number=${user.classNumber }">교과목 추가로 돌아가기</a>
		<h5>${user.classNumber }</h5>
	</c:if>	
	<c:if test="${eu != null }">		
		<h1>추가한 교과목 리스트</h1>	
		<a href="/user_class/add?class_number=${user.classNumber }">교과목 추가로 돌아가기</a><br>
		<table border="10" style="text-align:center">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>성적</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='list' items="${eu }">
					<tr>	
						<td>${list.num }</td>
						<td>${list.userGrade }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>