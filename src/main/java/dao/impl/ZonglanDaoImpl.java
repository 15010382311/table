package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ClassNoDao;
import dao.ZonglanDao;
import domain.ClassNo;
import domain.Zonglan;
import util.JDBCUtils;

public class ZonglanDaoImpl implements ZonglanDao{
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ClassNo> findAll() {
        //ʹ��JDBC�������ݿ�...
        //1.����sql
        String sql = "select * from class";
        List<ClassNo> classNo = template.query(sql, new BeanPropertyRowMapper<ClassNo>(ClassNo.class));

        return classNo;
    }

    @Override
    public void add(ClassNo classNo) {
        //1.����sql
        String sql = "insert into class values(null,?,?,?)";
        //2.ִ��sql
      //  template.update(sql,classNo.getCno(), classNo.getClassName(), classNo.getDepartment());
    }
    
    @Override
    public ClassNo findById(int id) {
        String sql = "select * from class where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<ClassNo>(ClassNo.class), id);
    }

    @Override
    public void update(ClassNo classNo) {
        String sql = "update class set cno = ?,classname = ? ,department = ? where id = ? ";
     //   template.update(sql, classNo.getCno(), classNo.getClassName(), classNo.getDepartment(),classNo.getId());
    }
    

    @Override
    public void delete(int id) {
        //1.����sql
        String sql = "delete from class where id = ?";
        //2.ִ��sql
        template.update(sql, id);
    }

  

    @Override
    public int findTotalCount(Map<String, String[]> condition,String name ,String host) {
        //1.����ģ���ʼ��sql
    	String sql = "SELECT\r\n"
    			+ "	count(*)\r\n"
    			+ "FROM\r\n"
    			+ "	`hosts` t\r\n"
    			+ "	LEFT JOIN\r\n"
    			+ "	items f\r\n"
    			+ "	on t.hostid = f.hostid\r\n"
    			+ "WHERE\r\n"
    			+ "	t.`name` NOT LIKE '%NAME%' \r\n"
    			+ "	AND t.`status` = '0'\r\n"
    			+ "	AND f.`name` like '%服务%'";
    	if (name != null && !"".equals(name) && !"null".equals(name)) {
			sql = sql + " AND t.name like '%" + name + "%'";
		}
		if (host != null && !"".equals(host) && !"null".equals(host)) {
			sql = sql + " AND t.host like '%" + host + "%'";
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
                sb.append(" and t."+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }
       // System.out.println(sb.toString());
        //System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Zonglan> findByPage(int start, int rows, Map<String, String[]> condition,String name ,String host) {
        
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
    	
    	if (name != null && !"".equals(name)&& !"null".equals(name)) {
			sql = sql + " AND t.name like '%" + name + "%'";
		}
		if (host != null && !"".equals(host)&& !"null".equals(host)) {
			sql = sql + " AND t.host like '%" + host + "%'";
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
                sb.append(" and t."+key+" like ? ");
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
       // System.out.println(template.query(sql,new BeanPropertyRowMapper<Zonglan>(Zonglan.class),params.toArray()));
        
        return template.query(sql,new BeanPropertyRowMapper<Zonglan>(Zonglan.class),params.toArray());
    }
}
