<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	.idFind{
	float:left;
	margin-left:100px;
}
	.pwdFind{
	panel-default: border-radius-none;
	margin: top-0;
	margin: bottom-10;
	margin-right:300px;
	
	border-left : 1px solid #DFDFDF;
	padding-left: 50px;

}
input[type='text'] {
	height: 55px;
	width: 350px;
}
input[type='submit']{
    height: 55px;
	width: 350px;
	font-size:20px;
	background-color:#DFDFDF;
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
		<div class="idFind">
		<label>아이디 찾기</label>
			<br><br><br>
			<input type="text" placeholder="이름">
			<br><br>
			<input type="text" placeholder="핸드폰 번호">
			<br><br><br>
			<input type="submit" value="아이디 찾기">
		</div>
		<div class="pwdFind">
		<label>비밀번호 찾기</label>
		<br><br><br>
		<input type="text" placeholder="아이디">
			<br><br>
			<input type="text" placeholder="이메일">
			<br><br><br>
			<input type="submit" value="비밀번호 찾기">
		</div>
	</div>
</body>
</html>