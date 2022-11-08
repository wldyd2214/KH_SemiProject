<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.member.model.vo.*"%>
  
<%-- <% 
	ArrayList<Member> list 
		= (ArrayList<Member>)request.getAttribute("list"); 
	 /* Member loginUser = (Member)session.getAttribute("loginUser");  */

%> --%>

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
	  width:auto;
	  height:100%;
   }
   body{
   	 width:auto;
   	 height:100%;
   }
    #main1{
   	width:auto;
   	height:100%;
   	display:inline-block;
   	overflow:hidden;
   	margin-top:70px;
   }
   #main1 div{
   	display: inline-block;
   } 
#one{
    width:1800px;
    height:100%;
    display: inline-block;
	overflow:hidden;
}
#one table {
    display: inline-block;
	width: 300px;
	height: 300px;
	border: 4px solid #ffd400;
	margin-right:50px;
	text-align:center;
	margin-top:100px;
}
#tableCount{
	margin-left:300px;
}
table #web-font{
      margin:auto;
	  width:100%;
      font-family: 'Jua', sans-serif;
      font-size: 30px;
      text-align:center;
   }
table .web-font{
	margin:auto;
	width:100%;
	font-family: 'Jua', sans-serif;
	font-size:30px;
	color:#FA8258;
	text-align:center;
}
table .web-font1{
	margin:auto;
	width:100%;
	font-family: 'Jua', sans-serif;
	font-size:30px;
	color:#FA8258;
	text-align:center;
}
table tr{
	margin:auto;
	width:100%;
}
table tr td{
	margin:auto;
	width:100%;
}
</style>
</head>
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
<div id="one">
<%@ include file="adminbar.jsp" %>
</div>	
<script>
window.onload=function(){
	var nuriNum = 1;
	
	$.ajax({
		url:"/ns/selectAdminPark.am",
		data:{nuriNum:nuriNum},
		type:"post",
		success:function(data){
			
			$div = $("#one");
			
			$div.find("table").remove();
			
			for(var key in data){
				var $table = $("<table id='tableCount'>");
				var $trMember = $("<tr id='web-font' width='100%'>");
			    var $trMemberTwo = $("<tr class='web-font' width='100%'>");
			    
			    var $tableTwo = $("<table>");
			    var $trJoin = $("<tr id='web-font' align='center'>");
			    var $trJoinTwo = $("<tr class='web-font' id='web-font' align='center'>");
			    
			    var $tableThree = $("<table>");
			    var $trActivated = $("<tr id='web-font' align='center'>");
			    var $trActivatedTwo = $("<tr class='web-font' id='web-font' align='center'>");
			    
			    var $tableFour = $("<table>");
			    var $trNuriter = $("<tr id='web-font' align='center'>");
			    var $trNuriterTwo = $("<tr class='web-font' id='web-font' align='center'>");
				
			    $trMember.text("전체 회원수");
				$trMemberTwo.text(data[key].memberCount + "명");
				
				$trJoin.text("오늘 가입한 회원수");
				$trJoinTwo.text(data[key].memberJoinCount + "명");
				
				$trActivated.text("탈퇴한 회원수");
				$trActivatedTwo.text(data[key].activatedMemberCount + "명");
				
				$trNuriter.text("오늘 개설된 누리터 수");
				$trNuriterTwo.text(data[key].nuriterCount + "건");
				
				$div.append($table);
				$table.append($trMember);
				$table.append($trMemberTwo);
				
				$div.append($tableTwo);
				$tableTwo.append($trJoin);
				$tableTwo.append($trJoinTwo);
				
				$div.append($tableThree);
				$tableThree.append($trActivated);
				$tableThree.append($trActivatedTwo);
				
				$div.append($tableFour);
				$tableFour.append($trNuriter);
				$tableFour.append($trNuriterTwo);
			}
			
			$("#one").show();
		},
		error:function(data){
			console.log(data);
		}
	});
}
</script>
</div>
<%@ include file="/views/common/footer.jsp" %>
	
</body>
</html>