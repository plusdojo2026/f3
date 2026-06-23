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
	public boolean authorize(int project_id,String user_id,String source) {
		Connection conn = null;
        PreparedStatement pStmt = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
        	if("P".equals(source)) {
        		String sql =
        		        "SELECT image_url, number " +
        		        "FROM projects " +
        		        "WHERE project_id=? AND user_id=?";
        		
        	}else {
        		String sql =
        		        "SELECT editedimage_url, process_count " +
        		        "FROM history " +
        		        "WHERE project_id=? AND user_id=?";
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


