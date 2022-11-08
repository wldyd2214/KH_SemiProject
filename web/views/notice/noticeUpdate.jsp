<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.nuriter.notice.model.vo.*"%>
<% Notice n = (Notice)request.getAttribute("n"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	#main{
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
   
   #noticeModify{
   	width: 60%;
   	border:1px solid white;
   	margin-right: 19%;
   	float: right;
   	overflow: hidden;
   	background:rgb(248, 223, 125);
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
<% if(loginUser != null && loginUser.getUserEmail().equals("admin")){ %>

<div id="main">

	<%@ include file="../admin/adminbar.jsp"%>

   	<div id="noticeModify" align="center">
   		<div id="upBox" align="center">
   			<h1 class="web-font">공지 사항 수정</h1>
   		</div>
   		<div class="tableArea">
   			<form id="updateForm" method="post">
			<table class="web-font">
				<tr>
					<td>제목</td>
					<td colspan="3">
							<input type="text" size="100" 
							name="title" value="<%=n.getbTitle()%>">
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" value="<%= n.getUserNumber() %>" name="writer" readonly>
					</td>
					<td>작성일</td>
					<td>
						<input type="date" name="date" value="<%= n.getbDate() %>">
					</td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="108" rows="30" style="resize:none"><%= n.getbContent() %></textarea>
					</td>
				</tr>
			</table>
			<br>
				<div align="center" id="btnBox" class="web-font">
					<button onclick="complete();">작성완료</button>
					<button onclick="deleteNotice();">삭제하기</button>
				</div>
			<script>
				function complete(){
					$("#updateForm").attr("action", "<%=request.getContextPath()%>/updateNotice.no?num=<%= n.getbNumber() %>");
				}
				
				function deleteNotice(){
					$("#updateForm").attr("action", "<%= request.getContextPath()%>/deleteNotice.no?num=<%= n.getbNumber() %>");
				}
			</script>
		</form>
   		</div>
   	</div>
</div>

<%} else{
	request.setAttribute("msg", "잘못된 경로로 접근하셨습니다");
	request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
}%>

</body>
</html>