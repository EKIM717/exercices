package com.windframework.shiro.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

import com.windframework.shiro.demo.base.response.ResponseInfo;
import com.windframework.shiro.demo.base.response.SveResult;

import jxl.CellType;
import jxl.Sheet;

public class ExcelReadUtil {
	
	/**
	 * 检查文件格式是否合法
	 * @param ctxPath
	 * @param stateMap
	 * @return true-合法; false-不合法
	 */
	public static boolean excelFormatValid(String ctxPath, ResponseInfo responseInfo) {
		if (!ctxPath.endsWith("xls")) {
			responseInfo.setStatus(SveResult.FAIL);
			responseInfo.setErrorMsg("传输失败，请上传Excel 97-2003  的xls格式文件。");
			return false;
		}
		return true;
	}
	
	public static boolean excelFormatValid2007(String ctxPath, ResponseInfo responseInfo) {
		if (!ctxPath.endsWith("xls") && !ctxPath.endsWith("xlsx")) {
			responseInfo.setStatus(SveResult.FAIL);
			responseInfo.setErrorMsg("传输失败，请上传Excel 97-2003  的xls格式或2007版的xlsx格式文件。");
			return false;
		}
		return true;
	}
	
	/**
	 * 检查文件是否存在
	 * @param ctxPath
	 * @param stateMap
	 * @return 存在则返回file,不存在则返回null
	 */
	public static File createExcelFile(String ctxPath, ResponseInfo responseInfo) {
		File file = new File(ctxPath);
		if (!file.exists()) {
			responseInfo.setStatus(SveResult.FAIL);
			responseInfo.setErrorMsg("传输失败，文件不存在。如果问题再次发生请联系管理员。");
			return null;
		}
		return file;
	}
	
	/**
	 * 检查文件是否存在
	 * @param ctxPath
	 * @param stateMap
	 * @return 存在则返回file,不存在则返回null
	 * @throws FileNotFoundException 
	 */
	public static InputStream createReadableExcelFile(String ctxPath, ResponseInfo responseInfo) throws FileNotFoundException {
		File file = new File(ctxPath);
		if (!file.exists()) {
			responseInfo.setStatus(SveResult.FAIL);
			responseInfo.setErrorMsg("传输失败，文件不存在。如果问题再次发生请联系管理员。");
			return null;
		}
		return new FileInputStream(ctxPath);
	}
	
	/**
	 * 检查导入.xls文件的时候检查表头一致性
	 * @param BATCH_HEADS
	 * @param sheet
	 * @param stateMap
	 * @return false(上传表头和模板的不相同), true(表头相同)
	 */
	public static boolean fileHeaderConsists(String[] BATCH_HEADS, Sheet sheet, ResponseInfo responseInfo) {
		return fileHeaderConsists(BATCH_HEADS, sheet, 0, responseInfo);
	}
	
