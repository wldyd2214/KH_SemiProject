<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.member.model.vo.PageInfo, com.kh.nuriter.member.model.vo.*"%>
 <% 
 	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
 	String nuriNum = (String)request.getAttribute("nuriNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	.outer{
		width:850px;
		height:auto;
		background:white;
		color:lightblack;
		margin-top:15%;
		margin-left:auto;
		margin-right:auto;
		/* margin-top:280px; */
	}
	#h2{
	font-family: 'Jua', sans-serif;
	}
	table {
		border:1px solid gray;
		text-align:center;
		font-family: 'Jua', sans-serif;
		width:auto;
		height:auto;
	}
	.tableArea {
		width:650px;
		height:auto;
		margin-left:12%;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	}
	table tr th{
	text-align:center;
	/* width:auto;
	height:auto; */
	}
	
	table td td{
	width:auto;
	}
	
	.content{
	padding-left:15px;
	padding-right:15px;
	white-space:nowrap;
	} 

	#listArea{
	align:center;
	}
	
	/* .pageArea{
	padding-left:20%;
	} */
	
	tbody{
		width:auto;
		height:auto;
	}
	
	 .pagination {
  		display:inline-blick;
	    /* width:400px;
	    height:60px;
	    overflow:hidden; */
	    padding-left: 45%;
	    margin: 20px 0;
	    boder-radius:4px;
	    pointer: cursor;
	    align:center;
	}

	.pagination a {
	    color: black;
	    padding: 8px 16px;
	    text-decoration: none;
	    border: 1px solid #ddd;
	    pointer: cursor;
	}
	.pagination a.active {
	    background-color: rgb(241, 196, 15);
	    color: white;
	    border: 1px solid rgb(241, 196, 15);
	    pointer: cursor;
	}
	.pagination a:hover:not(.active) {
		background-color: #ddd;
		pointer: cursor;
	}

	.pagination a:first-child {
	    border-top-left-radius: 5px;
	    border-bottom-left-radius: 5px;
	    pointer: cursor;
	}

	.pagination a:last-child {
	    border-top-right-radius: 5px;
	    border-bottom-right-radius: 5px;
	    pointer: cursor;
	
}
</style>
</head>
<body>
	<%@ include file="/views/common/myPage_left.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center" id="h2">누리원 명단</h2>
		<hr>
		<div class="tableArea" align="center">
			<table id="listArea">
				<tbody>
				<tr>
					<input type="hidden" id="bossNum" value="<%=loginUser.getUserNumber()%>">
					<th><div style="width:150px">누리원 이름</div></th>
					<th><div style="width:100px">연락처</div></th>
					<th><div style="width:100px">출석정보</div></th>
				</tr>				
				 <% for(Member m : list){ %>
				<tr>
					<td><div class="content"><%=m.getNickName()%></div></td>
					<td><div class="content"><%=m.getPhone()%></div></td>
					<td><div class="content">
					<input type="button" class="checkBtn" value="확인하기">
					<input type="hidden" class="nuriNum" name="nuriNum" value="<%=nuriNum%>">
					<input type="hidden" class="userNum" value="<%=m.getUserNumber()%>">
					<input type="hidden" class="nickName" value="<%=m.getNickName()%>">
					</div></td>
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
   			<a href="location.href='<%= request.getContextPath()%>/selectMyMemberList.at?currentPage=1'"><<</a>
   			<% if(currentPage <= 1){ %>
   			<a disabled><</a>
   			<% }else{ %>
   			<a onclick="location.href='<%= request.getContextPath()%>/selectMyMemberList.at?currentPage=<%=currentPage - 1%>'">&laquo;</a>
   			<% } %>
   			<% for(int p = startPage; p <= endPage; p++){
   				if(p == currentPage){	
   			%>
   				<a class="active" disabled><%= p %></a>
   			<%  }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectMyMemberList.at?currentPage=<%= p %>'"><%= p %></a>
   			<%  } %>
   			
   			<% } %>
   			
   			<% if(currentPage >= maxPage){ %>
   				<a disabled>></a>
   			<% }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectMyMemberList.at?currentPage=<%= currentPage + 1%>'">></a>
   			<% } %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectMyMemberList.at?currentPage=<%= maxPage %>'">>></a>
   		</div>
		</div>
		</div>

</body>
<script>
	$(function(){
		$('.checkBtn').on('click', function(){
			var nunum = $(this).next('.nuriNum').val();
			console.log(nunum);
			var usernumber = $('#bossNum').val();
			var nickName = $('.nickName').val();
			console.log(usernumber);
			location.href="<%=request.getContextPath()%>/mynuriMemberAttend.at?nunum=" + nunum + "&usernumber=" + usernumber + "&nickName=" + nickName; 
			});
		});
	
</script>
</html>