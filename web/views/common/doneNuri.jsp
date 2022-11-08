<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.PageInfo, com.kh.nuriter.nuriter.model.vo.*"%>
 <% 
	ArrayList<Nuriter> list = (ArrayList<Nuriter>)request.getAttribute("list");
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
	.outer{
		width:850px;
		height:auto;
		background:white;
		color:lightblack;
		margin-top:1%;
		margin-left:auto;
		margin-right:auto;
		/* margin-top:280px; */
	}
	h2{
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
		margin-left:5%;
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
	#web-font{
	align:center;
	}
	 .pagination {
  		display:inline-blick;
	    /* width:400px;
	    height:60px;
	    overflow:hidden; */
	    padding-left: 0%;
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
#notice {
    float: center;
    display: inline-block;
    font-size: 15px;
    margin-left: 50px;
    margin-bottom: 40px;
    }
    
    li.na {
    width: 120px;
    border-style: solid;
    border-color: rgb(241, 196, 15);
    border-top: none;
    border-bottom: none;
}
</style>
</head>
<body>
	<%@ include file="/views/common/myPage_left.jsp" %>
	<%@ include file="/views/common/myNuriList.jsp" %>	
	<div class="outer">
		<br>
		<h2 align="center">참여 종료된 누리터</h2>
		<div class="tableArea" align="center">
			<table id="listArea">
				<tbody>
				<tr>
					<!-- <th width="250px">누리터번호</th> -->
					<!-- <th width="150px">누리장</th> -->
					<th><div style="width:150px">누리터명</div></th>
					<!-- <th><div style="width:100px">누리장명</div></th> -->
					<th><div style="width:100px">시작일시</div></th>
					<th><div style="width:100px">종료일시</div></th>
					<th><div style="width:200px">장소</div></th>
					<th><div style="width:50px">참가비</div></th>
					<th><div style="width:100px">개설일자</div></th>
				</tr>
				
				 <% for(Nuriter n : list){ %>
				<tr>
					<input type="hidden" value="<%= n.getOwnerNum()%>">
					<td><div class="content"><%=n.getNuriTitle()%></div></td>
					<%-- <td><div class="content"><%=n.getOwnerNum()%></div></td> --%>
					<td><div class="content"><%=n.getStartDate()%></div></td>
					<td><div class="content"><%=n.getEndDate()%></div></td>
					<td><div class="content"><%=n.getPlace()%></div></td>
					<td><div class="content"><%=n.getPrice()%></div></td>
					<td><div class="content"><%=n.getApplicationDate()%></div></td>
				</tr>
				<% } %>
				</tbody>
			</table>
			<br>
			<br>
			<!-- 페이지처리 -->
			<!-- <div class="pageArea" align="center"> -->
			<div class="pagination" id="web-font" align="center">
   			<br>
   			<a href="location.href='<%= request.getContextPath()%>/selectDoneNuriList.nu?currentPage=1'"><<</a>
   			<% if(currentPage <= 1){ %>
   			<a disabled><</a>
   			<% }else{ %>
   			<a onclick="location.href='<%= request.getContextPath()%>/selectDoneNuriList.nu?currentPage=<%=currentPage - 1%>'">&laquo;</a>
   			<% } %>
   			<% for(int p = startPage; p <= endPage; p++){
   				if(p == currentPage){	
   			%>
   				<a class="active" disabled><%= p %></a>
   			<%  }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectDoneNuriList.nu?currentPage=<%= p %>'"><%= p %></a>
   			<%  } %>
   			
   			<% } %>
   			
   			<% if(currentPage >= maxPage){ %>
   				<a disabled>></a>
   			<% }else{ %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectDoneNuriList.nu?currentPage=<%= currentPage + 1%>'">></a>
   			<% } %>
   				<a onclick="location.href='<%= request.getContextPath()%>/selectDoneNuriList.nu?currentPage=<%= maxPage %>'">>></a>
   		</div>
		</div>
			
   		
   	<%@ include file="../common/footer.jsp" %>
		</div>

</body>
</html>