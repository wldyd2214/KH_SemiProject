<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#nuriList{
		/* position: fixed; */
    	width: 734px;
    	height: 74px;
 		margin-top:15%;
    	margin-left:auto;
		margin-right:auto;
		
	}
	
	#listTable{
		text-align:center;
		width: 100%;
    	max-width: 100%;
    	height: 100%;
    	border-spacing: 0;
    	border-collapse: collapse;
    	border: 2px solid #ccc;
    	table-layout: fixed;
    	font-family: 'Jua', sans-serif;
	}
 	a{
		color:black;
	}
</style>
</head>
<body>
	<div id="nuriList" align="center">
	<form> <!-- 기능구현 시 여기에 삽입 action="" method="" -->
	<table id="listTable">
		<tbody>
			<tr>
				<%-- <td><br><a href="<%=request.getContextPath()%>/selectMyNuriList.nu">참여중인 누리터<br>
				건<br><br></a></td>
				<td><br><a href="<%=request.getContextPath()%>/views/common/doneNuri.jsp">종료된 누리터<br>
				건<br><br></a></td> --%>
				<td><br><a href="<%=request.getContextPath()%>/selectMyNuriterList.nu">개설중인 누리터<br>
				<br></a></td>
				<td><br><a href="<%=request.getContextPath()%>/selectNuriEndedList.nu">개설했던 누리터<br>
				<br></a></td>
				<%-- <td><br><a href="<%=request.getContextPath()%>/views/common/nuriInteresting.jsp">관심 누리터<br>
				건<br><br></a></td> --%>
			</tr>
		</tbody>
	</table>
	</form>
	</div>
</body>
</html>