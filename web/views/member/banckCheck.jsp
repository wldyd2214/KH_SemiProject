<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.nuriter.member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/common/ext_util.js"></script><!-- 외부 유틸 js -->
<script type="text/javascript" src="<%= request.getContextPath() %>/js/common/constants.js"></script><!-- 상수 js --> 
<script type="text/javascript" src="<%= request.getContextPath() %>/js/common/common.js"></script><!-- 사용자정의 js --> 
<% 
 String username=request.getParameter("userName");
 String phone = request.getParameter("phone");
 String bancknumber = request.getParameter("bancknumber");
 String day = request.getParameter("day");

 %>

<style>
	.container {
	width: 100%;
	max-width: 400px;
	margin-top: 50px;
	margin-bottom: 100px;
	padding: 40px 40px;
	font-family: Roboto, 'Noto Sans KR', sans-serif;
	border: 1px solid lightgray;
	border-radius: 10px;
}

#real_nameFrm input[type=text], #real_nameFrm button {
	direction: ltr;
	height: 44px;
	font-size: 14px;
	width: 100%;
	height: 40px;
	display: block;
	margin-bottom: 10px;
	z-index: 1;
	position: relative;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	border: 1px solid #ccc;
}

#real_nameFrm .input-sm:focus {
	border-color: rgb(104, 145, 162);
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
}

p, label {
	text-align: center;
	font-weight: 400;
	color: rgba(0, 0, 0, 0.54);
} 
p {
    font-size:smaller;
}
#left{
    text-align:left;
}

