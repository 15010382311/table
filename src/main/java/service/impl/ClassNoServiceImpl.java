package service.impl;

import java.util.List;

import java.util.Map;

import cn.ybzy.mvcproject.dao.HostsDao;
import cn.ybzy.mvcproject.dao.HostsDaoImpl;
import dao.ClassNoDao;
import dao.impl.ClassNoDaoImpl;
import domain.ClassNo;
import domain.PageBean;

public class ClassNoServiceImpl implements ClassNoService{
	
	private ClassNoDao dao = new ClassNoDaoImpl();
	

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
    public PageBean<ClassNo> findClassNoByPage(String _currentPage, String _rows, Map<String, String[]> condition,String kaishi,String jieshu) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<ClassNo> pb = new PageBean<ClassNo>();
        //2.���ò���
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.����dao��ѯ�ܼ�¼��
        int totalCount = dao.findTotalCount(condition,kaishi,jieshu);
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
        List<ClassNo> list = dao.findByPage(start,rows,condition,kaishi,jieshu);
        
        
        //ClassNo a = list.get(0);
        //System.out.println("zhuji     " + a.getDizhi());
        
        
        pb.setList(list);

        //5.������ҳ��
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }

	@Override
	public List<ClassNo> export(String kaishi, String jieshu) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
