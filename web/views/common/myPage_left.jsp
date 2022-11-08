<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#leftSide {
	position: fixed;
	width: 160px;
	height: 300px;
	margin-top: -4%;
	margin-left: 3%;
	margin-right: auto;
	}
	.leftContent{
	width:100%;
	height:100%;
	align:left;
	border:1px solid gray;
	}
	#leftside div{
	align:center;
	}


#mpLogoPosition {
	/*top: 190px;
   		left: 90px; */
	width: 112px;
	height: 28px;
	margin-top: auto;
	margin-left: auto;
	margin-right: auto;
}

#mpLogo {
	font-family: 'Jua', sans-serif;
	margin-top: 25%;
	margin-left: auto;
	margin-right: auto;
}


#name {

	font-family: 'Jua', sans-serif;
	padding-top:15%;
	margin-left: auto;
	margin-right: auto;
}

	.contents{
	font-family: 'Jua', sans-serif;
	margin-left: auto;
	margin-right: auto;
		
	}


div a {
	color: black;
}
</style>
</head>
<body>
	<%@ include file="/views/common/logoAndLogbutton.jsp"%>
	<%@ include file="/views/common/categorybar.jsp" %>

	<!-- 왼쪽 마이페이지 목록 -->
	<div id="leftSide" align="left">
		<div id="mpLogo" style="font-size: 16px;" align="center">마이페이지</div>
		<br><br>
		<div class="leftContent">
			<div id="name" style="font-size: 18px;" align="center"><%=loginUser.getNickName()%> 님</div>
		<br><br>

			<div id="myNuri" class="contents" style="font-size: 16px;" align="center">
			<a href="<%=request.getContextPath()%>/selectMyNuriList.nu">나의누리터</a>

			</div><br>
	
			<div id="info" class="contents" style="font-size: 16px;" align="center">
				<a href="<%=request.getContextPath()%>/views/common/myInfo.jsp">개인정보수정</a>
			</div><br>
		

			<div id="check" class="contents" style="font-size: 16px;" align="center">
				<a href="<%=request.getContextPath()%>/attencheck.nu?">출석체크</a>

			</div><br>

					 	
	  	    <%if(loginUser.getGrade().equals("G3")) {%>
	  	   	    <div id="firstOption" class="contents" style="font-size: 16px;" align="center">
	        	<a href="<%=request.getContextPath()%>/views/member/nuribossApply.jsp">누리장 신청</a>
	        	</div>

	        <%}else if(loginUser.getGrade().equals("G2")){%>
	        	<div id="secondOption" class="contents" style="font-size: 16px;" align="center">
	            <a href="<%=request.getContextPath()%>/selectMyNuriterList.nu">누리터 관리</a>
	            </div>
	        
	        <%}%>
		</div>
		</div>
	<!-- 마이페이지 -->


</body>
</html>