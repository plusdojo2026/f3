package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.History;

public class HistoryDao {
    Connection conn = null;

    // historyテーブルから加工画像URL一覧を取得するメソッド
    public List<History> getHistory(int project_id) throws Exception {

        // 取得した加工履歴を入れるリスト
        List<History> list = new ArrayList<>();
        
        try {
        	// JDBCドライバを読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // データベースに接続
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
    				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
    				"root", "password");
            
           
            // SELECT文を準備する
            // hの画像URL、hのキャプションを取り出して
            String sql = "SELECT editedimage_url, caption, process_count FROM history WHERE project_id = ? ORDER BY process_count ASC";
            

            // SQLを実行する準備
            PreparedStatement pStmt = conn.prepareStatement(sql);
            // プロジェクトIDを指定
            pStmt.setInt(1,project_id);

            // SQL実行
            ResultSet rs = pStmt.executeQuery();

            
            // 取得したデータを1件ずつ取り出す
            while(rs.next()){
            	// 1加工分の箱を作成
            	History h = new History();
            	// 画像URLを保存
            	h.setEditedimage_url(rs.getString("editedimage_url"));
            	// キャプション保存
            	h.setCaption(rs.getString("caption"));
            	// 加工順保存
            	h.setProcess_count(rs.getInt("process_count"));
                // リストに追加
                list.add(h);
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
        return list;
    }
    
 // 登録用。＊まだコピペしただけ。書き換えよ
 			public boolean setHistory(History h) {
 			Connection conn = null;
 			boolean result = false;
 			

 			try {
 				// JDBCドライバを読み込む
 				Class.forName("com.mysql.cj.jdbc.Driver");

 				// データベースに接続する
 				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 						"root", "password");
 				
 				// SQL文を準備する
 				// まずは加工回数を検索して取得する
 				String sql0 = "SELECT COUNT(*) FROM history WHERE project_id = ?";
 				PreparedStatement pStmt0 = conn.prepareStatement(sql0);
 				int count = 0;
 				
 				pStmt0.setInt(1, h.getProject_id());
 				// sqlを実行し、取得した回数を格納する
 				ResultSet rs = pStmt0.executeQuery();
 				if(rs.next()) {
 					count = rs.getInt(1);
 				// 回数に1加える
 	 				count += 1;
 				}
 					
 				
 				
 				// 次にデータを登録する
 				String sql = "INSERT INTO history (work_id, user_id, editedimage_url, process_count, project_id, voice_id, caption, processing_date) VALUES (0, ?, ?, ?, ?, 1, ?, NOW())";
 				PreparedStatement pStmt = conn.prepareStatement(sql);
 				
 				// SQL文を完成させる
 				if (h.getUser_id() != null) {
 					pStmt.setString(1, h.getUser_id());
 				} else {
 					pStmt.setString(1, "");
 				}
 				if (h.getEditedimage_url() != null) {
 					pStmt.setString(2, h.getEditedimage_url());
 				} else {
 					pStmt.setString(2, "");
 				}
 				pStmt.setInt(3, count);
 				pStmt.setInt(4, h.getProject_id());
 				pStmt.setString(5, h.getCaption());
 				
 				// SQL文を実行する
 				if (pStmt.executeUpdate() == 1) {
 					result = true;
 				}
 				// コンソール確認用
 				System.out.println(result);
 				
 			} catch (SQLException e) {
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
 				e.printStackTrace();
 			} finally {
 				// データベースを切断
 				if (conn != null) {
 					try {
 						conn.close();
 					} catch (SQLException e) {
 						e.printStackTrace();
 					}
 			}
 			} return result;
 			}  
}
