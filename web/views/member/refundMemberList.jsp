<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*, com.kh.nuriter.member.model.vo.PageInfo, com.kh.nuriter.member.model.vo.*"%>
<%
   ArrayList<Member> refundList = (ArrayList<Member>) request.getAttribute("refundList");
   ArrayList<Member> refundList2 = (ArrayList<Member>) request.getAttribute("refundList2");
   
   PageInfo pi = (PageInfo) request.getAttribute("pi");
   int listCount = pi.getListCount();
   int currentPage = pi.getCurrentPage();
   int maxPage = pi.getMaxPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   
   PageInfo pi2 = (PageInfo) request.getAttribute("pi2");
   int listCount2 = pi2.getListCount();
   int currentPage2 = pi2.getCurrentPage();
   int maxPage2 = pi2.getMaxPage();
   int startPage2 = pi2.getStartPage();
   int endPage2 = pi2.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Jua"
   rel="stylesheet">
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/semantic-ui@2.3.3/dist/semantic.min.js"></script>
<title>Insert title here</title>
<style>

#main1 {
   width: 100%;
   height: 100%;
   display: inline-block;
   margin-top: 70px;
   /*    border-style: solid;
    border-color: red; */
}

#main {
   /* margin-top:190px;
      margin-left:220px;
      margin-right:auto;
      overflow:hidden; */
   margin-right: 19%;
   float: right;
   overflow: hidden;
   /* border-style: solid;
       border-color: black; */
}

#child {
   width: 900px;
   overflow: hidden;
   /* border-style: solid;
       border-color: hotpink; */
}

#child2 {
   width: 800px;
   margin-left: auto;
   margin-right: auto;
   overflow: hidden;
   /* border-style: solid;
        border-color: hotpink; */
}

#child3 {
   width: 800px;
   margin-left: auto;
   margin-right: auto;
   overflow: hidden;
   /* border-style: solid;
        border-color: hotpink; */
}

#web-font {
   font-family: 'Jua', sans-serif;
}


.pagination {
   width: 400px;
   height: 100px;
   overflow: hidden; /* 
       border-style: solid;
       border-color: hotpink; */
}

.pagination a {
   color: black;
   padding: 8px 16px;
   text-decoration: none;
   border: 1px solid #ddd;
}

.pagination a.active {
   background-color: rgb(241, 196, 15);
   color: white;
   border: 1px solid rgb(241, 196, 15);
}

.pagination a:hover:not (.active ) {
   background-color: #ddd;
}

.pagination a:first-child {
   border-top-left-radius: 5px;
   border-bottom-left-radius: 5px;
}

.pagination a:last-child {
   border-top-right-radius: 5px;
   border-bottom-right-radius: 5px;
}


#child2 table, #child3 table {
   width: 700px;
   height: auto;
   text-align: center;
   border-radius: 5px; /* iOS 둥근모서리 제거 */
}

#child2 table th, #child3 table th{
	height:30px;
	background-color:rgb(241, 196, 15);
}

#child2 table td, #child3 table td{
	height:50px;
}


