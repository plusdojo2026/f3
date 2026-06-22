package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BanDao {

	public boolean banUser(String userId) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			//BANをtrueにする
			String sql ="UPDATE users SET ban = TRUE WHERE user_id = ?";
				//SQLの準備
				PreparedStatement pStmt =conn.prepareStatement(sql);
				//対象ユーザーを一番にセット
				pStmt.setString(1, userId);
				//SQL実行
				int count = pStmt.executeUpdate();

				if(count == 1) {
					result = true;
				}

			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {

				try {
					if(conn != null) {
						conn.close();
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}

			return result;
		}
	}


