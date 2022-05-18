package cn.ybzy.mvcproject.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import cn.ybzy.mvcproject.model.ClassNo1;
import cn.ybzy.mvcproject.model.Tables;
import domain.ClassNo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/***
 * @ClassName: ExcelUtils
 * @Description:POI实现导出含多级表头和含有表尾部信息的excel
 * @Auther: lyb
 * @Date: 2019/12/17 11:21
 * @version : V1.0
 */
public class ExcelUtils {
    
    /** 
    * @Author lyb 
    * @Description //TODO 多级表头Excel文件导出
    * @Date 11:24 2019/12/17 
    * @Param [sheetName, head, dataList, type, tableEndData，out，titles] sheet名,多级表头,导出数据,导出类型,表尾,输出文件对象,首行标题
    * @return org.apache.poi.xssf.usermodel.XSSFWorkbook 
    **/ 
    public static XSSFWorkbook exportMultilevelHeader(String sheetName, String[][] head, List<?> dataList, Class type, String[][] tableEndData, OutputStream out,String titles) {
        /*变量*/
        String[] properties;
        Object[] rowValue;
        List<Object[]> values;
        Field[] fields;
        XSSFCell cell;
        String vo;

        /*导出Excel*/
        // 第一步，创建一个workBook，对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        
        // 表头 标题样式
        XSSFFont titleFont = wb.createFont();
        titleFont.setFontName("仿宋_GB2312");//字体
        titleFont.setFontHeightInPoints((short) 35);// 字体大小
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗
        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFillForegroundColor((short) 15);
        titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 左右居中
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 上下居中
        titleStyle.setLocked(true);
        titleStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
        titleStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
        titleStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
        titleStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
        
       
        ////
        titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        // 第二步，在workBook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);
        sheet.setDefaultColumnWidth(15);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row;
        // 第四步，创建单元格，并设置值表头 设置表头居中
        //生成一个Style
        XSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
        style.setFillForegroundColor((short) 15);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //二级表头样式
        XSSFFont titleFont1 = wb.createFont();
        titleFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗
        XSSFCellStyle style2 = wb.createCellStyle();
        style2.setFillForegroundColor((short) 15);
        style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style2.setFont(titleFont1);
        style2.setWrapText(true);
        style2.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
        style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
        style2.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
        style2.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        
        
        int mergerNum = 0; //合并数
        //添加表格标题
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,type.getDeclaredFields().length));
        row = sheet.createRow(0);//创建一行表格
        row.setHeight((short) 0x349);//设置高度
        cell = row.createCell(0);//创建单元格
        cell.setCellStyle(titleStyle);//设置样式
        cell.setCellValue(titles);//设置标题

        //给单元格设置值
        for (int i = 0; i < head.length; i++) {
            row = sheet.createRow(i+1);
            row.setHeight((short) 700);
            for (int j = 0; j < head[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellStyle(style2);
                cell.setCellValue(head[i][j]);
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();   // 合并行时要跳过的行列
        //合并行
        for (int i = 0; i < head[head.length - 1].length; i++) {
            if ("".equals(head[head.length - 1][i])) {
                for (int j = head.length - 2; j >= 0; j--) {
                    if (!"".equals(head[j][i])) {
                        sheet.addMergedRegion(new CellRangeAddress(j+1, head.length, i, i)); // 合并单元格
                        break;
                    } else {
                        if (map.containsKey(j)) {
                            List<Integer> list = map.get(j);
                            list.add(i);
                            map.put(j, list);
                        } else {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(i);
                            map.put(j, list);
                        }
                    }
                }
            }
        }
        //合并列
        for (int i = 0; i < head.length - 1; i++) {
            for (int j = 0; j < head[i].length; j++) {
                List<Integer> list = map.get(i);
                if (list == null || (list != null && !list.contains(j))) {
                    if ("".equals(head[i][j])) {
                        mergerNum++;
                        if (mergerNum != 0 && j == (head[i].length - 1)) {
                            sheet.addMergedRegion(new CellRangeAddress(i, i, j - mergerNum, j)); // 合并单元格
                            mergerNum = 0;
                        }
                    } else {
                        if (mergerNum != 0) {
                            sheet.addMergedRegion(new CellRangeAddress(i+1, i+1, j - mergerNum - 1, j - 1)); // 合并单元格
                            mergerNum = 0;
                        }
                    }
                }
            }
        }
        //解析导出类型
        Class<Record> recordClass = Record.class;
        if (null == type) {
            //导出失败
            return null;
        } else if (type.equals(recordClass)) {
            //导出List<Record>
            //获取Record中包含的properties，用于生成表格头及创建Cell
            properties = getRecordProperties(dataList, null);
            vo = "record";
        } else {
            //导出List<Bean>
            //获取Bean的Field
            fields = type.getFields();
            properties = getRecordProperties(null, fields);
            vo = "bean";
        }

        if (null == head) {
            int i = 0;
            if (head.length > 0) {
                i = head.length -1;
            }
            head[i] = properties;
        }

        // 第五步，写入实体数据
        /*表头行数*/
//        int m = 1;
//        if (head.length > 0) {
//            m = head.length;
//        }
//        values = getRowValue(dataList, properties, vo);
//      
//        for (int i = 0; i < dataList.size(); i++) {
//            row = sheet.createRow(i + m+1); //创建行
//            rowValue = values.get(i);
//            // 第四步，创建单元格，并设置值
//            for (int j = 0; j < properties.length; j++) {
//                cell = row.createCell(j);
//                cell.setCellStyle(style);
//                setCellValue(cell, rowValue[j]);
//            }
//        }
        
        // 第五步，写入实体数据
        /*表头行数*/
        
        int m = 1;
        if (head.length > 0) {
            m = head.length;
        }     
            
        if (dataList.get(0) instanceof Tables) {
        
        for (int i = 0; i < dataList.size(); i++) {
			Tables dto = (Tables) dataList.get(i);
	        Row row1 = sheet.createRow(i + 3);
	        
	        cell = (XSSFCell) row1.createCell(0);
	        cell.setCellValue(dto.getHostid());
	        cell.setCellStyle(style);
	       
	        
	        cell = (XSSFCell) row1.createCell(1);
	        cell.setCellValue(dto.getPro());
	        cell.setCellStyle(style);
	        
	        cell = (XSSFCell) row1.createCell(2);
	        cell.setCellValue(dto.getCpu());
	        cell.setCellStyle(style);
	        
	        cell = (XSSFCell) row1.createCell(3);
	        cell.setCellValue(dto.getMemory());
	        cell.setCellStyle(style);
	        
	        cell = (XSSFCell) row1.createCell(4);
	        cell.setCellValue(dto.getDisk());
	        cell.setCellStyle(style);
	        
	        cell = (XSSFCell) row1.createCell(5);
	        cell.setCellValue(dto.getShouye());
	        cell.setCellStyle(style);
	        
	        cell = (XSSFCell) row1.createCell(6);
	        cell.setCellValue(dto.getService());
	        cell.setCellStyle(style);
	        
	        cell = (XSSFCell) row1.createCell(7);
	        cell.setCellValue(dto.getNetwork());
	        cell.setCellStyle(style);
	        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        //row1.createCell(7).setCellValue(sdf.format(dto.getLtime()));
	    }
 }     
   else if (dataList.get(0) instanceof ClassNo1) {
	System.out.println("hahahahahahaha");
	 for (int i = 0; i < dataList.size(); i++) {
		ClassNo1 dto = (ClassNo1) dataList.get(i);
        Row row1 = sheet.createRow(i + 3);
        
        cell = (XSSFCell) row1.createCell(0);
        cell.setCellValue(dto.getZhuji());
        cell.setCellStyle(style);
       
        
        cell = (XSSFCell) row1.createCell(1);
        cell.setCellValue(dto.getDizhi());
        cell.setCellStyle(style);
        
        cell = (XSSFCell) row1.createCell(2);
        cell.setCellValue(dto.getTime());
        cell.setCellStyle(style);
        
        cell = (XSSFCell) row1.createCell(3);
        cell.setCellValue(dto.getDengji());
        cell.setCellStyle(style);
        
        cell = (XSSFCell) row1.createCell(4);
        cell.setCellValue(dto.getXinxi());
        cell.setCellStyle(style);
        
        cell = (XSSFCell) row1.createCell(5);
        cell.setCellValue(dto.getJilu());
        cell.setCellStyle(style);
        cell.setCellStyle(style);
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //row1.createCell(7).setCellValue(sdf.format(dto.getLtime()));
    }
}
        
        //第六步，处理表格尾部的数据
        if (tableEndData != null && tableEndData.length > 0) {
            for (int i = 0; i < tableEndData.length; i++) {
                row = sheet.createRow(dataList.size() + m + i + 1);
                sheet.addMergedRegion(new CellRangeAddress(dataList.size() + m + i + 1, dataList.size() + m + i + 1, 0,  type.getDeclaredFields().length));
                for (int j = 0; j < tableEndData[i].length; j++) {
                    cell = row.createCell(j);
                    cell.setCellStyle(style);
                    setCellValue(cell, tableEndData[i][j]);
                }
            }
        }
        try {
            wb.write(out);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wb;
    }

    /** 
    * @Author lyb 
    * @Description //TODO 获取Record包含的所有properties 
    * @Date 11:30 2019/12/17 
    * @Param [list, fields] 列名,属性
    * @return java.lang.String[] 包含properties
    **/ 
    private static String[] getRecordProperties(List<?> list, Field[] fields) {
        if (null != list && null == fields) {
            Record record = (Record) list.get(0);
            Set<String> keySet = record.keySet();
            List<String> keysList = new ArrayList<>(keySet);
            return keysList.toArray(new String[keysList.size()]);
        } else if (null != fields && null == list) {
            String[] properties = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                properties[i] = fields[i].getName();
            }
            return properties;
        }
        return new String[0];
    }

    /** 
    * @Author lyb 
    * @Description //TODO 转换列表数据
    * @Date 11:33 2019/12/17 
    * @Param [list, properties, vo] 数据列表,属性列表,类型
    * @return java.util.List<java.lang.Object[]> 转换后的数据
    **/ 
    private static List<Object[]> getRowValue(List<?> list, String[] properties, String vo) {
        List<Object[]> resultList = new ArrayList<>();
        Record record;
        if (StringUtils.isBlank(vo)) {
            return resultList;
        }
        else if ("record".equals(vo)) {
            for (Object object : list) {
                record = (Record) object;
                Object[] values = new Object[properties.length];    //定义在外部数组值会被最后写入的覆盖
                for (int i = 0; i < properties.length; i++) {

                    values[i] = record.get(properties[i]);

                }
                resultList.add(values);
            }
            return resultList;
        }
        else if ("bean".equals(vo)) {
            for (Object object : list) {
                Class cf = object.getClass();
                Object[] values = new Object[properties.length];    //定义在外部数组值会被最后写入的覆盖
                for (int i = 0; i < properties.length; i++) {
                    char[] name = properties[i].toCharArray();
                    name[0] -= 32;
                    try {
                        Method method = cf.getMethod("get" + String.valueOf(name));
                        values[i] = method.invoke(object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                resultList.add(values);
            }
            return resultList;
        }
        return resultList;
    }

    /** 
    * @Author lyb 
    * @Description //TODO 设置单元格值
    * @Date 11:34 2019/12/17 
    * @Param [cell, value] 单元格,值
    * @return void 
    **/ 
    private static void setCellValue(XSSFCell cell, Object value) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
            cell.setCellType(XSSFCell.CELL_TYPE_BOOLEAN);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
            cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        } else if (value instanceof RichTextString) {
            cell.setCellValue((RichTextString) value);
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        } else {
            cell.setCellValue(String.valueOf(value));
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        }
    }

    /**
    * @Author lyb
    * @Description //TODO 测试方法
    * @Date 13:26 2019/12/19
    * @Param [args]
    * @return void
    **/
   
    
    

}


