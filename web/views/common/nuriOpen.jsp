<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.nuriter.nuriter.model.vo.PageInfo, com.kh.nuriter.nuriter.model.vo.*"%>
<% 
	ArrayList<Nuriter> list = (ArrayList<Nuriter>)request.getAttribute("list"); 
	ArrayList<HashMap<String,Object>> pictureList = (ArrayList<HashMap<String,Object>>)request.getAttribute("pictureList");
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
 	int listCount = pi.getListCount();
 	int currentPage = pi.getCurrentPage();
 	int maxPage = pi.getMaxPage();
 	int startPage = pi.getStartPage();
 	int endPage = pi.getEndPage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
	html{
   		height:100%;
   }
   body{
   	 height:100%;
   }
   .colorgraph {
      width: 98%;
        height: 3px;
        border-top: 0;
        background: rgb(241, 196, 15);
        border-radius: 3px;
      /*   border-style: solid; 
      border-color: red;  */
   }
   #wrapper {
       width:70%;
      /*  border-style: solid; 
      border-color: red;  */
           /*margin : 0 auto ;*/
   }
   
   #tableDiv{
      width:100%;
      height:100%;
      display: inline-block;
       
       
   }
   #tableDiv table{
   	  width:20%;
   	  height:30%;
      display: inline-block;
      margin-top:1%;
      margin-left:1%;
   }
   #tableDiv table tr{
      align: center;
      border-left: 1px solid #D8D8D8;
      border-right: 1px solid #D8D8D8;
   }
   #tableHiddenTop {
   	border-top: 1px solid #D8D8D8;
   	border-bottom: 1px solid #D8D8D8;
   }
   #tableHidden{
   	border-bottom: 1px solid #D8D8D8;
   }
   #tableDiv table tr td{
      background: white;
      font-family: 'Do Hyeon', sans-serif;
      font-size: 15px;
      font-color:#6E6E6E;
   }
   #titleTd {
   	padding:10px;
   }
   #priceTd {
   	padding:10px;
   }
   ul.navi li a {
      float: center;
      font-size: 20px;
      line-height: 40px;
      color: #000000;
      text-decoration: none;
      margin: auto; 
      padding: 0 30px;
      -moz-border-radius-topright: 10px;
      -webkit-border-top-right-radius: 10px;
      -moz-border-radius-topleft: 10px;
      -webkit-border-top-left-radius: 10px;
   }
   .navi li a:hover {
      color:#FF4500;
   }
   
   ul.navi2 li a {
      float: center;
      font-size: 20px;
      line-height: 40px;
      color: #000000;
      text-decoration: none;
       /* margin: auto;  */
      /* padding: 0 30px; */
      -moz-border-radius-topright: 10px;
      -webkit-border-top-right-radius: 10px;
      -moz-border-radius-topleft: 10px;
      -webkit-border-top-left-radius: 10px;
   }
   
  	
	.wrapper li ul {
		background:white;
		display:none;  /* 평상시에는 서브메뉴가 안보이게 하기 */
		height:auto;
		padding:0px;
		margin:0px;
		border:0px;
		position:absolute;
		width:120px;
		z-index:200;
		/* left:0; */
		/* opacity: 0; */
		list-style-type: none;
		text-align:left;
		
		}
	
	.wrapper li:hover ul {
		display:block;   /* 마우스 커서 올리면 서브메뉴 보이게 하기 */
		/* opacity: 1; */
		
	}
	li.na{
		width:120px;
		border-style: solid;
       border-color: rgb(241, 196, 15);
       border-top:none;
       border-bottom:none;
       
	}
	
   
   #showMain{
     /*  border-style: solid; 
      border-color: red;  */
      display: inline-block;
      width:100%;
      height:100%;
      margin-left:10%;
   }
   
   #showLeft{
     /*  border-style: solid;
       border-color: red */
       width:10%;
      /*  height:15%; */
       font-size:20px;
        display: inline-block;
   }
   
    #showLeft ul li a:hover{
     color:#FF4500;
   }
   
   #showRight{
     /* border-style: solid;
     border-color: red;  */
     float:right;
     /*   margin-left: 10%; */
      display: inline-block;
      width: 90%;
      height:100%;
      
      
   }
   
   #showRightButton{
  /*  border-style: solid; 
      border-color: red;  */
   	  display:inline-block;
      margin-left: 8%;
      width:90%;
      height:10%;
   }
   
   #web-font{
      font-family: 'Jua', sans-serif;
   }
   
    .button{
       width: 90px;
     height: 40px;
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
   
   #showMain button{
       width: 100px;
     height: 40px;
     font-weight: 600;
     border-radius: 4px;
     background-color: rgb(241, 196, 15); 
     color: white;
   }
   
   #showMain button:hover {
     background-color: white; /* Green */
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15); /* Green */
   }
   
   #showRightButton button{
     width: 150px;
     height: 40px;
     font-weight: 600;
     border-radius: 4px;
     background-color: rgb(241, 196, 15); 
     color: white;
   }
   
   #showRightButton button:hover {
     background-color: white;
     color: rgb(241, 196, 15);
     border: 2px solid rgb(241, 196, 15);
   }
   .select-control{
   		display:inline-block;
   		width:30%;
   		margin-left: 340px;
   }
  table tr th {
  	 border-radius: 4px; 
     color: white;
     cursor: pointer;
  }
  /* .pagination {
	    width:400px;
	    height:60px;
	    overflow:hidden;

	}  */
	 .pagination {
  		display:inline-blick;
	    /* width:400px;
	    height:60px;
	    overflow:hidden; */
	    padding-left: 0;
	    margin: 20px 0;
	    boder-radius:4px;
	    pointer: cursor;
	}

	.pagination a {
	    color: black;
	    padding: 8px 16px;
	    text-decoration: none;
	    border: 1px solid #ddd;
	    pointer: cursor;
	}
	.pagination a.active {
	    background-color: rgb(241, 196, 15);
	    color: white;
	    border: 1px solid rgb(241, 196, 15);
	    pointer: cursor;
	}
	.pagination a:hover:not(.active) {
		background-color: #ddd;
		pointer: cursor;
	}

	.pagination a:first-child {
	    border-top-left-radius: 5px;
	    border-bottom-left-radius: 5px;
	    pointer: cursor;
	}

	.pagination a:last-child {
	    border-top-right-radius: 5px;
	    border-bottom-right-radius: 5px;
	    pointer: cursor;
    }
    td {
    	display: inline-block; width: 200px; white-space: nowrap; overflow: hidden;
    }
    button font{
		color:white;
	}
	button:hover font{
		color: rgb(241, 196, 15);
	}


