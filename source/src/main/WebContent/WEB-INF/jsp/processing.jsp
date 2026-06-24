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

#menu {border: 1px solid #999; padding: 10px; display: none;}
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
    <a href="/f3/LoginServlet" style="color: white;">ログイン</a><br><br>
    <a href="/f3/SearchServlet" style="color: white;">異物探索</a><br><br>
    <a href="" style="color: white;">通知</a><br><br>
    <a href="/f3/SettingServlet" style="color: white;">設定</a><br><br>
    <a href="/f3/LogoutServlet" style="color: white;">ログアウト</a>
    
</div>

<!-- テーマ表示部 -->
<div id="themeContainer">
<h2><%= request.getAttribute("theme") %></h2>
<img src="/f3/css/images/themebox.png">
</div>

<!-- 時計 -->
<div class="timerContainer">
<img src="/f3/css/images/processTimer.png" alt="残り時間">
<p><%= request.getAttribute("deadline") %></p>
</div>




<form action="ProcessingServlet" method="POST" id="proForm" enctype="multipart/form-data">
<!-- Canvas -->
<canvas id="canvas" width="700" height="400" style="border:3px solid black; padding: 0;"></canvas>
<!-- アップロード -->
<img src="${relay_image_url}" id="upload" style="z-index: 2000;">



<!-- 加工の種類 -->
<div class="kindContainer">
<img src="/f3/css/images/processKind2.png" alt="加工種類の背景" style="z-index: 900;">
<div class="pTag" style="position: absolute; z-index: 902; left: 4vw; top: 4vh;">
<label><input type="radio" id=kind1 style="" name="kind" value="1">フィルム加工</label><br>
<label><input type="radio" id=kind2 style="" name="kind" value="2">ケージ変形</label><br>
<label><input type="radio" id=kind3 style="" name="kind" value="3">モザイク</label><br>
<label><input type="radio" id=kind4 style="" name="kind" value="4">拡大・縮小</label><br>
<label><input type="radio" id=kind5 style="" name="kind" value="5">背景透過</label><br>
<label><input type="radio" id=kind6 style="" name="kind" value="6">サンプル画像と合成</label><br>
<label><input type="radio" id=kind7 style="" name="kind" value="7">消しゴムマジック</label><br>
<label><input type="radio" id=kind8 style="" name="kind" value="8">3Dデータと合成</label><br>
<label><input type="radio" id=kind9 style="" name="kind" value="9">エフェクト</label><br>
<label><input type="radio" id=kind10 style="" name="kind" value="10">吹き出し</label><br>
<label><input type="radio" id=kind11 style="" name="kind" value="11">ぼかし</label><br>
<label><input type="radio" id=kind12 style="" name="kind" value="12">明るさ変更</label><br>
<label><input type="radio" id=kind13 style="" name="kind" value="13">お絵描き</label><br>
<label><input type="radio" id=kind14 style="" name="kind" value="14">画像ランダム変化</label>
</div>
</div>

<div id="menu" style="z-index: 3000;"></div>


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
<form action="/f3/CaptionServlet" method="POST">
<img src="/f3/css/images/proCaption.png" alt="キャプションボックス画像" style="position: absolute; width: 20vw; height: auto;">
<input id="caption" type="text" maxlength="100" name="caption" placeholder="キャプション" style="position: absolute; top: 4vh; left: 3vw">
</form>
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

<!-- 加工終了ボタン -->
<img id="complete" src="/f3/css/images/completePro.png" 
onclick="document.getElementById('proForm').submit(); submitCanvas(); document.get" 
style="position: absolute; width: 10%; height: auto; left: 80%; top: 80%;">
</form>
<!-- 加工機能全般 -->

</body>
<script>
const canvas = document.getElementById("canvas");
// 2D描画コンテキストを取得する
const ctx = canvas.getContext("2d");
// 開発用画像
const upload = document.getElementById("upload");
const menu = document.getElementById("menu");

let originalImage = null;
let currentTool = null;

// 画像アップロード
upload.addEventListener("change", (e) => {
	const file = e.target.files[0];
	if(!file) return;
	
	const img = new Image();
	img.onload = () => {
		originalImage = img;
		redrawBaseImage();
	};
	img.src = URL.createObjectURL(file);
});

// 元画像だけ描画
function redrawBaseImage() {
	console.log("再描画された");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	if (originalImage) {
		ctx.drawImage(originalImage, 0, 0, canvas.width, canvas.height);
	}
}

// 加工クリア（元画像だけ残す）
function clearEdits() {
	redrawBaseImage();
}

// ラジオボタン変更
document.querySelectorAll("input[name='kind']").forEach(radio => {
	radio.addEventListener("change", (e) => {
		
		if (currentTool !== null) {
			const confirmChange = confirm("加工内容を消去して加工方法を変更しますか？");
			if (!confirmChange) {
				e.target.checked = false;
				document.querySelector(`input[value='${currentTool}']`).checked = true;
				return;
			}
			clearEdits();
		}
		
		currentTool = e.target.value;
		showMenu(currentTool);
	});
});

