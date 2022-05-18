package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC������ ʹ��Durid���ӳ�
 */
public class JDBCUtils {

    private static DataSource ds ;

    static {

        try {
            //1.���������ļ�
            Properties pro = new Properties();
            //ʹ��ClassLoader���������ļ�����ȡ�ֽ�������
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //2.��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ӳض���
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * ��ȡ����Connection����
     */
    public static Connection getConnection()  {
    	
        try {
			return  ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
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