</style>
</head>
<body>
   <%@ include file="../common/logoAndLogbutton.jsp"%>
   <%--  <%@ include file="../common/categorybar.jsp" %> --%>
   <%-- <%@ include file="../common/myPage_left.jsp" %> --%>
   <div id="main1">
      <%@ include file="../admin/adminbar.jsp"%>

      <div id="main" align="center">
         <form id="test">
            <div id="child">
               <div id="child2">
                  <h1 id="web-font">환불요청 회원</h1>
                  <br>
                  <table border="2" id="web-font" class="listBox"
                     style="align: center;">
                     <tr>
                        <th style="display: none;"></th>
                        <th style="text-align:center;">회원이름</th>
                        <th style="text-align:center;">누리터명</th>
                        <th style="text-align:center;">은행명</th>
                        <th style="text-align:center;">계좌번호</th>
                        <th style="text-align:center;">환불될 가격</th>
                        <th style="text-align:center;">환불승인</th>
                     </tr>
                     <%
                        for (Member m : refundList) {
                     %>
                     <tr>
                        <td id="getUserNum" style="display: none;"><input
                           type="hidden" value="<%=m.getUserNumber()%>"></td>
                        <td><%=m.getUserName()%></td>
                        <td><%=m.getRefundNuriterName()%></td>
                        <td><%=m.getBankName()%></td>
                        <td><%=m.getBankNumber()%></td>
                        <td><%=m.getRefundNuriterPrice()%></td>
                        <td id="goRefund" style="color:rgb(90, 174, 255);">승인하기</td>
                     </tr>
                     <%
                        }
                     %>
                  </table>

                  <script>
                  $(function(){
                     $(".listBox #goRefund").mouseenter(function(){
                        $(this).css({"cursor":"pointer", "background":"#dde8fc"});
                     }).mouseout(function(){
                        $(this).css({"background":"white"});
                     }).click(function(){
                        var num = $(this).parent().children("#getUserNum").children("input").val();
                        location.href="<%=request.getContextPath()%>/updateRefundMember.rm?num=" + num;
                     });
                     
                  });
                  </script>

                  <div class="pagination" align="center">

                     <br> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage=1'"><<</a>
                     <% if (currentPage <= 1) {%>
                     <a disabled><
                        </a> <% } else { %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage=<%=currentPage - 1%>'"><</a>
                        <% } %> <% for (int p = startPage; p <= endPage; p++) {
                         if (p == currentPage) { %> <a disabled><%=p%></a> <% } else { %>
                        <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage=<%=p%>'"><%=p%></a>
                        <%   } %> <% } %> <% if (currentPage >= maxPage) { %> <a disabled>></a>
                        <% }else { %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage=<%=currentPage + 1%>'">></a>
                        <% } %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage=<%=maxPage%>'">>></a>


                        <br> <br> <br>
                  </div>
               </div>

               <hr>

               <div id="child3">
                  <h1 id="web-font">환불승인 회원</h1>
                  <br>
                  <table border="2" id="web-font" class="listBox2">
                     <tr>
                        <th style="display: none;"></th>
                        <th style="text-align:center;">회원이름</th>
                        <th style="text-align:center;">누리터명</th>
                        <th style="text-align:center;">은행명</th>
                        <th style="text-align:center;">계좌번호</th>
                        <th style="text-align:center;">환불된 가격</th>
                        <th style="text-align:center;">환불날짜</th>
                     </tr>
                     <%
                        for (Member m : refundList2) {
                     %>
                     <tr>
                        <td id="getUserNum" style="display: none;"><input
                           type="hidden" value="<%=m.getUserNumber()%>"></td>
                        <td><%=m.getUserName()%></td>
                        <td><%=m.getRefundNuriterName()%></td>
                        <td><%=m.getBankName()%></td>
                        <td><%=m.getBankNumber()%></td>
                        <td><%=m.getRefundNuriterPrice()%></td>
                        <td><%=m.getRefundNuriterDate() %></td>
                     </tr>
                     <%
                        }
                     %>
                  </table>


                  <!-- 페이지처리 -->
                  <div class="pagination" align="center">

                     <br> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage2=1'"><<</a>
                     <%
                        if (currentPage2 <= 1) {
                     %>
                     <a disabled><
                        </a> <%
                        } else {
                     %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage2=<%=currentPage2 - 1%>'"><</a>
                        <%
                        }
                     %> <%
                        for (int p2 = startPage2; p2 <= endPage2; p2++) {
                           if (p2 == currentPage2) {
                     %> <a disabled><%=p2%></a> <%
                        } else {
                     %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage2=<%=p2%>'"><%=p2%></a>
                        <%
                        }
                     %> <%
                        }
                     %> <%
                        if (currentPage2 >= maxPage2) {
                     %> <a disabled>></a> <%
                        } else {
                     %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage2=<%=currentPage2 + 1%>'">></a>
                        <%
                        }
                     %> <a
                        onclick="location.href='<%=request.getContextPath()%>/selectRefundNuriMember.rm?currentPage2=<%=maxPage2%>'">>></a>
                  </div>

                  
               </div>
            </div>
         </form>
      </div>
   </div>
   
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
</body>
</html>