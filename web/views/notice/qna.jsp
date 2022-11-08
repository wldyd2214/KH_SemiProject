<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.nuriter.notice.model.vo.PageInfo, com.kh.nuriter.notice.model.vo.*"%>
<% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");

PageInfo pi = (PageInfo)request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.colorgraph {
	width: 98%;
	height: 3px;
	border-top: 0;
	background: rgb(241, 196, 15);
	border-radius: 3px;
}

#showLeft {
	/*  border-style: solid; */
	/* border-color: red; */
	float: left;
	width: 10%;
	/*  height:15%; */
	font-size: 20px;
	display: inline-block;
}

ul.navi2 li a {
	float: center;
	font-size: 15px;
	line-height: 10px;
	color: #000000;
	text-decoration: none;
	/* margin: auto;  */
	/* padding: 0 30px; */
	-moz-border-radius-topright: 10px;
	-webkit-border-top-right-radius: 10px;
	-moz-border-radius-topleft: 10px;
	-webkit-border-top-left-radius: 10px;
}

.web-font {
	font-family: 'Jua', sans-serif;
}

#listTable {
	text-align: center;
	width: 100%;
	max-width: 100%;
	height: 100%;
	border-spacing: 0;
	border-collapse: collapse;
	border: 2px solid #ccc;
	table-layout: fixed;
	font-family: 'Jua', sans-serif;
	border-radius:10px;
}

.showRight {
	float: right;
	height: 800px;
	width: 80%;
	margin-right: 105px;
	font-size:15px;
}

#bButton {
	background: #424242;
	height: 35px;
	color: white;
	float: right;
	border-radius:5px;

	
}

.buttonArea {
	height: 70px;
	width: 68%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 5%;
}

table tr th {
	text-align: center;
	border: 1px solid rgb(241, 196, 15);
	height: 50px;
	background: rgb(241, 196, 15);
}

#listArea {
	margin-right: auto;
	margin-left: auto;
}

table tr td {
	text-align: center;
	border: 1px solid lightgray;
	height: 40px;
}

.pageArea {
	margin-top: 30%;
	height: 500px;
}
</style>
</head>
<body>
	<%@ include file="../common/logoAndLogbutton.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="main" id="web-font">
		<%
         if (!loginUser.equals("admin") && loginUser != null) {
      %>
		<div id="showLeft">
			<ul class="navi2" style="list-style-type: none">
				<hr class="colorgraph">
				<!-- 기능 -->
				<li id="web-font"><a href="views/notice/fnq.jsp">고객센터</a></li>
				<hr class="colorgraph">
				<li id="web-font"><a href="views/notice/fnq.jsp">자주묻는질문</a></li>
				<li id="web-font"><a href="<%=request.getContextPath()%>/selectqnalist.sql">1:1 문의하기</a></li>
			</ul>
		</div>
		<%
         }else{
      %>
		<%@ include file="../admin/adminbar.jsp"%>
		<%} %>

		<div class="showRight">
		<br>
		<h2 id="web-font" align="center">1:1 문의하기</h2>
			<div class="buttonArea">
				<button id="bButton"
					onclick="location.href='views/notice/quaInquire.jsp'">게시글
					작성</button>
			</div>
			<table id="listArea">
				<tr>

					<th width="200px">문의제목</th>
					<th width="500px">문의내용</th>
					<th width="100px">문의자</th>
					<th width="100px">문의날짜</th>
				</tr>
				<tr>
					<% for(Notice n : list){ %>
				
				<tr class="testList">
					<input type="hidden" value="<%=n.getbNumber()%>" name="boardNum">
					<td><%=n.getbTitle() %></td>
					<td><%=n.getbContent() %></td>
					<td><%=n.getUserNumber() %></td>
					<td><%=n.getbDate() %></td>
				</tr>
				<% } %>
			</table>
			<div class="pageArea" align="center">
				<button
					onclick="location.href='<%= request.getContextPath()%>/selectqnalist.sql?currentPage=1'"><<</button>
				<% if(currentPage <= 1){ %>
				<button disabled><</button>
				<% }else{ %>
				<button
					onclick="location.href='<%= request.getContextPath()%>/selectqnalist.sql?currentPage=<%=currentPage - 1%>'"><</button>
				<% } %>
				<% for(int p = startPage; p <= endPage; p++){
               if(p == currentPage){   
            %>
				<button disabled><%= p %></button>
				<%  }else{ %>
				<button
					onclick="location.href='<%= request.getContextPath()%>/selectqnalist.sql?currentPage=<%= p %>'"><%= p %></button>
				<%  } %>

				<% } %>

				<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
				<% }else{ %>
				<button
					onclick="location.href='<%= request.getContextPath()%>/selectqnalist.sql?currentPage=<%= currentPage + 1%>'">></button>
				<% } %>
				<button
					onclick="location.href='<%= request.getContextPath()%>/selectqnalist.sql?currentPage=<%= maxPage %>'">>></button>
			</div>
		</div>
	</div>

	<script>
			$(function(){
				$('.testList').click(function(){
					
		 
					var num = $(this).children(0).eq(0).val();
		            var title =$(this).children(0).eq(1).text();
		            var content =$(this).children(0).eq(2).text();
			        var nickname =$(this).children(0).eq(3).text();
			        var date =$(this).children(0).eq(4).text();
			        
			        location.href="<%= request.getContextPath()%>/selectqnadetail.sdq?num="+num;
				});
				
				
			});
		</script>



</body>
</html>