package cn.ybzy.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import cn.ybzy.mvcproject.model.XiangQing;
import domain.ClassNo;

/**
 * �ƶ�����user��Ĺ���
 * 
 * @author Administrator
 *
 */
public interface XiangQingDao {
	/**
	 * �������ݣ�����intӰ������
	 * 
	 * @param users ����Usersʵ��������
	 * @return
	 */
	public int save(Tables users);

	/**
	 * ͨ��idɾ������
	 * 
	 * @param id Ϊusers_id
	 * @return
	 */
	public int deleteUserById(int id);

	/**
	 * ͨ��id�޸�����
	 * 
	 * @param id
	 * @return
	 */
	public int UpdateUserById(XiangQing xQing);

	/**
	 * ͨ��id��ѯһ������
	 * 
	 * @param id
	 * @return ����Hostsʵ������
	 */
	public Tables get(int id);

	/**
	 * �������߼���get����
	 * 
	 * @param conn
	 * @param id
	 * @return
	 */
	public Tables get(Connection conn, int id);

	/**
	 * ��ȡ�����û�����
	 * 
	 * @return users����
	 */
	public List<XiangQing> getListAll(String id);
	public List<ClassNo1> export(String kaishiString ,String jieshu);

	/**
	 * ͨ���û�����ȡ��������
	 * 
	 * @param name
	 * @return
	 */
	public long getCountByName(String name);

	/**
	 * ʵ��ģ����ѯ
	 * 
	 * @param username
	 * @return
	 */
	public List<Tables> query(String hostid,String host);

	

}
