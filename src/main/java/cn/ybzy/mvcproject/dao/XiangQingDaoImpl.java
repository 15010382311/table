package cn.ybzy.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import cn.ybzy.mvcproject.model.XiangQing;
import domain.ClassNo;

public class XiangQingDaoImpl extends BaseDao<XiangQing> implements XiangQingDao {

	
	public int save(Tables hosts) {
		String sql = "INSERT INTO `users`( `username`, `password`, `phone_no`, `address`, `reg_date`) VALUES (?,?,?,?,?)";

		return super.update(sql, hosts.getPro(), hosts.getPro(), hosts.getPro(), hosts.getPro(),
				hosts.getPro());
	}

	
	public int deleteUserById(int id) {
		String sql = "DELETE FROM users WHERE id = ?;";
		return super.update(sql, id);
	}

	
	public int UpdateUserById(XiangQing xiangQing) {
		String sql = "UPDATE items SET  `lujing`=?, `qidong`=?, `xiangqing`=?  WHERE itemid = ?";
		return super.update(sql, xiangQing.getLujing(), xiangQing.getQidong(), xiangQing.getXiangqing(), xiangQing.getItemid());
	}

	
	public Tables get(int id) {
		String sql = "SELECT t.id, t.address ,t.`password`,t.phone_no phoneNo,t.username ,t.reg_date regDate from  users t  where t.id = ?;";
		return null;
	}

	
	public List<XiangQing> getListAll(String id) {
		String sql = "SELECT\r\n"
    			+ "  f.`itemid` itemid,\r\n"
    			+ "  t.`name` pro,\r\n"
    			+ "	t.`host` ho,\r\n"
    			+ "	SUBSTRING_INDEX( f.`name`, '状态', 1 ) bushu,\r\n"
    			+ "	f.lujing lujing,\r\n"
    			+ "	f.qidong qidong,\r\n"
    			+ "	f.xiangqing xiangqing\r\n"
    			+ "FROM\r\n"
    			+ "	`hosts` t\r\n"
    			+ "	LEFT JOIN\r\n"
    			+ "	items f\r\n"
    			+ "	on t.hostid = f.hostid\r\n"
    			+ "WHERE\r\n"
    			+ "	t.`name` NOT LIKE '%NAME%' \r\n"
    			+ "	AND t.`status` = '0'\r\n"
    			+ "	AND f.`name` like '%服务%'";
		if (id != null && !"".equals(id)) {
			sql = sql + " and f.itemid = " + id ;
		}
		return super.getList(sql);
	}

	
//	public long getCountByName(String name) {
//		String sql = "SELECT COUNT(id) from users WHERE username = ?";
//		return (long) super.getValue(sql, name);
//	}

	
	public Tables get(Connection conn, int id) {
		String sql = "SELECT  t.address ,t.`password`,t.phone_no phoneNo,t.username ,t.reg_date regDate from  users t  where t.id = ?;";
		return null;
	}

	
	public List<Tables> query(String name,String host) {
		String sql = "";
		if (name != null && !"".equals(name)) {
			sql = sql + " AND t.pro like '%" + name + "%'";
		}
		if (host != null && !"".equals(host)) {
			sql = sql + " AND t.hostid = '" + host + "'";
		}
		return null;
	}


	public long getCountByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<ClassNo1> export(String kaishi, String jieshu) {
		// TODO Auto-generated method stub
		String sql = "";
    	if (kaishi != null && !"".equals(kaishi)) {
			sql = sql + " and FROM_UNIXTIME(t.clock) >  str_to_date( '" + kaishi + "' ,'%Y-%m-%d')";
		}
		if (jieshu != null && !"".equals(jieshu)) {
			sql = sql + " and FROM_UNIXTIME(t.clock) <  str_to_date( '" + jieshu + "' ,'%Y-%m-%d')";
		}
		return null;
	}


	public int updateJiluById(ClassNo1 classNo1) {
		// TODO Auto-generated method stub
		String sql = "UPDATE alerts SET  `chuli`=?  WHERE alertid = ?";
		return super.update(sql, classNo1.getJilu(), classNo1.getAlertid());
	}


	public List<ClassNo1> findJiluByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}




}
