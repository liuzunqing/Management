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
		// TODO 自动生成的方法存根
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
