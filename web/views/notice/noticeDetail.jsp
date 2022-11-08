<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.nuriter.notice.model.vo.*"%>
<% Notice n = (Notice)request.getAttribute("n");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	
	#main{
   	/* border:1px solid white;
   	min-height:90%: */
   	
   	width: 100%;
    height: 100%;
    display: inline-block;
    margin-top: 70px;
   }
   
   .web-font{
      font-family: 'Jua', sans-serif;
   } 

   ul.navi2 li a {
      float: center;
      font-size: 15px;
      line-height: 10px;
      color: #000000;
      text-decoration: none;
      -moz-border-radius-topright: 10px;
      -webkit-border-top-right-radius: 10px;
      -moz-border-radius-topleft: 10px;
      -webkit-border-top-left-radius: 10px;
   }
   
   #noticeDetail{
   	/* border:1px solid blue;
   	width:40%;
   	margin-left:auto;
   	margin-right:auto;
   	width: 1080px;
   	min-height: 800px;
   	background:#eaeaea; */
   	
   	width: 60%;
   	border:2px solid white;
   	margin-right: 19%;
   	float: right;
   	overflow: hidden;
   	background:rgb(248, 223, 125);
    margin-bottom: 150px;
   	
   }
   
   #upBox{
   	width:100%;
   	height:70px;
   }
   
   
   #tableArea{
     border:1px solid white;
     width:100%;
     height:480px;
   }
   
   #btnBox button {
    background: white;
    color: black;
    border: 1px solid black;
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
 	
 	<div id="noticeDetail" align="center">
 		<div id="upBox" align="center">
   			<h1 class="web-font">공지사항</h1>
   		</div>
 		<div class="tableArea">
 		<table class="web-font">
				<tr>
					<td>제목</td>
					<td colspan="3">
						<input type="text" size="100" 
						name="title" value="<%=n.getbTitle()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" 
						value="<%= n.getUserNumber() %>" name="writer" readonly>
					</td>
					<td>작성일</td>
					<td>
						<input type="date" name="date" 
						value="<%= n.getbDate() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" 
						cols="108" rows="30" 
						style="resize:none;" readonly><%= n.getbContent() %></textarea>
					</td>
				</tr>
				
			</table>
 			<br>
			<div align="center" id="btnBox" class="web-font">
				<button onclick="location.href='<%=request.getContextPath() %>/selectList.no'">이전</button>&nbsp;
				<% if(loginUser != null && loginUser.getUserEmail().equals("admin")){ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectNotice.no?num=<%=n.getbNumber()%>'">수정하기</button>
				<% } %>
			</div>
 		</div>
 	</div>
</div>
<br><br><br><br>
</body>
</html>