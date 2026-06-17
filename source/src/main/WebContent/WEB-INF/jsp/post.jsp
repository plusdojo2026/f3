<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/post.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- actionのurlを変更せよ -->
	<form action="/f3/PostServlet" method="post">
		<input type="file" id="image" name="image">
		<input type="text" id="theme" name="theme" placeholder="テーマ（１０文字まで）">
		<input type="range" id="number" name="number">
		<input type="submit" value="送信">
	</form>

</body>
</html>