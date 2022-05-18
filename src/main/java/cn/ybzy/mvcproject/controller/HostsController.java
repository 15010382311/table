package cn.ybzy.mvcproject.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import cn.ybzy.mvcproject.model.Tables;
import cn.ybzy.mvcproject.service.FactoryService;
import cn.ybzy.mvcproject.service.HostsService;
import cn.ybzy.mvcproject.utils.ExcelUtils;

/**
 * Servlet implementation class UserController
 */
@WebServlet({ "/UserController", "*.udo" })
public class HostsController extends HttpServlet {
	HostsService hostservice = FactoryService.getHostsService();
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HostsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getServletPath().substring(1);
		name = name.substring(0, name.length() - 4);
		try {
			Method method = this.getClass().getDeclaredMethod(name, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String expiredays = request.getParameter("expiredays");
		Boolean islogin = new Boolean(false);
		System.out.println(islogin);
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String host = request.getParameter("hostid");
		List<Tables> listusers = hostservice.query(name,host);
		request.setAttribute("userlist", listusers);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
	
	private void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		
		 

		    //标题
	        String titles="服 务 器 设 备 日 常 巡 检 单";

	        //表头名
	        String[][] headNames = {{"服务器","项目","运行状态检查","","","基本安全检查","","网卡检查"},{"","","Cpu占用率","内存占用率","硬盘状态","首页访问状态","关键服务运行状态","网卡状态"}};

	        //表尾名
	        String[][] tableEnd = {{"                                   巡检人：        日期：      "}};
		    String name = request.getParameter("name");
			String host = request.getParameter("hostid");
			List<Tables> listusers = hostservice.query(name,host);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
	        OutputStream out = new FileOutputStream("E:\\巡检报告.xlsx");
	        ExcelUtils excelUtils = new ExcelUtils();
	        //导出
	        excelUtils.exportMultilevelHeader("巡检数据",headNames,listusers,listusers.getClass(),tableEnd,out,titles);
	        InputStream inStream = new FileInputStream("E:\\巡检报告.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(inStream);
	        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(formatter.format(date) + "巡检报告.xlsx", "UTF-8"));
	        response.setHeader("Connection", "close");
	        response.setHeader("Content-Type", "application/octet-stream");
	        wb.write(response.getOutputStream());
	        out.close();
	        inStream.close();
//	        
//		
//        //导出
//        
//		//创建工作簿
//	    Workbook wb = new XSSFWorkbook();
//	    //创建sheet页
//	    Sheet sheet = wb.createSheet();
//	    //创建行
//	    Row row = sheet.createRow(0);
//	    //声明表格
//	    String[] header = {"服务器IP","项目名称","cpu利用率","内存利用率","硬盘状态","首页访问状态","关键服务监测","网卡状态"};
//	    //循环行创建单元格
//	    for (int i = 0; i <header.length ; i++) {
//	        Cell cell = row.createCell(i);
//	        cell.setCellValue(header[i]);
//	    }
//	    String name = request.getParameter("name");
//		String host = request.getParameter("hostid");
//		System.out.println("name : " + name);
//		System.out.println("host : " + host);
//		List<Tables> listusers = hostservice.query(name,host);
//		for (int i = 0; i < listusers.size(); i++) {
//			Tables dto = listusers.get(i);
//	        Row row1 = sheet.createRow(i + 3);
//	        row1.createCell(0).setCellValue(dto.getHostid());
//	        row1.createCell(1).setCellValue(dto.getPro());
//	        row1.createCell(2).setCellValue(dto.getCpu());
//	        row1.createCell(3).setCellValue(dto.getMemory());
//	        row1.createCell(4).setCellValue(dto.getDisk());
//	        row1.createCell(5).setCellValue(dto.getShouye());
//	        row1.createCell(6).setCellValue(dto.getService());
//	        row1.createCell(7).setCellValue(dto.getNetwork());
//	        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	        //row1.createCell(7).setCellValue(sdf.format(dto.getLtime()));
//	    }
//	    FileOutputStream fos;
//		try {
//			Date date = new Date();
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
//			
//			fos = new FileOutputStream("E:\\tables\\" + formatter.format(date) + "巡检报告.xlsx");
//			 //7.写入文件
//		    wb.write(fos);
//		    fos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   
	}
}