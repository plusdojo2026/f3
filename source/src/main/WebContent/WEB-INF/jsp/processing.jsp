<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/f3/css/processing.css">
<title>異物加工</title>
</head>
<body>
<!-- ロゴクリックでホーム行くやつ -->
<a href="/servlet/HomeServlet"><img src=""></a>

<h2>テーマ</h2>

<!-- 加工機能全般 -->
<div>
<!-- ② スタンプボタン -->
<button onclick="addStamp('だらけ目玉.png')">スタンプ1</button>
<button onclick="addStamp('藁人形持ち目玉.png')">スタンプ2</button>

<!--　モード切替ボタン　-->
<button onclick="isDrawMode = !isDrawMode">
  ペンモード切替
</button>



<!-- Canvas -->
<canvas id="canvas" width="800" height="600" style="border:3px solid black;"></canvas>

	
</div>
</body>
</html>