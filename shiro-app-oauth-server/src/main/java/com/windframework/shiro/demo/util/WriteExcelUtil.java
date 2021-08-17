package com.windframework.shiro.demo.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;


import jxl.CellType;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcelUtil {
	
	/**
	 * 限制行数
	 */
	public static final int PAGE_SIZE = 65000;
	
	public static int getIndex(int size) {
		int sheetIndex = size / PAGE_SIZE;//65000行一页
		if (sheetIndex < 1) {
			sheetIndex = 1;
		} else if (size % PAGE_SIZE > 0) {
			sheetIndex++;
		}
		return sheetIndex;
	}
	
	/**
	 * 在一张sheet中添加任意内容
	 * @param os
	 * @param list (excel内容)
	 * @throws IOException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os, List<Object[]> list) throws IOException, WriteException {
		writeExcel(os, list, null);
	}
	
	/**
	 * 在一张sheet中添加任意内容
	 * @param os
	 * @param list (excel内容)
	 * @param sheetName (可为空,为空sheet名为Sheet1)
	 * @throws IOException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os, List<Object[]> list, String sheetName) throws IOException, WriteException {
		//创建可以写入的Excel工作薄(默认运行生成的文件在tomcat/bin下 )
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		try {
			//生成工作表,(name:First Sheet,参数0表示这是第一页)
			WritableSheet sheet = null;
			if (!StrUtil.isEmpty(sheetName)) {
				sheet = wwb.createSheet(sheetName, 0);
			} else {
				sheet = wwb.createSheet("Sheet1", 0);
			}
			
			int rows = 0;
			for (int i = 0; i < list.size(); i++) {
				String[] titles = (String[]) list.get(i)[0];
				for (int j = 0; j < titles.length; j++) {
					//用于写入文本内容到工作表中去
					Label label = null;
					//在Label对象的构造中指明单元格位置(参数依次代表列数、行数、内容 )
					label = new Label(j, rows, titles[j]);
					//将定义好的单元格添加到工作表中
					sheet.addCell(label);
				}
				CellType[] types = (CellType[]) list.get(i)[1];
				List<Object[]> ret = (List<Object[]>) list.get(i)[2];
				for (int j = 0; j < ret.size(); j++) {
					Object[] cells = ret.get(j);
					for (int k = 0; k < cells.length; k++) {
						//类型判断
						if (types[k] == CellType.DATE) {
							if (cells[k] instanceof Long) {
								Calendar c = Calendar.getInstance();
								c.setTimeInMillis((Long) cells[k]);
								//获取时间数据由于时区相差8小时 获取系统时间 相加 补差8小时
								c.add(Calendar.MILLISECOND, c.getTimeZone().getRawOffset());
								//生成一个保存日期的单元格,必须使用DateTime的完整包路径,否则有语法歧义,值为new Date()
								DateTime date = new DateTime(k, rows + j + 1, c.getTime(), DateTime.GMT);
								
								sheet.addCell(date);
							}
						} else if (types[k] == CellType.LABEL) {
							Label label = null;
							label = new Label(k, rows + j + 1, (String) cells[k]);
							sheet.addCell(label);
						} else if (types[k] == CellType.NUMBER) {
							if (cells[k].getClass().equals(Integer.class)) {	// int类型
								jxl.write.Number number = new jxl.write.Number(k, rows + j + 1, (Integer) cells[k]);
								sheet.addCell(number);
							} else if (cells[k].getClass().equals(Double.class)) {
								jxl.write.Number number = new jxl.write.Number(k, rows + j + 1, (Double) cells[k]);
								sheet.addCell(number);
							} else if (cells[k].getClass().equals(Float.class)) {
								jxl.write.Number number = new jxl.write.Number(k, rows + j + 1, (Float) cells[k]);
								sheet.addCell(number);
							}
						}
					}
				}
				rows += ret.size() + 2;
			}
		} finally {
			close(wwb, os);
		}
	}
	
	/**
	 * 生成excel文件(文件标题栏与文件内容一定要对应)
	 * 只能生成一个sheet，且名字为sheet1
	 * @param os
	 * @param title (excel文件标题栏)
	 * @param types	(excel数据类型)
	 * @param lists (excel文件内容)
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os, String[] title, CellType[] types, List<Object[]> lists) throws IOException, RowsExceededException, WriteException {
		writeExcel(os, title, types, lists, null);
	}
	
	/**
	 * 生成excel文件(文件标题栏与文件内容一定要对应)
	 * 只能生成一个sheet，且名字为sheet1
	 * @param os
	 * @param title (excel文件标题栏)
	 * @param types	(excel数据类型)
	 * @param lists (excel文件内容)
	 * @param sheetName (excel的Sheet名)
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os, String[] title, CellType[] types, List<Object[]> lists, String sheetName) throws IOException, RowsExceededException, WriteException {
		//创建可以写入的Excel工作薄(默认运行生成的文件在tomcat/bin下 )
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		try {
			//生成工作表,(name:First Sheet,参数0表示这是第一页)
			WritableSheet sheet = null;
			if (!StrUtil.isEmpty(sheetName)) {
				sheet = wwb.createSheet(sheetName, 0);
			} else {
				sheet = wwb.createSheet("Sheet1", 0);
			}
			
			//开始写入第一行(即标题栏)
			if (title.length == 0 || title != null) {
				for (int i = 0; i < title.length; i++) {
					//用于写入文本内容到工作表中去
					Label label = null;
					//在Label对象的构造中指明单元格位置(参数依次代表列数、行数、内容 )
					label = new Label(i, 0, title[i]);
					//将定义好的单元格添加到工作表中
					sheet.addCell(label);
				}
			}
			//开始写入内容
			for (int i = 0; i < lists.size(); i++) {
				//获取一条(一行)记录
				Object[] cells = lists.get(i);
				for (int j = 0; j < cells.length; j++) {
					//类型判断
					if (types[j] == CellType.DATE) {
						if (cells[j] instanceof Long) {
							Calendar c = Calendar.getInstance();
							c.setTimeInMillis((Long) cells[j]);
							//获取时间数据由于时区相差8小时 获取系统时间 相加 补差8小时
							c.add(Calendar.MILLISECOND, c.getTimeZone().getRawOffset());
							//生成一个保存日期的单元格,必须使用DateTime的完整包路径,否则有语法歧义,值为new Date()
							DateTime date = new DateTime(j, i + 1, c.getTime(), DateTime.GMT);
							sheet.addCell(date);
						}
					} else if (types[j] == CellType.LABEL) {
						Label label = null;
						label = new Label(j, i + 1, (String) cells[j]);
						sheet.addCell(label);
					} else if (types[j] == CellType.NUMBER) {
						if (cells[j] == null) {
							continue;
						}
						if (cells[j].getClass().equals(Integer.class)) {	// int类型
							jxl.write.Number number = new jxl.write.Number(j, i + 1, (Integer) cells[j]);
							sheet.addCell(number);
						} else if (cells[j].getClass().equals(Double.class)) {
							jxl.write.Number number = new jxl.write.Number(j, i + 1, (Double) cells[j]);
							sheet.addCell(number);
						} else if (cells[j].getClass().equals(Float.class)) {
							jxl.write.Number number = new jxl.write.Number(j, i + 1, (Float) cells[j]);
							sheet.addCell(number);
						}
					}
				}
			}
		} finally {
			close(wwb, os);
		}
	}
	
	/**
	 * 多张sheet，用LinkedHashMap保存
	 * @param os
	 * @param titles (按顺序对应sheet的标题)
	 * @param types (按顺序对应sheet的内容类型)
	 * @param allMap (按顺序对应sheet的名称和内容)
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	public static void writeExcel(OutputStream os,
			List<String[]> titles, List<CellType[]> types,
			LinkedHashMap<String, List<Object[]>> allMap)
			throws RowsExceededException, WriteException, IOException {
		List<List<Object[]>> allList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		for (String sheetName : allMap.keySet()) {
			sheetNames.add(sheetName);
			allList.add(allMap.get(sheetName));
		}
		writeExcel(os, titles, types, allList, allMap.size(), sheetNames);
	}
	
	/**
	 * 自定义样式写入
	 * 
	 * @param os
	 * @param titles
	 * @param types (按顺序对应sheet的内容类型)
	 * @param allMap (按顺序对应sheet的名称和内容)
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	public static void writeCustomizeExcel(OutputStream os,List<CellStyle[]> titles,List<CellType[]> types,
			LinkedHashMap<String, List<Object[]>> allMap)
			throws RowsExceededException, WriteException, IOException {
		List<List<Object[]>> allList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		for (String sheetName : allMap.keySet()) {
			sheetNames.add(sheetName);
			allList.add(allMap.get(sheetName));
		}
		customizeWriteExcel(os, titles, types, allList, allMap.size(), sheetNames);
	}
	
	/**
	 * size为sheet的个数，写入不同的sheet里面
	 * @param os
	 * @param titles (按顺序对应sheet的标题)
	 * @param types	(按顺序对应sheet的内容类型)
	 * @param alllist (按顺序对应sheet的内容)
	 * @param size (sheet数量)
	 * @param sheetNames (按顺序对应sheet的名称)
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os,
			List<String[]> titles, List<CellType[]> types,
			List<List<Object[]>> alllist, int size, List<String> sheetNames)
			throws IOException, RowsExceededException, WriteException {
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		try {
			//生成工作表,(name:sheetName,参数size表示这是第size个sheet)
			for (int num = 0; num < size; num++) {// num表示sheet
				String[] title = titles.get(num);// 第num个sheet的title
				String sheetName = sheetNames.get(num);
				WritableSheet sheet = wwb.createSheet(sheetName, num);
				List<Object[]> lists = alllist.get(num);
				CellType[] type = types.get(num);
				//开始写入第一行(即标题栏)
				for (int i = 0; i < title.length; i++) {
					//用于写入文本内容到工作表中去
					Label label = null;
					//在Label对象的构造中指明单元格位置(参数依次代表列数、行数、内容 )
					label = new Label(i, 0, title[i]);
					//将定义好的单元格添加到工作表中
					sheet.addCell(label);
				}
				//开始写入内容
				for (int i = 0; i < lists.size(); i++) {
					//获取一条(一行)记录
					Object[] cells = lists.get(i);
					for (int j = 0; j < cells.length; j++) {
						//类型判断
						if (type[j] == CellType.DATE) {
							if (cells[j] instanceof Long) {
								Calendar c = Calendar.getInstance();
								c.setTimeInMillis((Long) cells[j]);
								//获取时间数据由于时区相差8小时 获取系统时间 相加 补差8小时
								c.add(Calendar.MILLISECOND, c.getTimeZone().getRawOffset());
								//生成一个保存日期的单元格,必须使用DateTime的完整包路径,否则有语法歧义,值为new Date()
								DateTime date = new DateTime(j, i + 1, c.getTime(), DateTime.GMT);
								sheet.addCell(date);
							}
						} else if (type[j] == CellType.LABEL) {
							Label label = null;
							label = new Label(j, i + 1, (String) cells[j]);
							sheet.addCell(label);
						} else if (type[j] == CellType.NUMBER) {
							jxl.write.Number number = null;
							if (cells[j] == null) {
								
							} else if (cells[j].getClass().equals(Integer.class)) {	//int类型
								number = new jxl.write.Number(j, i + 1, (Integer) cells[j]);
								sheet.addCell(number);
							} else if (cells[j].getClass().equals(Double.class)) {
								number = new jxl.write.Number(j, i + 1, (Double) cells[j]);
								sheet.addCell(number);
							} else if (cells[j].getClass().equals(Float.class)) {
								number = new jxl.write.Number(j, i + 1, (Float) cells[j]);
								sheet.addCell(number);
							}
						}
					}
				}
			}
		} finally {
			close(wwb, os);
		}
	}
	
	/**
	 * size为sheet的个数，写入不同的sheet里面(自定义)
	 * @param os
	 * @param titles (按顺序对应sheet的标题)
	 * @param types	(按顺序对应sheet的内容类型)
	 * @param alllist (按顺序对应sheet的内容)
	 * @param size (sheet数量)
	 * @param sheetNames (按顺序对应sheet的名称)
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void customizeWriteExcel(OutputStream os,
			List<CellStyle[]> titles, List<CellType[]> types,
			List<List<Object[]>> alllist, int size, List<String> sheetNames)
			throws IOException, RowsExceededException, WriteException {
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		try {
			//生成工作表,(name:sheetName,参数size表示这是第size个sheet)
			for (int num = 0; num < size; num++) {// num表示sheet
				CellStyle[] title = titles.get(num);// 第num个sheet的title
				String sheetName = sheetNames.get(num);
				WritableSheet sheet = wwb.createSheet(sheetName, num);
				List<Object[]> lists = alllist.get(num);
				CellType[] type = types.get(num);
				//开始写入第一行(即标题栏)
				for (int i = 0; i < title.length; i++) {
					//用于写入文本内容到工作表中去
					Label label = null;
					WritableFont font = new WritableFont(WritableFont.ARIAL);
					font.setColour(title[i].getColor());
					WritableCellFormat wcf = new WritableCellFormat(font);
					//在Label对象的构造中指明单元格位置(参数依次代表列数、行数、内容 )
					label = new Label(i, 0, title[i].getContext(), wcf);
					//将定义好的单元格添加到工作表中
					sheet.addCell(label);			
				}
				//开始写入内容
				for (int i = 0; i < lists.size(); i++) {
					//获取一条(一行)记录
					Object[] cells = lists.get(i);
					for (int j = 0; j < cells.length; j++) {
						//类型判断
						if (type[j] == CellType.DATE) {
							if (cells[j] instanceof Long) {
								Calendar c = Calendar.getInstance();
								c.setTimeInMillis((Long) cells[j]);
								//获取时间数据由于时区相差8小时 获取系统时间 相加 补差8小时
								c.add(Calendar.MILLISECOND, c.getTimeZone().getRawOffset());
								//生成一个保存日期的单元格,必须使用DateTime的完整包路径,否则有语法歧义,值为new Date()
								DateTime date = new DateTime(j, i + 1, c.getTime(), DateTime.GMT);
								sheet.addCell(date);
							}
						} else if (type[j] == CellType.LABEL) {
							Label label = null;
							label = new Label(j, i + 1, (String) cells[j]);
							sheet.addCell(label);
						} else if (type[j] == CellType.NUMBER) {
							jxl.write.Number number = null;
							if (cells[j] == null) {
								
							} else if (cells[j].getClass().equals(Integer.class)) {	//int类型
								number = new jxl.write.Number(j, i + 1, (Integer) cells[j]);
								sheet.addCell(number);
							} else if (cells[j].getClass().equals(Double.class)) {
								number = new jxl.write.Number(j, i + 1, (Double) cells[j]);
								sheet.addCell(number);
							} else if (cells[j].getClass().equals(Float.class)) {
								number = new jxl.write.Number(j, i + 1, (Float) cells[j]);
								sheet.addCell(number);
							}
						}
					}
				}
			}
		} finally {
			close(wwb, os);
		}
	}
	
	/**
	 * 
	 * @param os
	 * @param types
	 * @param lists
	 * @param sheetName
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os, List<CellType[]> types, List<Object[]> lists) throws IOException, RowsExceededException, WriteException {
		writeExcel(os, types, lists, null);
	}
	
	/**
	 * 
	 * @param os
	 * @param types
	 * @param lists
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void writeExcel(OutputStream os, List<CellType[]> types, List<Object[]> lists, String sheetName) throws IOException, RowsExceededException, WriteException {
		//创建可以写入的Excel工作薄(默认运行生成的文件在tomcat/bin下 )
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		try {
			//生成工作表,(name:First Sheet,参数0表示这是第一页)
			WritableSheet sheet = null;
			if (!StrUtil.isEmpty(sheetName)) {
				sheet = wwb.createSheet(sheetName, 0);
			} else {
				sheet = wwb.createSheet("Sheet1", 0);
			}
			
			//开始写入内容
			for (int i = 0; i < lists.size(); i++) {
				//获取一条(一行)记录
				Object[] cells = lists.get(i);
				CellType[] cellType = types.get(i);
				for (int j = 0; j < cells.length; j++) {
					//类型判断
					if (cellType[j] == CellType.DATE) {
						if (cells[j] instanceof Long) {
							Calendar c = Calendar.getInstance();
							c.setTimeInMillis((Long) cells[j]);
							//获取时间数据由于时区相差8小时 获取系统时间 相加 补差8小时
							c.add(Calendar.MILLISECOND, c.getTimeZone().getRawOffset());
							//生成一个保存日期的单元格,必须使用DateTime的完整包路径,否则有语法歧义,值为new Date()
							DateTime date = new DateTime(j, i, c.getTime(), DateTime.GMT);
							sheet.addCell(date);
						}
					} else if (cellType[j] == CellType.LABEL) {
						Label label = null;
						try {
							label = new Label(j, i, (String) cells[j]);
						} catch(ClassCastException e) {
							e.printStackTrace();
						}
						sheet.addCell(label);
					} else if (cellType[j] == CellType.NUMBER) {
						if (cells[j].getClass().equals(Integer.class)) {	// int类型
							jxl.write.Number number = new jxl.write.Number(j, i, (Integer) cells[j]);
							sheet.addCell(number);
						} else if (cells[j].getClass().equals(Double.class)) {
							jxl.write.Number number = new jxl.write.Number(j, i, (Double) cells[j]);
							sheet.addCell(number);
						} else if (cells[j].getClass().equals(Float.class)) {
							jxl.write.Number number = new jxl.write.Number(j, i, (Float) cells[j]);
							sheet.addCell(number);
						} else {
							sheet.addCell(new Label(j, i, ""));
						}
					}
				}
			}
		} finally {
			close(wwb, os);
		}
	}
	
	/*
	 * 生成一个保存数字的单元格,必须使用Number的完整包路径,否则有语法歧义,值为789.123 jxl.write.Number
	 * number = new jxl.write.Number(col, row, 555.12541);
	 * sheet.addCell(number);
	 */
	private static void close(WritableWorkbook wwb, OutputStream os) {
		try {
			if (wwb != null) {
				//写入数据
				wwb.write();
				//关闭文件
				wwb.close();
			}
			if (os != null) {
				//关闭输出流
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
}
