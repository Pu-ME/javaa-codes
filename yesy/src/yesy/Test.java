package yesy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * @author putengfei
 * @created 2018-02-22
*/
public class Test {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("UPDATE user SET password = 13224 WHERE username='jerry'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.release(conn, ps, null);
		}
	}
}
