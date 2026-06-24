package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Relay;

public class RelayDao {

    private static final String URL ="jdbc:mysql://localhost:3306/f3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Tokyo";

    private static final String USER = "root";
    private static final String PASS = "password";


    
    public boolean insert(Relay relay) {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASS);

            String sql = "INSERT INTO relay(user_id, process_count, project_id, redraw_count,relay_image_url, assigned_at, deadline_at)VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, relay.getUser_id());
            ps.setInt(2, relay.getProcess_count());
            ps.setInt(3, relay.getProject_id());
            ps.setInt(4, relay.getRedraw_count());
            ps.setString(5, relay.getRelay_image_url());
            ps.setObject(6, relay.getAssigned_at());
            ps.setObject(7, relay.getDeadline_at());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return false;
    }

    public Relay findByUserId(String userId) {

        Connection conn = null;
        Relay relay = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM relay r WHERE r.user_id = ? AND NOT EXISTS (SELECT 1 FROM history h WHERE h.project_id = r.project_id AND h.user_id = r.user_id) ORDER BY r.assigned_at DESC LIMIT 1";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            System.out.println("検索ユーザー=" + userId);

            if (rs.next()) {
                System.out.println("relay見つかった");
                
                relay = new Relay();

                relay.setRelay_id(rs.getInt("relay_id"));
                relay.setUser_id(rs.getString("user_id"));
                relay.setProcess_count(rs.getInt("process_count"));
                relay.setProject_id(rs.getInt("project_id"));
                relay.setRedraw_count(rs.getInt("redraw_count"));
                relay.setRelay_image_url(rs.getString("relay_image_url"));

                if (rs.getTimestamp("assigned_at") != null) {
                    relay.setAssigned_at(rs.getTimestamp("assigned_at").toLocalDateTime());
                }

                if (rs.getTimestamp("deadline_at") != null) {
                    relay.setDeadline_at(rs.getTimestamp("deadline_at").toLocalDateTime());
                }
            } else {
                System.out.println("relayなし");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return relay;
    }


    //  削除（期限切れ・再利用用）

    public boolean delete(int relayId) {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASS);

            String sql = "DELETE FROM relay WHERE relay_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, relayId);

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return false;
    }


    // 任意）ユーザーの最新レコード取得チェック用
    public boolean existsByUserId(String userId) {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT 1 FROM relay WHERE user_id = ? LIMIT 1";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return false;
    }
}