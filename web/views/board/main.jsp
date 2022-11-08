<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.nuriter.member.model.vo.*"%>
    <% Member loginUser = (Member)session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>Insert title here</title>
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
      width: 90%;
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
      font-size:2em;
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
      background:url(../images/board/1.jpg) no-repeat left top/ cover;
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
   	 width:30%;
   	 
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
</style>
</head>
<body>
	<!-- <label id="head">누리터</label> -->
   <!-- <button type="button" class="btn">로그인</button>
   <button type="button" class="btn btn-primary">회원가입</button> -->
 <div id="main">  
   <div id="iBox">
    <!-- <label id="head"><font id="web-font">누리터</font></label> -->
  	 <font id="web-font"><a id="head" href='#'>누리터</a></font>	
  	 
  	 	 <div id="loginBtn" align="right">
  	 	 	<font id="web-font"> <a><%= loginUser.getUserName() %> 님</a></font>
        	<!-- <button class="button" onclick="location.href='../../index.jsp' " >로그아웃</button> -->
        	<button class="button" onclick="logout();" >로그아웃</button>
        	<% if(!loginUser.getUserEmail().equals("admin")){ %>
			<button class="button" onclick="location.href='/w7/views/member/memberUpdateForm.jsp'">마이페이지</button>
		<% }else{ %>
			<button class="button" onclick="location.href='/w7/views/admin/adminPage.jsp'">관리자</button>
		<% } %>	
        	<!-- <button class="button">마이페이지</button> -->
        	
        	
      		<!-- <button type="button" class="btn">로그인</button>
       	 <button type="button" class="btn btn-primary">회원가입</button> -->
   		</div>
   		
     <!--  <input type="text" id="searchBox" value="내용을 입력해 주세요">
      <input type="button" id="searchBtn" value="검색"> -->
      
      <br><br><br><br><br><br><br><br>
   <div id="search" align="center">
      		<input type="text" id="searchBox" value="내용을 입력해 주세요">
      		<input type="button" id="searchBtn" value="검색">
  	 	</div>
  	 	
  	 	<br><br><br><br><br><br><br><br>
   </div>
   
   
   <div id="category">
      카테고리
   </div>
   <div id="category1">
   <table>
      <tr>
         <td><input type="button" value="언어" style="height:96px; width:226px;"
         onclick="location.href='views/member/category.jsp' "></td>
         <td><input type="button" value="공방" style="height:96px; width:226px;"></td>
         <td><input type="button" value="요리" style="height:96px; width:226px;"></td>
         <td><input type="button" value="운동" style="height:96px; width:226px;"></td>
      </tr>
      <tr>
         <td><input type="button" value="음악" style="height:96px; width:226px;"></td>
         <td><input type="button" value="컴퓨터" style="height:96px; width:226px;"></td>
         <td><input type="button" value="문화" style="height:96px; width:226px;"></td>
         <td><input type="button" value="기타" style="height:96px; width:226px;"></td>
      </tr>
   </table>
   </div>
   
   <!-- <div data-text-content="true" style="font-size:16px;" class="recommendText"> -->
  <div id="recommendText">
      마감임박 누리터
   </div>
   
   <div id="listBox">
   
   </div>
    <br><br><br><br>
   <div id="notice">
      <h4>공지사항</h4>
      <ul>
         <li>고객센터 운영시간 변경안내</li>
         <li>새로운 카테고리 추가 안내</li>
         <li>일시적인 오류 안내</li>
      </ul>
      
   </div>
      <div id="help">
      <h4>누리터 고객센터<br>
      1588-3287<br>
             상담시간 : 평일 10:30 ~ 18:30<br>
      *토요일 및 공휴일 휴무</h4>
      <input type ="button" id="callMe" value="전화 전 클릭">
   </div>
 </div>  
 <script>
		function logout(){
			var check = window.confirm('로그아웃 하시겠습니까?');
			
			if(check == true){
				location.href='<%=request.getContextPath()%>/logout';
			}
		}
	</script>  
 <%@ include file="../common/footer.jsp" %>
</body>
</html>