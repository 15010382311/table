//package cn.ybzy.mvcproject.utils;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class test {
//	 public static void main(String[] args) throws Exception{
//		 
//		 String[] properties;
//	        Object[] rowValue;
//	        List<Object[]> values;
//	        Field[] fields;
//	        XSSFCell cell;
//	        String vo;
//    
//		 XSSFWorkbook wb = new XSSFWorkbook();
//
//		    //标题
//	        String titles="服务器设备日常巡检";
//
//	        //表头名
//	        String[][] headNames = {{"服务器","项目","运行状态检查","","","基本安全检查","服务状态检测","网卡检查"},{"","","Cpu占用率","内存占用率","硬盘状态","首页访问状态","关键服务运行状态","网卡状态"}};
//
//	        //表尾名
//	        String[][] tableEnd = {{"不准看：    "}};
////	        Testvo vos = new Testvo();
////	        List<Testvo> list = new ArrayList<>();
////	        for (int i=0;i<8;i++) {
////	        	
////	        	vos.setNo("1");
////	        	vos.setName("鲁班大师");
////	        	vos.setSex("男");
////	        	vos.setAge(26);
////	        	vos.setMoney("13888");
////	        	vos.setMoney1("13888");
//	        	vos.setMoney11("13888");
////	        	vos.setMoney111("13888");
////	            list.add(vos);
////	        }
//
//	        OutputStream out = new FileOutputStream("D:\\测试汇总表.xls");
//	        ExcelUtils excelUtils = new ExcelUtils();
//	        //导出
//	        excelUtils.exportMultilevelHeader("测试汇总",headNames,list,vos.getClass(),tableEnd,out,titles);
//
//
//    }
//}
