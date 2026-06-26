package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Projects;

public class ProjectsDao {
	
	// 引数pImで指定されたレコードを登録し、成功したらtrueを返す
			public boolean insert(Projects pIm) {
			Connection conn = null;
			boolean result = false;
			

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"f3", "3MY7eT2zLbU8GDVm");
				
				// SQL文を準備する
				String sql = "INSERT INTO projects (user_id, image_url, number, theme, post_date) VALUES (?, ?, ?, ?, NOW())";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// SQL文を完成させる
				if (pIm.getUserId() != null) {
					pStmt.setString(1, pIm.getUserId());
				} else {
					pStmt.setString(1, "");
				}
				if (pIm.getImageUrl() != null) {
					pStmt.setString(2, pIm.getImageUrl());
				} else {
					pStmt.setString(2, "");
				}
					pStmt.setInt(3, pIm.getNumber());
				if (pIm.getTheme() != null) {
						pStmt.setString(4, pIm.getTheme());
				} else {
					pStmt.setString(4, "");				
				}
				
				
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
			} return result;
			} 
			
			// 加工画面にテーマを表示するための
			// 加工画面にテーマを表示するための
			public String selectTheme(Projects pIm) {
			    Connection conn = null;
			    PreparedStatement pStmt = null;
			    ResultSet rs = null;
			    String result = null;

			    try {
			        // JDBCドライバを読み込む
			        Class.forName("com.mysql.cj.jdbc.Driver");

			        // データベースに接続する
			        conn = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
			            "f3",
			            "3MY7eT2zLbU8GDVm"
			        );

			        // SQL文を準備する
			        String sql = "SELECT theme FROM projects WHERE project_id = ?";
			        pStmt = conn.prepareStatement(sql);

			        // パラメータをセット
			        pStmt.setInt(1, pIm.getProjectId());

			        // SELECTなのでexecuteQuery()
			        rs = pStmt.executeQuery();

			        // 結果取得
			        if (rs.next()) {
			            result = rs.getString("theme");
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    } finally {
			        // ResultSetを閉じる
			        if (rs != null) {
			            try {
			                rs.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			            }
			        }

			        // PreparedStatementを閉じる
			        if (pStmt != null) {
			            try {
			                pStmt.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			            }
			        }

			        // Connectionを閉じる
			        if (conn != null) {
			            try {
			                conn.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			            }
			        }
			    }

			    return result;
			}
	}

			
