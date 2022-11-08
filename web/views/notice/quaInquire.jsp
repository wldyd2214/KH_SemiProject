<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

.showRight {
	float: right;
	height: 100%;
	width: 80%;
	margin-right: 30px;
}

#web-font {
	font-family: 'Jua', sans-serif;
}

#qnaInquire {
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	width: 1080px;
	min-height: 700px;
}



table tr td {
	text-align: center;
	height: 40px;
	text-size: 20px;
	margin-top: 20px;
}

input {
	height: 40px;
}
button{
	background: #424242;
	height: 35px;
	border-radius:5px;
	
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
	<hr style="border: solid 1px lightgray;">
	<div class="main">
		<%
			if (!loginUser.getUserEmail().equals("admin") && loginUser != null) {
		%>
		<div id="showLeft">
			<ul class="navi2" style="list-style-type: none">
				<hr class="colorgraph">
				<!-- 기능 -->
				<li id="web-font"><a href="views/notice/fnq.jsp">고객센터</a></li>
				<hr class="colorgraph">
				<li id="web-font"><a href="<%=request.getContextPath()%>/views/notice/fnq.jsp">자주묻는질문</a></li>
				<li id="web-font"><a
					href="<%=request.getContextPath()%>/selectqnalist.sql">1:1 문의하기</a></li>
			</ul>
		</div>
		<%
			} else {
		%>
		<%@ include file="../admin/adminbar.jsp"%>
		<%
			}
		%>
		<div class="showRight" id="web-font">
			<div id="qnaInquire" align="center">
				<h2 align="center">질문하기</h2>
				<div id="tableArea">
					<form action="<%=request.getContextPath()%>/insert.qi"
						method="post">
						<table align="center">
							<tr>
								<td colspan="3">제목 <input type="text" size="95%"
									name="title"></td>
							</tr>
							<br>
							<tr>
								<td>작성자 <input type="text"
									value="<%=loginUser.getNickName()%>" name="writer" readonly>
									<input type="hidden" value="<%=loginUser.getUserNumber()%>"
									name="userNum">
								</td>
								<td></td>
								<td>작성일 <input type="date" name="date"></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							
							<tr>
							
								<td colspan="4"><textarea name="content" cols="100"
										rows="25" style="resize: none" placeholder="문의 내용을 입력하세요,,"></textarea>
								</td>
							</tr>
						</table>
						<div align="center" style="margin-top:50px;">
							<button type="submit" style="color:white">등록하기</button>
							<button type="reset" style="color:white">취소하기</button>
						</div>
					</form>
				</div>

				<br>

			</div>
		</div>
	</div>
</body>
</html>