package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Curse;

public class CurseDao {

	public boolean insert(Curse curse) {

		Connection conn = null;
		boolean result = false;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
				+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"f3", "3MY7eT2zLbU8GDVm");
			
			// 呪い情報登録SQL
			String sql ="INSERT INTO curse (project_id,user_id,raw_image_url) VALUES(?,?,?)";
			
			// SQL準備
			PreparedStatement pStmt =conn.prepareStatement(sql);
			// 1個目の？にプロジェクトID
			pStmt.setInt(1,curse.getProjectId());
			// 2個目の？に対象ユーザーID
			pStmt.setString(2,curse.getUserId());
			// 3個目の？に画像URL
			pStmt.setString(3,curse.getRawImageUrl());
			
			// SQL実行
			int count = pStmt.executeUpdate();
			
			// 1件登録なら成功
						if(count == 1) {
							result = true;
						}
					}
					catch(Exception e) {
						// エラー内容表示
						e.printStackTrace();
					}
					finally {
						try {
							// DB切断
							if(conn != null) {
								conn.close();
							}
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
					// 結果返却
					return result;
				}
	
	// ログインユーザーが呪われているか取得
	public Curse findByUserId(String userId) {

		Connection conn = null;

		Curse curse = null;

		try {

			// JDBC読込
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
								+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
								"f3", "3MY7eT2zLbU8GDVm");

			// 対象ユーザーの呪い取得
			String sql ="SELECT * FROM curse WHERE user_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// user_idセット
			pStmt.setString(1, userId);

			ResultSet rs =pStmt.executeQuery();

			// 1件見つかった
			if(rs.next()) {
				
				System.out.println("呪いデータ見つかった");

				curse = new Curse();

				curse.setCurseId(rs.getInt("curse_id"));

				curse.setProjectId(rs.getInt("project_id"));

				curse.setUserId(rs.getString("user_id"));

				curse.setRawImageUrl(rs.getString("raw_image_url"));
				
				curse.setCurseDate(rs.getTimestamp("curse_date").toLocalDateTime());
			}else {
				 System.out.println("呪いデータなし");
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

		return curse;
	}
	
	public boolean releaseCurse(int curseId) {

	    Connection conn = null;

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	     // データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f3", "3MY7eT2zLbU8GDVm");

	        String sql ="UPDATE curse SET curse_flg = FALSE WHERE curse_id = ?";

	        PreparedStatement pStmt =conn.prepareStatement(sql);

	        pStmt.setInt(1, curseId);

	        return pStmt.executeUpdate() == 1;

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return false;
	}
}

