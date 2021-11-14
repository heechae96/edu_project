<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 상세보기</title>
<script type="text/javascript">	

	var result = ${not empty result}
	
	if(result){
		alert("${result}");
	}
	
	window.addEventListener("DOMContentLoaded",function(){		
		
		// 수정 버튼
		var updateBtn = document.querySelector("#update");
		console.dir(updateBtn);
		updateBtn.onclick = function(){
			console.log("/user_class/update?num=${lst.num}&class_number=${lst.classNumber}");
			location.href = "/user_class/update?num=${lst.num}&class_number=${lst.classNumber}";
		}
		
		// 삭제 버튼
		var deleteBtn = document.querySelector("#delete");
		console.dir(deleteBtn);
		// post방식으로 요청해보자
		deleteBtn.addEventListener("click",function(){
			var form = document.createElement("form");
			form.setAttribute("charset", "utf-8");
			form.setAttribute("method", "post");
			form.setAttribute("action", "/user_class/delete");
			
			var idField = document.createElement("input");
			idField.setAttribute("type", "hidden");
			idField.setAttribute("name", "num");
			idField.setAttribute("value", ${lst.num });
					
			form.appendChild(idField);
			document.body.appendChild(form);
			form.submit();
		})
		
	});
</script>
</head>
<body>
	<h1>교과목 수정 및 삭제 페이지</h1>
		<table border="1" style="text-align:center">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>학점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='list' items="${eu }">
					<tr>
						<td>${list.num }</td>
						<td>${list.userGrade }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
						<button id="update">수정</button>
						<button id="delete">삭제</button>
					</td>
				</tr>
			</tbody>
		</table>	 	
</body>
</html>