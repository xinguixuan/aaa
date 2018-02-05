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

		// ��������
		try {
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// �ж������Ƿ�Ϊ�ջ����Ƿ��ѹر�
		// �Ե�����в�����ʱ��ֻ��ִ��һ�����ӾͿ����� ����
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(url,username, password);
		}
		return conn;
	}

	// �ر�����
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

