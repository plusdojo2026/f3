package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Notice;

public class NoticeDao {
	public List<Notice> noticeCall(String userId) {
			List<Notice> list = new ArrayList<>();
			Connection conn = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SELECT文を準備する
				String sql = "SELECT content FROM notice WHERE user_id=? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, userId);

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Notice nlist = new Notice();
					nlist.setContent(rs.getString("content"));
					list.add(nlist);
				}

			}
			catch(Exception e){
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
			return list;


		}
	}

			

