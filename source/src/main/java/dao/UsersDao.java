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
			pStmt.setString(1, user.getUserId());// 1つ目の ? にユーザーIDをセット
			pStmt.setString(2, user.getPassword());// 2つ目の ? にパスワードをセット

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
				
				pStmt.setString(1,user.getUserId());// ユーザーID

				pStmt.setString(2,user.getUserName());// ユーザー名

				pStmt.setString(3,user.getPassword());// パスワード

				pStmt.setString(4,user.getEmail());// メールアドレス
				
				// INSERT実行
				// 1件追加なら成功
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}

			}catch (Exception e) {
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
			// 登録結果返却
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
				String sql ="SELECT COUNT(*) FROM users WHERE user_id = ?";

				PreparedStatement pStmt =conn.prepareStatement(sql);
				
				
				pStmt.setString(1, userId);// ? に入力されたユーザーIDをセット

				ResultSet rs =pStmt.executeQuery();// SQL実行

				rs.next();// 1行目へ移動
				
				// 件数が1件以上なら既に存在
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
		
		public boolean update(Users user) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "UPDATE users SET user_name=?, email=?, user_id=?, password=? WHERE user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, user.getUserName());
				pStmt.setString(2, user.getEmail());
				pStmt.setString(3, user.getUserId());
				pStmt.setString(4, user.getPassword());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
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
			}

			// 結果を返す
			return result;
		}

		// 引数cardで指定された番号のレコードを削除し、成功したらtrueを返す
		public boolean delete(String userId) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "DELETE FROM users WHERE user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, userId);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
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
			}

			// 結果を返す
			return result;
		}
}
