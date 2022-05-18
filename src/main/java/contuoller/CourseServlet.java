package contuoller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Course;
import domain.PageBean;
import service.impl.CourseService;
import service.impl.CourseServiceImpl;

@WebServlet("/course")
public class CourseServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//��ѯ��������
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����service��ҵ�����
		request.setCharacterEncoding("utf-8");
		
        //1.��ȡ����
        String currentPage = request.getParameter("currentPage");//��ǰҳ��
        String rows = request.getParameter("rows");//ÿҳ��ʾ�ļ�¼��

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        
        //��ȡ������ѯ����
        Map<String, String[]> condition = request.getParameterMap();

        //2.����service������
        CourseService service = new CourseServiceImpl();
        PageBean<Course> pb = service.findCourseByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.ת����list.jsp
        request.getRequestDispatcher("/course_list.jsp").forward(request,response);
        

	}

	
	public void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("UTF-8");
        //2.��ȡ����
        Map<String, String[]> map = request.getParameterMap();
        
        System.out.println(request.getParameter("gender"));
        //3.��װ����
        Course course = new Course();

        try {
            BeanUtils.populate(course,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        //4.����Service����
        CourseService service = new CourseServiceImpl();
        service.addCourse(course);

        //5.��ת��userListServlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	
	public void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����serviceɾ��
        CourseService service = new CourseServiceImpl();
        service.deleteCourse(id);

        //3.��ת����ѯ���е�Servlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	public void delSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        String[] ids = request.getParameterValues("id");

        //2.����serviceɾ��
        CourseService service = new CourseServiceImpl();
        service.delSelectedCourse(ids);

        //3.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
        //2.��ȡmap
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        Course course = new Course();
        try {
            BeanUtils.populate(course,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service�޸�
        CourseService service = new CourseServiceImpl();
        service.updateCourse(course);

        //5.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	public void findCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����Service��ѯ��
        CourseService service = new CourseServiceImpl();
        Course course = service.findCourseById(id);

        //3.��User����request
        request.setAttribute("course",course);
        //4.ת����update.jsp
        request.getRequestDispatcher("/course_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("courseServlet��find����");
	}

}