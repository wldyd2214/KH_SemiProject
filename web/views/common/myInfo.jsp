<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
#myInfoPage {
	margin-top: 15%;
	margin-left: 0 auto;
	marign-right: 0 auto;
	font-family: 'Jua', sans-serif;
}

input {
	font-family: 'Jua', sans-serif;
}

button {
	font-family: 'Jua', sans-serif;
}

table {
	width: 350px;
	border-top: 2px solid #ACACAC;
	border-bottom: 2px solid #ACACAC;
	color: #5B5B5B;
	border-collapse: collapse;
	border-spacing: 0;
	font-size: 13px;
	line-height: 140%;
	font-family: 'Jua', sans-serif;
}

tbody {
	display: table-row-group;
	vertical-align: middle;
	dorder-color: inherit;
}

tr {
	display: table-row;
	vertical-align: inherit;
	boder-color: inherit;
}

.changeInfo tr th {
	height: 28px;
	bordor-top: 1px solid #E2E2E2;
	background-color: rgb(241, 196, 15);
	text-align: center;
}

th {
	font-weight: bold;
}

td, th {
	display: table-cell;
	vertical-align: inherit;
}

table tr {
	height: 28px;
	border-top: 1px solid #E2E2E2;
	text-align: left;
}

table tr td {
	height: 28px;
	padding-left: 10px;
	border-top: 1px solid #E2E2E2;
	text-align: left;
}

colorgroup {
	display: table-column-group;
}

.notice {
	height: 24px;
	color: #5B5B5B;
	font-weight: bold;
	font-family: 'Jua', sans-serif;
}

/* #noticeList {
	align: center;
	width: 1200px;
	padding-right: 50%;
	text-align: left;
	position: relative;
	font-family: 'Jua', sans-serif;
}

.notice_list {
	padding: 18px 15px;
	padding-left: 30px;
	padding-right: 15px;
	border: 1px solid #D7D7D7;
	background-color: #F7F7F7;
	font-size: 11px;
	position: relative;
	left: 60%;
} */

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
	/* position:relative; */
	left:30%;
	}

.notice_list li {
	padding-left: 7px;
}

