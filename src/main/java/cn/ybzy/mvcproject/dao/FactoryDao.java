package cn.ybzy.mvcproject.dao;

public class FactoryDao {

	public static HostsDao getUserDao() {
		return new HostsDaoImpl();
	}
	

}
