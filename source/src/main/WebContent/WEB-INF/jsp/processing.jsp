<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/f3/css/processing.css">
<title>異物加工</title>
<style>
* {
max-width: 100%;
  height: auto;
}
#caption {
width: 210px;
height: 70px;
background-color: transparent;
color: white;
}

</style>
</head>
<body>
<!-- ロゴクリックでホーム行くやつ -->
<a href="/f3/HomeServlet"><img src="/f3/css/images/logoAnker.png" style="position: absolute; width: 20vw; height: auto; left: 1vw; top: 2vh;"></a>
<!-- ナビゲーション -->
<label for="naviFlag"><img src="/f3/css/images/prettyAiSitting.png" style="position: absolute; width: 7vw; height: auto; top: 80vh; left: 0vw;"></label>

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
<div id="themeContainer">
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
<!-- ① アップロードボタン -->
<input type="file" id="upload" accept="image/*" style="z-index: 2000;">


<!-- ② スタンプボタン -->
<button onclick="addStamp('/f3/css/images/logoAnker.png')">スタンプ1</button>
<button onclick="addStamp('/f3/css/images/processTimer.png')">スタンプ2</button>

<!-- 加工の種類 -->
<div class="kindContainer">
<img src="/f3/css/images/processKind2.png" alt="加工種類の背景" style="z-index: 900;">
<div class="pTag" style="position: absolute; z-index: 902; left: 4vw; top: 4vh;">
<input type="radio" id=kind1 style="" name="kind" value="1">フィルム加工<br>
<input type="radio" id=kind2 style="" name="kind" value="2">ケージ変形<br>
<input type="radio" id=kind3 style="" name="kind" value="3" onclick="mosaicOn = true;">モザイク<br>
<input type="radio" id=kind4 style="" name="kind" value="4">拡大・縮小<br>
<input type="radio" id=kind5 style="" name="kind" value="5">背景透過<br>
<input type="radio" id=kind6 style="" name="kind" value="6">サンプル画像と合成<br>
<input type="radio" id=kind7 style="" name="kind" value="7">消しゴムマジック<br>
<input type="radio" id=kind8 style="" name="kind" value="8">3Dデータと合成<br>
<input type="radio" id=kind9 style="" name="kind" value="9">エフェクト<br>
<input type="radio" id=kind10 style="" name="kind" value="10">吹き出し<br>
<input type="radio" id=kind11 style="" name="kind" value="11">ぼかし<br>
<input type="radio" id=kind12 style="" name="kind" value="12">明るさ変更<br>
<input type="radio" id=kind13 style="" name="kind" value="13" onclick="drawOpen = true;">お絵描き

<div class="draw-background"></div>

<div id="drawwin" class="draw">
    <span class="close-button"
    onclick="document.getElementById('kind13').checked = false;">×</span>
    
</div>

<br>
<input type="radio" id=kind14 style="" name="kind" value="14">画像ランダム変化
</div>
</div>


<!-- 音声追加 -->
<label for="addSoundFlag"><img id="addSoundImage" src="/f3/css/images/proAddSound.png"></label>

<input type="checkbox" id="addSoundFlag" style="display:none;">

<div class="addSound-background"></div>

<div id="addSoundwin" class="addSound">
    <span class="close-button"
    onclick="document.getElementById('addSoundFlag').checked = false;">×</span>
    <button id="recordBtn">録音開始</button>
    
    
</div>
<!-- 音声選択 -->
<label for="selSoundFlag"><img id="selSoundImage" src="/f3/css/images/proSelSound.png"></label>

<input type="checkbox" id="selSoundFlag" style="display:none;">

<div class="selSound-background"></div>

<div id="selSoundwin" class="selSound">
    <span class="close-button"
    onclick="document.getElementById('selSoundFlag').checked = false;">×</span>
    
</div>
<!-- キャプション 送信は音声や画像加工とまとめて-->
<div class="caption" style="position: relative; top: 77vh; left: 30vw;">
<img src="/f3/css/images/proCaption.png" alt="キャプションボックス画像" style="position: absolute; width: 20vw; height: auto;">
<input id="caption" type="text" maxlength="100" name="caption" placeholder="キャプション" style="position: absolute; top: 4vh; left: 3vw">
</div>


<!-- 通報 -->
<label for="popupFlag" id="reportMark">通報</label>

<input type="checkbox" id="popupFlag" style="display:none">

<div class="popup-background"></div>

<div id="popwin" class="popup">
    <span class="close-button"
    onclick="document.getElementById('popupFlag').checked = false;">×</span>
    <h3 style="color: white">通報内容</h3>
    <input type="text" maxlength="50" name="reason">
    <input type="submit" value="送信">
    
</div>


<!-- 加工機能全般 -->

</body>
<script>
const canvas = document.getElementById("canvas");
// 2D描画コンテキストを取得する
const ctx = canvas.getContext("2d");

let baseImage = null;

//　！！！！開発用。画像をアップロードしてCanvasに表示
const upload = document.getElementById("upload");


upload.addEventListener("change", function() {
  const file = this.files[0];

  if (!file) return;

  const reader = new FileReader();

  reader.onload = function(e) {
    const img = new Image();
    
    img.onload = function() {
        baseImage = img;
        draw();
      
    };

    img.src = e.target.result;
  };


reader.readAsDataURL(file);
});

// キャンバスに矩形を描画
ctx.strokeRect(50, 20, 200, 200);
ctx.fillRect(180, 80, 100, 100);

// 録音機能
// 入力デバイスアクセスと2秒間録音
document.getElementById('recordBtn').addEventListener('click', async() =>{
	try {
		//マイク使用許可
		const stream = await navigator.mediaDevices.getUserMedia({audio: true});
		
		// 形式
		const options = { mimeType: 'audio/webm'};
		
		let chunks = [];
		const recorder = new MediaRecorder(stream, options);
		
		// 音声データが届くたびに保存
		recorder.ondataavailable = (e) => {
			if (e.data.size > 0) chunks.push(e.data);
		};
		
		recorder.start();
		
		// 2秒後に録音
		setTimeout(() => {
			recorder.stop();
			
			//マイクストリーム停止
			stream.getTracks().forEach(track => track.stop());
		}, 2000);
	} catch (err) {
		alert("マイクの使用許可が必要です:" + err);
	}
})
</script>
</html>