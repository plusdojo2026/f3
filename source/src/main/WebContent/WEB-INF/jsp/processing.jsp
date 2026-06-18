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
<!-- ナビゲーション -->
<label for="naviFlag"><img src="/f3/css/images/prettyAiSitting.png" style="width: 10vw; height: auto; top: 20vh;"></label>

<input type="checkbox" id="naviFlag" style="display:none">

<div class="navi-background"></div>

<div id="naviwin" class="navi">
    <span class="close-button"
    onclick="document.getElementById('naviFlag').checked = false;">×</span>
    <br><br><br><br>
    <a href="" style="color: white;">ログイン</a><br><br>
    <a href="" style="color: white;">異物探索</a><br><br>
    <a href="" style="color: white;">通知</a><br><br>
    <a href="" style="color: white;">設定</a><br><br>
    <a href="" style="color: white;">ログアウト</a>
    
</div>

<!-- テーマ表示部 -->
<div id="theme">
<h2>テーマ</h2>
<img src="/f3/css/images/themebox.png">
</div>

<!-- 時計 -->
<div class="timerContainer">
<img src="/f3/css/images/processTimer.png" alt="残り時間">
<p>23:59</p>
</div>




<!-- Canvas -->
<canvas id="canvas" width="700" height="400" style="border:3px solid black; padding: 0;"></canvas>

<!-- 加工の種類 -->
<div class="kindContainer">
<img src="/f3/css/images/processKind2.png" alt="加工種類の背景">
</div>


<!-- 音声追加 -->
<label for="addSoundFlag"><img id="addSoundImage" src="/f3/css/images/proAddSound.png"></label>

<input type="checkbox" id="addSoundFlag" style="display:none;">

<div class="addSound-background"></div>

<div id="addSoundwin" class="addSound">
    <span class="close-button"
    onclick="document.getElementById('addSoundFlag').checked = false;">×</span>
    <p>音声追加だドン♪</p>
    
</div>
<!-- 音声選択 -->
<label for="selSoundFlag"><img id="selSoundImage" src="/f3/css/images/proSelSound.png"></label>

<input type="checkbox" id="selSoundFlag" style="display:none;">

<div class="selSound-background"></div>

<div id="selSoundwin" class="selSound">
    <span class="close-button"
    onclick="document.getElementById('selSoundFlag').checked = false;">×</span>
    <p>選べ、死にたくなければな</p>
</div>
<!-- キャプション 送信は音声や画像加工とまとめて-->
<div id="caption">
<input type="text" placeholder="キャプション">
</div>


<!-- 通報 -->
<label for="popupFlag" id="reportMark">通報</label>

<input type="checkbox" id="popupFlag" style="display:none">

<div class="popup-background"></div>

<div id="popwin" class="popup">
    <span class="close-button"
    onclick="document.getElementById('popupFlag').checked = false;">×</span>
    <h3 style="color: white">通報内容</h3>
    <input type="text">
    <input type="submit" value="送信">
    
</div>


<!-- 加工機能全般 -->

</body>
<script>
document.getElementById('button1').onclick = function() {
    window.alert('あなたには縁のない場所ですわ。');
}
</script>
</html>