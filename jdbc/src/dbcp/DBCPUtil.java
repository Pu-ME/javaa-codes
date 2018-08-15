package dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbcp.DelegatingPreparedStatement;

public class DBCPUtil {
	private static DataSource ds = null;
	
	static{
		Properties prop = new Properties();
		try {
			prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop);//得到一个数据源
		} catch (Exception e) {
			throw new RuntimeException("初始化错误，请检查配置文件！");
		}
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器繁忙！");
		}
	}
	
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}

	}
}
