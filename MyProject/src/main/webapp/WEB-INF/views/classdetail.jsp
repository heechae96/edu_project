<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기 페이지</title>
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded",function(){
		// console.log("돔 이벤트 호출!!");
		
		//수정 버튼
		var updateBtn = document.querySelector("#update");
		console.dir(updateBtn);
		updateBtn.onclick = function(){
			console.log("/edu_class/update?num=${board.num}");
			location.href = "/edu_class/update?num=${board.num}";
		}
		
		// 삭제 버튼
		var deleteBtn = document.querySelector("#delete");
		console.dir(deleteBtn);
		deleteBtn.addEventListener("click",function(){
			// 컨트롤러에서 삭제 매핑을 post로 요청했음!
			// get은 따로 요청안했음..
			// post방식으로 요청해보자
			var form = document.createElement("form");
			form.setAttribute("charset", "utf-8");
			form.setAttribute("method", "post");
			form.setAttribute("action", "/edu_class/delete");
			
			// 폼에 넣어줄 값들 추가 (데이터 추가)
			// id값 추가
			var idField = document.createElement("input");
			idField.setAttribute("type", "hidden");
			idField.setAttribute("name", "num");
			idField.setAttribute("value", ${board.num});
			
			form.appendChild(idField);
			
			// 폼을 화면에 붙어주자!
			document.body.appendChild(form);		
			// 전송
			// form.submit();
		})
	});
</script>
</head>
<body>
	<h1>게시글 상세보기</h1>
	<c:if test="${board == null } ">
		<h2>요청하신 과목이 없습니다</h2>
		<a href="/edu_class/list">목록으로 돌아가기</a>
	</c:if>
	<c:if test="${board != null }">
		<table>
			<tbody>
				<tr>
					<td>번호</td>
					<td>트랙</td>
					<td>학년</td>
					<td>과목명</td>
					<td>학점</td>
				</tr>
				<tr>
					<td>${board.num }</td>
					<td>${board.track }</td>
					<td>${board.year }</td>
					<td>${board.className }</td>
					<td>${board.credit }</td>
				</tr>
				<tr>
					<td colspan="4">
						<button id="update">수정</button>
						<button id="delete">삭제</button>
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>	
</body>
</html>