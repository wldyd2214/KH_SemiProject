<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.*"%>
<% Nuriboss nb = (Nuriboss)request.getAttribute("nb");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#main {
	/* margin-top: 190px; */
	/* margin-left: 210px; */
	margin-right: 19%;
	float: right;
	overflow: hidden;
}

#child {
	width: 900px;
	overflow: hidden;
	/* border-style: solid;
    	border-color: hotpink; */
}

#child table td{
 	font-size:1em;
}

#web-font {
	font-family: 'Jua', sans-serif;
}

#main1 {
	width: 100%;
	height: 100%;
	display: inline-block;
	margin-top: 70px;
	/* 	border-style: solid;
    border-color: red; */
}

button {
	width: 90px;
	height: 40px;
	font-weight: 600;
	border-radius: 4px;
	background-color: rgb(241, 196, 15);
	color: white;
}
</style>
</head>
<body>
<%@ include file="../common/logoAndLogbutton.jsp"%>
<div id="main1">
	<%@ include file="adminbar.jsp"%>
	
	<div id="main" align="center">
		<form>
			<div id="child">
				<table border="2" width="100%" id="web-font" class="listBox">
					<tr>
						<td>신청일자</td>
							<td><input type="text" style="background-color: #f1c40fb8;" size="" 
								name="applyDate" readonly value="<%=nb.getApplyDate()%>"></td>
						<td>이름</td>
						<td><input type="text" style="background-color: #f1c40fb8;" size="" 
								name="name" readonly value="<%=nb.getUserNum()%>"></td>
						<td>카테고리</td>
						<td><input type="text" style="background-color: #f1c40fb8;" size="" 
								name="cname" readonly value="<%=nb.getCategoryNum()%>"></td>
					</tr>
					<tr>
						<td colspan="6" >활동 계획서</td>
					</tr>
					<tr>
						<td colspan="6" height="300px"><input type="text" size="110" 
								name="content" readonly value="<%=nb.getBossContent()%>"></td>
					</tr>
				</table>
				<br><br>
			</div>
		</form>
				<button id="web-font" onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu'">이전으로</button>
	</div>
</div>
</body>
</html>