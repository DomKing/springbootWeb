package org.prcode.utility.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.prcode.utility.util.support.excel.annotation.Excel;
import org.prcode.utility.util.support.excel.domain.ExcelDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @className: ExcelUtil
 * @date: 2017-04-24 15:47
 * @author: kangduo
 * @description: (excel工具类)
 */
public class ExcelUtil<T> {

    private static final Logger logger = Logger.getLogger(ExcelUtil.class);

    public static void writeDataToNewExcel(String modelFilePath, String goalFilePath, List<HashMap<String, Object>> srcDataInfo) throws Exception {
        //读取模板数据文件，初始化数据
        XSSFRow sheetRowFirst = null;
        List<String> keysList = new LinkedList<String>();
        {
            FileInputStream srcFileinputSteam = new FileInputStream(new File(modelFilePath));
            XSSFWorkbook srcWorkBook = new XSSFWorkbook(srcFileinputSteam);
            XSSFSheet sheet = srcWorkBook.getSheetAt(0);
            sheetRowFirst = sheet.getRow(0);
            XSSFRow sheetRow01 = sheet.getRow(1);
            short cellCount = sheetRow01.getLastCellNum();
            for (int i = 0; i < cellCount; i++) {
                keysList.add(sheetRow01.getCell(i).getStringCellValue());
            }
            //将第一行数据加入到结果数据listmap的第一个
            HashMap<String, Object> firstRowMap = new HashMap<String, Object>();
            for (int j = 0; j < cellCount; j++) {
                firstRowMap.put(keysList.get(j), sheetRowFirst.getCell(j).getStringCellValue());
            }
            srcDataInfo.add(0, firstRowMap);
        }
        //填写具体数据
        {
            XSSFWorkbook srcWorkBook = new XSSFWorkbook();
            XSSFSheet sheet = srcWorkBook.createSheet();
            int rowCount = srcDataInfo.size();
            for (int i = 0; i < rowCount; i++) {
                HashMap<String, Object> lineMap = srcDataInfo.get(i);
                XSSFRow row = sheet.createRow(i);
                int columnCount = keysList.size();
                for (int j = 0; j < columnCount; j++) {
                    String value = "";
                    if (lineMap.get(keysList.get(j)) != null) {
                        value = lineMap.get(keysList.get(j)).toString();
                    }
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(value);
                }
            }
            //写入文件

            FileOutputStream fileOut = new FileOutputStream(new File(goalFilePath));
            srcWorkBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
    }

    /**
     * excel导出
     *
     * @param exportFileName
     * @param workbook
     * @param response
     */
    public static void commonExport(String exportFileName, HSSFWorkbook workbook, HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        String fileName = null;
        try {
            fileName = URLEncoder.encode(exportFileName, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;filename=" + fileName + ".xls");
        OutputStream fOut = null;
        try {
            fOut = response.getOutputStream();
            workbook.write(fOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fOut != null) {
                try {
                    fOut.flush();
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出excel信息
     *
     * @param exportFileName 导出文件名
     * @param sheetName      文件sheet名
     * @param data           需要导出的数据
     * @param clazz          对象
     * @param response       响应
     * @throws Exception
     */
    public void exportExcelWithoutTemplate(String exportFileName,
                                           String sheetName,
                                           List<T> data,
                                           Class<?> clazz,
                                           HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = getExportExcelForXSSFWorkbook(sheetName, data, clazz);

        OutputStream out = null;
        try {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(exportFileName, "UTF-8") + ".xls");
            out = response.getOutputStream();
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    logger.error("excel数据流关闭错误！");
                }
            }
        }
    }

    /**
     * 生成导出数据的XSSFWorkbook并返回
     *
     * @param sheetName
     * @param data
     * @param clazz
     * @return
     * @throws Exception
     */
    public HSSFWorkbook getExportExcelForXSSFWorkbook(String sheetName, List<T> data, Class<?> clazz) throws Exception {
        //创建excel文件 并设置表格样式
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        HSSFCellStyle style = createCellStyle(workbook);

        ExcelDTO excelDTO = getExcelAnnotation(clazz);
        //写入title
        writeInTitle(sheet, style, excelDTO.getTitles());
        //写入数据
        writeData(data, excelDTO.getProperties(), sheet, style);
        return workbook;
    }

    /**
     * 向excel写入数据
     *
     * @param data       数据
     * @param properties 变量名
     * @param sheet
     * @param style
     * @throws Exception
     */
    private void writeData(List<T> data, List<String> properties, HSSFSheet sheet, HSSFCellStyle style) throws Exception {
        JSONObject json = null;
        Row row = null;
        Cell cell = null;
        for (int index = 0; index < data.size(); index++) {                //列
            json = (JSONObject) JSONObject.toJSON(data.get(index));
            row = sheet.createRow(index + 1);
            row.setHeight((short) 300);
            for (int i = 1; i <= properties.size(); i++) {                //行
                cell = row.createCell(i - 1);
                cell.setCellStyle(style);
                Object value = json.get(properties.get(i - 1));
                if (null != value) {
                    writeInFormatConversion(cell, value, sheet, i, index);
                }
            }
        }
    }

    /**
     * 写入标题栏
     *
     * @param sheet
     * @param style
     * @throws Exception
     */
    private void writeInTitle(HSSFSheet sheet, HSSFCellStyle style, List<String> titles) throws Exception {
        Cell cell = null;
        Row row = sheet.createRow(0);
        try {
            for (int i = 0; i < titles.size(); i++) {
                row.setHeight((short) 300);
                cell = row.createCell(i);
                cell.setCellStyle(style);
                cell.setCellValue(titles.get(i));
            }
        } catch (Exception e) {
            throw new Exception("Write title data error");
        }
    }

    /**
     * 获得excel的注解内容
     *
     * @param clazz
     * @return
     */
    private ExcelDTO getExcelAnnotation(Class<?> clazz) {
        ExcelDTO excelDTO = new ExcelDTO();
        List<String> titles = new ArrayList<String>();
        List<String> properties = new ArrayList<String>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //参数多注解时，只获得excel注解的数据
            if (field.isAnnotationPresent(Excel.class)) {
                Excel excel = (Excel) field.getAnnotation(Excel.class);
                titles.add(excel.title());
                properties.add(field.getName());
            }
        }
        excelDTO.setTitles(titles);
        excelDTO.setProperties(properties);
        return excelDTO;
    }

    /**
     * 写入数据时格式转换
     *
     * @param cell
     * @param value
     * @param index
     * @param i
     * @param sheet
     * @throws Exception
     */
    private void writeInFormatConversion(Cell cell, Object value, HSSFSheet sheet, int i, int index) throws Exception {
        try {
            if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cell.setCellValue(sdf.format((Date) value));
            } else {
                cell.setCellValue(value.toString());
            }

            sheet.setColumnWidth(i - 1, 5000);
        } catch (Exception e) {
            logger.debug("第" + (index + 1) + "行" + i + "列错误");
            throw e;
        }
    }

    /**
     * 对读取excel的数据进行格式转换
     *
     * @param cell
     * @return
     * @throws Exception
     */
    private Object dataFormat(Cell cell) throws Exception {
        try {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    return cellTypeNumeric(cell);
                case HSSFCell.CELL_TYPE_STRING:
                    return cell.getStringCellValue();
                case Cell.CELL_TYPE_BLANK:
                    return "";
                default:
                    return cell.getStringCellValue();
            }
        } catch (Exception e) {
            logger.debug("excel数据格式化错误！");
            throw e;
        }
    }

    /**
     * 格式化数字类型
     *
     * @param cell
     * @return
     * @throws Exception
     */
    private static Object cellTypeNumeric(Cell cell) throws Exception {
        SimpleDateFormat sdf = null;
        if (HSSFDateUtil.isCellDateFormatted(cell)) {
            short format = cell.getCellStyle().getDataFormat();
            double value = cell.getNumericCellValue();
            Date date = DateUtil.getJavaDate(value);
            if (format == 14 || format == 31 || format == 57 || format == 58) {
                return date;
            } else if (format == 20 || format == 32) {
                sdf = new SimpleDateFormat("HH:mm");
                return sdf.format(date);
            }
        } else {
            String cellStr = cell.getNumericCellValue() + "";
            if (cellStr.contains("E")) {
                DecimalFormat df = new DecimalFormat("#");
                return df.format(cell.getNumericCellValue());
            }
        }
        return cell.getNumericCellValue();
    }

    /**
     * @param workbook
     * @return
     * @description: (设置excel的表格样式)
     */
    private HSSFCellStyle createCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setWrapText(true); // 自动换行

        //设置字体样式
        HSSFFont font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        return style;
    }

}
