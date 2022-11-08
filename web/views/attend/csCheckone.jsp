<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.*, com.kh.nuriter.member.model.vo.*
    ,com.kh.nuriter.attend.model.vo.*"%>
 
<%--     <% Member loginUser = (Member)session.getAttribute("loginUser") --%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.Calendar"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
 <% 
	ArrayList<Nuriter> list = (ArrayList<Nuriter>)request.getAttribute("list");
 	/* PageInfo pi = (PageInfo)request.getAttribute("pi");
 	int listCount = pi.getListCount();
 	int currentPage = pi.getCurrentPage();
 	int maxPage = pi.getMaxPage();
 	int startPage = pi.getStartPage();
 	int endPage = pi.getEndPage(); */
 	
 	String usernumber=request.getParameter("usernumber");
 	
	Nuriter n = (Nuriter)request.getAttribute("n");
 	System.out.println("cscheckone n: " +n);
 	
 	ArrayList<Attend> attend = (ArrayList<Attend>)request.getAttribute("attend");
 	
 	System.out.println("attend one : " + attend);
 	
 	String nunum = request.getParameter("nunum");
 	System.out.println("cscheckone nunum : " + nunum);
%> 

<%
Calendar cal = Calendar.getInstance();
String strYear = request.getParameter("year");
String strMonth = request.getParameter("month");

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int date = cal.get(Calendar.DATE);
 
if(strYear != null)
{
  year = Integer.parseInt(strYear);
  month = Integer.parseInt(strMonth);

  
}else{

}

//년도/월 셋팅
cal.set(year, month, 1);

int startDay = cal.getMinimum(java.util.Calendar.DATE);
int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
int newLine = 0;

//오늘 날짜 저장.
Calendar todayCal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>누리원 출석체크</title>
<style>
	#web-font{
      font-family: 'Jua', sans-serif;
   }
   .web-font1{
      font-family: 'Jua', sans-serif;
       border-radius: 4px;
     background-color: rgb(241, 196, 15); 
     color: white;
      
   }
   .web-font1:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
   #web-font1{
      font-family: 'Jua', sans-serif;
      font-size : 10px;
      text-align:center;
       border-radius: 4px;
        background-color: rgb(241, 196, 15); 
     color: white;
      
   }
   #web-font1:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
    #web-font2{
      font-family: 'Jua', sans-serif;
       border-radius: 4px;
        background-color: rgb(241, 196, 15); 
     color: white;
      
   }
   #web-font2:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
   .web-font2{
      font-family: 'Jua', sans-serif;
       border-radius: 4px;
        background-color: rgb(241, 196, 15); 
     color: white;
      
   }
   .web-font2:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
    #main{
   	min-height:90%:
   }
   .outer1{
   		/* border-color: red; 
   	  	display:inline-block; */
		width:100%;
		height:300px;
		/* background:black;
		color:white; */
		margin-left:5%;
		/* margin-right:auto; */
		margin-top:30px;
		display:inline-block;
		
	}
	table {
		border:1px solid black;
		text-align:center;
	}
/* 	.tableArea{
		width:700px;
		height:100px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	} */
	
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
   .check1{
   		width:250px;
   		display:inline-block;
   		margin-top:1%;
   		float:left;
   		
   }
   /* .calender1{
   		/* width:100px; */
   		display:inline-block;
   		
   } */
