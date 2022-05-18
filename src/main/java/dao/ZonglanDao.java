package dao;

import java.util.List;
import java.util.Map;

import domain.ClassNo;
import domain.Zonglan;

public interface ZonglanDao {
	
	public List<ClassNo> findAll();
	   
    void add(ClassNo classNo);

    void delete(int id);

    ClassNo findById(int i);

    void update(ClassNo classNo);

    /**
     * ��ѯ�ܼ�¼��
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition,String kaishiString ,String jieshu);

    /**
     * ��ҳ��ѯÿҳ��¼
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Zonglan> findByPage(int start, int rows, Map<String, String[]> condition,String kaishiString ,String jieshu);
}
