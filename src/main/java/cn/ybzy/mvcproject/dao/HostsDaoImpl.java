package cn.ybzy.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import domain.ClassNo;

public class HostsDaoImpl extends BaseDao<Tables> implements HostsDao {

	
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
		return super.geT(sql, id);
	}

	
	public List<Tables> getListAll() {
		String sql = "SELECT  t.address ,t.`password`,t.phone_no phoneNo,t.username ,t.reg_date regDate from  users t  ;";
		return super.getList(sql);
	}

	
//	public long getCountByName(String name) {
//		String sql = "SELECT COUNT(id) from users WHERE username = ?";
//		return (long) super.getValue(sql, name);
//	}

	
	public Tables get(Connection conn, int id) {
		String sql = "SELECT  t.address ,t.`password`,t.phone_no phoneNo,t.username ,t.reg_date regDate from  users t  where t.id = ?;";
		return super.geT(conn, sql, id);
	}

	
	public List<Tables> query(String name,String host) {
		String sql = "SELECT * FROM(\r\n"
				+ "SELECT \r\n"
				+ "cpu.hostid,\r\n"
				+ "cpu.pro,\r\n"
				+ "concat( cpu.cpu, '%' ) cpu,\r\n"
				+ "concat( memory.memory, '%' ) memory,\r\n"
				+ "disk.disk,\r\n"
				+ "shouye.shouye,\r\n"
				+ "service.service,\r\n"
				+ "network.network\r\n"
				+ "\r\n"
				+ " FROM \r\n"
				+ "\r\n"
				+ "	(SELECT h.`host` hostid, h.name pro,FORMAT( h1.`value`,2) cpu FROM `hosts` h,\r\n"
				+ "(SELECT m1.* FROM (SELECT t1.hostid, t1.itemid, t2.value, t2.clock FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.description = 'CPU') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid) m1,\r\n"
				+ "(SELECT t1.hostid, MAX(t2.value) `value` FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.description = 'CPU') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid GROUP BY t1.hostid) m2\r\n"
				+ "WHERE m1.hostid=m2.hostid AND m1.value=m2.value) h1\r\n"
				+ "WHERE h.hostid=h1.hostid) cpu\r\n"
				+ "LEFT JOIN\r\n"
				+ "(SELECT h.name pro,  group_concat(concat( concat( h1.`name`, concat( FORMAT(( h1.`value` / 1024 / 1024 / 1024 ), 2 ), 'GB' ) ), '\\n' )) disk FROM `hosts` h,\r\n"
				+ "(SELECT m2.* FROM \r\n"
				+ "(SELECT t1.hostid, t2.value `value`,t1.`name` FROM (SELECT f.hostid, f.itemid,f.`name` FROM items f WHERE f.description = 'DISK') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid) m2\r\n"
				+ ") h1\r\n"
				+ "WHERE h.hostid=h1.hostid \r\n"
				+ "GROUP BY h.`name`\r\n"
				+ "UNION ALL\r\n"
				+ "SELECT h.name,  group_concat(concat( concat( h1.`name`, concat( FORMAT(( h1.`value` / 1024 / 1024 / 1024 ), 2 ), 'GB' ) ), '\\n' )) FROM `hosts` h,\r\n"
				+ "(SELECT m2.* FROM \r\n"
				+ "(SELECT t1.hostid, t2.value `value`,t1.`name` FROM (SELECT f.hostid, f.itemid,f.`name` FROM items f WHERE f.description = 'DISK') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history_uint g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history_uint g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid) m2\r\n"
				+ ") h1\r\n"
				+ "WHERE h.hostid=h1.hostid \r\n"
				+ "GROUP BY h.`name`) disk\r\n"
				+ "ON cpu.pro = disk.pro\r\n"
				+ "\r\n"
				+ "LEFT JOIN \r\n"
				+ "(SELECT h.name pro,FORMAT( h1.`value`,2) memory FROM `hosts` h,\r\n"
				+ "(SELECT m1.* FROM (SELECT t1.hostid, t1.itemid, t2.value, t2.clock FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.description = 'ME') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid) m1,\r\n"
				+ "(SELECT t1.hostid, MAX(t2.value) `value` FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.description = 'ME') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid GROUP BY t1.hostid) m2\r\n"
				+ "WHERE m1.hostid=m2.hostid AND m1.value=m2.value) h1\r\n"
				+ "WHERE h.hostid=h1.hostid ) memory\r\n"
				+ "ON cpu.pro = memory.pro\r\n"
				+ "\r\n"
				+ "LEFT JOIN\r\n"
				+ "\r\n"
				+ "(SELECT h.name pro,\r\n"
				+ "CASE\r\n"
				+ "               h1.`value` \r\n"
				+ "                WHEN '200' THEN\r\n"
				+ "                '正常' \r\n"
				+ "                WHEN '302' THEN\r\n"
				+ "                '正常' ELSE '异常' \r\n"
				+ "        END  shouye\r\n"
				+ "FROM `hosts` h,\r\n"
				+ "(SELECT m2.* FROM \r\n"
				+ "(SELECT t1.hostid, MAX(t2.value) `value` FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.`name` LIKE '%code%访问状态%') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history_uint g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history_uint g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid GROUP BY t1.hostid) m2\r\n"
				+ ") h1\r\n"
				+ "WHERE h.hostid=h1.hostid ) shouye\r\n"
				+ "\r\n"
				+ "ON cpu.pro = shouye.pro\r\n"
				+ "\r\n"
				+ "LEFT JOIN \r\n"
				+ "(	SELECT h.name pro,\r\n"
				+ "	CASE\r\n"
				+ "                h1.`value` \r\n"
				+ "        WHEN NULL THEN\r\n"
				+ "                '异常' ELSE '正常' \r\n"
				+ "        END  network\r\n"
				+ "	 FROM `hosts` h,\r\n"
				+ "(SELECT m1.* FROM (SELECT t1.hostid, t1.itemid, t2.value, t2.clock FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.`name` LIKE '%出口流量%') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history_uint g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history_uint g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid) m1,\r\n"
				+ "(SELECT t1.hostid, MAX(t2.value) `value` FROM (SELECT f.hostid, f.itemid FROM items f WHERE f.`name` LIKE '%出口流量%') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history_uint g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history_uint g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid GROUP BY t1.hostid) m2\r\n"
				+ "WHERE m1.hostid=m2.hostid AND m1.value=m2.value) h1\r\n"
				+ "WHERE h.hostid=h1.hostid) network \r\n"
				+ "ON cpu.pro = network.pro\r\n"
				+ "\r\n"
				+ "LEFT JOIN\r\n"
				+ "(SELECT h.name pro,\r\n"
				+ " concat(h1.name,':','正常') service\r\n"
				+ "FROM `hosts` h,\r\n"
				+ "(SELECT m2.* FROM \r\n"
				+ "(SELECT t1.hostid, MAX(t2.value) `value` ,t1.`name` FROM (SELECT f.hostid, f.itemid,f.`name` FROM items f WHERE f.`name` LIKE '%服务%') AS t1,\r\n"
				+ "(SELECT g.itemid, g.`value`, g.`clock` FROM history_uint g, (SELECT g.itemid, MAX(g.`clock`) clock FROM history_uint g GROUP BY g.`itemid`) g1 WHERE g.`itemid`=g1.`itemid` AND g.`clock`=g1.`clock`) AS t2\r\n"
				+ "WHERE t1.itemid=t2.itemid GROUP BY t1.hostid) m2\r\n"
				+ ") h1\r\n"
				+ "WHERE h.hostid=h1.hostid ) service\r\n"
				+ "\r\n"
				+ "ON cpu.pro = service.pro) t\r\n"
				+ "WHERE 1=1 \r\n"
				+ "";
		if (name != null && !"".equals(name)) {
			sql = sql + " AND t.pro like '%" + name + "%'";
		}
		if (host != null && !"".equals(host)) {
			sql = sql + " AND t.hostid = '" + host + "'";
		}
		return super.getList(sql);
	}


	public long getCountByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<ClassNo1> export(String kaishi, String jieshu) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT\r\n"
    			+ "	SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, 'IP地址：', 1 ), '告警主机：',- 1 ) zhuji,\r\n"
    			+ "	SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警时间:', 1 ), 'IP地址：',- 1 ) dizhi,\r\n"
    			+ "	SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警等级:', 1 ), '告警时间:',- 1 ) time,\r\n"
    			+ "	SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '告警信息:', 1 ), '告警等级:',- 1 ) dengji,\r\n"
    			+ "	SUBSTRING_INDEX( SUBSTRING_INDEX( t.message, '问题详情:', 1 ), '告警信息:',- 1 ) xinxi,\r\n"
    			+ "	t.chuli jilu \r\n"
    			+ "FROM\r\n"
    			+ "	`alerts` t \r\n"
    			+ "WHERE\r\n"
    			+ "	t.message NOT LIKE '%解除%' \r\n"
    			+ "	and t.message not LIKE '%¦%'";
    	if (kaishi != null && !"".equals(kaishi)) {
			sql = sql + " and FROM_UNIXTIME(t.clock) >  str_to_date( '" + kaishi + "' ,'%Y-%m-%d')";
		}
		if (jieshu != null && !"".equals(jieshu)) {
			sql = sql + " and FROM_UNIXTIME(t.clock) <  str_to_date( '" + jieshu + "' ,'%Y-%m-%d')";
		}
		return null;
	}




}