a {
	color: black;
}
li.na {
    width: 120px;
    border-style: solid;
    border-color: rgb(241, 196, 15);
    border-top: none;
    border-bottom: none;
}
</style>
</head>
<body>
	<%@ include file="myPage_left.jsp"%>

	<div id="myInfoPage">
		<h1 align="center"><%=loginUser.getNickName()%>님의 회원 정보 수정
		</h1>
		<br>
		<br>

		<form id="updatePage"
			action="<%=request.getContextPath()%>/updateMember.me" method="post">
			<table class="changeInfo" align="center">
				<colgroup>
					<col width="140">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<th><label>아이디</label></th>
						<td><input type="text" name="userEmail"
							value="<%=loginUser.getUserEmail()%>" readonly> <input
							type="hidden" name="userNumber"
							value="<%=loginUser.getUserNumber()%>"></td>
					</tr>
					<tr>
						<th>현재 비밀번호</th>
						<td><input type="password" id="oldPassword" name="password" maxlength="16">
						<input type="hidden" id="oldPassword2" name="oldPassword2" value="<%=loginUser.getPassword()%>"> <br> <label>*정보변경을
								위해 반드시 입력해주세요</label></td>
					</tr>
					<tr>
						<th>새 비밀번호</th>
						<td><input type="password" id="newPassword" name="newPassword"
							maxlength="16" class="newPassword"></td>
					</tr>
					<tr>
						<th>새 비밀번호 확인</th>
						<td><input type="password" id="newPassword2" name="newPassword"
							maxlength="16" class="newPassword"> <br> <label
							id="pwdresult"></label></td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" name="nickName"
							value="<%=loginUser.getNickName()%>"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" name="phone"
							value="<%=loginUser.getPhone()%>"></td>
					</tr>
					<tr>
						<th><label>주소</label></th>
						<td><input type="text" name="address"
							value="<%=loginUser.getAddress()%>"></td>
					</tr>
					<tr>
						<th><label>취미</label></th>
						<td><input type="checkbox" name="hobby" value="언어"
							id="language"> <label for="language">언어</label> <input
							type="checkbox" name="hobby" value="공방" id="handmaking">
							<label for="handmaking">공방</label> <input type="checkbox"
							name="hobby" value="요리" id="cooking"> <label
							for="cooking">요리</label><br> <input type="checkbox"
							name="hobby" value="운동" id="sports"> <label for="sports">운동</label>
							<input type="checkbox" name="hobby" value="음악" id="music">
							<label for="music">음악</label> <input type="checkbox" name="hobby"
							value="컴퓨터" id="computer"> <label for="computer">컴퓨터</label><br>
							<input type="checkbox" name="hobby" value="문화" id="culture">
							<label for="culture">문화</label></td>
					</tr>
				</tbody>
			</table>
			<br>
			<br>
			<div align="center">
		</form>
		<div align="center">
			<input type="button" value="취소하기"
				onclick="location.href='<%=request.getContextPath()%>/index.jsp'">
			<input type="button" value="변경하기" onclick="updateMember();">
			<input type="button" value="탈퇴하기" onclick="deleteMember();">
		</div>
		<!-- ▼ 알아두기 //-->
		<br>
		<hr width="50%">
		<br>
		<div class="notice" align="center">알아두기</div>
		<br>
		<div id="noticeList">
			<ul class="notice_list" align="left">
				<li>타인이 알아내기 쉬운 비밀번호는 아이디 도용의 위험이 있습니다.</li>
				<li>전화번호나 주민등록 번호, 아이디와 유사한 비밀번호는 사용을 삼가해야 합니다.</li>
				<li>연속된 문자나 숫자 배열로 이루어진 비교적 단순한 형태의 비밀번호는 이용을 자제해 주시기 바랍니다.</li>
				<li>타 사이트와 동일한 비밀번호 사용은 가급적 피해주시고 가능한 주기적으로 비밀번호를 변경하시는 것이
					좋습니다.</li>
			</ul>
		</div>
	</div>
	<script>
		$(function(){
			$("input[name=hobby]").each(function(){
				var arr = '<%=loginUser.getHobby()%>'.split(", ");
				//console.log(arr);
				for(var i = 0; i < arr.length; i++){
					if($(this).val() == arr[i]){
						$(this).attr("checked", true);
					}
				}
			});
		});
		
		function updateMember(){
			var password = $("#oldPassword").val();
			var oldPassword2 = $("#oldPassword2").val();
			var newPassword = $("#newPassword").val();
			var newPassword2 = $("#newPassword2").val();
			
			  $.ajax({
				url : "<%=request.getContextPath()%>/pwdCheck.me",
				data : {
					password : password,
					oldPassword2 : oldPassword2
						},
				type : "post",
				success : function(data) {
					password = data;
					if(password != oldPassword2){
						alert("기존 비밀번호가 일치하지 않습니다.");
					}else if(newPassword != newPassword2){
						alert("새 비밀번호가 일치하지 않습니다.");
					}else{
						window.confirm("정보변경이 완료되었습니다.");
						$("#updatePage").submit();			
					}
					
					},
					error : function(data, status, msg) {
					console.log("서버전송 실패!");
					}
				/* complete : function() {
				console.log("무조건 호출되는 함수"); */
			
		}); 
			
			
			/* console.log(oldPassword);
			console.log(oldPassword2);
			console.log(newPassword);
			console.log(newPassword2);		
			 */ 
			<%-- location.href="<%=request.getContextPath()%>/pwdCheck.me"; --%>
			
			
			
			
		};	
			
			
		
		
		 
		function deleteMember(){
			var answer = window.confirm('탈퇴 후 동일한 계정으로 재가입이 불가능합니다. 그래도 탈퇴하시겠습니까?');
			
			if(answer == true){
				alert('탈퇴 처리되었습니다.');
				location.href="<%=request.getContextPath()%>/deleteMember.me";
			}else{
				alert('탈퇴가 취소되었습니다.');
			}
		};
		
			
			
		
	</script>
</body>
</html>