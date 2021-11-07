<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가한 교과목 리스트</title>
<script>	
var result = ${not empty result}

if(result){
	alert("${result}");
}
</script>
</head>
<body>
	<c:if test="${eu.size() == 0 }">
	<!-- eu == null로 왜 불가능?? -->
		<h1>추가한 과목이 없습니다.</h1>
		<button type="button" onclick="location.href='/user_class/add?class_number=${user.classNumber }'">교과목 추가로 돌아가기</button>
		<button type="button" onclick="location.href='/edu_user/main'">메인으로 돌아가기</button> 
	</c:if>	
	<c:if test="${eu.size() != 0 }">		
		<h1>추가한 교과목 리스트</h1>	
		<h2 style="color:Tomato">성적을 클릭하여 수정 혹은 삭제가 가능합니다</h2>
		<table style="text-align:center">
			<thead>
					<tr>
						<th>강좌번호</th>
						<th>강좌명</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach var='list2' items="${classlist }">
					<tr>
						<td>${list2.num }</td>
						<td>${list2.className }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
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
							<td style="background-color:Tomato"><a href="/user_class/detail?num=${list.num }&class_number=${user.classNumber }">${list.userGrade }</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
		<button type="button" onclick="location.href='/user_class/add?class_number=${user.classNumber }'">교과목 추가로 돌아가기</button>
		<button type="button" onclick="location.href='/edu_user/main'">메인으로 돌아가기</button> 
	</c:if>
</body>
</html>