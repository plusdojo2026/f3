<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
<link rel="adminlogin.css" type="text/css" href="css/adminlogin.css">
</head>
<body>
	<form id="adminlogin" method="POST" action="/f3/AdminLoginServlet"></form>
	<div class="textlogo">
		<h5 class="id">管理者ID</h5>
		<input type="submit" class="login" name="login" value="ログイン">
		<h5 class="password">パスワード</h5>
	</div>
	<div>
	<input type="text" name="admin_id">
	<h4 id="logo"> //ロゴのサイズ調整
		<a href="/f3/AdminLoginServlet"><img src="images/adminlogo.png" alt="管理者ログイン"></a>
	</h4>
	<input type="text" name="password">
	</div>

</body>
</html>