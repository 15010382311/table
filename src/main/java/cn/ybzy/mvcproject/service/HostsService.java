package cn.ybzy.mvcproject.service;

import java.util.List;

import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import domain.ClassNo;

public interface HostsService {
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
	 * @return int
	 */
	public int UpdateUserById(Tables hosts);

	/**
	 * ͨ��id��ѯһ������
	 * 
	 * @param id
	 * @return ����Usersʵ������
	 */
	public Tables get(int id);

	public Tables getAction(int id);

	/**
	 * ��ȡ�����û�����
	 * 
	 * @return users����
	 */
	public List<Tables> getListAll();

	/**
	 * ͨ���û�����ȡ��������
	 * 
	 * @param name
	 * @return
	 */
	public long getCountByName(String name);

	/**
	 * ���տ��Ʋ����ݣ����ݸ�dao��ȥʵ��ģ����ѯ
	 * 
	 * @param username
	 * @param address
	 * @param phoneNO
	 * @return
	 */
	public List<Tables> query(String hostid,String host);

	public List<ClassNo1> export(String kaishi, String jieshu);
}
