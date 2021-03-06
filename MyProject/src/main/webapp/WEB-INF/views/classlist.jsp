<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자)리스트 페이지</title>
<script>
	// result가 
	// 비어있지 않은 경우 -> true
	// 비어있는 경우 -> false
	var result = ${not empty result}
	
	// 반환값을 넣었기 때문에 항상 값이 들어가 있는 상태
	// -> true를 반환
	// write와 delete의 반환값이 자동으로 들어간다!!
	if(result){
		alert("${result}");
	}
</script>
</head>
<body>
	<h1>과목 리스트</h1>
	
	<c:if test="${boardListView.boardTotalCount == 0 }">
		<h2>등록된 과목이 없습니다</h2>
	</c:if>
	<c:if test="${boardListView.boardTotalCount != 0 }">
		<table border="10" style="text-align:center">
			<thead>
				<tr>
					<th>번호</th>
					<th>트랙</th>
					<th>학년</th>
					<th>과목명</th>
					<th>학점</th>
				</tr>
			</thead>
			<tbody>
				<!-- for(BoardDto board : boardListView.getBoardList()){	} -->
				<c:forEach var='board' items="${boardListView.boardList }">
					<tr>
						<td>${board.num }</td>
						<td>${board.track }</td>
						<td>${board.year }</td>
						<td><a href="/edu_class/detail?num=${board.num }">${board.className }</a></td>
						<td>${board.credit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
		<!-- 페이징 -->
		<section>
			<c:forEach var="pageN" begin="1" end="${boardListView.pageTotalCount }">
				<a href="list?pageN=${pageN }">[${pageN }]</a>
			</c:forEach>
		</section>
	</c:if>
</body>
</html>