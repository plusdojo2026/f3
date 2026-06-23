<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者検閲</title>
<link rel="stylesheet" type="text/css" href="css/censorship.css">
</head>
<body>
	<div class="top">
		<div class="logout">
			<a href="/f3/LogoutServlet"><img src="images/ログアウト.png" class="flower" alt="ログアウト"></a>
		</div>
		<div>
			<a href="/f3/CensorshipServlet"><img src="images/adminlogo.png" class="logo" alt="管理者ページ"></a>
		</div>
		<div class="ban">
			<a href="/f3/BanServlet"><img src="images/teapott.png" class="ban" alt="通報確認"></a>
		</div>
	</div>
	<!-- ここにc:forEach -->
	<c:forEach var="e" items="${CensorshipList}">
		<div class="censorlist">
			<img src="${e.imageUrl }" class="img"><!-- ここにc:forEach -->
			<input type="text" name="caption" value="${e.caption}">
			<button type="button" onclick="playAudio('${e.voiceUrl}')" class="voice">
				<img src="images/再生ボタン.png" class="voice" alt="再生ボタン">
			</button>
			<form action="/f3/CheckServlet" method="post">
				<input type="hidden" name="project_id" value="${e.projectId}">
				<input type="hidden" name="user_id" value="${e.userId}">
				<input type="hidden" name="source" value="${e.source}">
				<button type="submit" class="undo" name="action" value="取り消し">
					<img src="images/取り消し.png" class="cancel" alt="取り消しボタン">
				</button>
				<button type="submit" class="authorize" name="action" value="許可">
					<img src="images/許可.png" class="permission" alt="許可ボタン">
				</button>
			</form>
		</div>
	</c:forEach>

			<script>
				

				function playAudio(url) {
					const audio = new Audio(url);
					audio.currentTime = 0;
					audio.play();
				}
			</script>

</body>
</html>