</style>
</head>
<body>
	<%-- <%@ include file="../common/logoAndLogbutton.jsp"%> --%>
	
    
	<div class="container">
	<h2 align="center" style="font-size:30px">계좌번호 실명 인증</h2>
	
	<hr><p>* 계좌 실명인증에 앞서 자신의 계좌가 아닌 타인의 계좌를 인증할 경우의 위험 안내를 확인하세요.</p>
	<br>
	<div align="center">
    <button class="form-control btn btn-danger" data-toggle="modal" data-target="#myModal">위험안내 확인하기</button>
    </div>
    <hr>
	<!-- <h3 align="center" style="font-size:24px">계좌실명인증</h3> -->
	<br>
	
	<input type="hidden" class="input-sm" id="client_id" name="client_id" value="l7xx6b2d557bc8a44b4fa6670114b6856595">
	<input type="hidden" class="input-sm" id="client_secret" name="client_secret" value="6d28ac42240c45e29a4026b00d3317f1">
	<input type="hidden" class="input-sm" id="token" name="token">
	<input type="hidden" class="input-sm" id="account_holder_info_type" name="account_holder_info_type">
	
	<form id="real_nameFrm" action="<%=request.getContextPath() %>/banckCheck" method="post">
	<input type="hidden" id="userId" name="userId">
	<input type="hidden" class="input-sm" id="tran_dtime" name="tran_dtime">
	<input type="hidden" class="input-sm" id="bank_code_std" name="bank_code_std">
	<div>
	<label style="font-size:14px">은행명&nbsp;&nbsp;</label><br>
	<select id="bankcode" style="font-size:14px">
	    <option value="003">기업은행</option>
	    <option value="004">국민은행</option>
	    <option value="011">농협중앙회</option>
	    <option value="012">단위농협</option>
	    <option value="020">우리은행</option>
	    <option value="031">대구은행</option>
	    <option value="005">외환은행</option>
	    <option value="023">SC제일은행</option>
	    <option value="032">부산은행</option>
	    <option value="045">새마을금고</option>
	    <option value="027">한국씨티은행</option>
	    <option value="034">광주은행</option>
	    <option value="039">경남은행</option>
	    <option value="007">수협</option>
	    <option value="048">신협</option>
	    <option value="037">전북은행</option>
	    <option value="035">제주은행</option>
	    <option value="064">산림조합</option>
	    <option value="071">우체국</option>
	    <option value="081">하나은행</option>
	    <option value="088">신한은행</option>
	    <option value="209">동양종금증권</option>
	    <option value="243">한국투자증권</option>
	    <option value="240">삼성증권</option>
	    <option value="230">미래에셋</option>
	    <option value="247">우리투자증권</option>
	    <option value="218">현대증권</option>
	    <option value="266">SK증권</option>
	    <option value="278">신한금융투자</option>
	    <option value="262">하이증권</option>
	    <option value="263">HMC증권</option>
	    <option value="267">대신증권</option>
	    <option value="270">하나대투증권</option>
	    <option value="279">동부증권</option>
	    <option value="280">유진증권</option>
	    <option value="287">메리츠증권</option>
	    <option value="291">신영증권</option>
	    <option value="238">대우증권</option>
	</select>
	</div>
	<br>
	<label style="font-size:14px"> 계좌주(회원 이름) </label><br>
    <input type="text" class="input-sm" id="name" name="name" value=<%=username%> readonly required>
    <label style="font-size:14px"> 연락처 </label><br>
    <input type="text" class="input-sm" id="phone" name="phone" value=<%=phone%> readonly required>
	<label style="font-size:14px"> 계좌번호 </label><br>
    <input type="text" class="input-sm" id="account_num" name="account_num" maxlength="16" placeholder="'-'없이 입력하세요" value="<%=bancknumber%>" required>
	<div class="error-accountNum">
	<label style="color: red; font-style: italic;">계좌번호는 숫자만 입력하실 수 있습니다.</label>
	</div>
	<label style="font-size:14px"> 생년월일 </label><br>
	<input type="text" class="input-sm" id="account_holder_info" name="account_holder_info" maxlength="6" placeholder="ex. 880101과 같이 6자리로 입력하세요" value="<%=day%>" required>
	<div class="error-birthNum">
	<label style="color: red; font-style: italic; font-size:14px;">생년월일은 숫자만 입력하실 수 있습니다.</label>
	</div>
	<div class="error-birthNum2">
	<label style="color: red; font-style: italic font-size:14px;">생년월일은 6자리입니다.</label>
	</div>
	</form>
    
		<br>
		<button class="form-control btn btn-primary" id="btnRealNameInquiry" type="button">계좌 실명 인증받기</button>
    <hr>
    <p>* 실명 인증을 진행하기 위해서는 회원님의 계좌 정보가 실제 정보와 일치해야 합니다. 위의 공란을작성하여 계좌실명인증을 진행해 주시기 바랍니다.</p>
    
	</div>
	
	<div>
		<%-- <%@ include file="../common/footer.jsp"%> --%>
	    </div>
	    
	    <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h3 class="modal-title" align="center" style="font-size:24px">타 계좌 인증 위험 주지 및 고지</h3>
        </div>
        <div class="modal-body">
          <p id="left"><br>
 &nbsp;본 위험고지서는 금융실명거래 및 비밀보장에 관한 법률(이하 “금융실명법”이라고만 합니다) 제3조의 제1항에 의하여 귀하가 nuriter에 계좌를 인증하기 전에  위험을 사전에 충분히 인지할 수 있도록 nuriter가 귀하에게 교부하는 것입니다.<br>
 <br>
 &nbsp;1. 금융회사등은 거래자의 실지명의(이하 "실명"이라 한다)로 금융거래를 하여야 한다(제3조 제1항).<br>
 &nbsp;2. 이에 따라 실명이 확인된 계좌 또는 외국의 관계 법령에 따라 이와 유사한 방법으로 실명이 확인된 계좌에 보유하고 있는 금융자산은 명의자의 소유로 추정한다(제3조 제5항).<br>
 &nbsp;3. 누구든지 불법재산의 은닉, 자금세탁행위 또는 공중협박자금조달행위(특정 금융거래정보의 보고 및 이용 등에 관한 법률 제2조 제3호 내지 제5호) 및 강제집행의 면탈, 그 밖에 탈법행위를 목적으로 타인의 실명으로 금융거래를 하여서는 아니 된다(제3조 제3항).<br>
 &nbsp;4. 명의인(신탁의 경우에는 위탁자 또는 수익자를 말한다)의 서면상의 요구나 동의를 받지 아니하고는 그 금융거래의 내용에 대한 정보 또는 자료("거래정보등")를 타인에게 제공하거나 누설하여서는 아니 된다(제4조 제1항 본문 전단).<br>
 &nbsp;5. 다음 각 호의 어느 하나에 해당하는 경우에는 그 사용 목적에 필요한 최소한의 범위에서 거래정보등을 제공하거나 그 제공을 요구할 수 있다<br>
 &nbsp;. 법원의 제출명령 또는 법관이 발부한 영장에 따른 거래정보등의 제공<br>
 &nbsp;. 조세에 관한 법률에 따라 제출의무가 있는 과세자료 등의 제공과 소관 관서의 장이 상속·증여 재산의 확인, 조세탈루의 혐의를 인정할 만한 명백한 자료의 확인, 체납자의 재산조회, 「국세징수법」 제14조제1항 각 호의 어느 하나에 해당하는 사유로 조세에 관한 법률에 따른 질문·조사를 위하여 필요로 하는 거래정보등의 제공<br>
 <br>
 &nbsp;6. 귀하는 아래 사항들에 대하여도 이해하였음을 확인합니다.<br>
 <br>
 &nbsp;위 사항들은 주문 거래를 위한 계좌 인증에 수반되는 위험∙제도 및  주문 거래를 위한 계좌인증과 관련하여 귀하가 알아야 할 사항을 간략하게 서술한 것으로 귀하의 위 거래와 관련하여 발생될 수 있는 모든 위험과 중요 사항을 전부 기술한 것은 아닙니다. 따라서 상세한 내용은 nuriter 및 관계법규를 통하여 확인하여야 합니다.<br></p>
        </div>
      </div>
      
    </div>
  </div>

	    <script>

	    $(function(){
	       <%--  var userId = <%= loginUser.getUserEmail() %>;
	        var userName = "<%= loginUser.getUserName()%>";
	        var phone = "<%= loginUser.getPhone()%>";
	    
	    	$("#userId").val(userId);
	    	
	    	
	    	if(userName != "null"){
	    		$("#name").val(userName);
	    	}
	    	
	    	if(phone != "null"){
	    		$("#phone").val(phone);
	    	} --%>
	    	
	    	
	    	var accountNum = $("#account_num");
	    	var birthNum = $("#account_holder_info");
	    	
	    	$(".error-accountNum").hide();
	    	$(".error-birthNum").hide();
	    	$(".error-birthNum2").hide();
	    	
	    	
	    	accountNum.blur(function(){
	    		$(".error-accountNum").hide();
	    		
		    	if (isNaN(accountNum.val())) {
			    	$(".error-accountNum").show();
			    	accountNum.select();
				}else{
					$(".error-accountNum").hide();
				}
		    	
		    });
	    	
	    	birthNum.blur(function(){
	    		$(".error-birthNum").hide();
		    	$(".error-birthNum2").hide();
		    	
		    	if (isNaN(birthNum.val())) {
			    	$(".error-birthNum").show();
			    	birthNum.select();
				}else{
					$(".error-birthNum").hide();
				}
		    	
		    	if (birthNum.val().length < 6) {
			    	$(".error-birthNum2").show();
			    	birthNum.select();
				}else{
					$(".error-birthNum2").hide();
				}
		    	
		    });
	    	
	    });
	    
	    $(function(){
	    	setFieldVal();
	    	bindEvents();
	    });

	    function setFieldVal(){
	    	 $('#tran_dtime').val(new Date().format('yyyyMMddHHmmss')); // 요청일시
	    	 getTokenByClientCredentials(); //access-token 발급 요청
	    	 
	    	 //은행코드
	    	 $("#bank_code_std").val($("#bankcode option:selected").val());
	    	 //console.log($("#bank_code_std").val());
	    	 $("#bankcode").change(function() {
		    		$("#bank_code_std").val($("#bankcode option:selected").val());
		    		//console.log($("#bank_code_std").val());
		    	});
	    }
	    
	    function bindEvents(){
	    	//인증요청
	    	$('#btnRealNameInquiry').on('click', function(e){ 
	    		
	    		$(".error-accountNum").hide();
	    		$(".error-birthNum").hide();
		    	$(".error-birthNum2").hide();
		    	
	    		if($(".error-accountNum").is(':visible')){
					return;
				}else if($(".error-birthNum").is(':visible')){
					return;
				}else if($(".error-birthNum2").is(':visible')){
					return;
				}
	    		
	    		inquiryRealName(); });
	    	
	    }

	    function inquiryRealName(){

	    	if(isEmptyElem('token')){
	    		showMsg('Access Token을 먼저 획득해 주십시오.');
	    		return;
	    	}
	    	
	    	$.ajax({
	    		url:  "https://testapi.open-platform.or.kr/v1.0/inquiry/real_name",
	    		type: 'post',
	    		headers: {
	    			'Authorization': ('Bearer ' + $('#token').val())
	    		},
	    		data: js($.extend({}, getFormParamObj('real_nameFrm'), {
	    			// additional parameters
	    		}))
	    	})
	    	.done(function(data, textStatus, jqXHR){
	    		if(isGatewayException(data)){ return; } // ajax 응답이 Gateway Exception일 경우 이후 처리를 종료한다.		
	    		 /* // UI에 결과값 바인딩
	    		$('#resultTextArea').val(js(data));  */
	    		//console.log(Object.keys(data));
	    		//console.log(data.rsp_code);
	    		if(data.rsp_code=="A0000" && data.account_holder_name==$("#name").val()){
	    		
	    				/* $("#real_nameFrm").submit(); */
	    				alert("계좌 인증에 성공하였습니다.");
	    				
	    				
	    					self.close();
	    				
	    				/* self.close(); */
	    	
	    		}else{
	    			alert("입력 정보가 일치하지 않아 계좌실명인증이 불가합니다. 입력 정보를 다시 한 번 확인해주세요.");
	    		}
	    	});
	    }

	    </script>
</body>
</html>