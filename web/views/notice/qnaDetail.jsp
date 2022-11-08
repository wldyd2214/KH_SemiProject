<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.nuriter.notice.model.vo.*"%>
<%
	Notice n = (Notice) request.getAttribute("n");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

.showRight {
	float: right;
	height: 900px;
	width: 80%;
	margin-right: 30px;

}

#web-font {
	font-family: 'Jua', sans-serif;
}

#qnaDetail {
	font-family: 'Jua', sans-serif;
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	width: 1080px;
	min-height: 800px;
}

#tableArea {
	border: 1px solid white;
	width: 100%;
	height: 480px;
}

img {
	max-width: 100%;
	height: auto;
}

.commentDiv input[type=text] {
	border-radius: 3px;
	margin-top: 50px;
	width: 600px;
	height: 100px;
	box-sizing: border-box;
	border-style: solid;
	/* border-color: rgb(241, 196, 15); */
}

.commentBtn {
	width: 100px;
	height: 100px;
	background-color: #FFBF00; /* Green */
	font-family: 'Jua', sans-serif;
	color: black;
	border-radius: 3px;
	font-size: 20px;
	border: 2px solid rgb(241, 196, 15); /* Green */
}

.commentBtn:hover {
	width: 100px;
	height: 100px;
	background-color: rgb(241, 196, 15); /* Green */
	font-family: 'Song Myung', serif;
	color: black;
	border-radius: 3px;
	font-size: 20px;
	border: 2px solid rgb(241, 196, 15); /* Green */
	opacity: 0.6;
}

.commentDiv {
	width: 800px;
}

#commentSelectTable {
	width: 799px;
	font-size: 24px;
	border-bottom: 2px solid rgb(241, 196, 15);
}

.commentSelectArea #commentSelectTable td {
	font-size: 24px;
	border-bottom: 2px solid rgb(241, 196, 15);
}

#commentSelectTable tr {
	font-size: 24px;
}

.commentSelectArea #commentSelectArea {
	width: 500px;
	overflow: hidden;
}

#trImage {
	width: 150px;
}

.trNickName {
	border-bottom: 2px solid rgb(241, 196, 15);
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
	<div class="main">
		<%
			if (loginUser.getUserEmail().equals("admin")) {
		%>
		<%@ include file="../admin/adminbar.jsp"%>
	
		<%
			} else {
		%>
			<div id="showLeft">
			<ul class="navi2" style="list-style-type: none">
				<hr class="colorgraph">
				<!-- 기능 -->
				<li id="web-font"><a href="views/notice/fnq.jsp">1:1문의하기</a></li>
				<hr class="colorgraph">
				<li id="web-font"><a href="views/notice/fnq.jsp">자주묻는질문</a></li>
				<li id="web-font"><a
					href="<%=request.getContextPath()%>/selectqnalist.sql">1:1 문의하기</a></li>
			</ul>
		</div>
		<%
			}
		%>

		<div class="showRight">
			<div id="qnaDetail" align="center">
				<h2 id="web-font">문의하기</h2>
				<div class="tableArea">
					<table>
						<tr>
							<td>제목</td>
							<td colspan="3"><input type="text" size="90" name="title"
								value="<%=n.getbTitle()%>" readonly></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" value="<%=n.getUserNumber()%>"
								name="writer" readonly></td>
							<td>작성일</td>
							<td><input type="date" name="date" value="<%=n.getbDate()%>"
								readonly></td>
						</tr>
						<tr>
							<td>내용</td>
						</tr>
						<tr>
							<td colspan="4"><textarea name="content" cols="100"
									rows="15" style="resize: none" readonly><%=n.getbContent()%></textarea>
							</td>
						</tr>

					</table>
					<br>
					<div class="commentDiv">
						<input type="text" id="web-font" name="comment" class="comment">&nbsp;&nbsp;
						<button class="commentBtn">댓글 등록</button>
					</div>
					<div class="commentSelectArea">
						<table id="commentSelectTable"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			$(function(){
				window.onload=function(){
					var boardNum = "<%=n.getbNumber()%>";
					var content = $('.comment').val();
					
					$.ajax({
						url:"/ns/insertqnacomment.iqc",
						data:{boardNum:boardNum, content:content},
						type:"post",
						success:function(data){
							
							$table = $("#commentSelectTable");
							$table.find("tr").remove();
							
							for(var key in data){
								var $trOne = $("<tr><td align='center' rowspan='4' id='trImage'><img src='images/board/ori.png'>");
								var $trDate = $("<tr id='web-font'>");
							    var $trContent = $("<tr id='web-font'>");
							    var $trNickName = $("<tr class='trNickName' id='web-font' style='size= 1px;'>");
								$trDate.text(data[key].comment_date);
								$trContent.text(data[key].comment_content);
								$trNickName.text(data[key].nickname);
								$table.append($trOne);
								$table.append($trDate);
								$table.append($trContent);
								$table.append($trNickName);
							}
							
							$("#commentSelectTable").show();
							
							
						},
						error:function(data){
							console.log(data);
						}
					});
				}
				
				
				$(".commentBtn").click(function(){
					
					var boardNum = "<%=n.getbNumber()%>";
									var content = $('.comment').val();

									$.ajax({
												url : "/ns/insertqnacomment.iqc",
												data : {
													boardNum : boardNum,
													content : content
												},
												type : "get",
												success : function(data) {

													$table = $("#commentSelectTable");
													$table.find("tr").remove();

													for ( var key in data) {
														var $trOne = $("<tr id='web-font'><td align='center' rowspan='4' id='trImage'><img src='images/board/ori.png'>");
														var $trDate = $("<tr class='trDate' id='web-font'>");
														var $trContent = $("<tr class='trContent' id='web-font'>");
														var $trNickName = $("<tr class='trNickName' id='web-font'>");
														$trDate
																.text(data[key].comment_date);
														$trContent
																.text(data[key].comment_content);
														$trNickName
																.text(data[key].nickname);
														$table.append($trOne);
														$table.append($trDate);
														$table
																.append($trContent);
														$table
																.append($trNickName);
													}

													$input = $(".comment");
													$input.val('');

													$("#commentSelectTable")
															.show();

												},
												error : function(data) {
													console.log(data);
												}
											});

								});
			});
		});
	</script>
</body>
</html>