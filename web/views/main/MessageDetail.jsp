<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		/* border-color: red; 
   	  	display:inline-block; */
		width:800px;
		height:500px;
		/* background:black;
		color:white; */
		margin-left:20%;
		margin-right:auto;
		margin-top:120px;
		
	}
	table {
		border:1px solid balck;
	}
	.tableArea {
		width:450px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>

<font id="web-font">  
    <%@ include file="../common/myPage_left.jsp" %>
	<div class="outer">
		<br>
		<h2 align="left">메세지</h2>
		<div class="tableArea">
			<table>
				<tr>
					<td>제목</td>
					<td colspan="3">
						<%-- <input type="text" size="50" 
						name="title" value="<%=n.getnTitle()%>" readonly> --%>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<%-- <input type="text" 
						value="<%= n.getnWriter() %>" name="writer" readonly> --%>
					</td>
					<td>작성일</td>
					<td>
						<%-- <input type="date" name="date" 
						value="<%= n.getnDate() %>" readonly> --%>
					</td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea> <!-- name="content" 
						cols="60" rows="15" 
						style="resize:none" readonly --><%-- <%= n.getnContent() %> --%></textarea>
					</td>
				</tr>
				
			</table>
			<br>
			<div align="center">
				<button onclick="location.href='<%=request.getContextPath() %>/selectList.no'">목록</button>
				<%-- <%if(loginUser !=null && loginUser.getUserId().equals("admin")){ %> --%>
					<button onclick = "location.href='<%-- <%=request.getContextPath()%>/selectNotice.no?num=<%=n.getNno()%> --%>'">삭제</button>
				<%-- <%} %> --%>
			</div>
			
		</div>
	</div>
</font>
</body>
</html>