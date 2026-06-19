CREATE DATABASE f3;

USE f3;

create user 'f3'@'%' identified by '3MY7eT2zLbU8GDVm';

/*ユーザ情報*/
CREATE TABLE users (
	user_id VARCHAR(20) PRIMARY KEY,/*ユーザID*/
	user_name VARCHAR(20) NOT NULL,/*ユーザ名*/
	password VARCHAR(20) NOT NULL,/*パスワード*/
	email VARCHAR(100) NOT NULL ,/*メールアドレス*/
	ban boolean DEFAULT FALSE,/*BAN*/
	status boolean DEFAULT FALSE/*状態*/
);

/*管理者情報*/
CREATE TABLE admin(
	admin_id int AUTO_INCREMENT PRIMARY KEY,/*管理者ID*/
	admin_name VARCHAR(20) NOT NULL,/*管理者名*/
	password VARCHAR(20) NOT NULL/*パスワード*/
);

/*音声一覧*/
CREATE TABLE voices(
	voice_id int AUTO_INCREMENT PRIMARY KEY,/*音声ID*/
	voice_url VARCHAR(255) NOT NULL,/*音声URL*/
	temporary_voice boolean /*一時使用音声*/
);


/*作品投稿*/
CREATE TABLE projects (
	project_id int AUTO_INCREMENT PRIMARY KEY,/*プロジェクトID*/
	user_id VARCHAR(20) NOT NULL,/*ユーザID*/
	image_url VARCHAR(255) NOT NULL,/*画像URL*/
	number int NOT NULL,/*人数指定*/
	theme VARCHAR(20) NOT NULL,/*テーマ*/
	post_date DATETIME, /*投稿日時*/
	
	 FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);



/*リレー管理*/
CREATE TABLE relay(
	relay_id int AUTO_INCREMENT PRIMARY KEY,/*リレーID*/
	user_id VARCHAR(20) NOT NULL,/*ユーザーID*/
	process_count int NOT NULL,/*加工順番*/
	project_id int NOT NULL,/*プロジェクトID*/
	redraw_count int NOT NULL,/*再抽選回数*/
	relay_image_url VARCHAR(255),/*画像URL*/
	assigned_at DATETIME,/*割当日時*/
	deadline_at DATETIME,/*期限日時*/
	
	FOREIGN KEY (user_id)
        REFERENCES users(user_id),
        
    FOREIGN KEY (project_id)
        REFERENCES projects(project_id)
);



/*作品加工保存*/
CREATE TABLE history(
	work_id int AUTO_INCREMENT PRIMARY KEY,/*作品ID*/
	user_id VARCHAR(20) NOT NULL,/*ユーザID*/
	editedimage_url VARCHAR(255) NOT NULL,/*加工画像URL*/
	process_count int NOT NULL,/*加工順番*/
	project_id int NOT NULL,/*プロジェクトID*/
	voice_id int NOT NULL,/*音声ID*/
	caption VARCHAR(500) NOT NULL,/*キャプション*/
	processing_date DATETIME,/*加工日時*/
	
	FOREIGN KEY (user_id)
        REFERENCES users(user_id),
	
	FOREIGN KEY (project_id)
        REFERENCES projects(project_id),
        
    FOREIGN KEY (voice_id)
        REFERENCES voices(voice_id)
          
);

/*検閲*/
CREATE TABLE censorship(
	censoring_id int AUTO_INCREMENT PRIMARY KEY,/*検閲ID*/
	project_id int NOT NULL,/*プロジェクトID*/
	user_id VARCHAR(20) NOT NULL,/*ユーザーID*/
	result BOOLEAN,/*判断結果*/
	admin_id int NOT NULL,/*管理者ID*/
	
	FOREIGN KEY (project_id)
        REFERENCES projects(project_id),
    
    FOREIGN KEY (user_id)
        REFERENCES users(user_id),
    
    FOREIGN KEY (admin_id)
        REFERENCES admin(admin_id)
);



/*通報*/
CREATE TABLE report(
	report_id int AUTO_INCREMENT PRIMARY KEY,/*通報ID*/
	relay_id int NOT NULL,/*リレーID*/
	user_id VARCHAR(20) NOT NULL,/*ユーザーID*/
	reason VARCHAR(255) NOT NULL,/*通報理由*/
	report_time DATETIME,/*通報日時*/
	
	FOREIGN KEY (relay_id)
		REFERENCES relay(relay_id),
	
	FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

/*BAN履歴*/
CREATE TABLE ban(
	ban_id int AUTO_INCREMENT PRIMARY KEY,/*BANID*/
	user_id varchar(20) NOT NULL,/*ユーザーID*/
	admin_id int NOT NULL,/*管理者ID*/
	report_id int NOT NULL,/*通報ID*/
	banned DATETIME,/*BAN日時*/
	
	FOREIGN KEY (user_id)
        REFERENCES users(user_id),
        
    FOREIGN KEY (admin_id)
        REFERENCES admin(admin_id),
        
    FOREIGN KEY (report_id)
    	REFERENCES report (report_id)
);

/*通知*/
CREATE TABLE notice(
	notice_id int AUTO_INCREMENT PRIMARY KEY,/*通知ID*/
	user_id varchar(20) NOT NULL,/*ユーザーID*/
	content varchar(255) NOT NULL,/*通知内容*/
	cursed_alert BOOLEAN,/*呪い通知*/
	
	FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

/*呪い*/
CREATE TABLE curse(
	curse_id int AUTO_INCREMENT PRIMARY KEY,/*呪いID*/
	project_id int NOT NULL,/*プロジェクトID*/
	user_id VARCHAR(20) NOT NULL,/*対象ユーザID*/
	raw_image_url VARCHAR(255) NOT NULL,/*未加工画像URL*/
	
	FOREIGN KEY (project_id)
        REFERENCES projects(project_id),
        
    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

/*作品評価*/
CREATE TABLE review(
	project_id int PRIMARY KEY,/*プロジェクトID*/
	thumbnail_url VARCHAR(250) NOT NULL,/*サムネイル用URL*/
	good int DEFAULT 0,/*いいね*/
	grossgood int DEFAULT 0,/*きもいいね*/
	scarygood int DEFAULT 0,/*こわいいね*/
	
	FOREIGN KEY (project_id)
        REFERENCES projects(project_id)
);

/*タグ中間テーブル*/
CREATE TABLE project_tags(
	tag_id int AUTO_INCREMENT PRIMARY KEY,/*タグID*/
	project_id int NOT NULL,/*プロジェクトID*/
	tag_name VARCHAR(20) NOT NULL,/*タグ名*/
	
	FOREIGN KEY (project_id)
        REFERENCES projects(project_id)
	
);




