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
		

		
		 

		    //??????
	        String titles="??? ??? ??? ??? ??? ??? ??? ??? ??? ???";

	        //?????????
	        String[][] headNames = {{"?????????","??????","??????????????????","","","??????????????????","","????????????"},{"","","Cpu?????????","???????????????","????????????","??????????????????","????????????????????????","????????????"}};

	        //?????????
	        String[][] tableEnd = {{"                                   ????????????        ?????????      "}};
		    String name = request.getParameter("name");
			String host = request.getParameter("hostid");
			List<Tables> listusers = hostservice.query(name,host);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
	        OutputStream out = new FileOutputStream("E:\\????????????.xlsx");
	        ExcelUtils excelUtils = new ExcelUtils();
	        //??????
	        excelUtils.exportMultilevelHeader("????????????",headNames,listusers,listusers.getClass(),tableEnd,out,titles);
	        InputStream inStream = new FileInputStream("E:\\????????????.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(inStream);
	        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(formatter.format(date) + "????????????.xlsx", "UTF-8"));
	        response.setHeader("Connection", "close");
	        response.setHeader("Content-Type", "application/octet-stream");
	        wb.write(response.getOutputStream());
	        out.close();
	        inStream.close();
//	        
//		
//        //??????
//        
//		//???????????????
//	    Workbook wb = new XSSFWorkbook();
//	    //??????sheet???
//	    Sheet sheet = wb.createSheet();
//	    //?????????
//	    Row row = sheet.createRow(0);
//	    //????????????
//	    String[] header = {"?????????IP","????????????","cpu?????????","???????????????","????????????","??????????????????","??????????????????","????????????"};
//	    //????????????????????????
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
//			fos = new FileOutputStream("E:\\tables\\" + formatter.format(date) + "????????????.xlsx");
//			 //7.????????????
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