</style>
</head>
<body><font id="web-font">
<%@ include file="../common/logoAndLogbutton.jsp" %>
    
    
    <%-- <%@ include file="../common/categorybar.jsp" %>
    
    <%@ include file="myPage_left.jsp" %> --%>
   
   <br><br><br>
   <hr class="colorgraph">
    
   <div id=#main>
   <h2>누리터 출석 및 관리방</h2> 
   
    <div class="outer1">
    	<br>

	<div class ="check1">
	<table align="center" id="listArea">
	<tr>
					<%-- <input type="hidden" value="<%= n.getNuriNum()%>"> --%>
					<td><div style="width:100px; text-align:center; display:inline-block;">누리터명</div></td>
					<td>
					<div style="width:100px; text-align:center; display:inline-block;"><%=n.getNuriTitle()%></div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center; display:inline-block;">시작일시</div></td>
					<td>
					<div style="width:100px; text-align:center; display:inline-block;"><%=n.getStartDate()%></div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center; display:inline-block;">종료일시</div></td>
					<td>
					<div style="width:100px; text-align:center; display:inline-block;"><%=n.getEndDate()%></div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center; display:inline-block;">장소</div></td>
					<td>
					<div style="width:100px; text-align:center; display:inline-block;"><%=n.getPlace()%></div></td>
				</tr>
				<tr>
					<td><div style="width:50px; text-align:center; display:inline-block;">참가비</div></td>
					<td>
					<div style="width:100px; text-align:center; display:inline-block;"><%=n.getPrice()%></div></td>
				</tr>
				<tr>
					<td><div style="width:50px; text-align:center; display:inline-block;">개설일자</div></td>
					<td>
					<div style="width:100px; text-align:center; display:inline-block;"><%=n.getApplicationDate()%></div></td>
				</tr>
			<%-- <th>
				<tr>
					<td><div style="width:100px; text-align:center;">누리터명</div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center;">시작일시</div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center;">종료일시</div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center;">장소</div></td>
				</tr>
				<tr>
					<td><div style="width:100px; text-align:center;">개설일자</div></td>
				</tr>
			</th>	
				
				<tr onclick="location.href='<%=request.getContextPath()%>/views/attend/csCheckone.jsp'">
			 <% for(Nuriter n : list){ %>
			<th>
				<tr>
					<input type="hidden" value="<%= n.getOwnerNum()%>">
					<td>
					<div class="content"><%=n.getNuriTitle()%></div></td>
				</tr>
				<tr>
					<td><div class="content"><%=n.getStartDate()%></div></td>
				</tr>
				<tr>
					<td><div class="content"><%=n.getEndDate()%></div></td>
				</tr>
				<tr>
					<td><div class="content"><%=n.getPlace()%></div></td>
				</tr>
				<tr>
					<td><div class="content"><%=n.getPlace()%></div></td>
				</tr>
			</th>	
			
				 <% } %> --%>
	</table>
	<br>
	<%-- <form id = "form1" action="<%=request.getContextPath()%>/checkcodeone.at" method="post"> --%>
		<input type="hidden" id="nunum" name="nunum" value=<%=nunum%>>
		<input type="hidden" id="userNum" name="userNum" value=<%=loginUser.getUserNumber()%>>
		<input type="text" id="checkcode" name="checkcode" style="width: 250px; height: 30px;"
						placeholder="출석코드">
	
		<br><br>
						
		<button class="web-font2" id ="checkbutton" type="submit" style="width: 250px; height: 30px;">출석하기</button>
	<!-- </form> -->
		<br><br>
	
		<input id ="web-font1" type="button" style="width: 80px; height: 30px;" value="누리터 이용완료">			
    
    
  	    <input id ="web-font1" type="button" style="width: 80px; height: 30px;" value="누리터  그만두기">	
    
    
   		 <input id ="web-font2" type="button" style="width: 80px; height: 30px;" value="환불요청">	
    
    	<br><br>
    
    	<input id ="web-font2" type="button" style="width: 250px; height: 30px;" value="불량누리원 신고하기"
    	onclick="location.href='<%=request.getContextPath()%>/views/member/reportPage.jsp'">	
    
    </div>
	
    <div class="caleder1" style="width: 600px; height :300px; display:inline-block;margin-left: 10%;" align="center">    
<form name="calendarFrm" id="calendarFrm" action="" method="post">

<DIV id="content" style="width:600px; height :400px; display:inlin-block;">

<table width="80%" border="0" cellspacing="1" cellpadding="1">
<tr>
       <td align ="right" style="border:1px solid #FFFFFF">
             <input type="button" onclick="location.href='<%=request.getContextPath()%>/attendonedeteil.nu?nunum=<%=nunum%>&amp;usernumber=<%=usernumber%>'" value="오늘"/>
       </td>
</tr>
</table>
<!--날짜 네비게이션  -->

<table width="80%" border="0" cellspacing="1" cellpadding="1" id="KOO" bgcolor="#F3F9D7" style="border:1px solid #FFFFFF">

<tr>
<td height="60" style="border:1px solid #FFFFFF">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #FFFFFF">
       <tr>
             <td height="10">
             </td>
       </tr>      
       <tr>
             <td align="center" >
                    <a href="<%=request.getContextPath()%>/attendonedeteil.nu?nunum=<%=nunum%>&amp;year=<%=year-1%>&amp;month=<%=month%>&amp;usernumber=<%=usernumber%>" target="_self">
                           <b>&lt;&lt;</b><!-- 이전해 -->
                    </a>
                    <%if(month > 0 ){ %>
                    <a href="<%=request.getContextPath()%>/attendonedeteil.nu?nunum=<%=nunum%>&amp;year=<%=year%>&amp;month=<%=month-1%>&amp;usernumber=<%=usernumber%>" target="_self">
                   
                           <b>&lt;</b><!-- 이전달 -->
                    </a>
                    <%} else {%>
                           <b>&lt;</b>
                    <%} %>
                    &nbsp;&nbsp;
                    <%=year%>년                   
                    <%=month+1%>월
                    &nbsp;&nbsp;
                    <%if(month < 11 ){ %>
                    <a href="<%=request.getContextPath()%>/attendonedeteil.nu?nunum=<%=nunum%>&amp;year=<%=year%>&amp;month=<%=month+1%>&amp;usernumber=<%=usernumber%>" target="_self">
                           <!-- 다음달 --><b>&gt;</b>
                    </a>
                    <%}else{%>
                           <b>&gt;</b>
                    <%} %>
                    <a href="<%=request.getContextPath()%>/attendonedeteil.nu?nunum=<%=nunum%>&amp;year=<%=year+1%>&amp;month=<%=month%>&amp;usernumber=<%=usernumber%>" target="_self">
                           <!-- 다음해 --><b>&gt;&gt;</b>
                    </a>
             </td>
       </tr>
       </table> 
