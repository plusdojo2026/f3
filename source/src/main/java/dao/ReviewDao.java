package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Detail;
import dto.Review;

public class ReviewDao {
	public List<Detail> detail(int project_id){
		List<Detail>list = new ArrayList<>();
		Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/f3?"
                + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root",
                "password"
            );
            String sql = "SELECT p.image_url AS image_url,NULL AS voice_url, NULL AS caption,0 AS sort_order "
            			+"FROM projects p WHERE p.project_id = ? UNION ALL SELECT "
            			+"h.editedimage_url AS image_url,v.voice_url,h.caption,h.process_count AS sort_order FROM "
            			+"history h LEFT JOIN voices v ON h.voice_id = v.voice_id WHERE h.project_id =? "
            			+"ORDER BY sort_order";
            pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, project_id);
            pStmt.setInt(2, project_id);
            rs = pStmt.executeQuery();
            while(rs.next()) {
            	Detail detail = new Detail();
            	System.out.println("image_url=" + rs.getString("image_url"));
                System.out.println("voice_url=" + rs.getString("voice_url"));
                System.out.println("caption=" + rs.getString("caption"));
                System.out.println("sort_order=" + rs.getInt("sort_order"));
                System.out.println("-------------------");
            	detail.setImageUrl(rs.getString("image_url"));
            	detail.setCaption(rs.getString("caption"));
            	detail.setVoiceUrl("voice_url");
            	list.add(detail);
            	
            }
        }catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }
		return list;
		
	}
	// 引数card指定された項目で検索して、取得されたデータのリストを返す
	public List<Review> select() {
		Connection conn = null;
		List<Review> cardList = new ArrayList<Review>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			// SQL文を準備する //重複削除DISTINCT
			String sql = "SELECT * FROM review";
					
			
			//desc
					//１０件まで表示
					//+"LIMIT 10 OFFSET ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Review Review = new Review(
						rs.getInt("project_id"), 
						rs.getString("thumbnail_url"),
						rs.getInt("good"),
						rs.getInt("grossgood"),
						rs.getInt("scarygood")
						);
				cardList.add(Review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
	}
}


		
			
