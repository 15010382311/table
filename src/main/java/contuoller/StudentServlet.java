package contuoller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.ybzy.mvcproject.model.Tables;
import cn.ybzy.mvcproject.service.FactoryService;
import cn.ybzy.mvcproject.service.HostsService;
import cn.ybzy.mvcproject.utils.ExcelUtils;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;
import service.impl.StudentService;
import service.impl.StudentServiceImpl;

@WebServlet("/student")
public class StudentServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void export(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����service��ҵ�����
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); 
		request.setCharacterEncoding("utf-8");
		System.out.println("这里是studentservlet-export");
		HostsService hostservice = FactoryService.getHostsService();
		 //标题
        String titles="服 务 器 设 备 日 常 巡 检 单";

        //表头名
        String[][] headNames = {{"服务器","项目","运行状态检查","","","基本安全检查","","网卡检查"},{"","","Cpu占用率","内存占用率","硬盘状态","首页访问状态","关键服务运行状态","网卡状态"}};

        //表尾名
        String[][] tableEnd = {{"                                   巡检人：        日期：      " + formatter1.format(date)}};
	    String name = request.getParameter("name");
		String host = request.getParameter("hostid");
		List<Tables> listusers = hostservice.query(name,host);
		 
        OutputStream out = new FileOutputStream("D:\\巡检报告.xlsx");
        ExcelUtils excelUtils = new ExcelUtils();
        //导出
        excelUtils.exportMultilevelHeader("巡检数据",headNames,listusers,listusers.getClass(),tableEnd,out,titles);
        InputStream inStream = new FileInputStream("D:\\巡检报告.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(inStream);
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(formatter.format(date) + "巡检报告.xlsx", "UTF-8"));
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "application/octet-stream");
        wb.write(response.getOutputStream());
        out.close();
        inStream.close();
	}
	//��ѯ��������
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����service��ҵ�����
		request.setCharacterEncoding("utf-8");
		System.out.println("这里是studentservlet-findAll");
	
        //1.��ȡ����
        String currentPage = request.getParameter("currentPage");//��ǰҳ��
        String rows = request.getParameter("rows");//ÿҳ��ʾ�ļ�¼��
        String name = request.getParameter("name");
        String hostid = request.getParameter("hostid");
        System.out.println(name);
        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "10";
        }
        
        //��ȡ������ѯ����
        Map<String, String[]> condition = request.getParameterMap();
        Map<String, String[]> map = new HashMap<>();
        
       
        
        for (Entry<String, String[]> entry : condition.entrySet()) {
        	if (!entry.getKey().equals("name")&&!entry.getKey().equals("hostid")) {
        		
        		map.put(entry.getKey(), entry.getValue());
			} else {

			}
          //  System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

       
        

        //2.����service������
        StudentService service = new StudentServiceImpl();
        PageBean<Student> pb = service.findStudentByPage(currentPage,rows,map,name,hostid);
        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.ת����list.jsp
        request.getRequestDispatcher("/student_list.jsp").forward(request,response);
        

	}
	


	
	public void addStudent(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
		request.setCharacterEncoding("utf-8");
		System.out.println("这里是studentservlet-addStudent");
        String currentPage = request.getParameter("currentPage");//��ǰҳ��
        String rows = request.getParameter("rows");//ÿҳ��ʾ�ļ�¼��
        String name = "";
        String hostid = "wo";
        System.out.println(name);
        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "10";
        }
        
        //��ȡ������ѯ����
        Map<String, String[]> condition = request.getParameterMap();
        Map<String, String[]> map = new HashMap<>();
        
       
        
        for (Entry<String, String[]> entry : condition.entrySet()) {
        	if (!entry.getKey().equals("name")&&!entry.getKey().equals("hostid")) {
        		
        		map.put(entry.getKey(), entry.getValue());
			} else {

			}
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            
            
        }
        
       
        

        //2.����service������
        StudentService service = new StudentServiceImpl();
        PageBean<Student> pb = service.findStudentByPage(currentPage,rows,map,name,hostid);
        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.ת����list.jsp
        request.getRequestDispatcher("/student_list.jsp").forward(request,response);
      
	}
	
	
	public void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
		System.out.println("这里是studentservlet-delStudent");
        String id = request.getParameter("id");
        //2.����serviceɾ��
        StudentService service = new StudentServiceImpl();
        service.deleteStudent(id);

        //3.��ת����ѯ���е�Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void delSelectedStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
		System.out.println("这里是studentservlet-delSelectedStudent");
        String[] ids = request.getParameterValues("id");

        //2.����serviceɾ��
        StudentService service = new StudentServiceImpl();
        service.delSelectedStudent(ids);

        //3.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
		System.out.println("这里是studentservlet-updateStudent");
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        //2.��ȡmap
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service�޸�
        StudentService service = new StudentServiceImpl();
        service.updateStudent(student);

        //5.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void findStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
		System.out.println("这里是studentservlet-findStudent");
        String id = request.getParameter("id");
        //2.����Service��ѯ��
        StudentService service = new StudentServiceImpl();
        Student student = service.findStudentById(id);

        //3.��User����request
        request.setAttribute("student",student);
        //4.ת����update.jsp
        request.getRequestDispatcher("/student_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userServlet��find����");
	}

}