<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	hr {
		color:gray;
	}
	p {
		text-align:center;
		margin-right:8%;
	}
	#container {
    height:200px;
   	background:#BDBDBD;
   }
   #notice{
      float:center;
   	  display:inline-block;
      font-size: 15px;
     /*  margin-left: 500px; */
      margin-bottom: 40px;
   }
   #help{
   		text-align:center;
   		float:right;
   		/* margin-top:1%; */
   		/* margin-right:10%; */
   		margin-left:5%;
   }
   #web-font{
      font-family: 'Jua', sans-serif;
   }
   #noticeMain{
   	  float:left;
   	  display:inline-block;
      font-size: 15px;
      margin-left: 50px;
      margin-bottom: 40px;
   }
   #notice{
   
   }
</style>
</head>
<body>
	<div>
	<hr>
    <font id="web-font">
	<div id="noticeMain" onclick="location.href='views/notice/notice.jsp'" align="left"><!-- <font id="web-font"> -->
	      <h4>(주)누리터 사업자 정보</h4><br>
	      (주)누리터 | 서울시 강남구 역삼로<br>
	         대표: 채은비 | 개인정보관리책임자: 김진호<br>
	      1544-1544
	   </div>
	   
	   <div id="notice" onclick="goNotice();" align="center">
	   	<h4>공지사항</h4>
	      <ul>
	         <li>고객센터 운영시간 변경안내</li>
	         <li>새로운 카테고리 추가 안내</li>
	         <li>일시적인 오류 안내</li>
	      </ul>
	   </div>
	   
      <div id="help">
	      <h4>누리터 고객센터<br>
	      1588-3287<br>
	             상담시간 : 평일 10:30 ~ 18:30<br>
	      *토요일 및 공휴일 휴무</h4>
	      <input type ="button" id="callMe" value="전화 전 클릭" onclick="location.href='<%=request.getContextPath()%>/views/notice/fnq.jsp'">
      </div>
      </div>
	<hr>
	<p align="center">Copyright ⓒ 2018 Nuriter Inc. All rights reserved</p>
	</font>
	
</body>
</html>
