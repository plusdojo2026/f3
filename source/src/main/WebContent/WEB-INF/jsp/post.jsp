<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/f3/css/post.css">
<meta charset="UTF-8">
<title>異物投稿</title>
<style>
/* ロゴ */
.logo img {
position: absolute;
width: 20vw;
height: auto;
top: 2vh;
left: 2vw;
}
/* ナビゲーション */
.navi {
        position: absolute;
        top: 0;
        left:0;
        width: 10vw;
        height: 100vh;
        background-color: black;
        padding-top: 20px;
        box-sizing: border-box;
        display: none;
    }
/* 閉じるボタン */
        .close-button {
        	color: white;
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }
        
        #naviFlag:checked + .navi-background,
        #naviFlag:checked + .navi-background + .navi {
            display: block;
        }   
 #naviwin a {
 font-size: 30px;
 }   

.fileUpload {
position: absolute; 
top: 7vh; 
left: 43vw;
}
#previewArea {
	width: 240px;
    height: 160px;
    border: 3px solid black;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden; /* 画像がはみ出さないように */
            background-color: white;
        }
        #previewImage {
            max-width: 100%;
            max-height: 100%;
            object-fit: contain;
            display: none; /* 初期状態では非表示 */
        }

#theme {
border: 3px solid black;
background-color: white;
width: 300px;
height: 34px;
font-size: 30px

}

#number {
accent-color: #F5B31B;
}
</style>

</head>
<body>

<!-- タイトルロゴ。画像をもらって挿入せよ -->
<div class="logo">
	<a href="/f3/HomeServlet"><img src="/f3/css/images/logoAnker.png" alt="タイトルロゴ"></a>
</div>


<!-- ナビゲーション -->
<label for="naviFlag"><img src="/f3/css/images/prettyAiSitting.png" style="position: absolute; width: 10vw; height: auto; left: 0vw; top: 80vh;"></label>

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
<!-- actionのurlを変更せよ -->
	<form action="/f3/PostServlet" method="post" enctype="multipart/form-data">
	<!-- ファイルアップロード -->
	<div class="fileUpload">
    <input type="file" id="imageInput" name="file" accept="image/*">

    <div id="previewArea">
        <img id="previewImage" src="" alt="プレビュー画像">
        <p id="noImageText">ここに画像が表示される！</p>
    </div>
    </div>
		
		
	<!-- テーマ -->	
	<div class="theme" style="position: absolute; top: 30vh; left: 70vw;">
		<input type="text" id="theme" name="theme" placeholder="テーマ（１０文字まで）">
	</div>
	
	<!-- 人数指定メーター -->
	<div class="number" style="position: absolute; top: 90vh; left: 50vw;">
		<input type="range" id="number" name="number" min="3" max="7" value="5">
		
	</div>
	
	<!-- 投稿ボタン -->
	<div class="submit" style="position: absolute; top: 70vh; left: 15vw;">
		<input type="image" src="/f3/css/images/postSubmit.png" alt="投稿" style="position: absolute; width: 20vw; height: auto;">
	</div>
	</form>

</body>
<script>
 // 画像アップロード
    // DOM要素の取得
        const imageInput = document.getElementById('imageInput');
        const previewImage = document.getElementById('previewImage');
        const noImageText = document.getElementById('noImageText');

        // ファイルが選択された時のイベントリスナー
        imageInput.addEventListener('change', function(e) {
            const file = e.target.files[0]; // 選択されたファイルを取得

            if (file) {
                // FileReaderオブジェクトを作成
                const reader = new FileReader();

                // ファイルの読み込みが完了した時の処理
                reader.onload = function(e) {
                    previewImage.src = e.target.result; // 読み込んだデータを画像のsrcに設定
                    previewImage.style.display = 'block'; // 画像を表示
                    noImageText.style.display = 'none'; // 「画像なし」テキストを非表示
                };

                // ファイルをData URLとして読み込む
                reader.readAsDataURL(file);
            } else {
                // ファイルが選択されなかった場合
                previewImage.src = '';
                previewImage.style.display = 'none';
                noImageText.style.display = 'block';
            }
        });
        
</script>
</html>


