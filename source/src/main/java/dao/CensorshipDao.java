package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Censorshiplist;

public class CensorshipDao {
	public boolean undo(int project_id,String user_id,int admin_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/webapp1?"
                + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root",
                "password"
            );
            String sql;
            int count;
            sql =
            	    "INSERT INTO censorship(project_id," 
            	     +"user_id,result,admin_id) VALUES(?,?,false,?)";

            	pStmt = conn.prepareStatement(sql);

            	pStmt.setInt(1, project_id);
            	pStmt.setString(2, user_id);
            	pStmt.setInt(3, admin_id);

              count = pStmt.executeUpdate();
            	if(count == 0) {
            	    return false;
            	}
             sql =
            		    "INSERT INTO notice(" +
            		    "user_id," +
            		    "content," +
            		    "cursed_alert" +
            		    ") VALUES(?,?,FALSE)";
            	pStmt = conn.prepareStatement(sql);

            	pStmt.setString(1, user_id);
            	pStmt.setString(2, "あなたの作品が検閲で取り消されました。内容を確認してください。");

               count = pStmt.executeUpdate();
               if(count == 0) {
           	    return false;
           	}
               return ture;

            	
        }catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            try {
                if (rs != null) rs.close();
                if (pStmt != null) pStmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}
	public boolean authorize(int project_id,String user_id,String source,int admin_id) {
		Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/webapp1?"
                + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root",
                "password"
            );
            String sql;
            String imageUrl = null;
            int processCount = 0;
             sql =
            	    "INSERT INTO censorship(project_id," 
            	     +"user_id,result,admin_id) VALUES(?,?,TRUE,?)";

            	pStmt = conn.prepareStatement(sql);

            	pStmt.setInt(1, project_id);
            	pStmt.setString(2, user_id);
            	pStmt.setInt(3, admin_id);

            	int count = pStmt.executeUpdate();
            	if(count == 0) {
            	    return false;
            	}
            	

            

            // =====================
            // 元画像取得
            // =====================

            if ("PROJECT".equals(source)) {

                sql =
                    "SELECT image_url " +
                    "FROM projects " +
                    "WHERE project_id=? AND user_id=?";

                pStmt = conn.prepareStatement(sql);

                pStmt.setInt(1, project_id);
                pStmt.setString(2, user_id);

                rs = pStmt.executeQuery();

                if (!rs.next()) {
                    return false;
                }

                imageUrl = rs.getString("image_url");
                processCount = 1;

            } else {

                 sql =
                    "SELECT editedimage_url, process_count " +
                    "FROM history " +
                    "WHERE project_id=? AND user_id=?";

                pStmt = conn.prepareStatement(sql);

                pStmt.setInt(1, project_id);
                pStmt.setString(2, user_id);

                rs = pStmt.executeQuery();

                if (!rs.next()) {
                    return false;
                }

                imageUrl = rs.getString("editedimage_url");
                processCount = rs.getInt("process_count") + 1;
            }

            // =====================
            // 必要人数取得
            // =====================

            int number = 0;

             sql =
                "SELECT number " +
                "FROM projects " +
                "WHERE project_id=?";

            pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, project_id);

            rs = pStmt.executeQuery();

            if (!rs.next()) {
                return false;
            }

            number = rs.getInt("number");

            // =====================
            // 加工人数取得
            // =====================

            int historyCount = 0;

            sql =
                "SELECT COUNT(*) AS cnt " +
                "FROM history " +
                "WHERE project_id=?";

            pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, project_id);

            rs = pStmt.executeQuery();

            if (rs.next()) {
                historyCount = rs.getInt("cnt");
            }

            // =====================
            // 完成判定
            // =====================

            if (historyCount >= number) {
            	sql =
            	        "INSERT INTO review(" +
            	        "project_id," +
            	        "thumbnail_url," +
            	        "good," +
            	        "grossgood," +
            	        "scarygood" +
            	        ") " +
            	        "SELECT " +
            	        "project_id," +
            	        "image_url," +
            	        "0," +
            	        "0," +
            	        "0 " +
            	        "FROM projects " +
            	        "WHERE project_id=?";

            	    pStmt = conn.prepareStatement(sql);
            	    pStmt.setInt(1, project_id);
            	    pStmt.executeUpdate();
                return true;
            }

            // =====================
            // 次の加工者抽選
            // =====================

            String nextUserId = null;

            sql =
                "SELECT u.user_id " +
                "FROM users u " +
                "WHERE u.user_id NOT IN (" +
                    "SELECT p.user_id " +
                    "FROM projects p " +
                    "WHERE p.project_id=? " +
                    "UNION " +
                    "SELECT h.user_id " +
                    "FROM history h " +
                    "WHERE h.project_id=? " +
                ") " +
                "ORDER BY RAND() " +
                "LIMIT 1";

            pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, project_id);
            pStmt.setInt(2, project_id);

            rs = pStmt.executeQuery();

            if (!rs.next()) {
                return false;
            }

            nextUserId = rs.getString("user_id");

            // =====================
            // relay登録
            // =====================

            sql =
                "INSERT INTO relay(" +
                "user_id," +
                "process_count," +
                "project_id," +
                "redraw_count," +
                "relay_image_url," +
                "assigned_at," +
                "deadline_at" +
                ") VALUES (" +
                "?,?,?,0,?," +
                "NOW()," +
                "DATE_ADD(NOW(), INTERVAL 1 DAY)" +
                ")";

            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, nextUserId);
            pStmt.setInt(2, processCount);
            pStmt.setInt(3, project_id);
            pStmt.setString(4, imageUrl);

            pStmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            try {
                if (rs != null) rs.close();
                if (pStmt != null) pStmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
	}
        
		
	
	public List<Censorshiplist> findCensorship(){
		List<Censorshiplist> list = new ArrayList<>();
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
                "root",
                "password"
            );
            String sql =
            		"select p.project_id,p.user_id,p.image_url,NULL as voice_url,NULL as caption,'project' as source "+
            		"from projects p where not exists(select 1 from censorship c where c.project_id = p.project_id and c.user_id = p.user_id) "+
            		"union all select h.project_id,h.user_id, h.editedimage_url as image_url,v.voice_url,h.caption,'history' as source from history h inner join voices v on h.voice_id = v.voice_id where not exists("+
            		"select 1 from censorship c where c.project_id = h.project_id and c.user_id = h.user_id)";
          
            		
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Censorshiplist censorship = new Censorshiplist();
            	censorship.setProjectId(rs.getInt("project_id"));
            	censorship.setUserId(rs.getString("user_id"));
            	censorship.setImageUrl(rs.getString("image_url"));
            	censorship.setVoiceUrl(rs.getString("voice_url"));
            	censorship.setCaption(rs.getString("caption"));
            	censorship.setSource(rs.getString("source"));
            	list.add(censorship);
            	
            }
		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }
		return list;
		}
		
	}


