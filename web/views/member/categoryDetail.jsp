<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.nuriter.nuriter.model.vo.*,com.kh.nuriter.payment.model.vo.*"%>
<% 
   Nuriter n = (Nuriter)request.getAttribute("n"); 
   String nuriNum=(String)request.getAttribute("num");
   request.setAttribute("n", n);
%>

<%-- <% pageContext.forward( "categoryUpdateDetail.jsp" );  %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<link href="https://fonts.googleapis.com/css?family=Song+Myung"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<title>categoryDetail</title>
<style>
#textBox {
	width: 400px;
	height: auto;
	overflow: hidden;
}

hr {
	width: 90%;
}

.content {
	margin-top: 170px;
	border: 1px solid white;
	margin-left: auto;
	margin-right: auto;
	width: 1300px;
	min-height: 935px;
}

.leftBox {
	float: left;
	margin-top: 50px;
}

.images {
	border: 2px solid #FFBF00;
	border-radius: 6px;
	padding-top: 50px;
	margin-top: 50px;
	width: 705px;
	height: auto;
	float: left;
	overflow: hidden;
}

img {
	width: 100px;
	object-fit: contain;
}

#tabs {
	width: 500px;
	margin-top: 50px;
}

.rightBox {
	float: right;
}

#info {
	border: 2px solid #FFBF00;
	width: 450px;
	height: auto;
	margin-bottom: 20px;
	overflow: hidden;
	border-radius: 6px;
}

.likeOrAngry>div {
	margin-left: 10px;
	border: 2px solid #FFBF00;
	float: left;
	width: 210px;
	border-radius: 4px;
	cursor: pointer;
}

.likeOrAngry>div:hover {
	border: 2px solid #FFBF00;
	background: #F5D0A9;
	float: left;
	width: 210px;
	border-radius: 4px;
	opacity: 0.8;
}

button {
	margin-top: 10px;
	width: 200px;
	height: 50px;
}

#aboutHe {
	border: 1px solid black;
	width: 450px;
	height: 400px;
	padding-top: 20px;
}

#profile {
	width: 100px;
	height: 100px;
}

#introduce {
	margin-top: 30px;
}

#introduce>p {
	border: 1px solid black;
	width: 370px;
	height: 200px;
}

#textBox {
	text-align: center;
	margin-top: 30px;
}

#popupDiv { /* 팝업창 css */
	top: 0px;
	position: absolute;
	width: 550px;
	height: 550px;
	display: none;
	background: #D8D8D8;
	border: none;
}

#textArea {
	margin-left: auto;
	margin-right: auto;
	margin-top: 5px;
}

.popBtn {
	margin-top: 10px;
}

#popSendbtn {
	background: #0080FF;
	color: white;
	margin-right: 15px;
	height: 30px;
	width: 80px;
}

#popCloseBtn {
	background: #FFBF00;
	color: white;
	height: 30px;
	width: 80px;
}

.applyButton {
	margin-top: 10px;
	width: 200px;
	height: 50px;
}

.likeOrAngry {
	overflow: hidden;
}

#nuri {
	font-size: 20px;
}

#nuri p {
	margin-left: 20px;
	text-align: left;
	height: auto;
}

#enterDiv {
	margin-top: 5px;
	margin-bottom: 5px;
}

#enter {
	color: #424242;
	font-weight: 600;
	border-radius: 4px;
	background: #FFBF00;
}

#enter:hover {
	color: #424242;
	font-weight: 600;
	border-radius: 4px;
	background: #FFBF00;
	opacity: 0.6;
}

img {
	max-width: 100%;
	height: auto;
}

.commentDiv input[type=text] {
	border-radius: 3px;
	margin-top: 50px;
	width: 600px;
	height: 100px;
	box-sizing: border-box;
	border-style: solid;
	border-color: rgb(241, 196, 15);
}

.commentBtn {
	width: 100px;
	height: 100px;
	background-color: #FFBF00; /* Green */
	font-family: 'Song Myung', serif;
	color: black;
	border-radius: 3px;
	font-size: 20px;
	border: 2px solid rgb(241, 196, 15); /* Green */
}

