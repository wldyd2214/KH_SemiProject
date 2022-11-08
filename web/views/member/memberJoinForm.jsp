<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.nuriter.member.model.vo.*"%>
<% Member b = (Member) request.getAttribute("b"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>누리터 회원가입</title>
<style>
   
   html{
   		height:100%;
   }
   body{
   	 height:100%;
   }
   #main{
   	margin-left:0 auto;
   	margin-right:0 auto;
   	min-height:90%:
   }
   
   #showmain{
   		width:1000px;
   		height:100%;
   		margin-left: auto;
   		margin-right: auto;
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
   
   #showRight{
     /*  border-style: solid; */
     /*  border-color: red; */
     float:right;
     /*   margin-left: 10%; */
      display: inline-block;
      width: 40%;
      height:100%;
      
      
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
    /*    width: 90px;
     height: 40px; */
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
   
   
   
   
   
   #help{
   		text-align:center;
   		float:right;
   		/* margin-top:1%; */
   		margin-right:2%;
   }
   
  colorgroup{
	display:table-column-group;
	}
	
 	.notice{
	height:24px;
	color:#5B5B5B;
	font-weight:bold;
	font-family: 'Jua', sans-serif;
	}
	
	#noticeList{
	align:center;
	width:650px;
	text-align:left;
	position:relative;
	font-family: 'Jua', sans-serif;
	}
	 	
	.notice_list{
	padding:18px 15px;
	padding-left:30px;
	padding-right:15px;
	border:1px solid #D7D7D7;
	background-color:#F7F7F7;
	/* font-size:11px; */
	position:relative;
	left:30%;
	}
	
	.notice_list li{
	padding-left:7px;
	}
   
   
   #myInfoPage{
	/* margin-top:16%; */
	margin-left:auto;
	/* marign-right:0 auto; */
	font-family: 'Jua', sans-serif;
	display:inline-block;
	width:600px;
	}

	input{
	font-family: 'Jua', sans-serif;
	}
	
	button{
	font-family: 'Jua', sans-serif;
	}

	table {
	width:420px;
    border-top: 2px solid #ACACAC;
    border-bottom: 2px solid #ACACAC;
    color: #5B5B5B;
    border-collapse:collapse;
    border-spacing:0;
    font-size:13px;
    line-height:140%;
    font-family: 'Jua', sans-serif;
	}
	
	
	tbody{
	display:table-row-group;
	vertical-align:middle;
	dorder-color:inherit;
	}
	
	tr{
		display:table-row;
		vertical-align:inherit;
		boder-color:inherit;
	}
	
	.changeInfo tr th {
	height:28px;
	bordor-top:1px solid #E2E2E2;
    background-color: rgb(241, 196, 15);
    text-align:center;
	}
	
	th{
		font-weight:bold;
	}
	
	td, th{
	display:table-cell;
	vertical-align:inherit;
	}
	
	table tr {
	height:28px;
	border-top:1px solid #E2E2E2;
    text-align:left;
	}
	
	table tr td{
	height:28px;
	padding-left:10px;
	border-top:1px solid #E2E2E2;
    text-align:left;
	}
	#idCheck{
		background:rgb(241, 196, 15);
		border-radius:5px;
		width:80px;
		height:25px;
		text-align:center;
		color: white;
		
	
	}

	#idCheck:hover{
	
		cursor:pointer;
	}
	
	#emailCheck{
		background:rgb(241, 196, 15);
		border-radius:5px;
		width:80px;
		height:25px;
		text-align:center;
		color: white;
		
	
	}

	#emailCheck:hover{
	
		cursor:pointer;
	}
	
	#emailok{
		background:rgb(241, 196, 15);
		border-radius:5px;
		width:80px;
		height:25px;
		text-align:center;
		color: white;
		
	
	}

	#emailok:hover{
	
		cursor:pointer;
	}
	
	#banckCheck{
		background:rgb(241, 196, 15);
		border-radius:5px;
		width:80px;
		height:25px;
		text-align:center;
		color: white;
		
	
	}

	#banckCheck:hover{
	
		cursor:pointer;
	}

    
