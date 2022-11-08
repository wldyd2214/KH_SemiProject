<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
<style>
.item {
	margin-top: 50px;
}

/* .menuArea {
	float: left;
	width: 20%;
	height: 500px;
	margin-left: 30px;
	border: 3px solid black;
} */
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



.uiSearch {
	height: 50px;
	width: 500px;
	margin-right: auto;
	margin-left: auto;
	margin-top: 50px;
}

.ui.icon.input>input {
	padding-right: 2.67142857em !important;
	border-color: gray;
	height: 30px;
	width: 500px;
}

.web-font {
	font-family: 'Jua', sans-serif;
}

.item label a:hover {
	color: #FF4500;
}


#fnqColor {
	background-color: rgb(224, 224, 224);
}

#demo {
	border: 1px solid #F2F2F2;
	background: #F2F2F2;
	height: 300px;
	width: 600px;
	margin-left: auto;
	margin-right: auto;
	font-family: 'Jua', sans-serif;
}

#accordion {
	
	height: 300px;
	width: 70%;
	margin-right: auto;
	margin-left: auto;
	margin-top: 50px;
	font-family: 'Jua', sans-serif;
	border:none;
	
}

#textArea {
	float: right;
	height: 500px;
	width: 80%;
	margin-right: 100px;
}

h3:hover{
	background: rgb(241, 196, 15);
	
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
	
	<div class="mainArea">
		<%if(loginUser !=null && loginUser.equals("admin")){ %>
		<%@ include file="../admin/adminbar.jsp"%>
		<%}else{ %>
		<div class="menuArea">
			<div id="showLeft">
				<ul class="navi2" style="list-style-type: none">
					<hr class="colorgraph">
					<!-- 기능 -->
					<li class="web-font"><a href="./fnq.jsp">고객센터</a></li>
					<hr class="colorgraph">
					<li class="web-font" id=fnqColor><a href="./fnq.jsp">자주묻는질문</a></li>
					<li class="web-font"><a href="<%=request.getContextPath()%>/selectqnalist.sql">1:1 문의하기</a></li>
				</ul>
			</div>
		</div>
		<%} %>
		<div id="textArea">
			<h1 id="web-font" align="center" style="margin-top: 30px;">자주 묻는
				질문</h1>
			<div id="accordion">
				<h3>Q.환불문의</h3>
				<div>
					<p>환불은 고객센터로 연결하여 문의 해주세요</p>
				</div>
				<h3>Q.아이디 비밀번호 찾기</h3>
				<div>
					<p>메이플스토리를 하기 위해 게임에 접속하려 했지만, ID/PW가 기억나지 않아 혹시 많이 당황하셨나요?

						그렇다면 여기를 주목해주세요! GM소리가 용사님들을 위해 계정 관련 궁금증을 속 시원하게 풀어드리고, 용사님들의 계정을
						보호할 수 있는 몇 가지 방법을 안내해드리고자 합니다. 1. 메이플스토리 ID/PW찾기 2. 2차 비밀번호 재설정하기
						3. 보호모드 해제하기 4. 비활성ID 설정하기 5. 넥슨 플레이 보안 서비스 3종 안내 6. 넥슨 보안센터 ‘어머!
						이게 바로 내가 궁금했던 점이야!’ 라는 생각이 드신다면 자세한 내용은 아래를 확인해주세요</p>
				</div>
				<h3>Q.해킹 관련 질문</h3>
				<div>
					<p>소중한 아이템이 한 순간에 사라져 버린다면!! 생각만 해도 너무나 속상한 일인데요. 미리미리 고객님의 소중한
						아이템과 ID를 보호하는 방법을 안내해드리오니 꼭!! 지켜주시길 바랍니다. [보안서비스 이용하기] - 저도 가입한
						보안서비스! U-OTP+ / 넥슨플레이 보안서비스를 이용해주세요. 1회용 비밀번호/로그인 알림 등 다양한 서비스를 통해
						안전한 접속이 가능케 합니다. -U-OTP+ / 넥슨플레이 자세히보기 [바로가기] [ID와 비밀번호 관리하기] -
						용사님의 ID와 비밀번호 혼자만 알고 계신다고 생각하나요?? 방심하는 순간 ID와 비밀번호는 노출될 수 있습니다.
						그렇기에 ID와 비밀번호는 혼자만 알고 계시길 바라며 수시로 비밀번호를 변경해주세요. [바이러스 검사하기] -
						바이러스/악성코드 용사님의 PC를 느리게만 한다고 알고 계신가요?? PC에서 하는 모든 정보가 바이러스/악성코드 하나로
						인해 노출될 수 있습니다. 그렇기에 인터넷이 연결된 PC라면 꼭! 백신 프로그램을 설치하여 정기적으로 검진
						부탁드립니다. * 무료 백신 : [V3 Lite], [네이버백신], [알약] 인터넷을 이용하는 스마트한 용사님이라면
						모두 알만한 아주 기본적인 안전 수칙이지만 지키지 않는다면 아무런 소용이 없습니다. 작지만 큰 효과를 가져오는 예방방법
						이용하여 안전한 메이플스토리 이용을 해주시면 감사하겠습니다.</p>
				</div>
				<h3>Q.비매너는 어떻게 신고할까요?</h3>
				<div>
					<p>게임 이용 도중 비매너 친구로 인해 마음이 아프셨나보군요! 고객 센터를 통한 비매너 사용자 신고는 가능하지
						않습니다. 하지만 비매너 사용자로 인해 불편을 겪으실 경우를 대비하여 게임 내 신고하기 메뉴가 마련되어 있답니다!
						욕설, 방해 등 여러 비매너 행위의 신고가 필요한 순간에는 아래 내용을 참고하여 신고해 주세요! [신고하기 방법] 게임
						내 메뉴의 신고하기 버튼을 클릭하여 욕설/음란글 혹은 사기 등 선택 후 캐릭터 이름, 상황설명을 정확하게 남겨주시면
						신고가 완료됩니다.</p>
					
				</div>
			</div>
		</div>

	</div>
	<script>
		$(function() {
		/* 	$("#accordion").css('border','none'); */
			$("#accordion").accordion();
		});
		
	</script>

</body>
</html>