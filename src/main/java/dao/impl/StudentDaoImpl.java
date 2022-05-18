package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.StudentDao;
import domain.Student;
import util.JDBCUtils;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Student> findAll() {
        //ʹ��JDBC�������ݿ�...
        //1.����sql
        String sql = "select * from student";
        List<Student> student = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        return student;
    }

    

    @Override
    public void add(Student student) {
        //1.����sql
        String sql = "insert into student values(null,?,?,?,?,?,?)";
        //2.ִ��sql
      //  template.update(sql,student.getName(), student.getGender(), student.getAge(), student.getClassno(), student.getPhone(), student.getEmail());
    }
    
    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name = ?,gender = ? ,age = ? , classno = ? , phone = ?, email = ? where id = ?";
       // template.update(sql, student.getName(), student.getGender(), student.getAge(), student.getClassno(), student.getPhone(), student.getEmail(), student.getId());
    }
    

    @Override
    public void delete(int id) {
        //1.����sql
        String sql = "delete from student where id = ?";
        //2.ִ��sql
        template.update(sql, id);
    }

  

    @Override
    public int findTotalCount(Map<String, String[]> condition,String name ,String hostid) {
        //1.����ģ���ʼ��sql
        String sql = "SELECT count(*) FROM(\r\n"
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
		if (hostid != null && !"".equals(hostid)) {
			sql = sql + " AND hostid like '%" + hostid + "%'";
		}
        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //�ų���ҳ��������
            if("method".equals(key) || "currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Student> findByPage(int start, int rows, Map<String, String[]> condition,String name,String hostid) {
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
		if (hostid != null && !"".equals(hostid)) {
			sql = sql + " AND hostid like '%" + hostid + "%'";
		}

        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //�ų���ҳ��������
            if("method".equals(key)||"currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }

        //��ӷ�ҳ��ѯ
        sb.append(" limit ?,? ");
        //��ӷ�ҳ��ѯ����ֵ
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),params.toArray());
    }

	
}
