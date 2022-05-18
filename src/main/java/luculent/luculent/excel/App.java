package luculent.luculent.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	//创建工作簿
        Workbook wb = new XSSFWorkbook();
        //创建sheet页
        Sheet sheet = wb.createSheet();
        //创建行
        Row row = sheet.createRow(0);
        //声明表格
        String[] header = {"课程编号","课程名称","课程节数","课程教授","课程地址","课程图片","课程特点","上课时间"};
        //循环行创建单元格
        for (int i = 0; i <header.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
        //从数据库查询所有记录
//        List<DTO> list = lessionService.findAll(new DTO());
//        for (int i = 0; i < list.size(); i++) {
//            DTO dto = list.get(i);
//            Row row1 = sheet.createRow(i + 1);
//            row1.createCell(0).setCellValue(dto.getId());
//            row1.createCell(1).setCellValue(dto.getName());
//            row1.createCell(2).setCellValue(dto.getNum());
//            row1.createCell(3).setCellValue(dto.getLname());
//            row1.createCell(4).setCellValue(dto.getAname1()+"-"+dto.getAname2()+"-"+dto.getAname3());
//            row1.createCell(5).setCellValue(dto.getPic());
//            row1.createCell(6).setCellValue(dto.getHobby());
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            row1.createCell(7).setCellValue(sdf.format(dto.getLtime()));
//        }
        FileOutputStream fos = new FileOutputStream("E:\\test.xlsx");
        //7.写入文件
        wb.write(fos);
        fos.close();
    }
}
