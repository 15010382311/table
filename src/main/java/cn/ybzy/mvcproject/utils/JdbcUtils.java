package cn.ybzy.mvcproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	public static Connection getConnection() {
		try {
			Connection conn = dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public static Connection getConnection() {
//		Connection conn = null;
//		//加载驱动程序
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			//创建连接
//			//java10为数据库名
//			String url="jdbc:mysql://10.100.103.74:3306/zabbix?useSSL=false&serverTimezone=UTC";
//			String username="zabbix";
//			String userpwd="123456";
//			conn = DriverManager.getConnection(url,username,userpwd);
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// return conn;
//		
//	}

	public static void Closecoon(Connection coon) {
		if (coon != null) {
			try {
				coon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void huigunConn(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
