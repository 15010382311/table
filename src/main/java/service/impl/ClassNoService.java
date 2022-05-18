package service.impl;

import java.util.List;
import java.util.Map;

import domain.ClassNo;
import domain.PageBean;

public interface ClassNoService {
	
	/**
     * ��ѯ���а༶��Ϣ
     * @return
     */
    public List<ClassNo> findAll();


    /**
     * ����༶��Ϣ
     * @param user
     */
    void addClassNo(ClassNo classNo);

    /**
     * ����idɾ���༶��Ϣ
     * @param id
     */
    void deleteClassNo(String id);

    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    ClassNo findClassNoById(String id);

    /**
     * �޸İ༶��Ϣ
     * @param user
     */
    void updateClassNo(ClassNo classNo);

    /**
     * ����ɾ���û�
     * @param ids
     */
    void delSelectedClassNo(String[] ids);

    /**
     * ��ҳ������ѯ
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    List<ClassNo> export(String kaishi, String jieshu);
    PageBean<ClassNo> findClassNoByPage(String currentPage, String rows, Map<String, String[]> condition,String kaishi, String jieshu);
}
    


