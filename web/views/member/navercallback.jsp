<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<html>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<script type="text/javascript">
  var clientId = "p7rY8Kd2Yc3e2TAc4l38";
  var callbackUrl = "http://localhost:8001/ns/views/member/navercallback.jsp";
  var naver_id_login = new naver_id_login(clientId, callbackUrl);
  // 접근 토큰 값 출력
  /* alert(naver_id_login.oauthParams.access_token); */
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
   /*  alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age')); */
    
    /* var email = naver_id_login.getProfileData('email');
    var name = naver_id_login.getProfileData('name');
    var nickname = naver_id_login.getProfileData('nickname');
    var birthday = naver_id_login.getProfileData('birthday');
    var accessToken=naver_id_login.oauthParams.access_token();
    console.log(email);
    console.log(name);
    
    document.frm.useremail.value=email;
    document.frm.name.value=name;
    document.frm.nickname.value=nickname;
    document.frm.birthday.value=birthday;
  
    console.log(document.frm.name.value);
    document.frm.submit(); */
	$("#useremail").val(naver_id_login.getProfileData('email'));
    $("#name").val(naver_id_login.getProfileData('name'));
	$("#nickname").val(naver_id_login.getProfileData('nickname'));
	$("#birthday").val(naver_id_login.getProfileData('birthday'));
	/* $("#accessToken").val(naver_id_login.oauthParams.access_token);
	$("#refreshToken").val(); */
	$("#login").submit();
    self.close();
  }
  
  
</script>



<form id="login" method="post" name="frm" action="<%=request.getContextPath()%>/naverlogin" target="naverLogin">
		
		<input type="hidden" id="useremail" name="useremail">
		<input type="hidden" id="name" name="name">
		<input type="hidden" id="nickname" name="nickname">
		<input type="hidden" id="birthday" name="birthday">
		
	</form>


</body>
</html>