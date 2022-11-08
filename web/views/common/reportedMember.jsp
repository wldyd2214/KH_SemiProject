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
 	.outer{
		width:900px;
		height:10px;
		background:white;
		color:lightblack;
		/* margin-top:1%; */
		margin-left:auto;
		margin-right:auto;
		margin-top:150px; 
 	}
	h2{
	font-family: 'Jua', sans-serif;
	}
	table {
		border:1px solid gray;
		text-align:center;
		font-family: 'Jua', sans-serif;
	}
	.tableArea {
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
	
	#takeReport{
	padding-right:14%;
	}
	 

	
</style>
</head>
<body>
	<div class="outer">
		<br>
		<h2 align="center">신고 회원 관리</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th width="250px">아이디</th>
					<th width="500px">신고사유</th>
					<th width="250px">신고자</th>
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
		<div id="takeReport" align="right">
		<button class="ui secondary button">신고 접수</button>
		</div>
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>검색분류</option>
				<option value="searchById">아이디검색</option>
				<option value="searchByReporter">신고자검색</option>
			</select>
			<input type="search">
			<button type="submit" class="ui secondary button" style=height:28px;>검색하기</button>
			<%-- <% if(loginUser != null){ %>
				<button onclick="location.href='views/board/boardInsertForm.jsp'">작성하기</button>
			<% } %> --%>
		</div>
	</div>
	<br><br>
</body>
</html>