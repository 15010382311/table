package cn.ybzy.mvcproject.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.ClassNo;
import util.JDBCUtils;



/**
 * ���ڹ����о����Dao��̳� ʵ�־������ɾ�Ĳ�
 * 
 * @author Administrator
 *
 */
public class BaseDao<T> {
	private Class<T> calzz;
	QueryRunner queryRunner = new QueryRunner();

	/**
	 * ��ʼ�����췽�������ڵõ�T.Class get�������õ�dbutils-queryrunner-query���� �˷�����Ҫ����T.Class����
	 */
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type suType = this.getClass().getGenericSuperclass();
		if (suType instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) suType;
			Type[] trry = pt.getActualTypeArguments();
			if (trry[0] instanceof Class) {
				calzz = (Class<T>) trry[0];
			}
		}
	}

	/**
	 * geT���� ���ڵõ�sql��ѯ����� ����T���ʵ����
	 * 
	 * @param sql  ����sql����ɵ����ഫ��
	 * @param args ռλ����
	 * @return
	 */
	public T geT(String sql, Object... args) {
		Connection coon = null;
		T ent = null;
		try {
			coon = JDBCUtils.getConnection();
			ent = queryRunner.query(coon, sql, new BeanHandler<T>(calzz), args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.Closecoon(coon);
		}

		return ent;
	}

	/**
	 * ��Ҫ����conn��GET����
	 * 
	 * @param coon
	 * @param sql
	 * @param args
	 * @return
	 */
	public T geT(Connection coon, String sql, Object... args) {

		T ent = null;
		try {
			ent = queryRunner.query(coon, sql, new BeanHandler<T>(calzz), args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.Closecoon(coon);
		}

		return ent;
	}

	/**
	 * ����һ��users���ϣ���ѯ���������ͨ�÷���
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getList(String sql, Object... args) {

		Connection coon = null;
		List<T> list = null;
		try {
			coon = JDBCUtils.getConnection();
			list = queryRunner.query(coon, sql, new BeanListHandler<T>(calzz), args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.Closecoon(coon);
		}

		return list;
	}

	/**
	 * ����ɾ����ͨ�÷���
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql, Object... args) {

		Connection coon = null;
		int rows = 0;
		try {
			coon = JDBCUtils.getConnection();
			rows = queryRunner.update(coon, sql, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.Closecoon(coon);
		}

		return rows;
	}

	/**
	 * ��ѯһ��ֵ��ͨ�÷������� count();
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object getValue(String sql, Object... args) {

		Connection coon = null;
		Object value = null;
		try {
			coon = JDBCUtils.getConnection();
			value = queryRunner.query(coon, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.Closecoon(coon);
		}

		return value;
	}

	public List<ClassNo> export1(String kaishi, String jieshu) {
		// TODO Auto-generated method stub
		return null;
	}
}
