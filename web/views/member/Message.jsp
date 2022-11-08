<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#web-font{
      font-family: 'Jua', sans-serif;
   }
   .outer1{
   		/* border-color: red; 
   	  	display:inline-block; */
		width:800px;
		height:500px;
		/* background:black;
		color:white; */
		margin-left:180px;
		margin-right:auto;
		margin-top:220px;
		
	}
	table {
		border:1px solid black;
		text-align:center;
	}
	.tableArea{
		width:700px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<title>Insert title here</title>
</head>
<body><font id="web-font">
  	<%@ include file="../common/logoAndLogbutton.jsp" %>
  
    <%@ include file="../common/categorybar.jsp" %>
    
    <%@ include file="myPage_left.jsp" %>
    
    <div class="outer1">
    	<br>
    	<h2 align="left">메세지</h2>
    	
    
    
    <div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<th width="50px">체크</th>
					<th width="100px">메세지 번호</th>
					<th width="300px">메세지 제목</th>
					<th width="100px">작성자</th>
					<!-- <th>조회수</th> -->
					<th width="100px">작성일</th>
				</tr>
				<%-- <% for(Notice n : list){ %>
				<tr>
					<td><%= n.getNno() %></td>
					<td><%= n.getnTitle() %></td>
					<td><%= n.getnWriter() %></td>
					<td><%= n.getnCount() %></td>
					<td><%= n.getnDate() %></td>
				</tr>
				<% } %> --%>
			</table>
		</div>	
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>---</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<%-- <% if(loginUser != null ){ %> --%>
				<button onclick="location.href='views/notice/noticeInsertForm.jsp'">메세지 작성</button>
			
			<%-- <% } %> --%>
		</div>
	</div>
	<script>
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"black"});
			}).click(function(){
				//console.log($(this).parent().children().eq(0).text());
				var num = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/selectOne.no?num=" + num;
			
			});
			
		});
	</script>
	
 
 </font>   
</body>
</html>