.commentBtn:hover {
	width: 100px;
	height: 100px;
	background-color: rgb(241, 196, 15); /* Green */
	font-family: 'Song Myung', serif;
	color: black;
	border-radius: 3px;
	font-size: 20px;
	border: 2px solid rgb(241, 196, 15); /* Green */
	opacity: 0.6;
}

.commentDiv {
	width: 800px;
}

#commentSelectTable {
	width: 799px;
	font-size: 24px;
	border-bottom: 2px solid rgb(241, 196, 15);
}

.commentSelectArea #commentSelectTable td {
	font-size: 24px;
	border-bottom: 2px solid rgb(241, 196, 15);
}

#commentSelectTable tr {
	font-size: 24px;
}

.commentSelectArea #commentSelectArea {
	width: 500px;
	overflow: hidden;
}

#trImage {
	width: 150px;
}

.trNickName {
	border-bottom: 2px solid rgb(241, 196, 15);
}

#web-font-Nanum {
	font-family: 'Song Myung', serif;
}

.update {
	width: 705px;
}

.update button {
	margin-top: 10px;
	width: 120px;
	height: 40px;
	background-color: #FFBF00; /* Green */
	font-family: 'Song Myung', serif;
	color: black;
	border-radius: 3px;
	font-size: 20px;
	border: 2px solid rgb(241, 196, 15); /* Green */
}

.update button:hover {
	margin-top: 10px;
	width: 120px;
	height: 40px;
	background-color: #FFBF00; /* Green */
	font-family: 'Song Myung', serif;
	color: black;
	border-radius: 3px;
	font-size: 20px;
	border: 2px solid rgb(241, 196, 15); /* Green */
	opacity: 0.6;
}

#notice {
	float: center;
	display: inline-block;
	font-size: 15px;
	margin-left: 500px;
	margin-bottom: 40px;
}

