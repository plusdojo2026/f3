package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Users;

public class UsersDao {
	// ログイン成功ならtrue
		public boolean isLoginOK(Users user) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SELECT文を準備する
			String sql = "SELECT count(*) FROM users WHERE user_id=? AND password=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			rs.next();
			if (rs.getInt(1) == 1) {
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
		
		
		public boolean insert(Users user) {

			Connection conn = null;
			boolean result = false;	
			
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				String sql ="INSERT INTO users (user_id,user_name,password,email) VALUES(?,?,?,?)";
				
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				pStmt.setString(1,user.getUserId());

				pStmt.setString(2,user.getUserName());

				pStmt.setString(3,user.getPassword());

				pStmt.setString(4,user.getEmail());
			
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}

			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {

				if (conn != null) {

					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			return result;
		}
		
		// ユーザーIDが既に存在するか確認
		public boolean isExistUserId(String userId) {

			Connection conn = null;
			boolean result = false;

			try {

				// JDBCドライバ読込
				Class.forName("com.mysql.cj.jdbc.Driver");

				// DB接続
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL
				String sql =
						"SELECT COUNT(*) FROM users WHERE userid = ?";

				PreparedStatement pStmt =
						conn.prepareStatement(sql);

				pStmt.setString(1, userId);

				ResultSet rs =
						pStmt.executeQuery();

				rs.next();

				if (rs.getInt(1) > 0) {
					result = true;
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {

				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			return result;
		}
}