	/**
	 * 检查导入.xls文件的时候检查表头一致性
	 * @param BATCH_HEADS
	 * @param sheet
	 * @param headerRowIndex 起始检查表头行数
	 * @param responseInfo
	 * @return false(上传表头和模板的不相同), true(表头相同)
	 */
	public static boolean fileHeaderConsists(String[] BATCH_HEADS, Sheet sheet, int headerRowIndex, ResponseInfo responseInfo) {
		String tmpStr;
		if (!Objects.equals(sheet.getColumns(), BATCH_HEADS.length)) {
			responseInfo.setStatus(SveResult.FAIL);
			responseInfo.setErrorMsg("模板表头列数对不上,请重新下载模板，正确填写数据后再上传。");
			return false;
		}
		for (int i = 0; i < BATCH_HEADS.length; i++) {
			tmpStr = sheet.getCell(i, headerRowIndex).getContents().trim();
			if (!(tmpStr.equalsIgnoreCase(BATCH_HEADS[i]))) {
				responseInfo.setStatus(SveResult.FAIL);
				responseInfo.setErrorMsg("上传表头:" + tmpStr + " 模板表头:" + BATCH_HEADS[i] + " 。表头数据错误，请重新下载模板，正确填写数据后再上传。");
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 检查导入.xls或.xlsx文件的时候检查表头一致性
	 * @param BATCH_HEADS
	 * @param sheet
	 * @param stateMap
	 * @return false(上传表头和模板的不相同), true(表头相同)
	 */
	public static boolean fileHeaderConsists(String[] BATCH_HEADS, org.apache.poi.ss.usermodel.Sheet sheet, ResponseInfo responseInfo) {
		return fileHeaderConsists(BATCH_HEADS, sheet, 0, responseInfo);
	}
	
	/**
	 * 检查导入.xls或.xlsx文件的时候检查表头一致性
	 * @param BATCH_HEADS
	 * @param sheet
	 * @param headerRowIndex 起始检查表头行数
	 * @param responseInfo
	 * @return false(上传表头和模板的不相同), true(表头相同)
	 */
	public static boolean fileHeaderConsists(String[] BATCH_HEADS, org.apache.poi.ss.usermodel.Sheet sheet, int headerRowIndex, ResponseInfo responseInfo) {
		String tmpStr;
		for (int i = 0; i < BATCH_HEADS.length; i++) {
			tmpStr = sheet.getRow(headerRowIndex).getCell(i).getStringCellValue().trim();
			if (!(tmpStr.equalsIgnoreCase(BATCH_HEADS[i]))) {
				responseInfo.setStatus(SveResult.FAIL);
				responseInfo.setErrorMsg("上传表头:" + tmpStr + " 系统程序表头:" + BATCH_HEADS[i] + " 。表头数据错误，请重新下载模板，正确填写数据后再上传。");
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查该行是否存在空的单元格或者为空行
	 * @param currentRow  当前行
	 * @param columnCount 列数总和
	 * @param sheet
	 * @return true含有false不含有
	 */
	public static boolean containsEmptyRow(int currentRow, int columnCount, Sheet sheet, StringBuilder errorList) {
		Set<Integer> set = new HashSet<Integer>();
		for (int j = 1; j < columnCount; j++) {
			CellType type = sheet.getCell(j, currentRow).getType();
			if (type == CellType.EMPTY)// 表示为空
				set.add(j);
		}
		if (set.size() == columnCount - 1) {// 整行为空
			errorList.append("第" + (currentRow + 1) + "行不能整行为空!<br>");
			return true;
		}
		return false;
	}
	
	/**
	 * 判断Excel单元格输入内容是否为空<br>
	 * @param currentRow	当前行
	 * @param columnCount	当前列
	 * @param sheet
	 * @param headers		表头
	 * @param errorList		记录错误信息
	 * @return
	 */
	public static boolean containsEmptyCell(int currentRow, int currentColumn, Sheet sheet, String[] headers, StringBuilder errorList) {
		String cellContent = StrUtil.trim(sheet.getCell(currentColumn, currentRow).getContents());
		if (StrUtil.isEmpty(cellContent)) {
			errorList.append("第" + (currentRow + 1) + "行" + headers[currentColumn] + "不能为空!<br>");
			return true;
		}
		return false;
	}
	
	/**
	 * 验证平台ID,站点名,仓库ID输入的合法性(暂不考虑输入为空的情况)
	 * @param validInfo 合法的info List
	 * @param inputInfo 用户输入的信息
	 * @return
	 */
	public static boolean validateInputInfo(List<String> validInfo, String inputInfo) {
		for (String info : validInfo) {
			if (inputInfo.equals(info)) {//如果匹配成功
				return true;//返回true
			}
		}
		return false;//否则返回false
	}
	
	/**
	 * 让每一列和序号对应起来,如A列对应的序号为0,B列为1,这样只需要根据列名,就可以获取到对应的列序号
	 * 但是遇到列数量太多,还要增加
	 * @return
	 */
	public static Map<String, Integer> getTitleMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int index = 0;
		//A列到Z列
		for(char c = 'A'; c <='Z'; c++) {
			map.put("" + c, index++);
		}
		//AA列到DZ
		for(char ch = 'A'; ch <= 'D'; ch++) {
			for(char cha = 'A'; cha <= 'Z'; cha++) {
				map.put("" + ch + cha, index++);
			}
		}
		return map;
	}
	
	/**
	 * poi获取cell字符串类型
	 * 
	 * @param cell
	 * @return 默认返回空字符串,而非null
	 */
	public static String getCellString(Cell cell) {
		String str = "";
		if (cell != null) {
			org.apache.poi.ss.usermodel.CellType cellType = cell.getCellTypeEnum();
			if (cellType == org.apache.poi.ss.usermodel.CellType.STRING) {
				str = cell.getRichStringCellValue().getString().trim();
			} else if (cellType == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
				 // 对整数进行判断处理
                double cur = cell.getNumericCellValue();  
                long longVal = Math.round(cur);
                Object inputValue = null;
                if(Double.parseDouble(longVal + ".0") == cur) {   
                    inputValue = longVal;
                } else {   
                    inputValue = cur; 
                }
                str = String.valueOf(inputValue);
			}
		}
		return str;
	}
	
	/**
	 * 日期类型
	 * @param cell
	 * @return
	 */
	public static Date getCellDate(Cell cell) {
		if (cell != null) {
			double value = cell.getNumericCellValue();  
            Date date = org.apache.poi.ss.usermodel.DateUtil  
                    .getJavaDate(value);
            
            return date;
		}
		return null;
	}
	
	/**
	 * poi获取xls或者xlsx的值，公式结果
	 * @param cell
	 * @param formulaEvaluator
	 * @return
	 */
	public static String getValue(Cell cell, FormulaEvaluator formulaEvaluator) {
        if(cell==null){
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                // 判断是日期时间类型还是数值类型
                if (DateUtil.isCellDateFormatted(cell)) {
                    short format = cell.getCellStyle().getDataFormat();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                    /* 所有日期格式都可以通过getDataFormat()值来判断
                     *     yyyy-MM-dd----- 14
                     *    yyyy年m月d日----- 31
                     *    yyyy年m月--------57
                     *    m月d日  --------- 58
                     *    HH:mm---------- 20
                     *    h时mm分  --------- 32
                     */
                    if(format == 14 || format == 31 || format == 57 || format == 58){ 
                        //日期 
                        sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                      }else if (format == 20 || format == 32) { 
                        //时间 
                        sdf = new SimpleDateFormat("HH:mm"); 
                      }
                    return sdf.format(cell.getDateCellValue());
                } else {
                    // 对整数进行判断处理
                    double cur = cell.getNumericCellValue();  
                    long longVal = Math.round(cur);  
                    Object inputValue = null;
                    if(Double.parseDouble(longVal + ".0") == cur) {   
                        inputValue = longVal;
                    } else {   
                        inputValue = cur; 
                    }
                    return String.valueOf(inputValue);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                //对公式进行处理,返回公式计算后的值,使用cell.getCellFormula()只会返回公式
                return String.valueOf(formulaEvaluator.evaluate(cell).getNumberValue());
            //Cell.CELL_TYPE_BLANK || Cell.CELL_TYPE_ERROR
            default:
                return null;
        }
    }
	
	/**
	 * poi获取xls或者xlsx的值
	 * @param cell
	 * @return
	 */
	public static String getValue(Cell cell) {
        if(cell==null){
            return null;
        }
        
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                // 判断是日期时间类型还是数值类型
                if (DateUtil.isCellDateFormatted(cell)) {
                    short format = cell.getCellStyle().getDataFormat();
                    SimpleDateFormat sdf = null;
                    /* 所有日期格式都可以通过getDataFormat()值来判断
                     *     yyyy-MM-dd----- 14
                     *    yyyy年m月d日----- 31
                     *    yyyy年m月--------57
                     *    m月d日  --------- 58
                     *    HH:mm---------- 20
                     *    h时mm分  --------- 32
                     *    2019/10/25  18:11:00 ----------22
                     */
                    if(format == 14 || format == 31 || format == 57 || format == 58){ 
                        //日期 
                        sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                      }else if (format == 20 || format == 32) { 
                        //时间 
                        sdf = new SimpleDateFormat("HH:mm"); 
                      } else if (format == 22) {
                    	sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
                      }
                    return sdf.format(cell.getDateCellValue());
                } else {
                    // 对整数进行判断处理
                    double cur = cell.getNumericCellValue();  
                    long longVal = Math.round(cur);  
                    Object inputValue = null;
                    if(Double.parseDouble(longVal + ".0") == cur) {   
                        inputValue = longVal;
                    }
                    else {   
                        inputValue = cur; 
                    }
                    return String.valueOf(inputValue);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return null;
        }
    }
	
//	public static Map<String, Integer> getTitleMap(String s) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		int index = 0;
//		char[] cArr = new char[2];
//		
//		if (StrManager.isEmpty(s)) {
//			cArr[0] = 1;
//			cArr[1] = 'Z';
//		} else if (s.length() == 1) {
//			cArr[0] = 1;
//			cArr[1] = 'Z';
//		}
//		//A列到Z列
//		for(char c = 'A'; c <='Z'; c++) {
//			map.put("" + c, index++);
//		}
//		//AA列到DZ
//		for(char ch = 'A'; ch <= 'D'; ch++) {
//			for(char cha = 'A'; cha <= 'Z'; cha++) {
//				map.put("" + ch + cha, index++);
//			}
//		}
//		return map;
//	}
	
}
