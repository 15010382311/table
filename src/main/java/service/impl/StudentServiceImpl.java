package service.impl;

import java.util.List;

import java.util.Map;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;

public class StudentServiceImpl implements StudentService{

	private StudentDao dao = new StudentDaoImpl();

    @Override
    public PageBean<Student> findAll(String _currentPage, String _rows, Map<String, String[]> condition,String name,
			String hostid) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<Student> pb = new PageBean<Student>();
        //2.���ò���
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.����dao��ѯ�ܼ�¼��
        int totalCount = dao.findTotalCount(condition,name,hostid);
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
        List<Student> list = dao.findAll();
        
        
        pb.setList(list);

        //5.������ҳ��
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }

    @Override
    public void addStudent(Student student) {
        dao.add(student);
    }

    @Override
    public void deleteStudent(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Student findStudentById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateStudent(Student student) {
        dao.update(student);
    }

    @Override
    public void delSelectedStudent(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.��������
            for (String id : ids) {
                //2.����daoɾ��
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<Student> findStudentByPage(String _currentPage, String _rows, Map<String, String[]> condition,String name,String hostid) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        System.out.println("这里是StudentServiceImpl-findStudentByPage");
        if(currentPage <=0) {
        	
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<Student> pb = new PageBean<Student>();
        
        //2.���ò���
        pb.setCurrentPage(currentPage);
        
        pb.setRows(rows);
        
        //3.����dao��ѯ�ܼ�¼��
        int totalCount = dao.findTotalCount(condition,name,hostid);
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
       
        List<Student> list = dao.findByPage(start,rows,condition,name,hostid);
        
        
        pb.setList(list);

        //5.������ҳ��
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        System.out.println("这里是StudentServiceImpl-findStudentByPage4");

        return pb;
    }

	@Override
	public PageBean<Student> findAll(String _currentPage, String _rows, Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
