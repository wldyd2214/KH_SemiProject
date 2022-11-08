<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#main{
   	  /* border:1px solid black;
   	  min-height:90%; */
   	  
   	  width: 100%;
    height: 100%;
    display: inline-block;
    margin-top: 70px;
   	  
    }
    #notice{
   	  width: 60%;
   	  border:1px solid white;
   	  margin-right: 19%;
   	  float: right;
   	  overflow: hidden;
   	  background:rgb(248, 223, 125);
    }
    
    #tableArea{
    	/* border:1px solid black; */
    	width:80%;
    }
    
    .web-font{
      font-family: 'Jua', sans-serif;
   }
   
   #btnBox button {
    background: white;
    color: black;
    border: 1px solid black;
   }
</style>
</head>
<body>
	<%@ include file="../common/logoAndLogbutton.jsp" %>
	
	<%if(loginUser != null && loginUser.getUserEmail().equals("admin")){ %>
	
	<div id="main">
		
		<%@ include file="../admin/adminbar.jsp"%>
	
		<div id="notice" align="center">
		  <h1 class="web-font">공지 사항 작성</h1>
		  <div id="tableArea">
		  	<form action="<%=request.getContextPath() %>/insert.no" method="post">
		  		<table align="center" class="web-font">
		  			<tr>
		  				<td>제목</td>
		  				<td colspan="3"><input type="text" size="95%" name="title"></td>
		  			</tr>
		  			<tr>
		  				<td>작성자</td>
		  				<td>
		  					<input type="text" value="<%=loginUser.getNickName()%>" name="writer" readonly>
		  					<input type="hidden" value="<%=loginUser.getUserNumber()%>" name="userNumber">
		  				</td>
		  				<td>작성일</td>
						<td><input type="date" name="date"></td>
		  			</tr>
		  			<tr>
						<td>내용</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4">
						<textarea rows="25" cols="105" name="content" style="resize:none;"></textarea>
						</td>
					</tr>
		  		</table>
		  		<br>
		  		<div align="center" id="btnBox" class="web-font">
						<button type="reset">취소하기</button>
						<button type="submit">등록하기</button>
			    </div>
		  	</form>
		  </div>  
		</div>
	</div>
	
	<%}else{ 
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다!");
		request.getRequestDispatcher("../common/errorPage.jsp");
	} %>
	
</body>
</html>