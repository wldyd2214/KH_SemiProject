<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.member.model.vo.*"%>
  
<% 
	ArrayList<Member> list 
		= (ArrayList<Member>)request.getAttribute("list"); 
	 /* Member loginUser = (Member)session.getAttribute("loginUser");  */

%>

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
   	/* width:170%; */
   	min-height:90%:
   } 
   
    .colorgraph {
      width: 98%;
        height: 3px;
        border-top: 0;
        background: rgb(241, 196, 15);
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
   
  	
	.menubar li ul {
	background: rgb(109,109,109);
	display:none;  /* 평상시에는 서브메뉴가 안보이게 하기 */
	height:auto;
	padding:0px;
	margin:0px;
	border:0px;
	position:absolute;
	width:200px;
	z-index:200;
}
	
	.menubar li:hover ul {
	display:block;   /* 마우스 커서 올리면 서브메뉴 보이게 하기 */
}
	
   
   #showMain{
    /* border-style: solid;
    border-color: black; */
    display: inline-block;
    width: 1000px;
    height: 50%;
    /* float: center; */
    /* margin-left:26%; */
    margin-bottom:1%;

   }
     #showMain1{
    /* border-style: solid;
    border-color: black; */
    display: inline-block;
    width: 1000px;
    height: 100%;
    float: right;
    /* margin-left:30%; */
    /* margin-right: 30% */
    /* float: center; */
    /* margin-left:13%;
    margin-bottom:1%; */

   }
   
  /*  #showLeft{ */
     /*  border-style: solid; */
       /* border-color: red; */
      /*  width:10%; */
      /*  height:15%; */
    /*    font-size:20px;
        display: inline-block;
   } */
   
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
       font-size:3em;
      
      text-decoration: none;
      /* padding:8px; */
      /* width:80%; */
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
   #slelct{
   	display:inline-block;
   	  width: 50%;
    height:50%;
   	
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
   
   /* 네비바 고정 */
   #nuriBavBar.is-fixed {
    position: fixed;
    /* 하단 경계선 */
    /* border-bottom: 1px solid #ffd400; */
    background-color: #fff;
    top: 0;
    z-index: 10;
    }
   #main1{
   	width:100%;
   	height:100%;
   	display:inline-block;
   	margin-top:70px;
   /* 	border-style: solid;
    border-color: red; */
   }

   #notice {
    float: center;
    display: inline-block;
    font-size: 15px;
    margin-left: 500px;
    margin-bottom: 40px;
}
</style>
</head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<body>
<%-- <% if(loginUser == null 
				|| !loginUser.getUserId().equals("admin")){
		//관리자가 아닌 경우
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
		
		
	}else{%> --%>
<%-- <nav id="nuriBavBar" class="top-0 is-nav-white is-fixed">
	
	<div id="iBox"><font id="web-font">
        <!-- <label id="head" href='../../index.jsp'><font id="web-font">누리터</font></label> -->
       <font id="web-font"><a id="head" href="#home" onclick="home()">누리터</a></font> 
        <div id="search" align="center">
      		<input type="text" id="searchBox" value="내용을 입력해 주세요">
      		<input type="button" id="searchBtn" value="검색">
  	 	</div>
  	 	
  	 	 <div id="loginBtn"  align=right>
        	 <%if(loginUser != null) {%>
        		<font id="web-font"> <a><%= loginUser.getUserName() %> 님</a></font>
        		<button class="button" onclick="logout();" >로그아웃</button>
        <% } %>
        		<% if(!loginUser.getUserId().equals("admin")){ %>
					<button class="button" onclick="location.href='/w7/views/member/memberUpdateForm.jsp'">마이페이지</button>
				<% }else{ %>
					<button class="button" onclick="location.href='views/admin/adminPage.jsp'">관리페이지</button>
				<% } %>
 		</div> 
 		</div>
 		<script>
		
	function logout(){
		var check = window.confirm('로그아웃 하시겠습니까?');
		
		if(check == true){
			location.href='<%=request.getContextPath()%>/logout';
		}
	}
	
	function home(){
		location.href='<%=request.getContextPath()%>/home';
	}
	
	</script>   
   </nav>     --%>
 
<%@ include file="../common/logoAndLogbutton.jsp" %>


<div id="main1">
<%@ include file="adminbar.jsp" %>
<!-- <div id="main">
 <br><br> <br><br>
   <hr class="colorgraph">
   <div id="showLeft" >
     <ul class="navi2" style="list-style-type:none">
        <li id="web-font"><a href="#" onclick="selectAll();">회원정보조회</a></li>
        <hr class="colorgraph">
        <li id="web-font"><a href="#">회원관리</a></li>
        <hr class="colorgraph">
        <li id="web-font"><a href="#">게시글관리</a></li>
        <li id="web-font"><a href="#">공지사항</a></li>
        <li id="web-font"><a href="#">고객문의관리</a></li>
     </ul>
   	</div>  -->       		
<div id="showMain1" style="align:center;">   		
 <div id="showMain" align="center" style="align:center;">  		
   		<!-- <h1 align="center">회원 정보 전체 보기</h1> -->
		<div  align="center">
			<form action="<%=request.getContextPath() %>/searchMember" method="get" style="margin-left:100px;">
				<input type="radio" id="findId" name="searchCondition" value="findId" checked>
				<label for="findId">이메일로 찾기</label>
				<input type="radio" id="findName" name="searchCondition" value="findName">
				<label for="findName">이름으로 찾기</label>
				<input type="radio" id="findNickname" name="searchCondition" value="findNickname">
				<label for=findNickname>닉네임으로 찾기</label>
				<br>
				<div id="idNameBox">
					<input type="search" name="searchValue">
					<button type="submit">검색하기</button>
				</div>
				<!-- <div id="genderBox">
					<select name="gender">
						<option value="A">전체</option>
						<option value="M">남자</option>
						<option value="F">여자</option>
					</select>
					<button type="submit">검색하기</button>
				</div> -->
			
			</form>
		</div>
		
		<script>
		/* $(function(){
			$("#genderBox").hide();
			
			$("input:radio").change(function(){
				if($(this).val() == "findGender"){
					$("#idNameBox").hide();
					$("#genderBox").show();
				}else{
					$("#idNameBox").show();
					$("#genderBox").hide();
				}
			});
		});	 */
			
		</script>
		<br>
		<table align="center" border="1" style="width:1200px; text-align:center;">
			<tr>
				<th style="width:100px; text-align:center;">유저번호</th>
				<th style="width:300px; text-align:center;">이메일</th>
				<th style="width:200px; text-align:center;">이름</th>
				<th style="width:300px; text-align:center;">닉네임</th>
				<th style="width:300px; text-align:center;">전화번호</th>
				<th style="width:800px; text-align:center;">주소</th>
				<th style="width:200px; text-align:center;">생일</th>
				<th style="width:500px; text-align:center;">취미</th>
				<th style="width:200px; text-align:center;">은행명</th>
				<th style="width:300px; text-align:center;">계좌번호</th>
				<th style="width:300px; text-align:center;">가입일</th>
			</tr>

			
			 <% for(Member m : list){ %>
			<tr>
				<td><%= m.getUserNumber() %></td>
				<td><%= m.getUserEmail() %></td>
				<td><%= m.getUserName() %></td>
				<td><%= m.getNickName() %></td>
				<td><%= m.getPhone() %></td>
				<td><%= m.getAddress() %></td>
				<td><%= m.getBirthDate() %></td>
				<td><%= m.getHobby() %></td>
				<td><%= m.getBankName() %></td>
				<td><%= m.getBankNumber() %></td>
				<td><%= m.getEnrollDate() %></td>
			</tr>	
			<% } %>
		</table>
 	</div>
 </div>
 </div>
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>		
		 <%-- <script>
			$(function(){
				<% for(Member m : list){%>
					$('table').append("<tr>");
					
					$("table").append("<td>" + '<%= m.getUserId() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getUserName() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getGender() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getAge() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getEmail() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getPhone() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getAddress() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getHobby() %>' + "</td>");
					$("table").append("<td>" + '<%= m.getEnrollDate() %>' + "</td>");
					
					
					$("table").append("</tr>");
					
					$('table').append("<tr>" +
							"<td>" + '<%= m.getUserId() %>' + "</td>" +
							  "<td>" + '<%= m.getUserName() %>' + "</td>" +
							  "<td>" +  '<%= m.getGender() %>' + "</td>" +
							  "<td>" +  '<%= m.getAge() %>' + "</td>" +
							  "<td>" + '<%= m.getEmail() %>' +"</td>" +
							  "<td>"  + '<%= m.getPhone() %>' +"</td>" + 
							  "<td>" + '<%= m.getAddress() %>' +"</td>" +
							  "<td>" + '<%= m.getHobby() %>' +"</td>" + 
							  "<td>"  + '<%= m.getEnrollDate() %>' +"</td>"+
							  "</tr>"
					
					);
					
				<% } %>
				
			});
		</script> --%>
<%@ include file="/views/common/footer.jsp" %>
  </font>
 <%-- <% } %> --%>
	
</body>
</html>