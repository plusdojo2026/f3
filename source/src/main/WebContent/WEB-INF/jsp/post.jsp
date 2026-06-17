<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- actionのurlを変更せよ -->
	<form action="/PostServlet" method="post">
		<input type="file" id="image">
		<input type="text" id="theme" placeholder="テーマ（１０文字まで）">
		<input type="range" id="number">
	</form>

</body>
</html>