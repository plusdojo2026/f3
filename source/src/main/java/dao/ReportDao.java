package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Report;

public class ReportDao {

	// 引数reportで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Report report) {
		Connection conn = null;
		boolean result = false;
		
	try {
		// JDBCドライバを読み込む
		Class.forName("com.mysql.cj.jdbc.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"f3", "3MY7eT2zLbU8GDVm");
			
		// SQL文を準備する
		String sql = "INSERT INTO report (relay_id, user_id, reason, report_time) VALUES (?, ?, ?, NOW())";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		// SQL文を完成させる
		pStmt.setInt(1, report.getRelayId());
		if (report.getUserId() != null) {
			pStmt.setString(2, report.getUserId());
		} else {
			pStmt.setString(2, "");
		}
		if (report.getReason() != null) {
			pStmt.setString(3, report.getReason());
		} else {
			pStmt.setString(3, "");
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
}
