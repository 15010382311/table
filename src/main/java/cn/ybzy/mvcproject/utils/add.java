package cn.ybzy.mvcproject.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class add {
 
    public static void main(String[] args) throws IOException {
        System.out.println("1 " + Runtime.getRuntime().freeMemory());
        FileInputStream input = new FileInputStream(new File("D:/1.xlsx"));
        XSSFWorkbook wb2 = new XSSFWorkbook(input);
        OutputStream os = new FileOutputStream(new File("D:/1.xlsx"));
        XSSFSheet sheet2 = null;
        if (wb2.getSheet("test") != null) {
            sheet2 = wb2.getSheet("test");
        } else {
            sheet2 = wb2.createSheet("test");
        }
        // 如果循环超过10172次，则报内存溢出，有谁循环超过10万次不报错，麻烦请告诉我，这样是因为可以一次性导出大量数据
        System.out.println(sheet2.getLastRowNum());
        System.out.println("2 " + Runtime.getRuntime().freeMemory());
        System.out.println("时间" + System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            // 创建第一个sheet
            // 生成第一行
            XSSFRow row = sheet2.createRow(i);
            // 给这一行的第一列赋值
            row.createCell(0).setCellValue(i);
            // 给这一行的第一列赋值
            row.createCell(1).setCellValue(i);
        }
        // 写文件
        wb2.write(os);
        // 关闭输出流
        os.close();
        System.out.println("3 " + Runtime.getRuntime().freeMemory());
        System.out.println("时间" + System.currentTimeMillis());
    }
 
}