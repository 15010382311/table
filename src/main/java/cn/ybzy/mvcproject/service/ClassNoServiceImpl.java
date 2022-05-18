package cn.ybzy.mvcproject.service;

import java.sql.Connection;
import java.util.List;

import cn.ybzy.mvcproject.dao.ClassNoDaoImpl;
import cn.ybzy.mvcproject.dao.FactoryDao;
import cn.ybzy.mvcproject.dao.HostsDao;
import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import domain.ClassNo;
import util.JDBCUtils;


public class ClassNoServiceImpl implements HostsService {
	HostsDao hostdao = new ClassNoDaoImpl();

	
	public int save(Tables users) {

		return hostdao.save(users);
	}

	
	public int deleteUserById(int id) {

		return hostdao.deleteUserById(id);
	}

	
	public int UpdateUserById(Tables hosts) {

		return hostdao.UpdateUserById(hosts);
	}

	
	public Tables get(int id) {

		return hostdao.get(id);
	}

	
	public List<Tables> getListAll() {

		return hostdao.getListAll();
	}

	
	public long getCountByName(String name) {

		return hostdao.getCountByName(name);
	}

	
	public Tables getAction(int id) {

		Connection conn = null;
		Tables hosts = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);// ��ʼ����
			hosts = hostdao.get(conn, id);
			conn.commit();
		} catch (Exception e) {
			JDBCUtils.huigunConn(conn);// �ع�����
		}
		return hosts;
	}

	
	public List<Tables> query(String hostid,String host) {

		return hostdao.query(hostid,host);
	}


	@Override
	public List<ClassNo1> export(String kaishi, String jieshu) {
		// TODO Auto-generated method stub
		return hostdao.export(kaishi,jieshu);
	}


	
	

}
