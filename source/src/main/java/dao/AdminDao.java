package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Admin;

public class AdminDao {
	public Admin login(String admin_id, String password ) {
		Connection conn = null;
		Admin admin = null;
		
		try {
			// JDBCドライバを読み込む
						Class.forName("com.mysql.cj.jdbc.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
								+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
								"root", "password");
						String sql = "SELECT admin_id,pssword FROM admin WHERE admin_id = ? AND password = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, admin_id);
						pStmt.setString(2, password);
						
						// SELECT文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
						if (rs.next()) {
			                admin = new Admin();  // ★ user_id を返す
			                admin.setAdmin_id(rs.getInt("admin_id"));
			                admin.setPassword(rs.getString("password"));
			            }

			        } catch (Exception e) {
			            e.printStackTrace();
			        } finally {
			            if (conn != null) try { conn.close(); } catch (SQLException e) {}
			        }
					
		return admin;


		}
		
	}


