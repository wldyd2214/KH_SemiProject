<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="semantic/dist/semantic.min.js"></script>
<style>
 	.outer2{
		width:900px;
		height:500px;
		background:white;
		color:lightblack;
		/* margin-top:1%; */
		margin-left:auto;
		margin-right:auto;
		margin-top:200px; 
 	}
	h2{
	font-family: 'Jua', sans-serif;
	}
	table {
		border:1px solid gray;
		text-align:center;
		font-family: 'Jua', sans-serif;
	}
	.tableArea2 {
		width:650px;
		height:100px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	}
	table tr th{
	text-align:center;
	}
	
	#reJoin{
	padding-right:14%;
	}
	 

	
</style>
</head>
<body>
	<div class="outer2">
		<br>
		<h2 align="center">탈퇴 회원 관리</h2>
		<div class="tableArea2">
			<table id="listArea2">
				<tr>
					<th width="250px">아이디</th>
					<th width="500px">탈퇴사유</th>
					<th width="250px">탈퇴일자</th>
				</tr>
				<%-- 기능구현시 적용시킬 것
				 <% for(Board b : list){ %>
				<tr>
					<input type="hidden" value="<%= b.getBid()%>">
					<td><%= b.getBno() %></td>
					<td><%= b.getCategory() %></td>
					<td><%= b.getbTitle() %></td>
					<td><%= b.getbWriter() %></td>
					<td><%= b.getbCount() %></td>
					<td><%= b.getbDate() %></td>
				</tr>
				<% } %> --%>
			</table>
		</div>
		<div id="reJoin" align="right">
		<button class="ui secondary button">재가입 승인</button>
		</div>
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>검색분류</option>
				<option value="searchById">아이디검색</option>
				<option value="searchByReporter">탈퇴일자검색</option>
			</select>
			<input type="search">
			<button type="submit" class="ui secondary button" style=height:28px;>검색하기</button>
			<%-- <% if(loginUser != null){ %>
				<button onclick="location.href='views/board/boardInsertForm.jsp'">작성하기</button>
			<% } %> --%>
		</div>
	</div>
</body>
</html>