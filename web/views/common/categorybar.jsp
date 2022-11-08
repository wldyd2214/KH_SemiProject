<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.nuriter.member.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .colorgraph {
      width: 98%;
        height: 3px;
        border-top: 0;
        background: rgb(241, 196, 15);
        border-radius: 3px;
   } 
   #wrapper {
       width:100%;
       background-color: white;
   }
   .navi{
   	 background-color: #fff;
   	 font-size:25px;
   } 
   .navi li {
      display: inline-block;
      text-align:center;
      margin-top:2%;
     
   }
   .navi li:hover {
      display: inline-block;
      text-align:center;
      margin-top:2%;
      cursor:pointer;
   }
   .navi li a:hover {
      color:#FF4500;
   }
	.wrapper li ul {
		background:white;
		display:none;  /* 평상시에는 서브메뉴가 안보이게 하기 */
		height:auto;
		padding:0px;
		margin:0px;
		border:0px;
		position:absolute;
		width:150px;
		z-index:200;
		list-style-type: none;
		text-align:center;
		
		}
	
	.wrapper li:hover ul {
		display:block;   /* 마우스 커서 올리면 서브메뉴 보이게 하기 */
		/* opacity: 1; */
		
	}
	
   
   #showMain{
     /*  border-style: solid; */
       /* border-color: red; */
      display: inline-block;
      width:100%;
      height:100%;
   }
   
   #showLeft{
     /*  border-style: solid; */
       /* border-color: red; */
       width:10%;
      /*  height:15%; */
       font-size:20px;
        display: inline-block;
   }
   
    #showLeft ul li a:hover{
     color:#FF4500;
   }
   #web-font{
      font-family: 'Jua', sans-serif;
   }
    
      #nuriBavBar1.is-fixed {
      width:100%;
    position: fixed;
    background-color: #fff;
    top: 0;
    margin-top:69px;
    /* z-index: 10; */
    }
    
</style>	
</head>
<body>
	<nav id="nuriBavBar1" class="top-0 is-nav-white is-fixed">
        <div class="wrapper">
          <ul class="navi">
          	   &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C1" class="parentsNa" onclick="goParentsNuriList();">언어
               	 <ul class="nana">
               		<li id="web-font" class="na" value="C11" onclick="goNuriList();">영어</li>
               		<li id="web-font" class="na" value="C12" onclick="goNuriList();">중국어</li>
               		<li id="web-font" class="na" value="C13" onclick="goNuriList();">일본어</li>
               		<li id="web-font" class="na" value="C14" onclick="goNuriList();">아랍어</li>
               	</ul> 
               	</li>	
               	&nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C2" class="parentsNa" onclick="goParentsNuriList();">공방
               	<ul>
               		<li id="web-font" class="na" value="C15" onclick="goNuriList();">목공</li>
               		<li id="web-font" class="na" value="C16" onclick="goNuriList();">가죽</li>
               		<li id="web-font" class="na" value="C17" onclick="goNuriList();">플로리스트</li>
               		
               	</ul> 
               </li>
               &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C3" class="parentsNa" onclick="goParentsNuriList();">요리
               	<ul>
               		<li id="web-font" class="na" value="C18" onclick="goNuriList();">한식</li>
               		<li id="web-font" class="na" value="C19" onclick="goNuriList();">중식</li>
               		<li id="web-font" class="na" value="C20" onclick="goNuriList();">일식</li>
               		<li id="web-font" class="na" value="C21" onclick="goNuriList();">양식</li>
               		
               	</ul> 
               </li>
               &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C4" class="parentsNa" onclick="goParentsNuriList();">운동
               <ul>
               	<li id="web-font" class="na" value="C9" onclick="goNuriList();">축구</li>
               	<li id="web-font" class="na" value="C10" onclick="goNuriList();">야구</li>
               	</ul>
               </li>
               &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C5" class="parentsNa" onclick="goParentsNuriList();">음악
               <ul>
               	<li id="web-font" class="na" value="C22" onclick="goNuriList();">악기</li>
               	<li id="web-font" class="na" value="C23" onclick="goNuriList();">보컬</li>
               	<li id="web-font" class="na" value="C24" onclick="goNuriList();">작곡</li>
               	</ul>
               </li>
               &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C6" class="parentsNa" onclick="goParentsNuriList();">컴퓨터
               <ul>
               	<li id="web-font" class="na" value="C25" onclick="goNuriList();">소프트웨어</li>
               	<li id="web-font" class="na" value="C26" onclick="goNuriList();">하드웨어</li>
               	</ul>
               </li>
               &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C7" class="parentsNa" onclick="goParentsNuriList();">문화
               <ul>
               	<li id="web-font" class="na" value="C27" onclick="goNuriList();">영화</li>
               	<li id="web-font" class="na" value="C28" onclick="goNuriList();">미술관</li>
               	<li id="web-font" class="na" value="C29" onclick="goNuriList();">공연</li>
               </ul>
               </li> 
               &nbsp;&nbsp;&nbsp;
               <li id="web-font" value="C8" class="parentsNa" onclick="goParentsNuriList();">기타
               	<ul>
               	<li id="web-font" class="na" value="C30" onclick="goNuriList();">낚시</li> <!-- onclick="goNuriList();" -->
               </ul>
               </li>
               &nbsp;&nbsp;&nbsp;
          </ul>
        </div>
        <hr class="colorgraph">
  </nav> 
  <script>
    function goNuriList(){
  		$(".na").click(function(){
  			event.stopPropagation();
  			var name = $(this).attr('value');
  			location.href="<%=request.getContextPath()%>/SelectNurinerChildList.no?name="+name;
  		});
  	};
  	
   function goParentsNuriList(){
  		$(".parentsNa").click(function(){
  			var name = $(this).attr('value');
  			location.href="<%=request.getContextPath()%>/selectNuriterList.no?name="+name;
  		});
  	};
  </script>
</body>
</html>