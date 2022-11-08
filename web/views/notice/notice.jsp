<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.notice.model.vo.PageInfo, com.kh.nuriter.notice.model.vo.*"%>
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

<title>공지사항</title>
<style>

	#main{
   	width: 100%;
    height: 100%;
    display: inline-block;
    margin-top: 70px;
   }
   
   .web-font {
   	font-family: 'Jua', sans-serif;
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
   
   #notice{
   	width: 60%;
   	border:1px solid white;
   	margin-right: 19%;
   	float: right;
   	overflow: hidden;
   }
   
   #upBox{
   	border:1px solid white;
   	width:100%;
   	height:50px;
   }
   
   #upBox > label {
    font-size:20px;
   	float: left;
   }
   
   #btnBox{
     border:1px solid white;
     width:30%;
     height:40px;
     float:right;
   }
   
   #btnBox > input{
    /* display:table-cell; */
   	width: 100px;
    height: 40px;
   	font-size: 16px;
   	text-align: center;
   	line-height: 2.5em;
   	border-top-left-radius: 4px;
   	border-top-right-radius: 4px;
   	border-bottom-right-radius: 4px;
    border-bottom-left-radius: 4px;
    background-color: rgb(224, 224, 224);
   }
   
   #noticeList{
     border:1px solid white;
     width:100%;
     height:480px;
   }
   
   table {
    margin-bottom: 20px;
   }
   
   table tr th{
    background: white;
   	text-align:center;
   	height:50px;
   }
   
   table tr td{
    text-align:center;
   	height:50px;
   }
   
   
   
   .pagination {
   width: 400px;
   height: auto;
   
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

.pagination a:hover:not (.active ) {
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

#btnBox button {
    background: rgb(127, 182, 64);
    color: white;
    border: none;
}
   
</style>
</head>
<body>
	<%@ include file="../common/logoAndLogbutton.jsp" %>
	
	<div id="main">
	
	<% if(loginUser != null && loginUser.getUserEmail().equals("admin")){ %>
	
		<%@ include file="../admin/adminbar.jsp"%>

   	<% }else{ %>
   	
   	<br><br><br><br>
   	
   	<% } %>
   	
   	<div id="notice" align="center">
   		<div id="upBox" align="center">
   			<h1 class="web-font">공지사항</h1>
   			<div id="btnBox">
   			
   			<% if(loginUser != null 
			     && loginUser.getUserEmail().equals("admin")){ %>
			     
   			  <button onclick="location.href='views/notice/noticeInsertForm.jsp'" class="web-font">작성하기</button>
   			  
   			<% } %>
   			
   			</div>
   		</div>
   	
   		<div id="noticeList">
   			<table border="2" width="100%" height="40%" id="listArea" class="web-font">
   				<tr>
					<th width="10%">글번호</th>
					<th width="35%">글제목</th>
					<th width="15%">작성자</th>
					<th width="10%">조회수</th>
					<th width="30%">작성일</th>
   				</tr>
   				<% for(Notice n : list){ %>
				<tr>
					<input type="hidden" value="<%= n.getbNumber()%>">
					<td><%= n.getbRownum() %></td>
					<td><%= n.getbTitle() %></td>
					<td><%= n.getUserNumber() %></td>
					<td><%= n.getbCount() %></td>
					<td><%= n.getbDate() %></td>
				</tr>
				<% } %>
   			</table>
   		</div>
   		
   		<!-- 페이지처리 -->
   		<div class="pagination" align="center">
   			<a onclick="location.href='<%= request.getContextPath()%>/selectList.no?currentPage=1'"><<</a>
   			<% if(currentPage <= 1){ %>
   			<a disabled><</a>
   			<% }else{ %>
   			<a onclick="location.href='<%= request.getContextPath()%>/selectList.no?currentPage=<%=currentPage - 1%>'"><</a>
   			<% } %>
   			<% for(int p = startPage; p <= endPage; p++){
   				if(p == currentPage){	
   			%>
   				<a disabled><%= p %></a>
   			<%  }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectList.no?currentPage=<%= p %>'"><%= p %></a>
   			<%  } %>
   			
   			<% } %>
   			
   			<% if(currentPage >= maxPage){ %>
   				<a disabled>></a>
   			<% }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectList.no?currentPage=<%= currentPage + 1%>'">></a>
   			<% } %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectList.no?currentPage=<%= maxPage %>'">>></a>
   		</div>
   		
   	</div>
</div>

	<script>
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"rgb(245, 250, 240)", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var num = $(this).parent().children("input").val();
				console.log(num);
				location.href="<%= request.getContextPath()%>/selectOne.no?num=" + num;
			});
		});
	</script>

</body>
</html>