<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>누리터 아이디&비밀번호 찾기</title>
<style>
   
   html{
   		height:100%;
   }
   body{
   	 height:100%;
   }
   #main{
   	min-height:90%:
   }
   
   .colorgraph {
      width: 98%;
        height: 3px;
        border-top: 0;
        background: gray;
        border-radius: 3px;
   }
   #wrapper {
       width:70%;
           /*margin : 0 auto ;*/
   }
   
   #tableDiv{
      width:100%;
      height:100%;
      display: inline-block;
     /*  border-style: solid; */
       /* border-color: red; */
       
       
   }
   #tableDiv table{
   	  width:20%;
   	  height:20%;
      display: inline-block;
      margin-top:1%;
      /* margin: 8px; */
      margin-left:1%;
   }
   #tableDiv table tr{
      align: center;
      border: 2px solid black;
      
   }
   #tableDiv table tr td{
      background: white;
   }
   
   ul.navi li {
      display: inline-block;
      /* margin:auto;  */
      text-align:center;
     
   }
   ul.navi li a {
      float: center;
      font-size: 20px;
      line-height: 40px;
      color: #000000;
      text-decoration: none;
      margin: auto; 
      padding: 0 30px;
      -moz-border-radius-topright: 10px;
      -webkit-border-top-right-radius: 10px;
      -moz-border-radius-topleft: 10px;
      -webkit-border-top-left-radius: 10px;
   }
   .navi li a:hover {
      color:#FF4500;
   }
   
   ul.navi2 li a {
      float: center;
      font-size: 20px;
      line-height: 40px;
      color: #000000;
      text-decoration: none;
       /* margin: auto;  */
      /* padding: 0 30px; */
      -moz-border-radius-topright: 10px;
      -webkit-border-top-right-radius: 10px;
      -moz-border-radius-topleft: 10px;
      -webkit-border-top-left-radius: 10px;
   }
   
   #showMain{
     /*  border-style: solid; */
       /* border-color: red; */
      display: inline-block;
      width:100%;
      height:100%;
   }
   
   #showLeft{
     /*  border-style: solid; */
       /* border-color: red; */
       width:10%;
      /*  height:15%; */
       font-size:20px;
        display: inline-block;
   }
   
   #showRight{
     /*  border-style: solid; */
     /*  border-color: red; */
     float:right;
     /*   margin-left: 10%; */
      display: inline-block;
      width: 50%;
      height:100%;
      
      
   }
   
   #showRightButton{
   	  
      margin-left: 8%;
      width:50%;
      height:30%;
   }
   
   #web-font{
      font-family: 'Jua', sans-serif;
   }
   
   #head{
      margin-left:3%;
      margin-top:1%;
      color: rgb(241, 196, 15);
      font-size:3em;
       text-decoration: none;
      /* padding:8px; */
      /* width:80%; */
   }
   
   #iBox{
      display: inline-block;
      /* margin-top: 5px; */
      /* margin-left: 30px; */
      width:100%;
      height:60%;
      /*  height: 40px; */
     /*  background:url(../images/board/1.jpg) no-repeat left top/ cover; */
   }
   
   #search{
   	  display: inline-block;
      width:50%;
      height:10%;
      margin-left:25%;
     /*  float:center; */
   }
   
   #searchBox{
    display: inline-block;
       color: rgb(94, 94, 94);
       border-width: 3px;
       border-style: solid;
       border-color: rgb(241, 196, 15);
       width:80%;
       height:60px;
   }
   
   #searchBtn {
     width: 90px;
   	 height: 60px;
     border-radius: 3px;
    font-weight: 600;
     border-color: transparent;
     font-size: 15px;
    color: white;
    cursor: pointer;
    background-color: rgb(241, 196, 15);
   }
   
   #loginBtn{
   	  float:right;
      display: inline-block;
      margin-top: 2%;
      margin-right:1%;
   	/*   margin-left: 20%; */
   	 width:40%;
   	 
   }
   #loginBtn a{
   		/* display:inline-block; */
   		width:10%;
   		 text-decoration: none;
   		 margin-right:2%;
   		 color:#646464;
   }
   
   .button{
       width: 90px;
     height: 40px;
     font-weight: 600;
     border-radius: 4px;
     background-color: rgb(241, 196, 15); 
     color: white;
   }
   
   .button:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
   #showMain button{
       width: 150px;
     height: 40px;
     font-weight: 600;
     border-radius: 4px;
     background-color: rgb(241, 196, 15); 
     color: white;
   }
   
   #showMain button:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
   #showRightButton button{
       width: 150px;
     height: 40px;
     font-weight: 600;
     border-radius: 4px;
     background-color: rgb(241, 196, 15); 
     color: white;
   }
   
   #showRightButton button:hover {
     background-color: white;
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15);
   }
   
    #category{
      /* border:1px solid black; */
      height:62px;
      margin-top:50px;
      text-align:center;
      font-size: 35px;
       font-weight: bold;
   }
   
   #category1{
      /* border:1px solid black; */
      margin-left: auto;
       margin-right: auto;
       width: 907px;
      height:195px;
   }
   
   #recommendText{
   text-align:center;
      font-size:25px;
      font-weight: bold;
      margin-left: auto;
      margin-right: auto;
      margin-top: 100px;
      height: 50%;
      width: 70%;
   }
   
   #help{
   		text-align:center;
   		float:right;
   		/* margin-top:1%; */
   		margin-right:2%;
   }
   
    #listBox{
   border:1px solid black;
    height: 352px;
    width: 682px;
    /* margin-left:auto;
    margin-right:auto; */
    margin:auto;
   
   }
   
    #notice{
   	 /* border:1px solid black; */
   	  display:inline-block;
   	  width:50%;
      height:80%;
      margin-left:2%;
     /*  margin-top:50px; */
      /* text-align:center; */
      font-size: 15px;
       /* font-weight: bold; */
   }
   #web-font2{
      font-family: 'Jua', sans-serif;
       border-radius: 4px;
        background-color: rgb(241, 196, 15); 
     color: white;
      
   }
   #web-font2:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
    