#map {
	border: 2px solid rgb(241, 196, 15); /* Green */
	margin-left: 15px;
}
</style>
</head>
<body>

	<%@ include file="../common/logoAndLogbutton.jsp"%>
	<%@ include file="../common/categorybar.jsp"%>

	<%if(loginUser == null || loginUser != null){ %>
	<div class="content">
		<div class="leftBox">
			<div class="images">
				<%= n.getContent() %>
			</div>

			<% if(loginUser.getUserNumber() == Integer.parseInt(n.getOwnerNum())){ %>
			<form class="writeForm"
				action="<%=request.getContextPath()%>/requestNuriter.nu"
				method="post">
				<input type="hidden" value='<%= n.getNuriNum() %>' name="nuriNum">
				<input type="hidden" value='<%= n.getNuriTitle() %>'
					name="nuriTitle"> <input type="hidden"
					value='<%= n.getContent() %>' name="content">
				<div class="update" align="right">
					<button type="button" class="updateBtn">누리터 수정</button>
				</div>
			</form>
			<% } %>

			<div class="commentDiv">
				<input type="text" id="web-font" name="comment" class="comment">&nbsp;&nbsp;
				<button class="commentBtn">댓글 등록</button>
			</div>

			<br>
			<hr>
			<br>

			<div class="commentSelectArea">
				<table id="commentSelectTable">
				</table>
			</div>
		</div>

		<div class="rightBox">
			<br>

			<div id="textBox" align="center">
				<font id="web-font-Nanum" size="5px"><%= n.getNuriTitle() %></font>
				<input type="hidden" value='
      	<%=n.getNuriTitle()%>'
					id="nuriTitle" name="nuriTitle">
			</div>

			<br>
			<br>
			<div id="info">

				<br>

				<div id="nuri">
					<p>
						<font id="web-font-Nanum">누리장 : <%= n.getNickName() %></font>
					</p>
					<p>
						<font id="web-font-Nanum">누리장 신고 횟수 : <%= n.getReportCount() %>
							회
						</font>
					</p>
					<hr>
					<p>
						<font id="web-font-Nanum">카테고리 : <%= n.getCategoryName() %></font>
					</p>
					<hr>
					<p>
						<font id="web-font-Nanum">누리터 활동상태: <%= n.getProgress() %></font>
					</p>
					<p>
						<font id="web-font-Nanum">시작일시: <%= n.getStartDate() %></font><br>
						<font id="web-font-Nanum">종료일시: <%= n.getEndDate() %></font>
					</p>
					<p>
						<font id="web-font-Nanum">총 출석 횟수: <%= n.getAttendCount() %></font>
					<hr>
					<p>
						<font id="web-font-Nanum">장소: <%= n.getPlace() %></font>
					</p>
					<div id="map" style="width: 420px; height: 400px;"></div>
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32a364f56c1e2fe3c30aa773daa80f7e&libraries=services"></script>
					<script>
			  var place = '<%= n.getPlace() %>';
			  var fruits = place.split("|")[1];
			  
			  var container = document.getElementById('map');
			  var options = {
			  center: new daum.maps.LatLng(37.555268, 126.970673),
			  level: 3
			  };
				
			  var map = new daum.maps.Map(container, options);
			  
			   // 주소-좌표 변환 객체를 생성합니다
			  var geocoder = new daum.maps.services.Geocoder();
		
			  // 주소로 좌표를 검색합니다
			  geocoder.addressSearch(fruits, function(result, status) {
		
			      // 정상적으로 검색이 완료됐으면 
			       if (status === daum.maps.services.Status.OK) {
		
			          var coords = new daum.maps.LatLng(result[0].y, result[0].x);
		
			          // 결과값으로 받은 위치를 마커로 표시합니다
			          var marker = new daum.maps.Marker({
			              map: map,
			              position: coords
			          });
		
			          // 인포윈도우로 장소에 대한 설명을 표시합니다
			          var infowindow = new daum.maps.InfoWindow({
			              content: '<div style="width:150px;text-align:center;padding:6px 0;"><font id="web-font">누리터 장소</font></div>'
			          });
			          infowindow.open(map, marker);
		
			          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			          map.setCenter(coords);
			      } 
			  });    
			  </script>
   		</div>
   		
	        <hr>
	        <p><font id="web-font-Nanum" size="4px">가격(1인) : <%= n.getPrice() %> 원</font></p>
	        <p><font id="web-font-Nanum" size="4px">정원 : <%= n.getPersonnel() %> 명</font></p>
	        <p><font id="web-font-Nanum" size="4px">현재까지 신청된 인원은 <%= n.getEnterCount() %> 명 입니다.</font></p>
	        <p><font id="web-font-Nanum" size="4px">이 누리터는 <%= n.getInterestCount() %> 명의 관심을 받고있습니다.</font></p>
        
        
        <hr color="red" size="10px">
        
        <div class="likeOrAngry" align="center">
        
	        <div class="hobbyDiv">
	             <i class="far fa-grin-hearts fa-5x"></i><br><font id="web-font" size="5px">관심누리터 등록</font>
	        </div>
	            
	        <div>
	             <i class="fas fa-angry fa-5x" id="popOpen" data-toggle="modal" data-target="#popupDiv"></i><br><font id="web-font" size="5px">게시글 신고</font>
	        </div>
	         
            <div id="popupDiv" class="modal fade" role="dialog">
	            <h2 id="web-font">누리터 신고</h2>
	            <div id="textArea">
		            <h5 id="web-font">신고 제목</h5>
		            <input type="text" style="width:300px; height:30px;border:6px solid #FFBF00;" id="reportTitle" name="reportTitle">
		            <h5 id="web-font">신고 내용</h5>
		            <textarea rows="15" cols="50" id="report" style="border:6px solid #FFBF00;" name="reportContent"></textarea>
	            </div>
	            <div class="popBtn">
		            <button id="popSendbtn">send</button>
		            <button id="popCloseBtn">close</button>
	            </div>
           </div>
        </div>
         
         <% if(loginUser != null){ %>
         <div id="enterDiv" align="center">
         	<button id="enter" onclick="choice();"><font id="web-font-Nanum" size="3px">누리터 신청하기</font></button>
         </div>
         <% } %>
                                                                                     
                                                                                     
                                                                                     
         
         </div>
         <br><br>
    </div>
   
</div>
 <%-- <%@ include file="../common/footer.jsp" %> --%>

      
<script>
$(function(){
	$(function(){
		window.onload=function(){
			var nuriNum = "<%= n.getNuriNum() %>";
			var content = $('.comment').val();
			
			$.ajax({
				url:"/ns/insertComment.nu",
				data:{nuriNum:nuriNum, content:content},
				type:"post",
				success:function(data){
					
					$table = $("#commentSelectTable");
					$table.find("tr").remove();
					
					for(var key in data){
						var $trOne = $("<tr><td align='center' rowspan='4' id='trImage'><img src='images/board/ori.png'>");
						var $trDate = $("<tr id='web-font'>");
					    var $trContent = $("<tr id='web-font'>");
					    var $trNickName = $("<tr class='trNickName' id='web-font' style='size= 1px;'>");
						$trDate.text(data[key].comment_date);
						$trContent.text(data[key].comment_content);
						$trNickName.text(data[key].nickname);
						$table.append($trOne);
						$table.append($trDate);
						$table.append($trContent);
						$table.append($trNickName);
					}
					
					$("#commentSelectTable").show();
					
					
				},
				error:function(data){
					console.log(data);
				}
			});
		}
		
		
		$(".commentBtn").click(function(){
			
			var nuriNum = "<%= n.getNuriNum() %>";
			var content = $('.comment').val();
			
			$.ajax({
				url:"/ns/insertComment.nu",
				data:{nuriNum:nuriNum, content:content},
				type:"get",
				success:function(data){
					
					$table = $("#commentSelectTable");
					$table.find("tr").remove();
					
					for(var key in data){
						var $trOne = $("<tr id='web-font'><td align='center' rowspan='4' id='trImage'><img src='images/board/ori.png'>");
						var $trDate = $("<tr class='trDate' id='web-font'>");
					    var $trContent = $("<tr class='trContent' id='web-font'>");
					    var $trNickName = $("<tr class='trNickName' id='web-font'>");
						$trDate.text(data[key].comment_date);
						$trContent.text(data[key].comment_content);
						$trNickName.text(data[key].nickname);
						$table.append($trOne);
						$table.append($trDate);
						$table.append($trContent);
						$table.append($trNickName);
					}
					
					$input = $(".comment");
					$input.val('');
					
					$("#commentSelectTable").show();
					
					
				},
				error:function(data){
					console.log(data);
				}
			});
			
		});
	});
});

$(function(){
	$(".updateBtn").click(function(){
		$(".writeForm").submit();
	});
});

//셀렉트 박스
$(function(){
	$(function(){
		$(".hobbyDiv").click(function(){
			console.log("관심버튼눌림");
			
			var name = "<%= n.getNuriNum() %>";
			
			console.log(name);
			
			$.ajax({
				url:"/ns/insertHobby.nu",
				data:{name:name},
				type:"get",
				success:function(data){
					
					console.log(data);
					
					alert(data); 
					
					location.reload();
				},
				error:function(data){
					console.log(data);
				}
			});
			
		});
	});
});

$(function(){
    
    $("#popOpen").click(function(event){
       console.log('작동');
       $("#popupDiv").css({
                 "top": (($(window).height()-$("#popupDiv").outerHeight())/1.5+$(window).scrollTop())+"px",
                 "left": (($(window).width()-$("#popupDiv").outerWidth())/2+$(window).scrollLeft())+"px"
       
        });
          $("#popup_mask").css("display","block"); 
             
             $("body").css("overflow","hidden");
         });
         
         $("#popCloseBtn").click(function(event){
           /*  $("#popup_mask").hide(); */
             $("#popupDiv").hide(); 
             $(".modal-backdrop").hide();
             $("body").css("overflow","auto");
         
         });
       
        
         $("#popSendbtn").click(function(event){
            var rTitle =$("#reportTitle").val();
            var rContent = $("div textarea").val();
         
            var nuriNum = '<%=n.getNuriNum()%>';
            var ownerNum ='<%=n.getOwnerNum()%>';
            
            location.href="<%=request.getContextPath()%>/reportSend.rs?nuriNum="+ nuriNum+"&rTitle="+rTitle+"&rContent="+rContent+"&rOwnerNum="+ownerNum;
            alert("신고가 접수 되었습니다");
            
            
         });
 });
</script>
	<script>
function choice(){
	var answer = window.confirm("환불 후 재결제는 불가능합니다. 계속 진행하시겠습니까?");
	var count = '<%= n.getEnterCount() %>';
	var parsonnel ='<%= n.getPersonnel() %>';
	
	if(answer==true){
		if(parsonnel < count){
			var answer2 = window.confirm("정원이 초과되어 신청이 불가합니다");
			
		}else{
			if(<%=n.getPrice()%> != 0){
    	 		cash();
     		}else{
    			var contextPath = '<%=request.getContextPath()%>';
   				var pId = "imp_"+new Date().getTime() ;
    			var userNum = '<%=loginUser.getUserNumber()%>';
    			var nuriNum = '<%=n.getNuriNum()%>';
    			var endDate ='<%=n.getEndDate()%>';
				var loc = contextPath + '/payment.pms?imp=' + pId + "&userNum="
						+ userNum + "&nuriNum=" + nuriNum + "&endDate="
						+ endDate;
					console.log(loc);

					location.href = loc;
			}
		}
	}else{
		alert("신청이 취소되었습니다.");
		}
}
	

	function cash() {
		var IMP = window.IMP; // 생략가능
		IMP.init('imp43582013'); // 가맹점 식별 코드

		IMP.request_pay({
			pg : 'inicis', // 결제방식
			pay_method : 'card', // 결제 수단
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '주문명: 결제 테스트', // order 테이블에 들어갈 주문명 혹은 주문 번호
			amount : '<%=n.getPrice()%>',   // 결제 금액
           buyer_email : '<%=loginUser.getUserEmail()%>',// 구매자 email
          buyer_name :  '<%=loginUser.getUserName()%>',   // 구매자 이름
           buyer_tel :  '<%=loginUser.getPhone()%>',   // 구매자 전화번호
           buyer_addr :  '<%=loginUser.getAddress()%>',   // 구매자 주소
           buyer_postcode :  '123-456',   // 구매자 우편번호
       }, function(rsp) {
       if ( rsp.success ) { // 성공시
          var msg = '결제가 완료되었습니다.';
          msg += '고유ID : ' + rsp.imp_uid;
          msg += '상점 거래ID : ' + rsp.merchant_uid;
          msg += '결제 금액 : ' + rsp.paid_amount;
          msg += '카드 승인번호 : ' + rsp.apply_num;
          //console.log();
          var contextPath = '<%= request.getContextPath() %>';
          var uid = rsp.imp_uid;
          var userNum = '<%=loginUser.getUserNumber()%>';
          var nuriNum = '<%=n.getNuriNum()%>';
          var cardNum = rsp.apply_num;
          var endDate ='<%=n.getEndDate()%>'
          var loc = contextPath + '/payment.pms?imp=' + uid + "&userNum=" + userNum +"&nuriNum=" + nuriNum +"&endDate=" + endDate; 
          console.log(loc);
    
          location.href=loc;
       		alert(msg);
          /*m_redirect_url : // 결제 완료 후 보낼 컨트롤러의 메소드명 */
       } else { // 실패시
          var msg = '결제에 실패하였습니다.';
          msg += '에러내용 : ' + rsp.error_msg;
          
       }
    });
	}

</script>
	<% } %>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>