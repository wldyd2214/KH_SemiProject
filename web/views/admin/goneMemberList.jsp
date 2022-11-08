<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.PageInfo, com.kh.nuriter.member.model.vo.*"%>
 <% 
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
 	System.out.println("list출력  : " + list);
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
 	System.out.println("pi출력 : " + pi);
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	width: auto;
	overflow: hidden;
	/* border-style: solid;
    	border-color: hotpink; */
}

#child2 {
	width: 100%;
	margin-left: 2%;
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
	width: auto;
	height: auto;
	text-align: center;
	border-radius: 5px; /* iOS 둥근모서리 제거 */
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
	th div{
	text-align:center;
	}
	
	.colorgraph{
	margin-top:7%;
	}
</style>
</head>
<body>
<%@ include file="../common/logoAndLogbutton.jsp"%>
<%@ include file="adminbar.jsp"%>
	<div id="main1">
		<div class="main" align="center">
		<form>
			<div id="child">
				<div id="child2">
					<h2 align="center">탈퇴 회원 목록</h2>
					<br>
					<table id="web-font" style="border-line:1px solid black;">
				<tbody>
				<tr>
					<!-- <th width="250px">누리터번호</th> -->
					<!-- <th width="150px">누리장</th> -->
					<th><div style="width:70px">회원번호</div></th>
					<!-- <th><div style="width:100px">누리장명</div></th> -->
					<th><div style="width:150px">아이디</div></th>
					<th><div style="width:70px">이름</div></th>
					<th><div style="width:100px">닉네임</div></th>
					<th><div style="width:250px">주소</div></th>
					<th><div style="width:100px">연락처</div></th>
					<th><div style="width:100px">가입일</div></th>
					<th><div style="width:100px">탈퇴일</div></th>
				</tr>
				
				 <% for(Member m : list){ %>
				<tr>
					
					<td><div class="content"><%=m.getUserNumber()%></div>
					<%-- <td><div class="content"><%=n.getOwnerNum()%></div></td> --%>
					<td><div class="content"><%=m.getUserEmail()%></div></td>
					<td><div class="content"><%=m.getUserName()%></div></td>
					<td><div class="content"><%=m.getNickName()%></div></td>
					<td><div class="content"><%=m.getAddress()%></div></td>
					<td><div class="content"><%=m.getPhone()%></div></td>
					<td><div class="content"><%=m.getEnrollDate()%></div></td>
					<td><div class="content"><%=m.getActivatedDate()%></div></td>
					<!-- <td><div class="content"><input type="button" value="환불신청" onclick="doRefund();"></div></td> -->
				</tr>
				<% } %>
				</tbody>
			</table>	
				
			<br>
			<br>
			<!-- 페이지처리 -->
			<!-- <div class="pageArea" align="center"> -->
			<div class="pagination" align="center" id="web-font">
   			<br>
   			<a href="location.href='<%= request.getContextPath()%>/selectGoneMemberList.ad?currentPage=1'"><<</a>
   			<% if(currentPage <= 1){ %>
   			<a disabled><</a>
   			<% }else{ %>
   			<a onclick="location.href='<%= request.getContextPath()%>/selectGoneMemberList.ad?currentPage=<%=currentPage - 1%>'">&laquo;</a>
   			<% } %>
   			<% for(int p = startPage; p <= endPage; p++){
   				if(p == currentPage){	
   			%>
   				<a class="active" disabled><%= p %></a>
   			<%  }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectGoneMemberList.ad?currentPage=<%= p %>'"><%= p %></a>
   			<%  } %>
   			
   			<% } %>
   			
   			<% if(currentPage >= maxPage){ %>
   				<a disabled>></a>
   			<% }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectGoneMemberList.ad?currentPage=<%= currentPage + 1%>'">></a>
   			<% } %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectGoneMemberList.ad?currentPage=<%= maxPage %>'">>></a>
			</div>
			</div>
			</div>
			</form>
			</div>
			</div>
			
	
   	

</body>
</html>