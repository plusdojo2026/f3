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


		
			
