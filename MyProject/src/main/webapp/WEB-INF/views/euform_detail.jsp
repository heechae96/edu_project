<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 상세보기</title>
<link href="/resources/css/euform/euform_detail.css" rel="stylesheet">
<script type="text/javascript">	
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
		
		var idField1 = document.createElement("input");
		idField1.setAttribute("type", "hidden");
		idField1.setAttribute("name", "num");
		idField1.setAttribute("value", ${lst.num });
		
		
		var idField2 = document.createElement("input");
		idField2.setAttribute("type", "hidden");
		idField2.setAttribute("name", "classNumber");
		idField2.setAttribute("value", ${lst.classNumber });
				
		form.appendChild(idField1);
		form.appendChild(idField2);
		document.body.appendChild(form);
		form.submit();
	})
	
});
</script>
</head>
<body>
	<main class="con">
		<h1>교과목 상세보기</h1>
		<table>
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
			</tbody>
		</table>
		<button id="update">수정</button>
		<button id="delete">삭제</button>
	</main>	 	
</body>
</html>