<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 조희</title>
<link href="/resources/css/result.css" rel="stylesheet">
</head>
<body>	
<c:if test="${list['top_txt'] == null }">
	<h1>보여줄 결과가 없습니다.</h1>
	<h2>과목을 추가하세요.</h2>
	<button type="button" onclick="location.href='/user_class/add?class_number=${user.classNumber }'">교과목 추가로 돌아가기</button>
	<button type="button" onclick="location.href='/edu_user/main'">메인으로 돌아가기</button> 
</c:if>
<c:if test="${list['top_txt'] != null }" >
	<main class="con">
	    <div class="title">
	      <h3>내 성적에 맞는 직군은??</h3>
	    </div>
	   
	   <div class="sub_title">
	     <p class="top_txt">${list["top_txt"] }</p>	     
	     <p class="btm_txt">${list["recommend"] }</p>
	   </div> 
	    
	   <div class="explain-box">
	     <div class="data">
	       <p>${list["recommend"] }</p>
	
	       <ul class="job">
	         <li class="job_title">어떤 직군이 있을까?</li>
	         <li class="job_ex"><span>${list["job_list[1]"] }</span></li>
	         <li class="job_ex"><span>${list["job_list[2]"] }</span></li>
	         <li class="job_ex"><span>${list["job_list[3]"] }</span></li>
	         <li class="job_ex"><span>${list["job_list[4]"] }</span></li>
	         <li class="job_ex"><span>${list["job_list[5]"] }</span></li>
	       </ul>
	
	       <ul class="job">
	         <li class="job_title">어떤 역량이 필요한가요?</li>
	         <li class="job_ex"><span>${list["job_ability[1]"] }</span></li>
	         <li class="job_ex"><span>${list["job_ability[2]"] }</span></li>
	         <li class="job_ex"><span>${list["job_ability[3]"] }</span></li>
	         <li class="job_ex"><span>${list["job_ability[4]"] }</span></li>
	         <li class="job_ex"><span>${list["job_ability[5]"] }</span></li>
	       </ul>
	     </div>
	   </div>
	
	   <div class="retest">
	     <button type="button" onclick="location.href='/edu_user/main'">
	         <p>메인으로</p>
	     </button>
	   </div>   
   </main>
</c:if>
</body>
</html>