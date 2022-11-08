<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.nuriter.member.model.vo.*, com.kh.nuriter.nuriter.model.vo.*"%>
<%
	Member m = (Member)request.getAttribute("m");
	int numberOfPeople1 = (int)(request.getAttribute("numberOfPeople1"));
	int numberOfPeople2 = (int)(request.getAttribute("numberOfPeople2"));
	int price = (int)(request.getAttribute("price"));
	String ownerNum = request.getAttribute("ownerNum").toString();
	String nuriNum = request.getAttribute("nuriNum").toString();
	Nuriter nu = (Nuriter)request.getAttribute("nu");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Jua"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.js"></script>
<title>Insert title here</title>
<style>
#main {
	/* margin-top:190px;
		margin-left:220px;
		margin-right:auto;
		overflow:hidden; */
	margin-right: 19%;
	float: right;
	overflow: hidden;
	/* border-style: solid;
    	border-color: black; */
}

#child {
	width: 900px;
	overflow: hidden;
	/* border-style: solid;
    	border-color: hotpink; */
}

#child2 {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	overflow: hidden;
	/* border-style: solid;
    	 border-color: hotpink; */
}


#web-font {
	font-family: 'Jua', sans-serif;
}

#submit>button {
	width: 150px;
}

.pagination {
	width: 400px;
	height: auto;
	overflow: hidden; /* 
	    border-style: solid;
    	border-color: hotpink; */
}

.pagination a {
	color: black;
	padding: 8px 16px;
	text-decoration: none;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: rgb(241, 196, 15);
	color: white;
	border: 1px solid rgb(241, 196, 15);
}

.pagination a:hover:not(.active) {
	background-color : #ddd;
}

.pagination a:first-child {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}

.pagination a:last-child {
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

.pagination>button {
	width: 200px;
}
/* hr { 
	    display: block;
	    margin-top: 0.5em;
	    margin-bottom: 0.5em;
	    margin-left: auto;
	    margin-right: auto;
	    border-style: inset;
	    border-width: 10px;
	} */
#child2 table{
	width: 700px;
	height: auto;
	text-align: center;
	border-radius: 5px; /* iOS 둥근모서리 제거 */
}

#child2 table th{
	height:30px;
	background-color:rgb(241, 196, 15);
}

#child2 table td{
	height:50px;
}

select {
	height: 40px;
	border-radius: 5px; /* iOS 둥근모서리 제거 */
	background: rgb(241, 196, 15);
}

button {
	width: 90px;
	height: 40px;
	font-weight: 600;
	border-radius: 4px;
	background-color: rgb(241, 196, 15);
	color: white;
}

button:hover {
	background-color: white; /* Green */
	color: rgb(241, 196, 15);
	border: 2px solid rgb(241, 196, 15); /* Green */
}

#main1 {
	width: 100%;
	height: 100%;
	display: inline-block;
	margin-top: 70px;
	/* 	border-style: solid;
    border-color: red; */
}


</style>
</head>
<body>
	<!-- <div> -->
	<%@ include file="../common/logoAndLogbutton.jsp"%>
	<%--  <%@ include file="../common/categorybar.jsp" %> --%>
	<%-- <%@ include file="../common/myPage_left.jsp" %> --%>
	<div id="main1">
		<%@ include file="adminbar.jsp"%>
		<!-- </div> -->

		<div id="main" align="center">
			<form id="test" action="<%=request.getContextPath()%>/selectNuribossNuriterList.nu?userNum=<%=ownerNum%>" method="post">
			
				<div id="child">
					<div id="child2">
						<h1 id="web-font">지급정보</h1>
						<br>
						<table border="2" id="web-font" class="listBox" style="align:center;">
							<tr>
								<th style="display:none;"><th>
								<th>누리장 이름</th>
								<th>총결제인원</th>
								<th>환불인원</th>
								<th>누리터 참가비</th>
								<th>지급될 돈</th>
								<th>은행명</th>
								<th>계좌번호</th>
								<th>지급하기</th>
								<th>지급여부</th>
							</tr>
							
							
							<tr>
								<input type="hidden" value=<%=ownerNum%>>
								<td id="give" style="display:none;"><input type="hidden" value=<%=nuriNum%>><td>
								<td style="color:rgb(139, 195, 74);"><%=m.getUserName() %></td>
								<td><%=numberOfPeople1 %></td>
								<td><%=numberOfPeople2 %></td>
								<td><%=price %></td>
								<td><%=numberOfPeople1 * price %></td>
								<td style="color:rgb(90, 174, 255);"><%=m.getBankName() %></td>
								<td style="color:rgb(90, 174, 255);"><%=m.getBankNumber() %></td>
								<td id="giveMoney"><div style="color:#FF5E00;">지급하기</div></td>
								<td><%=nu.getPayStatus() %></td>
							</tr>
							
						</table>
						
						<script>
							$(function(){
								$(".listBox #giveMoney").mouseenter(function(){
									$(this).css({"background":"#fed8cd", "cursor":"pointer"});
								}).mouseout(function(){
									$(this).css({"background":"white"});
								}).click(function(){
									var nuriNum = $(this).parent().children("#give").children("input").val();
									/* console.log(nuriNum);
									alert("누리터번호 : " + nuriNum); */
									location.href="<%=request.getContextPath()%>/updatePayStatus.nu?nuriNum=" + nuriNum;
								});
							});
						</script>

						<div class="pagination" align="center">

								<br> <br> <br>

								<div id="eb" align="center">
									 <button id="web-font" >이전 페이지</button>
								</div>
								
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
    </script>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>