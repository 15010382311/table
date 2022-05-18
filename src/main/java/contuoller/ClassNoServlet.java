package contuoller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
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
import javax.swing.text.html.HTML;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.html.HTMLUListElement;

import cn.ybzy.mvcproject.dao.ClassNoDaoImpl;
import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import cn.ybzy.mvcproject.model.XiangQing;
import cn.ybzy.mvcproject.service.FactoryService;
import cn.ybzy.mvcproject.service.HostsService;
import cn.ybzy.mvcproject.utils.ClassNOExcelUtils;
import cn.ybzy.mvcproject.utils.ExcelUtils;
import domain.ClassNo;
import domain.PageBean;
import domain.Zonglan;
import service.impl.ClassNoService;
import service.impl.ClassNoServiceImpl;
import service.impl.ZonglanServiceImpl;

@WebServlet("/classno")
public class ClassNoServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void export(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是： ClassNoServlet - expot");
		 //标题
       String titles="告 警 处 理 信 息 统 计 单";

       //表头名
       String[][] headNames = {{"告警主机","地址","告警时间","告警等级","告警信息","处理记录"},{"","","","","",""}};

       //表尾名
       String[][] tableEnd = {{"                                   巡检人：        日期：      "+ formatter1.format(date)}};
	    String kaishi = request.getParameter("kaishi");
		String jieshu = request.getParameter("jieshu");
		 ClassNoService service = new ClassNoServiceImpl();
		 HostsService hostservice = new cn.ybzy.mvcproject.service.ClassNoServiceImpl();
		 List<ClassNo1> listcClassNos = hostservice.export(kaishi,jieshu);
 
       OutputStream out = new FileOutputStream("D:\\告警报告.xlsx");
       ClassNOExcelUtils excelUtils = new ClassNOExcelUtils();
       //导出
       excelUtils.exportMultilevelHeader("告警处理信息统计单",headNames,listcClassNos,listcClassNos.getClass(),tableEnd,out,titles);
       InputStream inStream = new FileInputStream("D:\\告警报告.xlsx");
       XSSFWorkbook wb = new XSSFWorkbook(inStream);
       response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(formatter.format(date) + "告警信息处理报告.xlsx", "UTF-8"));
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
		System.out.println("这里是： classno - findAll " );
        //1.��ȡ����
        String currentPage = request.getParameter("currentPage");//��ǰҳ��
        String rows = request.getParameter("rows");//ÿҳ��ʾ�ļ�¼��
        String kaishi = request.getParameter("kaishi");
        String jieshu = request.getParameter("jieshu");
        System.out.println(kaishi);
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
        	if (!entry.getKey().equals("kaishi")&&!entry.getKey().equals("jieshu")) {
        		
        		map.put(entry.getKey(), entry.getValue());
			} else {

			}
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        //2.����service������
        ClassNoService service = new ClassNoServiceImpl();
        PageBean<ClassNo> pb = service.findClassNoByPage(currentPage,rows,map,kaishi,jieshu);

        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.ת����list.jsp
        request.getRequestDispatcher("/classno_list.jsp").forward(request,response);
        
	}
	
	public void addClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是 ：  ClassNoServlet - addClassNo");
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
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        //2.����service������
        ZonglanServiceImpl service = new ZonglanServiceImpl();
        PageBean<Zonglan> pb = service.findClassNoByPage(currentPage,rows,map,name,hostid);
        List<Zonglan> zonglans = service.find(currentPage,rows,map,name,hostid);

        System.out.println("控制层：    " +  zonglans);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("zonglan",zonglans);
        request.setAttribute("condition",condition);
        //2.��ȡ����
       
        request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	
	
	public void delClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����serviceɾ��
        System.out.println("这里是  delClassNo 参数为：" + id);
        
        cn.ybzy.mvcproject.dao.XiangQingDaoImpl xiangqing = new cn.ybzy.mvcproject.dao.XiangQingDaoImpl();
        List<XiangQing> xiangQings = xiangqing.getListAll(id);
        XiangQing xiangQing = xiangQings.get(0);
        request.setAttribute("xiangQings",xiangQing);
      // System.out.println(xiangQing);
        request.getRequestDispatcher("/student_add.jsp").forward(request,response);
	}
	
	public void updateZonglan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        
        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是 ：  ClassNoServlet - updateZonglan");
       // String[] ids = request.getParameterValues("id");
        String lujing = request.getParameter("lujing");
        String qidong = request.getParameter("qidong");
        String itemid = request.getParameter("itemid");
        String content = request.getParameter("content");
        cn.ybzy.mvcproject.dao.XiangQingDaoImpl xiangqing = new cn.ybzy.mvcproject.dao.XiangQingDaoImpl();
        XiangQing upxQing = new XiangQing();
        upxQing.setItemid(itemid);
        upxQing.setLujing(lujing);
        upxQing.setQidong(qidong);
        upxQing.setXiangqing(content);
        int i = xiangqing.UpdateUserById(upxQing);
        System.out.println("id ： " + itemid);
        System.out.println("路径 ： " + lujing );
        System.out.println("启动 ： " + qidong );
        System.out.println("详情 ： " + content);
        System.out.println("修改行数 ： " + i);
        request.setAttribute("xiangqing",content);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	
	public void updateClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
        
        //2.��ȡmap
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        ClassNo classNo = new ClassNo();
        try {
            BeanUtils.populate(classNo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service�޸�
        ClassNoService service = new ClassNoServiceImpl();
        service.updateClassNo(classNo);

        //5.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void findClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����Service��ѯ��
        ClassNoService service = new ClassNoServiceImpl();
        ClassNo classNo = service.findClassNoById(id);

        //3.��User����request
        request.setAttribute("classNo",classNo);
        //4.ת����update.jsp
        request.getRequestDispatcher("/classno_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("classNoServlet��find����");
	}
	public void updateLuru(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        
        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是 ：  ClassNoServlet - updateLuru");
        String id = request.getParameter("id");
        ClassNoDaoImpl classNoDaoImpl = new ClassNoDaoImpl();
        List<ClassNo1> classNo1s = classNoDaoImpl.findJiluByID(id);
        ClassNo1 a = classNo1s.get(0);
        request.setAttribute("classNo1",a);
        System.out.println(a.getAlertid());
        request.getRequestDispatcher("/chuliluru.jsp").forward(request,response);
//        String id = request.getParameter("id");
//        String jilu = request.getParameter("jilu");
//        System.out.println("id ： " + id);
//        System.out.println("记录 ： " + jilu );
//        ClassNo1 classNo1 = new ClassNo1();
//        cn.ybzy.mvcproject.dao.XiangQingDaoImpl xiangqing = new cn.ybzy.mvcproject.dao.XiangQingDaoImpl();
//        classNo1.setAlertid(id);
//        classNo1.setJilu(jilu);
//        int i =   xiangqing.updateJiluById(classNo1);
//        System.out.println("修改行数 ： " + i);
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	public void updateLuruchuli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        
        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是 ：  ClassNoServlet - updateLuruchuli");
        String id = request.getParameter("id");
        String jilu = request.getParameter("content");
        System.out.println("id ： " + id);
        System.out.println("记录 ： " + jilu );
        ClassNo1 classNo1 = new ClassNo1();
        cn.ybzy.mvcproject.dao.XiangQingDaoImpl xiangqing = new cn.ybzy.mvcproject.dao.XiangQingDaoImpl();
        classNo1.setAlertid(id);
        classNo1.setJilu(jilu);
        int i =   xiangqing.updateJiluById(classNo1);
        System.out.println("修改行数 ： " + i);
        request.getRequestDispatcher("/classno_list.jsp").forward(request,response);
	}
}