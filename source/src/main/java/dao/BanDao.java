package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Reportlist;

public class BanDao {
	public List<Reportlist>ReportList(){
		List<Reportlist> list = new ArrayList<>();
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9",
                "f3",
                "3MY7eT2zLbU8GDVm"
            );
            
            String sql = "SELECT r.report_id,r.reason,r.report_time,rl.relay_id, "
            	 +"rl.process_count,rl.redraw_count,rl.relay_image_url, "
            	+"h.work_id,h.editedimage_url,h.caption,v.voice_url ,r.user_id "
            	 +"FROM report r INNER JOIN relay rl ON r.relay_id = "
            	+"rl.relay_id LEFT JOIN history h ON h.project_id = "
            	+"rl.project_id AND h.process_count = rl.process_count "
            	+"LEFT JOIN voices v ON v.voice_id = h.voice_id";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Reportlist report = new Reportlist();
            	report.setRelayId(rs.getInt("relay_id"));
            	report.setUserId(rs.getString("user_id"));
            	report.setImageUrl(rs.getString("editedimage_url"));
            	report.setCaption(rs.getString("caption"));
            	report.setVoiceUrl(rs.getString("voice_url"));
            	report.setReason(rs.getString("reason"));
            	list.add(report);
            }
            }catch (Exception e) {
    	        e.printStackTrace();
    	    } finally {
    	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    	    }
    		return list;
		
	}

	public boolean banUser(String userId) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f3?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f3", "3MY7eT2zLbU8GDVm");
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


