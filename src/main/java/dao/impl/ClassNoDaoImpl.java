package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ClassNoDao;
import domain.ClassNo;
import util.JDBCUtils;

public class ClassNoDaoImpl implements ClassNoDao{
	
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
    public int findTotalCount(Map<String, String[]> condition,String kaishi ,String jieshu) {
        //1.����ģ���ʼ��sql
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
    	if (kaishi != null && !"".equals(kaishi) && !"null".equals(kaishi)) {
			sql = sql + "and FROM_UNIXTIME(t.clock) >  str_to_date('" + kaishi + "','%Y-%m-%d')";
		}
		if (jieshu != null && !"".equals(jieshu) && !"null".equals(jieshu)) {
			sql = sql + "and FROM_UNIXTIME(t.clock) <  str_to_date('" + jieshu + "','%Y-%m-%d')";
		}
		sql = "SELECT count(*) FROM (" + sql + ") t";
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
    public List<ClassNo> findByPage(int start, int rows, Map<String, String[]> condition,String kaishi ,String jieshu) {
        
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
    	if (kaishi != null && !"".equals(kaishi) && !"null".equals(kaishi)) {
			sql = sql + "and FROM_UNIXTIME(t.clock) >  str_to_date('" + kaishi + "','%Y-%m-%d')";
		}
		if (jieshu != null && !"".equals(jieshu) && !"null".equals(jieshu)) {
			sql = sql + "and FROM_UNIXTIME(t.clock) <  str_to_date('" + jieshu + "','%Y-%m-%d')";
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

        return template.query(sql,new BeanPropertyRowMapper<ClassNo>(ClassNo.class),params.toArray());
    }
}
