<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.member.model.vo.*"%>
<% Member loginUser = (Member)session.getAttribute("loginUser");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>아이디 찾기</title>
<style>
 #iBox{
      display: inline-block;
      margin-top: 5px;
      /* margin-left: 30px; */
      width:100%;
      height:10%;
      /*  height: 40px; */
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
   
   #web-font{
      font-family: 'Jua', sans-serif;
   }
   #user{
  	display:inline-block;
   /*  border-style: solid;
    border-color: red; */
  	width:100%;
  	min-height:90%;
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
</style>
</head>
<body>
	<div id="iBox">
       <!--  <font id="web-font"><a id="head" href='../../index.jsp'>누리터</a></font>  -->
        <font id="web-font"><a id="head" href="#home" onclick="home()">누리터</a></font> 
   </div> 
   
   <br><br><br><br>
   <%-- <script>
   		alert("회원님의 아이디는 <%=loginUser.getUserEmail()%> 입니다." );
   </script> --%>
   <div id="user" align="center">
   <h2><%=loginUser.getUserName() %> 회원님</h2>
   <h2><%=loginUser.getUserEmail() %> 입니다.</h2>
   <button class="button" onclick="location.href='login.jsp' ">로그인하기</button>
   </div>
   <script>
		
		function home(){
			location.href='<%=request.getContextPath()%>/home';
		}
		
	
	</script> 
   
</body>
</html>