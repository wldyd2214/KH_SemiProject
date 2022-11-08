<%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.PageInfo, com.kh.nuriter.nuriter.model.vo.*"%>

<%@page import="java.text.SimpleDateFormat"%>

<% 
	ArrayList<Nuriter> list = (ArrayList<Nuriter>)request.getAttribute("list");
	ArrayList<Nuriter> list1 = (ArrayList<Nuriter>)request.getAttribute("list1");
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
 	int listCount = pi.getListCount();
 	int currentPage = pi.getCurrentPage();
 	int maxPage = pi.getMaxPage();
 	int startPage = pi.getStartPage();
 	int endPage = pi.getEndPage();
 	
 	System.out.print("참여 : "+list1);
 	System.out.print("개설 : " +list);
 	
 	Calendar todayCal = Calendar.getInstance();
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
 	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>출석체크</title>
<style>
	#web-font{
      font-family: 'Jua', sans-serif;
   }
   .outer{
		width:850px;
		height:auto;
		background:white;
		color:lightblack;
		margin-top:15%;
		margin-left:auto;
		margin-right:auto;
		/* margin-top:280px; */
	}
   
   .outer1{
   		/* border-color: red; 
   	  	display:inline-block; */
		width:800px;
		height:auto;
		/* background:black;
		color:white; */
		/* margin-left:20%; */
		margin-right:auto;
		/* margin-top:30px; */
		
	}
	table {
		border:1px solid black;
		text-align:center;
	}
	.tableArea{
		width:700px;
		height:100px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	}
	
	.colorgraph {
      width: 98%;
        height: 3px;
        border-top: 0;
        background: rgb(241, 196, 15);
        border-radius: 3px;
   }
   h2{
   		margin-left:1%;
   }
   #listArea{
	align:center;
	}
	
	.pageArea{
	padding-left:20%;
	}
	
	  #notice {
    float: center;
    display: inline-block;
    font-size: 15px;
    margin-left: 50px;
    margin-bottom: 40px;
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
<body><font id="web-font">
<%-- <%@ include file="../common/logoAndLogbutton.jsp" %> --%>
  
<%-- <%@ include file="../common/categorybar.jsp" %>--%>
<!-- <hr class="colorgraph"> -->
   
<%-- <%@ include file="myPage_left.jsp" %> --%>
<%@ include file="/views/common/myPage_left.jsp" %>
   <div class="outer">
  
   <h2>출석체크</h2> 
   
    <div class="outer1">
    <br>

    <div class="tableArea">
    <h3 align="left">참여중인 누리터</h3> 
			<table align="center" id="listArea1">
				<tr>
					<!-- <th><div style="width:150px; text-align:center;">누리터명</div></th>
					<th><div style="width:100px; text-align:center;">시작일시</div></th>
					<th><div style="width:100px; text-align:center;">종료일시</div></th>
					<th><div style="width:300px; text-align:center;">장소</div></th>
					<th><div style="width:50px; text-align:center;">참가비</div></th>
					<th><div style="width:100px; text-align:center;">개설일자</div></th> -->
					
					<th width="150px">누리터명</th>
					<th width="150px">시작일시</th>
					<th width="150px">종료일시</th>
					<th width="150px">장소</th>
					<th width="150px">참가비</th>
					<th width="150px">개설일자</th>
				</tr>
				<%-- <tr onclick="location.href='<%=request.getContextPath()%>/views/attend/csCheckone.jsp'"> --%>
				<% if(list1 != null){
					for(Nuriter n : list1){ %>
				<tr>
					<%-- <input type="hidden" value="<%= n.getNuriNum()%>">
					<td>
					<div class="content"><%=n.getNuriTitle()%></div></td>
					<td><div class="content"><%=n.getStartDate()%></div></td>
					<td><div class="content"><%=n.getEndDate()%></div></td>
					<td><div class="content"><%=n.getPlace()%></div></td>
					<td><div class="content"><%=n.getPrice()%></div></td>
					<td><div class="content"><%=n.getApplicationDate()%></div></td> --%>
					<input type="hidden" value="<%=n.getNuriNum()%>">
					<td><%=n.getNuriTitle()%></td>
					<td><%=n.getStartDate()%></td>
					<td><%=n.getEndDate()%></td>
					<td><%=n.getPlace()%></td>
					<td><%=n.getPrice()%></td>
					<td><%=n.getApplicationDate()%></td>
				</tr>
				 <%} } %>
			</table>
		</div>	
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<div class="tableArea">
    <h3 align="left">개설중인 누리터</h3> 
			<table align="center" id="listArea">
				<tr>
					<th width="150px">누리터명</th>
					<th width="150px">시작일시</th>
					<th width="150px">종료일시</th>
					<th width="150px">장소</th>
					<th width="150px">참가비</th>
					<th width="150px">개설일자</th>
				</tr>
				
				<% if(list !=null){
					for(Nuriter n:list ){ %>
				<tr>
					<input type="hidden" value="<%=n.getNuriNum()%>">
					<td><%=n.getNuriTitle()%></td>
					<td><%=n.getStartDate()%></td>
					<td><%=n.getEndDate()%></td>
					<td><%=n.getPlace()%></td>
					<td><%=n.getPrice()%></td>
					<td><%=n.getApplicationDate()%></td>
				</tr>
				<%} } %>
			</table>
		</div>
		
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%@ include file="../common/footer.jsp" %>
	<script>
		$(function(){
			var usernumber = <%=loginUser.getUserNumber()%>
			var date = <%=intToday%>
			$("#listArea1 td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				console.log($(this).parent().children().eq(0).val());
				var nunum = $(this).parent().children().eq(0).val();
				location.href="<%=request.getContextPath()%>/attendonedeteil.nu?nunum="+nunum+"&usernumber="+usernumber;
				
			
			});
			

			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				console.log($(this).parent().children().eq(0).val());
				var nunum = $(this).parent().children().eq(0).val();
				location.href="<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum="+nunum+"&usernumber="+usernumber+"&date="+date;
				
			
			});
			
		});
	</script>
	
 </div>
 </font>   
</body>
</html>