<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

   #leftSide{
      position: absolute;
      left:50px;
      top:240px;
      width:160px;
      height:314px;
   }
   
   #tableOntheLeft{
      width:100%;
      max-width:100%;
      height:100%;
      border-spacing:0;
      border-collapse:collapse;
      border:2px solid lightgray;
      table-layout:fixed;
   }
   
   #mpLogoPosition{
       position: absolute;
       top: 190px;
         left: 90px;
       width: 112px;
       height: 28px;
    
   }
   
   #mpLogo{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }

   #namePosition{
      position: absolute;
       top: 280px;
       left: 100px;
       width: 72px;
       height: 28px;
   }
   
   #name{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }
   
   #myNuriPosition{
      position: absolute;
       top: 330px;
       left: 90px;
       width: 100px;
       height: 28px;
   }
   
   #myNuri{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }
   
   #infoPosition{
      position: absolute;
       top: 370px;
       left: 85px;
       width: 100px;
       height: 28px;
   }
   
   #info{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }
   
   #checkPosition{
      position: absolute;
       top: 410px;
       left: 95px;
       width: 100px;
       height: 28px;
   }
   
   #check{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }
   
   #msgPosition{
      position: absolute;
       top: 450px;
       left: 100px;
       width: 100px;
       height: 28px;
   }
   
   #msg{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }
   
   #newNuriPosition{
      position: absolute;
       top: 490px;
       left: 75px;
       width: 130px;
       height: 28px;
   }
   
   #newNuri{
      position: absolute;
      font-family: 'Jua', sans-serif;
   }
</style>
</head>
<body>
   <!-- 왼쪽 마이페이지 목록 -->
   <div id="leftSide">
      <table id="tableOntheLeft">
      <tbody>
         <tr>
            <td>&nbsp;</td>
         </tr>
      </tbody>
      </table>
   </div>
   <!-- 마이페이지 -->
   <div id="mpLogoPosition">
      <div id="mpLogo" style="font-size:16px;">마이페이지</div>
   </div>
   
   <div id="namePosition">
      <div id="name" style="font-size:16px;">홍길동</div>
   </div>
   
   <br>
   
   <div id="myNuriPosition">
      <div id="myNuri" style="font-size:16px;">나의누리터</div>
   </div>
   
   <div id="infoPosition">
      <div id="info" style="font-size:16px;">개인정보수정</div>
   </div>
   
   <div id="checkPosition">
      <div id="check" style="font-size:16px;">출석체크</div>
   </div>
   
   <div id="msgPosition">
      <div id="msg" style="font-size:16px;">메세지</div>
   </div>
   
   <div id="newNuriPosition">
      <div id="newNuri" style="font-size:16px;">나의 누리터 개설</div>
   </div>

</body>
</html>