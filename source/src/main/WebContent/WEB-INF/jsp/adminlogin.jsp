<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
<link rel="stylesheet" type="text/css" href="css/adminlogin.css">
</head>
<body>
<div class="screen">


	<img src="images/adminbackground.webp" class="bg">
	<form id="adminlogin" method="POST" action="/f3/AdminLoginServlet">
		<div class="textlogo">
			<h5 class="id">管理者ID</h5>
			<input type="submit" class="login" name="login" value="ログイン">
			<h5 class="password">パスワード</h5>
		</div>
		<div class="center">
			<input type="text" name="admin_id" placeholder="入力出来たらログイン">
			<img src="images/adminlogo.png" class="logo" alt="管理者ページ">
			<input type="text" name="password" placeholder="の顔をクリック‼">
		</div>
	</form>
</div>
<%
if(request.getAttribute("error_msg")!=null){
	String error_msg = (String)request.getAttribute("error_msg");
%>
<script>
var msg = "<%=request.getAttribute("error_msg")%>";
</script>
<%
}
%>
</body>
</html>