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

<!-- テーマ表示部 -->
<h2>テーマ</h2>

<!-- 音声追加 -->

<!-- 音声選択 -->

<!-- 通報 -->
<label for="popupFlag">ポップアップを開く</label>

<input type="checkbox" id="popupFlag" style="display:none">

<div class="popup-background"></div>

<div id="popwin" class="popup">
    <span class="close-button"
    onclick="document.getElementById('popupFlag').checked = false;">×</span>
    <h3 style="color: white">ポップアップ内容</h3>
    <p style="color: white">ここにメッセージを記載できます。</p>
    <button id="button1">天国</button>
</div>


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
<script>
document.getElementById('button1').onclick = function() {
    window.alert('あなたには縁のない場所ですわ。');
}
</script>
</html>