package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	public static final String driverclass;
	public static final String username;
	public static final String url;
	public static final String password;

	private static Connection conn;
	
	static {
		driverclass = Constants.DRIVERCLASS;
		username = Constants.USERNAME;
		url = Constants.URL;
		password = Constants.PASSWORD;

		// 加载驱动
		try {
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// 判断连接是否为空或者是否已关闭
		// 对单表进行操作的时候只需执行一次链接就可以了 单例
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(url,username, password);
		}
		return conn;
	}

	// 关闭连接
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public static void closePreparedStatement(PreparedStatement ps) throws SQLException {
		if (ps != null) {
			ps.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
}