//メニュー表示
function showMenu(kind) {
	resetCanvasEvents()
	menu.style.display = "block";
	
	switch (kind) {
	case "1":
		menu.innerHTML = `
		<h4>フィルタ</h4>
		<button type="button" onclick="grayscale()">グレースケール</button>
		`; //<button>はデフォルトでtype="submit"なので、typeを指定しないとページロードされる
		break;
	
	case "2":
		
		break;
		
	case "3":
		menu.innerHTML = `
		<h4>モザイク</h4>
		ブロックサイズ:
			<input type="range" id="mosaicSize" min="5" max="50" value="100">
		<p>ドラッグで範囲選択</p>
		`;
		enableMosaic()
		break;

	case "4":
		
		break;
	
	case "5":
		
		break;
		
	case "6":
		menu.innerHTML = `
		<img id="stampImg" src="/f3/css/images/nyukai.png" 
		style="width: 10%; height: auto; z-index: 4000"; 
		onclick="addStamp(this);">
		`;
		break;

	case "7":
		
		break;
	
	case "8":
		
		break;
		
	case "9":
		
		break;

	case "10":
		menu.innerHTML = `
			<img name="fkds" src="/f3/css/images/fkds/fkds001.png" 
			style="width: 10%; height: auto; z-index: 4000"; 
			onclick="addFkds(this);">
			<img name="fkds" src="/f3/css/images/fkds/fkds002.png" 
			style="width: 10%; height: auto; z-index: 4000"; 
			onclick="addFkds(this);">
			<img name="fkds" src="/f3/css/images/fkds/fkds003.png" 
			style="width: 10%; height: auto; z-index: 4000"; 
			onclick="addFkds(this);">
			<img name="fkds" src="/f3/css/images/fkds/fkds004.png" 
			style="width: 10%; height: auto; z-index: 4000"; 
			onclick="addFkds(this);">
			`;
		
		break;
	
	case "11":
		
		break;
		
	case "12":
		
		break;
		
	case "13":
		menu.innerHTML = `
		<h4>お絵描き</h4>
		ペン色: <input type="color" id="penColor"><br>
		`;
		enableDraw();
		break;
		
	case "14":
		
		break;
	}
}


// ツール切り替え時のイベントリセット（消去バグ防止）
function resetCanvasEvents() {
	canvas.onmousedown = null;
	canvas.onmouseup = null;
	canvas.onmousemove = null;
	canvas.onclick = null;
}
// フィルタ
function grayscale() {
	const img = ctx.getImageData(0, 0, canvas.width, canvas.height);
	for (let i = 0; i < img.data.length; i += 4) {
		const avg = (img.data[i] + img.data[i+1] + img.data[i+2]) / 3;
		img.data[i] = img.data[i+1] = img.data[i+2] = avg;
	}
	ctx.putImageData(img, 0, 0);
}

//　モザイク処理
 // ドラッグによる座標指定
function enableMosaic() {
	let startX, startY;
	let selecting = false;
	
	canvas.onmousedown = (e) => {
		const rect = canvas.getBoundingClientRect();
		startX = e.clientX - rect.left;
		startY = e.clientY - rect.top;
		selecting = true;
	};
	
	canvas.onmouseup = (e) => {
		if(!selecting) return;
		selecting = false;
		
		const rect = canvas.getBoundingClientRect();
		const endX = e.clientX - rect.left;
		const endY = e.clientY - rect.top;
		
		applyMosaic(startX, startY, endX, endY);
	};
	
	canvas.onmousemove = null;
}

 // モザイク適用
 function applyMosaic(x1, y1, x2, y2) {
	 const size = parseInt(document.getElementById("mosaicSize").value);
	 
	 const sx = Math.min(x1, x2); // Math.min()は引数のうち最小値を求める
	 const sy = Math.min(y1, y2);
	 const sw = Math.abs(x2 - x1); // 絶対値を求める
	 const sh = Math.abs(y2 - y1);
	 
	 const imageData = ctx.getImageData(sx, sy, sw, sh);
	 const data = imageData.data;
	 
	 for (let y = 0; y < sh; y += size) {
		 for(let x = 0; x < sw; x += size) {
			 
			 let r = 0, g = 0, b = 0, count = 0;
			 
			 // ブロック平均色取得
			 for (let dy = 0; dy < size; dy++) {
				 for(let dx = 0; dx < size; dx++) {
					 const px = x + dx;
					 const py = y + dy;
					 if(px < sw && py < sh) {
						 const idx = (py * sw + px) * 4;
						 r += data[idx];
						 g += data[idx + 1];
						 b += data[idx + 2];
						 count++;
					 }
				 }
			 }
			 
			 r = r / count;
			 g = g / count;
			 b = b / count;
			 
			 // ブロック書き込み
			 for(let dy = 0; dy < size; dy++) {
				 for(let dx = 0; dx < size; dx++) {
					 const px = x + dx;
					 const py = y + dy;
					 if (px < sw && py < sh) {
						 const idx = (py * sw + px) * 4;
						 data[idx] = r;
						 data[idx + 1] = g;
						 data[idx + 2] = b;
					 }
				 }
			 }
		 }
	 }
	 
	 ctx.putImageData(imageData, sx, sy);
 }

