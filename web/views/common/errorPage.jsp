<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet">
<style>
	div h1 {
		font-family: 'Nanum Pen Script', cursive;
		font-size: 100px;
		color: #F79F81;
	}
	#main {
		margin-top: 300px;
	}
	
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/logoAndLogbutton.jsp" %>
    <%@ include file="../common/categorybar.jsp" %>
	<div id="main" align="center">
		<h1 align="center" id="web-font"><%= msg %></h1>
		<br><br><br><br>
		<a href="<%=request.getContextPath()%>"><font id="web-font" size="8px">메인으로 이동</font></a>
	</div>
</body>
</html>