</style>
</head>
<body>
	<font id="web-font">
	<div id="main">
		<font id="web-font"><a id="head" href="#home" onclick="home()">누리터</a></font> 
	<div id = showmain>	
		<h1 align="center">회원가입</h1>
		<br><br>
		<div id="myInfoPage" >
		<form id="form1" action="<%=request.getContextPath()%>/insertMember.me" method="post" style="margin-left: 23%; display: inline-block;">
			<table class="changeInfo" align="center">
			<colgroup>
				<col width="140">
				<col>
			</colgroup>
			<tbody>
			<tr>
				<th>이메일</th>		
				<td><input type="text" id="userEmail" name="userEmail" ></td>
				<td width=100px><div id="idCheck">중복확인</div></td>
				<td width=100px><div id="emailCheck" style="background-color:darkgray">이메일 발송</div></td>
			</tr>
			<tr>
				<th>이메일 인증</th>
				<input type="hidden" id="userEmailcheck" name="userEmailcheck" value="">		
				<td><input type="text" id="emailok1" name="emailok1"></td>
				<td width=100px><div id="emailok">인증</div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" id="password" name="password" maxlength="16" class="newPassword">
				</td>
				<td></td>
			</tr>
			<tr>
				<th> 비밀번호 확인</th>
				<td><input type="password" id="password1" name="password1" maxlength="16" class="newPassword"></td>
				<td><label id="pwdresult"></label></td>
				
			</tr>
			<tr>
				<th>이름</th>
				<td><input id ="userName" type="text" name="userName" <%-- value="<%=loginUser.getUserName()%>" --%>></td>
				<td></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" name="nickName" <%-- value="<%=loginUser.getUserName()%>" --%>></td>
				<td></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input id = "date" type="date" name="birthdate" style="width:100%;" <%-- value="<%=loginUser.getUserName()%>" --%>></td>
				<td></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input id = "phone" type="tel" name="phone" <%-- value="<%=loginUser.getPhone()%>" --%>></td>
				<td></td>
			</tr>
			<tr>
				<th><label>주소</label></th>
				<td><input type="text" name="address" <%-- value="<%=loginUser.getAddress()%>" --%>></td>
				<td></td>
			</tr>
			
			<tr>
				<th><label>은행명</label></th>
				<td><input type="text" name="bankname"></td>
				<td></td>
			</tr>
			<tr>
				<th><label>계좌번호</label></th>
				<td><input id="bancknumber" type="text" name="banknumber"></td>
				<td width=100px><div id="banckCheck" style="background-color:darkgray">계좌인증</div></td>
				<td></td>
			</tr>
			<tr>
			<th><label>취미</label></th>
			<td>
					<input type="checkbox" name="hobby" value="언어" id="language">
					<label for="language">언어</label> 
					<input type="checkbox" name="hobby"
					value="공방" id="handmaking"> 
					<label for="handmaking">공방</label> 
					<input type="checkbox" name="hobby" value="요리" id="cooking"> 
					<label for="cooking">요리</label><br>
					<input type="checkbox" name="hobby"
					value="운동" id="sports"> 
					<label for="sports">운동</label>
					<input type="checkbox" name="hobby"
					value="음악" id="music"> 
					<label for="music">음악</label>
					<input type="checkbox" name="hobby"
					value="컴퓨터" id="computer"> 
					<label for="computer">컴퓨터</label><br>
					<input type="checkbox" name="hobby"
					value="문화" id="culture"> 
					<label for="culture">문화</label>
				</td>
				<td></td>
				</tr>
				</tbody>
		</table>			
		
		<br><br>
		<div align="center">
		<input class="button" type="button" value="취소하기" onclick="home();"> 
		<input class="button" type="button" value="가입하기" onclick="insertMember();">

		</div>
		<script>
		 function insertMember(){

				var yes = document.getElementById("yes").checked;
				var num = 0;
				
				
				if(yes == true){
					$("#form1").submit();
				}else{
					alert("약관에 동의 해 주시길 바랍니다.");
				}
			}
		
			$(function(){
				$("#password1").change(function(){
					if($("#password").val() != $(this).val()){
						$("#pwdresult").html("비밀번호가 일치하지 않습니다.").css("color","red");
						$("#password1").val('');
						$(this).select();
					}else{
						$("#pwdresult").html("비밀번호 일치").css("color","green");
					}
				});

				
				$("#idCheck").click(function(){
					var userEmail = $("#userEmail").val();
					console.log("클릭");
					$.ajax({
						url:"/ns/idCheck.me",
						type:"post",
						data:{userEmail:userEmail},
						success:function(data){
							console.log(data);
							if(data === "fail"){
								alert("아이디가 중복됩니다.");
							}else{
								alert("사용 가능합니다.");
							}
						},
						error:function(data){
							console.log("실패");
						}
					});
				});
				
				$("#emailCheck").click(function(){
					var userEmail = $("#userEmail").val();
					console.log("클릭");
					$.ajax({
						url:"/ns/emilcheck.me",
						type:"post",
						data:{userEmail:userEmail},
						success:function(data){
							console.log(data);
							$("#userEmailcheck").attr('value',data); 
							alert("인증번호가 발송 되었습니다.");
						},
						error:function(data){
							console.log("실패");
						}
					});
				});
				
				
				$("#emailok").click(function(){
					if($("#userEmailcheck").val() != $("#emailok1").val()){
						alert("인증번호가 일치하지 않습니다.");
					}else{
						alert("인증되었습니다.");
					}
				});
				
				  $("#banckCheck").click(function(){
					 var userName=  $("#userName").val();
				        var phone =  $("#phone").val();
				        var bancknumber = $("#bancknumber").val();
				        var date = $("#date").val();
				        
				        var year = date.substring(2,4);
				        var month = date.substring(5,7);
				        var date1 = date.substring(8,10);
				        
				        var day = year+month+date1;
				
					window.open("<%=request.getContextPath()%>/views/member/banckCheck.jsp?userName="+userName+"&phone="+phone+"&bancknumber="+bancknumber+"&day="+day, "", "width=500, height=700");
					
				});
				
			});
	
	</script> 
		
		
		</form>
		</div>
		<!-- <button onclick="deleteMember();">탈퇴하기</button> -->
		
		
		<div id="showRight">
			<textarea rows="10px" cols="40px">이 약관은 주식회사 누리터(이하 “회사”라고 합니다) 가 
			“누리터” 인터넷 서비스 마켓플레이스 사이트 (http://www.nuriter.com, 이하 "누리터 사이트”라고 합니다)와 
			스마트폰 등 이동통신기기를 통해 제공되는 “누리터” 모바일 애플리케이션(이하 “모바일 누리터”이라고 합니다)을 통하여 제공하는 
			중개서비스 및 기타 정보서비스(이하 "서비스"라고 합니다)와 관련하여 회사와 회원간의 권리와 의무, 
			책임사항 및 회원의 서비스이용절차에 관한 사항을 규정함을 목적으로 합니다.</textarea>
			<br>
			<input type="checkbox" name="yes" value="동의하고 가입" id="yes">
			<label for="language">이 약관에 대해서 동의 합니다.</label> 
			<!-- <button class="button" style="width:310px; height:40px;">동의하고 가입완료</button> -->
		</div>
		
	
		<!-- ▼ 알아두기 //-->
	<br>
	<hr width="50%">
	<br>
	<div class="notice" align="center">알아두기</div>
	<br>
	<div id="noticeList" align="center">
	<ul class="notice_list">
		<li>타인이 알아내기 쉬운 비밀번호는 아이디 도용의 위험이 있습니다.</li>
		<li>전화번호나 주민등록 번호, 아이디와 유사한 비밀번호는 사용을 삼가해야 합니다.</li>
		<li>연속된 문자나 숫자 배열로 이루어진 비교적 단순한 형태의 비밀번호는 이용을 자제해 주시기 바랍니다.</li>
		<li>타 사이트와 동일한 비밀번호 사용은 가급적 피해주시고 가능한 주기적으로 비밀번호를 변경하시는 것이 좋습니다.</li>
	</ul>
	</div>
	</div>		
	
	<script>
		
		function home(){
			location.href='<%=request.getContextPath()%>/';
		}
		
	</script> 
	</div></font>
</body>
</html>






