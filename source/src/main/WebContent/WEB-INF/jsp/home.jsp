<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>

	<!-- ヘッダー（ここから） -->
	<header>
		<div class="header">
			<a href="/f3/LoginServlet"><img src="/f3/css/images/home/ログインボタン.png" width="110" height="130" alt=""></a>
			<a href="/f3/LogoutServlet"><img src="/f3/css/images/home/ログアウト.png" width="110" height="130" alt=""></a>
			<!-- 通知 -->
			<a href="/f3/NoticeSerclet" onclick="openNotice();return false;"><img src="/f3/css/images/home/デべそ.png" width="140" height="120" alt="" class="right"></a>
		</div>
		<h1>異物クロニクル</h1>
		<h2>異物クロニクル</h2>
	</header>
	<!-- ヘッダー（ここまで） -->
	<!-- メイン（ここから） -->
	<main>
	<!-- 画像がくる -->
		<div class="form">
			<div id="noticeModal" style="display: none;">
				<h3>通知一覧</h3>

				<c:forEach var="e" items="${noticelist}">
					<div>${e.content}</div>
					<hr>
				</c:forEach>

				<button type="button" onclick="closeNotice()">閉じる</button>
			</div>
			<form action="ProcessingServlet" method="post">

			    <input type="hidden" name="relayId" value="${relay.relay_id}">
			
			    <c:if test="${not empty relay}">
			        <input type="image"src="${relay.relay_image_url}"alt="加工開始"style="width:400px;">
			    </c:if>
			
			</form>
		</div>
		<div class="center">
			<a href="/f3/PostServlet"><img src="/f3/css/images/home/異物投稿.png" width="105" height="140" alt="" class="post"></a>
			<a href="/f3/SearchServlet"><img src="/f3/css/images/home/異物探索.png" width="105" height="120" alt="" class="search"></a>
			<a href="/f3/SettingServlet"><img src="/f3/css/images/home/ホーム画面コイン.png" width="120" height="160" alt="" class="right"></a>
		</div>
	
			<img src="${curse.rawImageUrl}"
     style="position:fixed; top:120px; left:50px; width:250px; transform:rotate(-20deg); z-index:9999;">

<img src="${curse.rawImageUrl}"
     style="position:fixed; top:320px; left:30px; width:250px; z-index:9999;">

<img src="${curse.rawImageUrl}"
     style="position:fixed; top:500px; left:180px; width:250px; z-index:9999;">

<img src="${curse.rawImageUrl}"
     style="position:fixed; top:120px; right:150px; width:250px; transform:rotate(15deg); z-index:9999;">

<img src="${curse.rawImageUrl}"
     style="position:fixed; top:300px; right:50px; width:250px; z-index:9999;">

<img src="${curse.rawImageUrl}"
     style="position:fixed; top:500px; right:200px; width:250px; transform:rotate(-15deg); z-index:9999;">
			


			
	</main>
	
	
	
	<!-- メイン（ここまで） -->
	<!-- フッター（ここから） -->
	<!-- フッター（ここまで） -->
	<!-- JavaScript（ここから） -->
	<script>
		function openNotice(){
		    document.getElementById("noticeModal").style.display = "block";
		}
		
		function closeNotice(){
		    document.getElementById("noticeModal").style.display = "none";
		}
	</script>
</body>
</html>