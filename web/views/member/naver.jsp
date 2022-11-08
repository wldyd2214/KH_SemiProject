<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
   boolean bool = true;/* (boolean)request.getAttribute("bool"); */
   String name = (String)request.getAttribute("name");
   String email = (String)request.getAttribute("email");
   String id = (String)request.getAttribute("id");
   String refresh_token = (String)request.getAttribute("refresh_token");
   boolean suc = false;
   if(request.getAttribute("suc") != null){
      suc = true;
   }
   System.out.print(name);
%>
  <head>
  	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <title>네이버로그인</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/common/pushy-buttons.css">
    <link href="<%= request.getContextPath() %>/css/common/bootstrap.min.css" rel="stylesheet">
    
  </head>
  <!-- <body>
	<script type="text/javascript">
  var clientId = "방금 발급받은거 넣으세요";
  var callbackUrl = "api신청할때 넣은 callback url 넣으세요";
  var naver_id_login = new naver_id_login(clientId, callbackUrl);
  // 접근 토큰 값 출력
  alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age'));
  }
</script>
</body> -->
 <body onload="addInfor();">
     <!-- onload="setParentText();" -->
     <script type="text/javascript">   
        function setParentText(){   //메인페이지 새로고침후 닫기
           opener.location.href='<%=request.getContextPath() %>/MainFunding';
           window.close();
        }
        
        function addInfor(){
           
           if(<%=bool%>){
              if(<%=suc%>){
                 alert('회원가입 완료');
              }
              setParentText();
           }else{
              console.log("추가입력");
           }
           
        }
   </script>
   
   <div style='width:100%; height:400px; text-align: center;'>
         <label style='font-size:50px; font color:green; margin-left:auto; margin-right:auto'>추가입력</label>
         
         <br>
         <hr style='width:80%;'>
         <form action='<%=request.getContextPath() %>/memberSNSJoin.mem' method='post'>
            <input type='hidden' name='refresh_token' value='<%=refresh_token%>'>
            <input type='hidden' name='id' value='<%=id%>'>
            
            <label style='font-size:20px'>이름 : </label>
            <input type='text' name='name' value='<%=name%>'  readonly>
            <br>
            <label style='font-size:20px'>이메일 : </label>
            <input type='text' name='email' value='<%=email%>' style="width: 200px;" readonly>
            <br>
            <label style='font-size:20px'>닉네임 : </label>
            <input type='text' name='nick' placeholder='닉네임 입력'>
            <br><br>
            <button class='btns btn--sm btn--green'>회원가입</button>
         </form>
   </div>
   
  </body>
</html>