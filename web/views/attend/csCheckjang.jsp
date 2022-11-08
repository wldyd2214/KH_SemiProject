<%@page import="com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter"%>
<%@page import="oracle.net.aso.e"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.*,  com.kh.nuriter.attend.model.vo.*"%>
    
    
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
 	
 	String nunum = request.getParameter("nunum");
 	System.out.print("nunum : " + nunum);
 	
 	ArrayList<Enter> en = (ArrayList<Enter>)request.getAttribute("en");
 	/* ArrayList<HashMap<String, Object>> en = (ArrayList<HashMap<String, Object>>)request.getAttribute("en"); */
 	
 	/* ArrayList<Attendprint> att=(ArrayList<Attendprint>)request.getAttribute("att"); */
 	ArrayList<Attendprint> att2=(ArrayList<Attendprint>)request.getAttribute("att2");
 	/* ArrayList<HashMap<String, Object>> att = (ArrayList<HashMap<String, Object>>)request.getAttribute("att"); */
 	
 	
 	 int datejang = Integer.parseInt((String)request.getAttribute("datejang"));
 	 	System.out.println("jang : " + datejang); 
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
int intToday2 = intToday-10000;
int intToday3 = intToday-100;
int intToday4 = intToday+100;
int intToday5 = intToday+10000;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javaScript" language="javascript"> </script>

<title>누리장 출석체크</title>
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
    #main{
   	min-height:90%:
   }
   #main1{
   	height:100%;
   }
   .outer1{
   		/* border-color: red; 
   	  	display:inline-block; */
		width:100%;
		height:500px;
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
   		margin-top:10%;
   		float:left;
   		
   }
    /* .calender1{
   		width:100px; 
   		display:inline-block;
   		
   } */
  
   /* td {font-family: "돋움"; font-size: 9pt; color:#595959;}

             th {font-family: "돋움"; font-size: 9pt; color:#000000;}

             select {font-family: "돋움"; font-size: 9pt; color:#595959;}

             .divDotText {

             overflow:hidden;

             text-overflow:ellipsis;

             }
            A:link { font-size:9pt; font-family:'Jua', sans-serif;color:#000000; text-decoration:none; }

            A:visited { font-size:9pt; font-family:'Jua', sans-serif;color:#000000; text-decoration:none; }

            A:active { font-size:9pt; font-family:'Jua', sans-serif;color:red; text-decoration:none; }

            A:hover { font-size:9pt; font-family:'Jua', sans-serif;color:red;text-decoration:none;} */
  
</style>
</head>
<body><font id="web-font">
    
    
    <%-- <%@ include file="../common/categorybar.jsp" %>
    
    <%@ include file="myPage_left.jsp" %> --%>
   
   <br><br><br>
   
    
<div id=#main1>
<%@ include file="../common/logoAndLogbutton.jsp" %>

<hr class="colorgraph">


   <h2>누리터 출석 및 관리방</h2> 
   
    <div class="outer1">
    	<br>

	<div class ="check1">
		<table align="center" id="listArea" style="width:250px;">

				<%-- <tr onclick="location.href='<%=request.getContextPath()%>/views/attend/csCheckone.jsp'"> --%>
				
				<tr>
					 <input type="hidden" value="<%= n.getNuriNum()%>">
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
				
	</table>
	
	
	
		<!-- <input id="codetext" type="text" name="checkcode" style="width: 250px; height: 30px;"
						placeholder="출석코드"> -->
	
		<br><br>
		<p id="p1" style="width:250px; height:30px; border:1px solid black"></p>
		<input class="web-font1" id ="checkcode" type="button" style="width: 250px; height: 30px;" value="출석코드 발급">
	
		<%-- <br><br>
	
		<input class ="web-font1" type="button" style="width: 120px; height: 30px;" value="누리터 종료">			
    
    
  	    <input class ="web-font1" type="button" style="width: 120px; height: 30px;" value="누리터  삭제">	
    
    
    	<br><br>
    
    	<input class ="web-font1" type="button" style="width: 250px; height: 30px;" value="불량누리원 신고하기"
    	onclick="location.href='<%=request.getContextPath()%>/views/member/reportPage.jsp'">	 --%>
    
    </div>

<div class="caleder1" style="width: 600px; height :300px; display:inline-block;margin-left: 10%;" align="center">    
<form name="calendarFrm" id="calendarFrm" action="" method="post">

<DIV id="content" style="width:600px; height :400px; display:inlin-block;">

