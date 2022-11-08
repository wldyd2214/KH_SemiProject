<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.kh.nuriter.board.model.vo.*,com.kh.nuriter.nuriter.model.vo.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	.main{
		/* background:red */;
	/* 	border:3px solid black; */
		margin-top:15%;
		height:100px;
		width:60%;
		margin-left:auto;
		margin-right:auto;
		
	}
	
	#web-font {
	font-family: 'Jua', sans-serif;
}
</style>
</head>
<body>
	<%@include file="../common/logoAndLogbutton.jsp"%>
	<div class="main">
		<h2>누리장 신고</h2>
		<div id="reportList">
			<table border="1" width="100%" height="40%" id="listArea">
   				<tr>
					<th width="10%">글번호</th>
					<th width="35%">글제목</th>
					<th width="15%">작성자</th>
					<th width="10%">조회수</th>
					<th width="30%">작성일</th>
   				</tr>
   			
		</div>
	</div>
</body>
</html>