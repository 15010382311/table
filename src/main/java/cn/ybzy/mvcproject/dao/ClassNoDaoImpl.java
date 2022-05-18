package cn.ybzy.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import domain.ClassNo;

public class ClassNoDaoImpl extends BaseDao<ClassNo1> implements HostsDao {

	
	public int save(Tables hosts) {
		String sql = "INSERT INTO `users`( `username`, `password`, `phone_no`, `address`, `reg_date`) VALUES (?,?,?,?,?)";

		return super.update(sql, hosts.getPro(), hosts.getPro(), hosts.getPro(), hosts.getPro(),
				hosts.getPro());
	}

	
	public int deleteUserById(int id) {
		String sql = "DELETE FROM users WHERE id = ?;";
		return super.update(sql, id);
	}

	
	public int UpdateUserById(Tables hosts) {
		String sql = "UPDATE users SET `id` =?, `username`=?, `password`=?, `phone_no`=?, `address`=?, `reg_date`=? WHERE id = ?";
		return super.update(sql, hosts.getPro(), hosts.getPro(), hosts.getPro(), hosts.getPro(),
				hosts.getPro(),hosts.getPro(), hosts.getPro());
	}

	
	public Tables get(int id) {
		String sql = "SELECT t.id, t.address ,t.`password`,t.phone_no phoneNo,t.username ,t.reg_date regDate from  users t  where t.id = ?;";
		return null;
	}

	
	public List<Tables> getListAll() {
		String sql = "SELECT  t.address ,t.`password`,t.phone_no phoneNo,t.username ,t.reg_date regDate from  users t  ;";
		return null;
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
		String sql = "SELECT t.alertid,t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi,t.jilu FROM (\r\n"
				+ "SELECT MIN(t.alertid) alertid,t.clock, t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi,max(t.jilu) jilu FROM(\r\n"
				+ "    	SELECT DISTINCT t.alertid,t.clock, t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi,t.jilu FROM (		SELECT DISTINCT\r\n"
				+ "    			            t.clock,\r\n"
				+ "											t.alertid,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, 'IP地址：', 1 ), '告警主机:',- 1 ) zhuji,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警时间:', 1 ), 'IP地址：',- 1 ) dizhi,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警等级:', 1 ), '告警时间:',- 1 ) time,\r\n"
				+ "    			    				CASE\r\n"
				+ "    			    					REPLACE(REPLACE((SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警信息:', 1 ), '告警等级:',- 1 )), CHAR(10),''), CHAR(13),'') \r\n"
				+ "    			    					WHEN 'Information' THEN\r\n"
				+ "    			    					'信息'  \r\n"
				+ "    			    					WHEN 'Warning' THEN\r\n"
				+ "    			    					'警告' \r\n"
				+ "    			    					WHEN 'Average' THEN\r\n"
				+ "    			    					'一般严重'  \r\n"
				+ "    			    					WHEN 'High' THEN\r\n"
				+ "    			    					'严重' \r\n"
				+ "    			    					WHEN 'Disaster' THEN\r\n"
				+ "    			    					'灾难' ELSE '未设置' \r\n"
				+ "    			    				END  dengji,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '问题详情:', 1 ), '告警信息:',- 1 ) xinxi,\r\n"
				+ "    			    				t.chuli jilu \r\n"
				+ "    			    			FROM\r\n"
				+ "    			    				`alerts` t \r\n"
				+ "    			    			WHERE\r\n"
				+ "    			    				t.message NOT LIKE '%解除%'\r\n"
				+ "    			    			and t.message not LIKE '%¦%' \r\n"
				+ "										\r\n"
				+ "										 ORDER BY SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警等级:', 1 ), '告警时间:',- 1 ) DESC) t) t\r\n"
				+ "										 GROUP BY   t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi\r\n"
				+ "										 ORDER BY t.time DESC\r\n"
				+ "						 ) t		 \r\n"
				+ "						WHERE 1=1	 ";
    	if (kaishi != null && !"".equals(kaishi)) {
			sql = sql + " and FROM_UNIXTIME(t.clock) >  str_to_date( '" + kaishi + "' ,'%Y-%m-%d')";
		}
		if (jieshu != null && !"".equals(jieshu)) {
			sql = sql + " and FROM_UNIXTIME(t.clock) <  str_to_date( '" + jieshu + "' ,'%Y-%m-%d')";
		}
		return super.getList(sql);
	}


	public List<ClassNo1> findJiluByID(String id) {
		String sql = "SELECT t.alertid,t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi,t.jilu FROM (\r\n"
				+ "SELECT MIN(t.alertid) alertid,t.clock, t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi,max(t.jilu) jilu FROM(\r\n"
				+ "    	SELECT DISTINCT t.alertid,t.clock, t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi,t.jilu FROM (		SELECT DISTINCT\r\n"
				+ "    			            t.clock,\r\n"
				+ "											t.alertid,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, 'IP地址：', 1 ), '告警主机:',- 1 ) zhuji,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警时间:', 1 ), 'IP地址：',- 1 ) dizhi,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警等级:', 1 ), '告警时间:',- 1 ) time,\r\n"
				+ "    			    				CASE\r\n"
				+ "    			    					REPLACE(REPLACE((SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警信息:', 1 ), '告警等级:',- 1 )), CHAR(10),''), CHAR(13),'') \r\n"
				+ "    			    					WHEN 'Information' THEN\r\n"
				+ "    			    					'信息'  \r\n"
				+ "    			    					WHEN 'Warning' THEN\r\n"
				+ "    			    					'警告' \r\n"
				+ "    			    					WHEN 'Average' THEN\r\n"
				+ "    			    					'一般严重'  \r\n"
				+ "    			    					WHEN 'High' THEN\r\n"
				+ "    			    					'严重' \r\n"
				+ "    			    					WHEN 'Disaster' THEN\r\n"
				+ "    			    					'灾难' ELSE '未设置' \r\n"
				+ "    			    				END  dengji,\r\n"
				+ "    			    				SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '问题详情:', 1 ), '告警信息:',- 1 ) xinxi,\r\n"
				+ "    			    				t.chuli jilu \r\n"
				+ "    			    			FROM\r\n"
				+ "    			    				`alerts` t \r\n"
				+ "    			    			WHERE\r\n"
				+ "    			    				t.message NOT LIKE '%解除%'\r\n"
				+ "    			    			and t.message not LIKE '%¦%' \r\n"
				+ "										\r\n"
				+ "										 ORDER BY SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警等级:', 1 ), '告警时间:',- 1 ) DESC) t) t\r\n"
				+ "										 GROUP BY   t.zhuji,t.dizhi,t.time,t.dengji,t.xinxi\r\n"
				+ "										 ORDER BY t.time DESC\r\n"
				+ "						 ) t " ;
    	if (id != null && !"".equals(id)) {
			sql = sql + "where t.alertid = " + id + ";";
		}
		// TODO Auto-generated method stub
		return super.getList(sql);
	}




}
