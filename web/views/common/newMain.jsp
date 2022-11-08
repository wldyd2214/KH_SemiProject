<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #category{
      /* border:1px solid black; */
      height:62px;
      margin-top:50px;
      text-align:center;
      font-size: 35px;
       font-weight: bold;
   }
   
   #category1{
      /* border:1px solid black; */
      margin-left: auto;
       margin-right: auto;
       width: 907px;
      height:195px;
   }
   
   #recommendText{
   text-align:center;
      font-size:25px;
      font-weight: bold;
      margin-left: auto;
      margin-right: auto;
      margin-top: 100px;
      height: 50%;
      width: 70%;
   }
   
   #help{
   		text-align:center;
   		float:right;
   		/* margin-top:1%; */
   		margin-right:2%;
   }
   
    #listBox{
   border:1px solid black;
    height: 352px;
    width: 682px;
    /* margin-left:auto;
    margin-right:auto; */
    margin:auto;
   
   }
   
    #notice{
   	 /* border:1px solid black; */
   	  display:inline-block;
   	  width:50%;
      height:80%;
      margin-left:2%;
     /*  margin-top:50px; */
      /* text-align:center; */
      font-size: 15px;
       /* font-weight: bold; */
   }
</style>
</head>
<body>
	<%@ include file="logoAndLogbutton.jsp" %>
	   <div id="category">
      카테고리
   </div>
   <div id="category1">
   <table>
      <tr>
         <td><input type="button" value="언어" style="height:96px; width:226px;"></td>
         <td><input type="button" value="공방" style="height:96px; width:226px;"></td>
         <td><input type="button" value="요리" style="height:96px; width:226px;"></td>
         <td><input type="button" value="운동" style="height:96px; width:226px;"></td>
      </tr>
      <tr>
         <td><input type="button" value="음악" style="height:96px; width:226px;"></td>
         <td><input type="button" value="컴퓨터" style="height:96px; width:226px;"></td>
         <td><input type="button" value="문화" style="height:96px; width:226px;"></td>
         <td><input type="button" value="기타" style="height:96px; width:226px;"></td>
      </tr>
   </table>
   </div>
   
   <!-- <div data-text-content="true" style="font-size:16px;" class="recommendText"> -->
  <div id="recommendText">
      마감임박 누리터
   </div>
   
   <div id="listBox">
   
   </div>
    <br><br><br><br>
   <div id="notice">
      <h4>공지사항</h4>
      <ul>
         <li>고객센터 운영시간 변경안내</li>
         <li>새로운 카테고리 추가 안내</li>
         <li>일시적인 오류 안내</li>
      </ul>
      
   </div>
      <div id="help">
      <h4>누리터 고객센터<br>
      1588-3287<br>
             상담시간 : 평일 10:30 ~ 18:30<br>
      *토요일 및 공휴일 휴무</h4>
      <input type ="button" id="callMe" value="전화 전 클릭">
   </div>
   
   
   <br><br><br><br>
</body>
</html>