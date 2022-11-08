<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.nuriter.nuriter.model.vo.PageInfo, com.kh.nuriter.nuriter.model.vo.*"%>
<%
	ArrayList<Nuriboss> bossList = (ArrayList<Nuriboss>) request.getAttribute("bossList");
	ArrayList<Nuriboss> bossList2 = (ArrayList<Nuriboss>) request.getAttribute("bossList2");
	
	
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = 0;
	int currentPage = 0;
	int maxPage = 0;
	int startPage = 0;
	int endPage = 0;
	if(pi != null){
		listCount = pi.getListCount();
		currentPage = pi.getCurrentPage();
		maxPage = pi.getMaxPage();
		startPage = pi.getStartPage();
		endPage = pi.getEndPage();
	}
	
	PageInfo pi2 = (PageInfo) request.getAttribute("pi2");
	int listCount2 = pi2.getListCount();
	int currentPage2 = pi2.getCurrentPage();
	int maxPage2 = pi2.getMaxPage();
	int startPage2 = pi2.getStartPage();
	int endPage2 = pi2.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Jua"
	rel="stylesheet">
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

#child2 {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	overflow: hidden;
	/* border-style: solid;
    	 border-color: hotpink; */
}

#child3 {
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
	height: 45px;
	/* overflow: hidden;  */
	 
	  /* border-style: solid;
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

.pagination a:hover :not (.active ){
	background-color: #ddd;
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
#child2 table, #child3 table {
	width: 700px;
	height: auto;
	text-align: center;
	border-radius: 5px; /* iOS 둥근모서리 제거 */
}

#child2 table th, #child3 table th{
	/* height:30px; */
	background-color:rgb(241, 196, 15);
}


#child2 table td, #child3 table td{
	/* height:30px; */
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
	<%@ include file="../common/logoAndLogbutton.jsp"%>
	<%-- <%@ include file="../common/categorybar.jsp" %> --%>
	<%--  <%@ include file="../common/myPage_left.jsp" %> --%>
	<div id="main1">


		<%@ include file="adminbar.jsp"%>
		<!-- </div> -->

		<div id="main" align="center">
			<form>
				<div id="child">
					<div id="child2">
						<h1 id="web-font">누리장 신청 회원</h1>
						<br>
						<table border="2" width="100%" id="web-font" class="listBox" align="center">
							<tr>
								<th width="400px" style="text-align:center;">신청일자</th>
								<th width="400px" style="text-align:center;">이름</th>
								<th width="400px" style="text-align:center;">카테고리</th>
								<th width="400px" style="text-align:center;">활동 계획서</th>
							</tr>
							<%
								if(bossList != null) {
								for (Nuriboss nb : bossList) {
							%>
							<tr>
								<input type="hidden" class="applyNum"
									value="<%=nb.getApplyNum()%>">
								<td><%=nb.getApplyDate()%></td>
								<td><%=nb.getUserName()%></td>
								<td><%=nb.getCategoryNum()%></td>
								<td id="checkBtn" style="color: #5AAEFF;">확인하기</td>
							</tr>
							<%
								}
							%>
							<%}else{ %>
								<tr>
									<td colspan="4" style="text-align:center;">신청 회원이 없습니다.</td>
								</tr>
							<%} %>

						</table>

						<script>
								$(function(){
										
									$(".listBox #checkBtn").mouseenter(function(){
										$(this).css({"cursor":"pointer", "background":"#dde8fc"});
									}).mouseout(function(){
										$(this).css({"background":"white"});
									}).click(function(){
										var num = $(this).parent().children("input").val();
										/* alert("야 !!! " + num); */
										location.href="<%=request.getContextPath()%>/selectOneNuriboss.nu?num=" + num;
									});
										
								});
									
						</script>



						<!-- 페이지처리 -->
						
						<% if(pi != null){ %>
						<div class="pagination" align="center">

							<br> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage=1'"><<</a>
							<%
								if (currentPage <= 1) {
							%>
							<a disabled><
								</button> <%
								} else {
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage=<%=currentPage - 1%>'"><</a>
								<%
								}
							%> <%
								for (int p = startPage; p <= endPage; p++) {
									if (p == currentPage) {
							%> <a disabled><%=p%></a> <%
								} else {
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage=<%=p%>'"><%=p%></a>
								<%
								}
							%> <%
								}
							%> <%
								if (currentPage >= maxPage) {
							%> <a disabled>></a> <%
								} else {
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage=<%=currentPage + 1%>'">></a>
								<%
								}
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage=<%=maxPage%>'">>></a>
						</div>
						<% } %>


						<div class="pagination2" align="center">

							<br>

							<input type="button" align="center" class="button"
								style="width: 200px;" value="신청회원 전체보기"
								onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList.nu'">
						</div>
					</div>

					<hr>

					<div id="child3">
						<h1 id="web-font">누리장 회원</h1>
						<br>
						<table border="2" id="web-font" class="listBox2">
							<tr>
								<th width="400px" style="text-align:center;">승인일자</th>
								<th width="400px" style="text-align:center;">이름</th>
								<th width="400px" style="text-align:center;">카테고리</th>
								<th width="400px" style="text-align:center;">활동 계획서</th>
							</tr>
							<%
								for (Nuriboss nb2 : bossList2) {
							%>
							<tr>
								<input type="hidden" class="applyNum"
									value="<%=nb2.getApplyNum()%>">
								<td><%=nb2.getApplyDate()%></td>
								<td><%=nb2.getUserName()%></td>
								<td><%=nb2.getCategoryNum()%></td>
								<td id="checkBtn2" style="color: #5AAEFF;">확인하기</td>
							</tr>
							<%
								}
							%>
							
						</table>

						<script>
								$(function(){
										
									$(".listBox2 #checkBtn2").mouseenter(function(){
										$(this).css({"cursor":"pointer", "background":"#dde8fc"});
									}).mouseout(function(){
										$(this).css({"background":"white"});
									}).click(function(){
										var num = $(this).parent().children("input").val();
										/* alert("야 !!! " + num); */
										location.href="<%=request.getContextPath()%>/selectOneNuriboss.nu?num=" + num;
									});
										
								});
									
						</script>

						<!-- 페이지처리 -->
						<div class="pagination" align="center">

							<br> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage2=1'"><<</a>
							<%
								if (currentPage2 <= 1) {
							%>
							<a disabled><
								</button> <%
								} else {
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage2=<%=currentPage2 - 1%>'"><</a>
								<%
								}
							%> <%
								for (int p2 = startPage2; p2 <= endPage2; p2++) {
									if (p2 == currentPage2) {
							%> <a disabled><%=p2%></a> <%
								} else {
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage2=<%=p2%>'"><%=p2%></a>
								<%
								}
							%> <%
								}
							%> <%
								if (currentPage2 >= maxPage2) {
							%> <a disabled>></a> <%
								} else {
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage2=<%=currentPage2 + 1%>'">></a>
								<%
								}
							%> <a
								onclick="location.href='<%=request.getContextPath()%>/selectNuribossList.nu?currentPage2=<%=maxPage2%>'">>></a>
						</div>

						<div class="pagination2" align="center">

							<br> 
							
							<input type="button" class="button" style="width:200px;"
								value="누리장 전체보기"
								onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList2.nu'">
						</div>
						
					</div>
				</div>
			</form>
		</div>
	</div>



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