<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*, com.kh.nuriter.board.model.vo.*, com.kh.nuriter.notice.model.vo.PageInfo, com.kh.nuriter.notice.model.vo.*"%>
<% ArrayList<reportNuri> list = (ArrayList<reportNuri>)request.getAttribute("rlist");

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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
.main {
   /* background: red; */
   height: 800px;
   width: 60%;
   margin-left: auto;
   margin-right: 15%;
   float: right;
}

#web-font {
   font-family: 'Jua', sans-serif;
}

table tr th {
   text-align: center;
   border: 1px solid black;
   height: 50px;
   background: rgb(241, 196, 15);
}

#reportBtn {
   padding-right: 30px;
   padding-bottom: 30px;
}

.listArea {
   width: 650px;
   height: 100px;
   margin-left: auto;
   margin-right: auto;
}

table tr td {
   text-align: center;
   border: 1px solid lightgray;
   height: 40px;
}

.pageArea {
   margin-top: 30%;
   height: 500px;
}

button {
   background: lightgray;
   border: none;
}


</style>
</head>
<body>
   <%@ include file="../common/logoAndLogbutton.jsp"%>
   <br>
   <br>
   <br>
   <%@ include file="adminbar.jsp"%>
   <div class="main" id="web-font">
      <h2>누리장 신고LIST</h2>
      <div class="reportList">
         <div id="reportBtn" align="right">
            <%-- <button id="rBtn" onclick="location.href='<%=request.getContextPath()%>/reportapprove.rp?num=<%=rn.getBoardNum()%>'"
               >신고
               접수</button> --%>
         </div>
         <table id="listArea">
            <tr>
            
               <th width="200px">신고된 누리장</th>
               <th width="200px">신고 제목</th>
               <th width="500px">신고 사유</th>
               <th width="200px">신고자</th>
               <th width="200px">신고날짜</th>
            </tr>

            
            <% for(reportNuri r : list){ %>
            <tr class="testList">
            <input type="hidden" value="<%=r.getBoardNum()%>"name="boardNum">
            <input type="hidden" value="<%=r.getN_ownerNum()%>" name="ownerNum">
            <input type="hidden" value="<%=r.getUserNum()%>" name="userNum">
               <td><%=r.getOwnerNickname()%></td>
               <td name="bTitle"><%=r.getBoardTitle() %></td>
               <td name="bContent"><%=r.getBoardContent() %></td>
               <td><%=r.getNuriNickname() %></td>
               <td name="bDate"><%=r.getBoardDate() %></td>
            </tr>
            
            <% } %>
         </table>
      </div>
      <div class="pageArea" align="center">
         <button
            onclick="location.href='<%= request.getContextPath()%>/reportlist.rl?currentPage=1'"><<</button>
         <% if(currentPage <= 1){ %>
         <button disabled><</button>
         <% }else{ %>
         <button
            onclick="location.href='<%= request.getContextPath()%>/reportlist.rl?currentPage=<%=currentPage - 1%>'"><</button>
         <% } %>
         <% for(int p = startPage; p <= endPage; p++){
               if(p == currentPage){   
            %>
         <button disabled><%= p %></button>
         <%  }else{ %>
         <button
            onclick="location.href='<%= request.getContextPath()%>/reportlist.rl?currentPage=<%= p %>'"><%= p %></button>
         <%  } %>

         <% } %>

         <% if(currentPage >= maxPage){ %>
         <button disabled>></button>
         <% }else{ %>
         <button
            onclick="location.href='<%= request.getContextPath()%>/reportlist.rl?currentPage=<%= currentPage + 1%>'">></button>
         <% } %>
         <button
            onclick="location.href='<%= request.getContextPath()%>/reportlist.rl?currentPage=<%= maxPage %>'">>></button>
      </div>
   </div>
  
   <script>
      $(function(){
         $('.testList').click(function(){
           
            //보드넘
            var num = $(this).children(0).eq(0).val();
            var ownerNum =$(this).children(0).eq(1).val();
            var userNum =$(this).children(0).eq(2).val();
            var bTitle =$(this).children(0).eq(4).text();
            var bContent =$(this).children(0).eq(5).text();
            var bDate =$(this).children(0).eq(7).text();
            
            console.log('btitle : '+bTitle);
            
            location.href="<%= request.getContextPath()%>/reportdetail.rd?num="+num+"&userNum="+userNum+"&ownerNum="+ownerNum+"&bTitle="+bTitle+"&bContent="+bContent+"&bDate="+bDate;
          
         });
      });
   </script>
</body>
</html>