button{
	     width: 90px;
	     height: 40px;
	     font-weight: 600;
	     border-radius: 4px;
	     background: rgb(241, 196, 15); 
	     color: white;
   	}
    button:hover {
	     background-color: white; /* Green */
	     color: rgb(241, 196, 15);
	     border: 2px solid rgb(241, 196, 15); /* Green */
	     color: rgb(241, 196, 15);
   	}
   	 #notice {
    float: center;
    display: inline-block;
    font-size: 15px;
    margin-left: 200px;
    margin-bottom: 40px;
    }
    #help {
    text-align: center;
    float: right;
    /* margin-top: 1%; */
    margin-right: 15%;
    /* margin-left: 5%; */
    }
</style>
</head>
<body>
	<%@ include file="/views/common/myPage_left.jsp" %>
	<%@ include file="/views/common/myNuriManagement.jsp" %>
	<br><br>
	<hr style="width:50%">
	 <div id="showMain">
  
     <div id="showRight">
        <div id="tableDiv">
        	<%
        		for(int i = 0; i < pictureList.size(); i++){
        			HashMap<String,Object> hmap = pictureList.get(i);
 					if(i == 4){
 			%>		
 					<br><br><br><br><br><br><br><br>
 			    <%  } %>
 			    
        		<table id="nuriterListArea">
           			<tr id="tableHiddenTop">
           				<input type="hidden" value="<%= hmap.get("nuri_number")%>">
           				<th><img src="/ns/thumbnail_uploadFiles/<%=hmap.get("change_name") %>" width="230px" height="230px" onclick=""></th>           			
           			</tr>
           			<tr>
           				<input type="hidden" value="<%= hmap.get("nuri_number")%>">
           				<td id="priceTd" align="left">[<%= hmap.get("category_name") %>]</td>
           			</tr>
           			<tr>
           				<input type="hidden" value="<%= hmap.get("nuri_number")%>">
           				<td>&nbsp;&nbsp;<%= hmap.get("start_date")%> ~ <%= hmap.get("end_date")%></td>
           			</tr>
           			<tr align="center">
           				<input type="hidden" value="<%= hmap.get("nuri_number")%>">
            			<td id="titleTd" align="left"  style="width:230px;overflow:hiddem;text-overflow:ellipsis;"><%= hmap.get("nuri_name") %></td>

           			</tr>
           			<tr id="tableHidden">
           				<input type="hidden" value="<%= hmap.get("nuri_number")%>">
           				<td id="priceTd" align="right"><%= hmap.get("price") %>원</td>
           			</tr>
            	</table>

        	<%  System.out.println(hmap.get("nuri_number")); } %>

            
            <br><br><br><br><br><br><br>
            
             <!-- 페이지처리 -->


             <div class="pageArea" align="center">
             <div class="pagination" align="center" id="web-font">
             <br>
             	<a href="location.href='<%= request.getContextPath()%>/selectNuriOpenList.nu?currentPage=1'"><<</a>
             	<% if(currentPage <= 1){ %>
             	<!-- <button disabled><</button> -->
             	<a disabled><</a>
             	<% }else{ %>
             	<a onclick="location.href='<%= request.getContextPath()%>/selectNuriOpenList.nu?currentPage=<%= currentPage - 1%>'">&laquo;</a>

             	<% } %>
             	<% for(int p = startPage; p <= endPage; p++){
             		if(p == currentPage){	
             	%>

             	<a class="active" disabled><%= p %></a>
             	<%  }else{ %>
             	<a onclick="location.href='<%= request.getContextPath()%>/selectNuriOpenList.nu?currentPage=<%= p %>'"><%= p %></a>

             	<%  } %>
             	<% } %>
             	
             	<% if(currentPage >= maxPage){ %>
             	<a disabled>></a>
             	<% }else{ %>
             	<a onclick="location.href='<%= request.getContextPath()%>/selectNuriOpenList.nu?currentPage=<%= currentPage + 1%>'">></a>
             	<% } %>
             	<a onclick="location.href='<%= request.getContextPath()%>/selectNuriOpenList.nu?currentPage=<%= maxPage %>'">>></a>
             </div>
			    </div>
    				<%@ include file="../common/footer.jsp" %>
    				</div>
						</div>
							</div>
						
  
 <script>
  <%-- $(function() {
	  var name = <%=name%>;
    if(name==1){
    	console.log("네임 : " + name);
    $(".navi2").append("<li id='web-font'><a href='#'>언어</a></li>");
    $(".navi2").append("<hr class='colorgraph'>");
    $(".navi2").append("<li id='web-font'><a href='#'>일본어</a></li>");
    }else{
    	$(".navi2").append("<li id='web-font'><a href='#'>축구</a></li>");
    	
    }
    
  } ); --%>
  
  	$(function(){
	 	$("#nuriterListArea td").mouseenter(function(){
			$(this).parent().css({"cursor":"pointer"});
	 	}).click(function(){
	 			/* $("form").submit(); */
	 		    var nuriNum = $(this).parent().children("input").val();
				console.log(nuriNum);
				location.href="<%=request.getContextPath()%>/selectMyNuriMember.at?nuriNum=" + nuriNum;
	 	});
  	});
  </script>


</body>
</html>