</style>
</head>
<body>
	<font id="web-font"><div id="main">
		
		<!-- <font id="web-font"><a id="head" href='../../index.jsp'>누리터</a></font>-->
		<font id="web-font"><a id="head" href="#home" onclick="home()">누리터</a></font> 
		<!-- <h1 align="center">회원가입</h1> -->
		<br><br><br><br><br><br>
		<div id="iBox">
			<div style="width:200px; display:inline-block; margin-left:20%;">
			<p style="font-size:2em;">아이디 찾기</p>
			</div>
			<div style="width:200px; display:inline-block; margin-left:27%;">
			<p style="font-size:2em;">비밀번호 찾기</p>
			</div>
			<br><br>
			<form id="form1" action="<%=request.getContextPath()%>/findUser" method="post" style="margin-left: 20%; display: inline-block;">
				<table align="center">
					<tr>
						<!-- <td><label>아이디</label></td> -->
						<td><input id="findName" type="text" name="findName"  style="width: 300px; height: 30px;"
						placeholder="이름"></td>
					</tr>
					<tr>
						<!-- <td><label>비밀번호</label></td> -->
						<td><input id="findTel" type="tel" name="findTel"  style="width: 300px; height: 30px;"
						placeholder="전화번호"></td>
					</tr>
					<!-- <tr>
						<td colspan="2" align="center">
							<input style="width: 300px; height: 30px;" type="submit" value="ID찾기">
						</td>	
					</tr> -->
				</table>
				<br><br>
				<input id="web-font2" style="width: 300px; height: 30px;" type="submit" value="ID찾기">
			</form>
			<form id="form1" action="<%=request.getContextPath()%>/findPassword.me" method="post" style="margin-left: 20%; display: inline-block;">
				<table align="center">
					<tr>
						<!-- <td><label>아이디</label></td> -->
						<td><input id="findEmail" type="text" name="findEmail" style="width: 300px; height: 30px;"
						placeholder="이메일"></td>
					</tr>
					<!-- <tr>
						<td colspan="2" align="center">
							<input style="width: 300px; height: 30px;" type="submit" value="ID찾기">
						</td>	
					</tr> -->
				</table>
				<br><br>
				<input id="web-font2" style="width: 300px; height: 30px;" type="submit" value="비밀번호 찾기">
			</form>
		</div>
		
	</div>
	</font>
	
	<script>
		
		function home(){
			location.href='<%=request.getContextPath()%>/';
		}
		
	
	</script> 
</body>
</html>