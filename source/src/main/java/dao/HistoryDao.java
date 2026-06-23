package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {
    Connection conn = null;

    // historyテーブルから加工画像URL一覧を取得するメソッド
    public List<String> getImages() throws Exception {

        // 取得した画像URLを保存するリスト
        List<String> images = new ArrayList<>();
        
        try {
        	// JDBCドライバを読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // データベースに接続
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
    				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
    				"root", "password");
            
           
            // SELECT文を準備する
            // プロジェクトIDを開くと
            String sql = "SELECT h.editedimage_url,v.voice_id,h.caption FROM history"
            		+ "JOIN voices v ON h.voice_id = v.voice_id WHERE h.project_id = ? ORDER BY h.process_count ASC";
            

            // SQLを実行する準備
            PreparedStatement pStmt = conn.prepareStatement(sql);
            // プロジェクトIDを指定
            // pStmt.setInt(1,project_id);

            // SQL実行
            ResultSet rs = pStmt.executeQuery();

            
            // 取得したデータを1件ずつ取り出す
            while(rs.next()){
                // editedimage_url列の値を取得
                String image = rs.getString("editedimage_url");
                // リストに画像パスを追加
                images.add(image);
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
			// DB切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
        // 取得した画像一覧を返す
        return images;
    }
}
