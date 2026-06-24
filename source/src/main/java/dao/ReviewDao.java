package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Review;

public class ReviewDao {
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
			String sql = "SELECT DISTINCT r.project_id, r.thumbnail_url, r.good, r.grossgood, r.scarygood "
					+ "FROM review r "                                //基準テーブル
					+ "JOIN projects p ON r.project_id=p.project_id " //テーマ検索
					+ "JOIN history h ON r.project_id=h.project_id "//キャプション検索
					+ "JOIN users u ON h.user_id=u.user_id "//ユーザー名検索
					+ "JOIN project_tags pt ON r.project_id=pt.project_id "//タグ検索
					
					//順番
					+ "ORDER BY project_id";
			
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


		
			