</td>
</tr>
</table>
<br>

<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
<THEAD>
<TR bgcolor="#CECECE">
       <TD width='70px'>
       <DIV align="center"><font color="red">일</font></DIV>
       </TD>
       
       <TD width='70px'>
       <DIV align="center">월</DIV>
       </TD>
       
       <TD width='70px'>
       <DIV align="center">화</DIV>
       </TD>

       <TD width='70px'>
       <DIV align="center">수</DIV>
       </TD>

       <TD width='70px'>
       <DIV align="center">목</DIV>
       </TD>

       <TD width='70px'>
       <DIV align="center">금</DIV>
       </TD>
       
       <TD width='70px'>
       <DIV align="center"><font color="#529dbc">토</font></DIV>
       </TD>

</TR>
</THEAD>
<TBODY>
<TR>

<%

int test = 0;
int test2 = 0;

//처음 빈공란 표시
for(int index = 1; index < start ; index++ )
{
  out.println("<TD >&nbsp;</TD>");
  newLine++;
}

for(int index = 1; index <= endDay; index++)
{
	   test++;
		
       String color = "";
       if(newLine == 0){          color = "RED";

       }else if(newLine == 6){    color = "#529dbc";

       }else{                     color = "BLACK"; };

       String sUseDate = Integer.toString(year); 
       sUseDate += Integer.toString(month+1).length() == 1 ? "0" + Integer.toString(month+1) : Integer.toString(month+1);
       sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);
 
       int iUseDate = Integer.parseInt(sUseDate);
        
       /* int attendDate = Integer.parseInt(attend.getAttendDate().toString()); */
       System.out.println(iUseDate);
       
       String backColor = "white";

       if(iUseDate == intToday ) {
             backColor = "#c9c9c9";
             test2 = test;
       }
       for(Attend at: attend){
    	 	 Date attendDate = at.getAttendDate();
    	 	
    	 	 SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");

    	 	 String to = transFormat.format(attendDate); 
    	 	
    	 	int attendDate1 = Integer.parseInt(to);
    	 	
    	 	if(iUseDate == attendDate1){
    	    	   backColor = "#D65BC1";
    	 	
    	 	}
    	 	System.out.println("날짜 : " + attendDate1); 
        
       }
       out.println("<TD id='today"+test+"' valign='top' align='left' height='52px' bgcolor='"+backColor+"' nowrap>");

      	System.out.println("test2 : " +test2);
       
%>

       <font color='<%=color%>'>
             <%=index%>
       </font>
       
       <%       
       out.println("<BR>");
       /* out.println(iUseDate); */
       out.println("<BR>");
              
       //기능 제거  
       out.println("</TD>");
       newLine++;
 
       if(newLine == 7)
       {
         out.println("</TR>");
         if(index <= endDay)
         {
           out.println("<TR>");
         }
         newLine=0;
       }
}

//마지막 공란 LOOP
while(newLine > 0 && newLine < 7)
{
  out.println("<TD>&nbsp;</TD>");
  newLine++;
}

%>

</TR>
</TBODY>
</TABLE>
</DIV>
</form>   
</div>    
     
</div>
</div>	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	


	<script>
		$(function(){
			<%-- $("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"black"});
			}).click(function(){
				//console.log($(this).parent().children().eq(0).text());
				var num = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/selectOne.no?num=" + num;
			
			}); --%>
			
			
			$("#checkbutton").click(function(){
				var checkcode = $("#checkcode").val();
				var userNum = $("#userNum").val();
				var nunum = $("#nunum").val();
				console.log(checkcode);
				console.log(userNum);
				$.ajax({
					url:"checkcodeone.at",
					type:"post",
					data:{checkcode:checkcode, 
						userNum:userNum,
						nunum:nunum},
					success:function(data){
						if(data === "fail"){
							alert("출석체크성공!!");
							
							var x = document.getElementById('today<%=test2%>');
							x.style.background="#D65BC1";
						}else{
							alert("출석체크실패!!")
						}
					},
					error:function(data){
						console.log("실패!");
					}
				});
				
			});
			
		});
	</script>
	

 
  
  </font>
  <%@ include file="../common/footer.jsp" %>    
</body>
</html>