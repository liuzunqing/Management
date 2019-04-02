package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public static Connection open() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/studentinfodb?characterEncoding=utf-8";
		user = "root";
		password = "123456";
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn) {
		// TODO �Զ����ɵķ������
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