// スタンプ合成
function addStamp(imgElement) {
  const img = new Image();

  img.onload = () => {

    const w = 80;
    const h = 80;

    // canvas中央に配置
    let x = canvas.width / 2 - w / 2;
    let y = canvas.height / 2 - h / 2;

    let dragging = false;
    let offsetX = 0;
    let offsetY = 0;

    // 現在の状態を保存（背景）
    let baseSnapshot = ctx.getImageData(0, 0, canvas.width, canvas.height);

    // 最初に描画（中央）
    drawPreview();

    canvas.onmousedown = (e) => {
      const rect = canvas.getBoundingClientRect();
      const mx = e.clientX - rect.left;
      const my = e.clientY - rect.top;

      // スタンプ内クリックでドラッグ開始
      if (mx >= x && mx <= x + w && my >= y && my <= y + h) {
        dragging = true;
        offsetX = mx - x;
        offsetY = my - y;
      }
    };

    canvas.onmousemove = (e) => {
      if (!dragging) return;

      const rect = canvas.getBoundingClientRect();
      const mx = e.clientX - rect.left;
      const my = e.clientY - rect.top;

      x = mx - offsetX;
      y = my - offsetY;

      drawPreview();
    };

    canvas.onmouseup = () => {
      if (!dragging) return;
      dragging = false;

      // 確定描画
      ctx.putImageData(baseSnapshot, 0, 0);
      ctx.drawImage(img, x, y, w, h);

      // 新しい状態を更新
      baseSnapshot = ctx.getImageData(0, 0, canvas.width, canvas.height);
    };

    function drawPreview() {
      ctx.putImageData(baseSnapshot, 0, 0);
      ctx.globalAlpha = 0.7; // 半透明プレビュー
      ctx.drawImage(img, x, y, w, h);
      ctx.globalAlpha = 1.0;
    }

  };

  img.src = imgElement.src;
}

//吹き出し
function addFkds(imgElement) {
  const img = new Image();

  img.onload = () => {

    const w = 80;
    const h = 80;

    // canvas中央に配置
    let x = canvas.width / 2 - w / 2;
    let y = canvas.height / 2 - h / 2;

    let dragging = false;
    let offsetX = 0;
    let offsetY = 0;

    // 現在の状態を保存（背景）
    let baseSnapshot = ctx.getImageData(0, 0, canvas.width, canvas.height);

    // 最初に描画（中央）
    drawPreview();

    canvas.onmousedown = (e) => {
      const rect = canvas.getBoundingClientRect();
      const mx = e.clientX - rect.left;
      const my = e.clientY - rect.top;

      // スタンプ内クリックでドラッグ開始
      if (mx >= x && mx <= x + w && my >= y && my <= y + h) {
        dragging = true;
        offsetX = mx - x;
        offsetY = my - y;
      }
    };

    canvas.onmousemove = (e) => {
      if (!dragging) return;

      const rect = canvas.getBoundingClientRect();
      const mx = e.clientX - rect.left;
      const my = e.clientY - rect.top;

      x = mx - offsetX;
      y = my - offsetY;

      drawPreview();
    };

    canvas.onmouseup = () => {
      if (!dragging) return;
      dragging = false;

      // 確定描画
      ctx.putImageData(baseSnapshot, 0, 0);
      ctx.drawImage(img, x, y, w, h);

      // 新しい状態を更新
      baseSnapshot = ctx.getImageData(0, 0, canvas.width, canvas.height);
    };

    function drawPreview() {
      ctx.putImageData(baseSnapshot, 0, 0);
      ctx.globalAlpha = 0.7; // 半透明プレビュー
      ctx.drawImage(img, x, y, w, h);
      ctx.globalAlpha = 1.0;
    }

  };

  img.src = imgElement.src;
}
// お絵描き
function enableDraw() {
	let drawing = false;
	
	canvas.onmousedown = () => drawing = true;
	canvas.onmouseup = () => drawing = false;
	
	canvas.onmousemove = (e) => {
		if(!drawing) return;
		
		const rect = canvas.getBoundingClientRect();
		ctx.fillStyle = document.getElementById("penColor").value || "#000";
		ctx.beginPath();
		ctx.arc(e.clientX - rect.left, e.clientY - rect.top, 3, 0, Math.PI * 2);
		ctx.fill();
	};
}

// canvasの内容を提出する
function submitCanvas() {
	canvas.toBlob(blob => {
		const formData = new FormData();
		formData.append("image", blob, "edited.png");
		
		fetch("/f3/uploadImages", {
			method: "POST",
			body: formData
		});
	});
}

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