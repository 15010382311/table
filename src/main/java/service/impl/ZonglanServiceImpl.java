package service.impl;

import java.util.List;

import java.util.Map;

import cn.ybzy.mvcproject.dao.HostsDao;
import cn.ybzy.mvcproject.dao.HostsDaoImpl;
import dao.ClassNoDao;
import dao.ZonglanDao;
import dao.impl.ClassNoDaoImpl;
import dao.impl.ZonglanDaoImpl;
import domain.ClassNo;
import domain.PageBean;
import domain.Zonglan;

public class ZonglanServiceImpl implements ZonglanService{
	
	private ZonglanDao dao = new ZonglanDaoImpl();
	

    @Override
    public List<ClassNo> findAll() {
        //����Dao��ɲ�ѯ
        return dao.findAll();
    }

    @Override
    public void addClassNo(ClassNo classNo) {
        dao.add(classNo);
    }

    @Override
    public void deleteClassNo(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public ClassNo findClassNoById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateClassNo(ClassNo classNo) {
        dao.update(classNo);
    }

    @Override
    public void delSelectedClassNo(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.��������
            for (String id : ids) {
                //2.����daoɾ��
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<Zonglan> findClassNoByPage(String _currentPage, String _rows, Map<String, String[]> condition,String name,String hostid) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<Zonglan> pb = new PageBean<Zonglan>();
        //2.���ò���
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.����dao��ѯ�ܼ�¼��
        int totalCount = dao.findTotalCount(condition,name,hostid);
        
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
        List<Zonglan> list = dao.findByPage(start,rows,condition,name,hostid);
        System.out.println("服务层：    " +  list);
        
        //ClassNo a = list.get(0);
        //System.out.println("zhuji     " + a.getDizhi());
        
        
        pb.setList(list);

        //5.������ҳ��
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
    
    public List<Zonglan> find(String _currentPage, String _rows, Map<String, String[]> condition,String name,String hostid) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<Zonglan> pb = new PageBean<Zonglan>();
        //2.���ò���
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.����dao��ѯ�ܼ�¼��
        int totalCount = dao.findTotalCount(condition,name,hostid);
        
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
        List<Zonglan> list = dao.findByPage(start,rows,condition,name,hostid);
        System.out.println("服务层：    " +  list);
        
        //ClassNo a = list.get(0);
        //System.out.println("zhuji     " + a.getDizhi());
        
        
       
        return list;
    }

	@Override
	public List<ClassNo> export(String kaishi, String jieshu) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
