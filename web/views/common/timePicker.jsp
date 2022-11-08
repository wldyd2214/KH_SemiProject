<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<link rel="stylesheet" href="//cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.css">
<script src='//cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.js'></script>
<style>
.web-font{
    font-family: 'Jua', sans-serif;
    margin-right:5px;
}
.ui-timepicker{
	font-family: 'Jua', sans-serif;
}
.ui-timepicker-minutes div{
	background: rgb(241, 196, 15);
}
.ui-timepicker-hours div{
	background: rgb(241, 196, 15);
}
</style>
<script>
$(function() {
	$('#timepicker1').timepicker({ 'step': 15 });
	$('#timepicker2').timepicker({
	    'step': function(i) {
	        return (i%2) ? 15 : 45;
	    }
	});
});
</script>
</head>
<body>
		<br>
		<label for="timepicker1"><font class="web-font">시작시간</font></label>
		<input type="text" name="timepicker1" id="timepicker1" class='web-font'>
		&nbsp&nbsp<font class="web-font">~</font>&nbsp&nbsp
		<label for="timepicker2"><font class="web-font">종료시간</font></label>
		<input type="text" name="timepicker2" id="timepicker2" class='web-font'>
</body>
</html>