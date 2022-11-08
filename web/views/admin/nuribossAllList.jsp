<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.nuriter.nuriter.model.vo.PageInfo, com.kh.nuriter.nuriter.model.vo.*"%>
<%
	ArrayList<Nuriboss> bossList = (ArrayList<Nuriboss>) request.getAttribute("bossList");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
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
#child2 table, #child3 table {
	width: 700px;
	height: auto;
	text-align: center;
	border-radius: 5px; /* iOS 둥근모서리 제거 */
}

#child2 table th, #child3 table th{
	height:30px;
	background-color:rgb(241, 196, 15);
}

#child2 table td, #child3 table td{
	height:50px;
}

#search-select {
	display: inline;
}

#search-web-font {
	margin-left: 15px;
	font-family: 'Jua', sans-serif;
	font-size: 150%;
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
			<form id="test">
				<div id="child">
					<div id="child2">
						<h1 id="web-font">누리장 회원</h1>
						<br>
						<table border="2" id="web-font" class="listBox" style="align:center;">
							<tr>
								<th style="display:none;"></th>
								<th style="display:none;"></th>
								<th>누리장 신청일자</th>
								<th>이름</th>
								<th>카테고리</th>
								<th>승인</th>
								<th>취소</th>
							</tr>
							<%
								for (Nuriboss nb : bossList) {
							%>
							<tr>
								<td id="tdApplyNum" style="display:none;"><input type="hidden" value="<%=nb.getApplyNum()%>"></td>
								<td id="tdUserNum" style="display:none;"><input type="hidden" value="<%=nb.getUserNum()%>"></td>
								<td><%=nb.getApplyDate()%></td>
								<td><%=nb.getUserName()%></td>
								<td><%=nb.getCategoryNum()%></td>
								<td id="applyBtn"><div style="color:#5AAEFF; text-align:center;">승인하기</div></td>
								<td id="cancelBtn"><div style="color:#FF5E00;">취소하기</div></td>
							</tr>
							<%
								}
							%>
						</table>
						
						<script>
						$(function(){
							$(".listBox td").mouseenter(function(){
								$(this).parent().css({"background":"#eaeaea", "cursor":"pointer"});
							}).mouseout(function(){
								$(this).parent().css({"background":"white"});
							}).click(function(){
								var num = $(this).parent().children("#tdApplyNum").children("input").val();
								location.href="<%=request.getContextPath()%>/selectOneNuriboss.nu?num=" + num;
							});
							
							$(".listBox #applyBtn").mouseenter(function(){
								$(this).css({"background":"#dde8fc"});
							}).mouseout(function(){
								$(this).css({"background":"white"});
							}).click(function(){
								var applyNum = $(this).parent().children("#tdApplyNum").children("input").val();
								var userNum = $(this).parent().children("#tdUserNum").children("input").val();
								location.href="<%=request.getContextPath()%>/updateNuribossStatus.nu?applyNum="+applyNum+"&userNum="+userNum;
							});
							
							$(".listBox #cancelBtn").mouseenter(function(){
								$(this).css({"background":"#fed8cd"});
							}).mouseout(function(){
								$(this).css({"background":"white"});
							}).click(function(){
								var applyNum = $(this).parent().children("#tdApplyNum").children("input").val();
								var userNum = $(this).parent().children("#tdUserNum").children("input").val();
								location.href="<%=request.getContextPath()%>/deleteNuriboss.nu?applyNum="+applyNum+"&userNum="+userNum;
							});
							
						});
						</script>

						<div class="pagination" align="center">

							<br>


							<a onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList.nu?currentPage=1'"><<</a>
							<% if (currentPage <= 1) {%>
							<a disabled><</button> 
							<% } else { %> 
							<a onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList.nu?currentPage=<%=currentPage - 1%>'"><</a>
							<% } %> 
							<% for (int p = startPage; p <= endPage; p++) {
 								if (p == currentPage) { %> 
 									<a disabled><%=p%></a> 
 							 <% } else { %> 
 							 <a onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList.nu?currentPage=<%=p%>'"><%=p%></a>
							<%	} %> 
							<% } %> 
							<% if (currentPage >= maxPage) { %> 
									<a disabled>></a> 
							<% }else { %> 
								<a onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList.nu?currentPage=<%=currentPage + 1%>'">></a>
							<% } %> <a onclick="location.href='<%=request.getContextPath()%>/selectNuriBossDetailList.nu?currentPage=<%=maxPage%>'">>></a>


								<br> <br> <br>

								<div id="search-select">
									<select id="web-font">
										<option id="web-font">신청일자</option>
										<option id="web-font">이름</option>
										<option id="web-font">카테고리</option>
									</select>
								</div>

								<div class="ui left icon action input">

									<i class="search icon"></i> <input type="text"
										placeholder="Order">
									<div class="ui blue submit button">
										<font id="search-web-font">검색</font>
									</div>
								</div> <br> <br>

								<div id="submit" align="center">
									<!-- <button id="web-font" onclick="deleteNuriboss();">누리장 삭제</button> -->
									<button id="web-font" onclick="goBefore();">이전 페이지</button>
								</div>
								<script>
									function goBefore(){
										$("#test").attr("action", "<%=request.getContextPath()%>/selectNuribossList.nu");
									}
								</script>
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