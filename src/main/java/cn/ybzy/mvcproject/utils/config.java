package cn.ybzy.mvcproject.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class config {
	static Properties properties = null;
	static {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.config");
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		String driver = properties.getProperty("DBDRIVER");
		String url = properties.getProperty("DBURL");
		String user = properties.getProperty("DBUSER");
		String pass = properties.getProperty("DBPASS");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
