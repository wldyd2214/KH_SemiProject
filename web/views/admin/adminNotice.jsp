<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

	#main{
   	/* width:170%; */
   	border:1px solid white;
   	min-height:90%;
   	margin-top:70px;
   }
   
   #web-font{
      font-family: 'Jua', sans-serif;
   } 

	.colorgraph {
      width: 98%;
        height: 3px;
        border-top: 0;
        background: rgb(241, 196, 15);
        border-radius: 3px;
   }


	#showLeft{
     /*  border-style: solid; */
       /* border-color: red; */
       float:left;
       width:10%;
      /*  height:15%; */
       font-size:20px;
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
   
   #notice{
   	border:1px solid white;
   	width:40%;
   	margin-left:auto;
   	margin-right:auto;
   	width: 1080px;
   	min-height: 935px;
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
    background: #eaeaea;
   	text-align:center;
   	height:50px;
   }
   
   table tr td{
    text-align:center;
   	height:50px;
   }
   
   #noticeUpdate{
     border:1px solid white;
     width:100%;
     height:410px;
   }
   
   #noticeUpdate > input[type='text']{
    margin-top: 10px;
   	width:100%;
   }
   
   #noticeUpdate > textarea{
    width:100%;
    height:300px;
    margin-top: 20px;
   }
   
   #noticeUpdate input[type='button']{
   	width: 100px;
    height: 40px;
    float:right;
    margin-top: 5px;
    margin-right: 10px;
    
   }
   
</style>
</head>
<body>
	<%@ include file="../common/logoAndLogbutton.jsp" %>
	
	
<div id="main">
<%@ include file="adminbar.jsp" %>
 <br><br> <br><br>
    <!-- <hr class="colorgraph">
    
	<div id="showLeft" >
     <ul class="navi2" style="list-style-type:none">
        <hr class="colorgraph">
        <li id="web-font"><a href="#">공지사항</a></li>
        <hr class="colorgraph">
        <li id="web-font"><a href="#">Q&A</a></li>
        <li id="web-font"><a href="#">자주묻는질문</a></li>
     </ul>
   	</div> -->
   	
   	<div id="notice" align="center">
   		<div id="upBox" align="center">
   			<label>공지사항</label>
   			<div id="btnBox">
   			  <input type="button" name="update" value="수정">
   			  <input type="button" name="delete" value="삭제">
   			</div>
   		</div>
   	
   		<div id="noticeList">
   			<table border="1" width="100%" height="40%">
   				<tr>
   					<th width="50"></th>
   					<th colspan="5">공지사항 제목</th>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">누리장 신청시 확인해주세요~!</td>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">누리장 신고시!</td>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">ㅇ아아아아앙</td>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">아에이옹우우우우ㅜㅇ</td>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">샤ㅏ라라라라랑</td>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ</td>
   				</tr>
   				<tr>
   					<td><input type="checkbox" name="cb"></td>
   					<td colspan="5">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
   				</tr>
   			</table>
   			<button onclick="#"><<</button>
   			<button onclick="#"><</button>
   			<button onclick="#">></button>
   			<button onclick="#">>></button>
   		</div>
   		<div id="noticeUpdate">
		  <input type="text" id="noticeTitle" placeholder="제목">
		  <textarea rows="15" cols="145">내용을 입력하세요...</textarea>
		  
		  <input type="button" id="" name="upLoad" value="등록">
   		</div>
   	</div>
</div>
   	<%@ include file="../common/footer.jsp" %>
</body>
</html>