<table width="80%" border="0" cellspacing="1" cellpadding="1">
<tr>
       <td align ="right" style="border:1px solid #FFFFFF">
             <input type="button" onclick="location.href='<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum=<%=nunum%>&amp;usernumber=<%=usernumber%>&amp;date=<%=intToday %>'" value="오늘"/>
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
                    <a href="<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum=<%=nunum%>&amp;year=<%=year-1%>&amp;month=<%=month%>&amp;usernumber=<%=usernumber%>&amp;date=<%=intToday%>" target="_self">
                           <b>&lt;&lt;</b><!-- 이전해 -->
                    </a>
                    <%if(month > 0 ){ %>
                    <a href="<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum=<%=nunum%>&amp;year=<%=year%>&amp;month=<%=month-1%>&amp;usernumber=<%=usernumber%>&amp;date=<%=intToday%>" target="_self">
                   
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
                    <a href="<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum=<%=nunum%>&amp;year=<%=year%>&amp;month=<%=month+1%>&amp;usernumber=<%=usernumber%>&amp;date=<%=intToday%>" target="_self">
                           <!-- 다음달 --><b>&gt;</b>
                    </a>
                    <%}else{%>
                           <b>&gt;</b>
                    <%} %>
                    <a href="<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum=<%=nunum%>&amp;year=<%=year+1%>&amp;month=<%=month%>&amp;usernumber=<%=usernumber%>&amp;date=<%=intToday%>" target="_self">
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
int date1 =0;

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
        date1 = iUseDate;    
       String backColor = "white";

       if(iUseDate == intToday ) {
             backColor = "#c9c9c9";
             test2 = test;
        
       } else if(iUseDate == datejang){
       	backColor = "#D65BC1";
       	test2 = test;
       }
       out.println("<TD <TD id='today"+test+"' valign='top' align='left' height='52px' bgcolor='"+backColor+"' nowrap>");
%>
<script>
$(function(){
	var usernumber = <%=loginUser.getUserNumber()%>
	<%-- var nunum = <%=n.getNuriNum()%>; --%>
	
	$("#today<%=test%>").click(function(){
		/* console.log($(this).parent().children().eq(0).val()); */
		/*  var nunum = $(this).parent().children().eq(0).val(); */
		 var nunum = "<%=n.getNuriNum()%>";
		 var date = <%=iUseDate%>
		 var year = <%=year%>
		 month = <%=month%>
		location.href="<%=request.getContextPath()%>/attendcheckdeteiljang.nu?nunum="+nunum+"&usernumber="+usernumber+"&year="+year+"&month="+month+"&date="+date;
		
	
	});
});	
</script>
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
         /* if(index <= endDay)
         {
           out.println("<TR>");
         } */
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
    <div class="caleder1" style="width: 500px; height :300px; display:inline-block;margin-left:14%;margin-top:  10%;" align="center">
    	<p style="width:50%">출석 누리원</p>
    	<table border="1" summary="" style="width:400px; height:30px;">
    		<tr>
                <th style="text-align:center;">이름</th>
                <th style="text-align:center;">출석</th>
                    
            </tr>   
       <%
          int test3=0;
          int test4=0;
          
          int test5=0;
          int test6=0;
          String name=" ";
          for(Enter e : en){ 
           	test3++;
           	
           	
           	test4 = test3;
          %>
         	<tr>	
       		<td id ="test<%=test4%>"><%=e.getNickName()%></td>
       		<td id ="t<%=test4%>"></td>
       		</tr>
     	 <% }%>
     	 	
     	 <%	for(Attendprint ad : att2){
     	 		test5++;
         		name=ad.getNickName();
         		System.out.println(name);
         		test6 = test5;
         }%>
          <%
         
         	String[] names = new String[att2.size()];
         	for(int i=0; i<att2.size(); i++){
         		names[i] = att2.get(i).getNickName();
         	
         %>
       </table>
         	<script>
				$(function(){
         			var name="<%=names[i]%>";
         			console.log(name);
						for(var a=1; a<=<%=test4%>; a++){
	            			console.log(a);
	            	  		var x = $("#test"+a).text();
	            	  		console.log("이름: "+x);
	            	  
	            	 	if(x==name)
	            		{
							$("#t"+a).text("V");
	            		} 

				  }
				});
         	
				</script> 
		<%} %>
 </div>   
    
     
	<script>
		$("#p1").text.val=1;
		
			$("#checkcode").click(function(){
				var nunum = "<%=nunum%>";
				
				if($("#p1").text.val == 1){
				$.ajax({
					url:"<%=request.getContextPath()%>/checkcode",
					type:"get",
					data:{nunum:nunum},
					success:function(result){
						
						$("#p1").text(result);
					
					},
					error:function(data){
						console.log("실패!");
					}
				});	
				$("#p1").text.val=2;
				}
			});
		
	</script>
	
</div>
</div>
  </font>
   <%@ include file="../common/footer.jsp" %> 
</body>
</html>