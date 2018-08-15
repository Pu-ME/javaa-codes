package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestDbcp {

	
	public static void main(String []args){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBCPUtil.getConnection();
			ps = conn.prepareStatement("UPDATE user SET password = 1234 WHERE username='jerry'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCPUtil.release(null, ps, conn);
		}
		
		
	}
}
