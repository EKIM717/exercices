package com.windframework.shiro.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jxl.CellType;

public class ExportUtil {
	
	/**
	  * 向客户端下载文件,弹出下载框.
	  * 
	  * @param response(HttpServletResponse)
	  * @param file(需要下载的文件)
	  * @param isDel(下载完成后是否删除该文件)
	  * @throws IOException 
	  */
	public static void exportFile(HttpServletResponse response, File file, boolean isDel) throws IOException {
		OutputStream out = null;
		InputStream in = null;

		//获得文件名
		String filename = new String(file.getName().getBytes(),"ISO8859-1"); //识别中文
		//定义输出类型(下载)
		response.setContentType("application/force-download");
		response.setHeader("Location", filename);
		//定义输出文件头
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		try {
			out = response.getOutputStream();
			in = new FileInputStream(file.getPath());

			byte[] buffer = new byte[1024];
			int len;
			//System.out.println("this is first time begin*****");
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			//System.out.println("this is first time end*****");
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		
		if (isDel) {
			//删除文件,删除前关闭所有的Stream.
//			file.delete();
			FileUtil.deleteFile(file);
		}
	}
	
	public static void exportFile(HttpServletResponse response, SmbFile file, boolean isDel) throws IOException {
		OutputStream out = null;
		InputStream in = null;

		//获得文件名
		String filename = URLEncoder.encode(file.getName(), "UTF-8");
		//定义输出类型(下载)
		response.setContentType("application/force-download");
		response.setHeader("Location", filename);
		//定义输出文件头
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		try {
			out = response.getOutputStream();
			in = new SmbFileInputStream(file.getPath());

			byte[] buffer = new byte[1024];
			int len;
			//System.out.println("this is first time begin*****");
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			//System.out.println("this is first time end*****");
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		
		if (isDel) {
			//删除文件,删除前关闭所有的Stream.
//			file.delete();
			FileUtil.deleteFile(file);
		}
	}
	
	/**
	 * 导出模板
	 * @param response
	 * @param UPLOAD_HEAD
	 * @param UPLOAD_TYPE
	 * @param fileName
	 * @return
	 */
	public static String exportTemplate(HttpServletResponse response, String[] UPLOAD_HEAD, CellType[] UPLOAD_TYPE, String fileName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String dateStr = sdf.format(calendar.getTime());
			fileName = dateStr + fileName;
			String fileFolder = Thread.currentThread().getContextClassLoader().getResource("").getPath();

			File file = FileUtil.fileCreate(fileFolder, fileName);
			List<String[]> heads = new ArrayList<String[]>();
			List<CellType[]> types = new ArrayList<CellType[]>();
			FileOutputStream os = new FileOutputStream(file); // 创建输出流
			LinkedHashMap<String, List<Object[]>> map = new LinkedHashMap<String, List<Object[]>>();
			
			heads.add(UPLOAD_HEAD);
			types.add(UPLOAD_TYPE);
			List<Object[]> list = new ArrayList<Object[]>();
			map.put("sheet1", list);

			// 生成excel文件(保存在服务器机上)
			try {
				WriteExcelUtil.writeExcel(os, heads, types, map);
				// 导出文件(下载到客户机上,并删除服务器机上的excel文件)
				ExportUtil.exportFile(response, file, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 自定义样式表头
	 * 
	 * @param response
	 * @param UPLOAD_HEAD
	 * @param UPLOAD_TYPE
	 * @param fileName
	 * @return
	 */
	public static String exportCustomizeTemplate(HttpServletResponse response, CellStyle[] UPLOAD_HEAD, CellType[] UPLOAD_TYPE, String fileName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String dateStr = sdf.format(calendar.getTime());
			fileName = dateStr + fileName;
			String fileFolder = Thread.currentThread().getContextClassLoader().getResource("").getPath();

			File file = FileUtil.fileCreate(fileFolder, fileName);
			List<CellStyle[]> heads = new ArrayList<CellStyle[]>();
			List<CellType[]> types = new ArrayList<CellType[]>();
			FileOutputStream os = new FileOutputStream(file); // 创建输出流
			LinkedHashMap<String, List<Object[]>> map = new LinkedHashMap<String, List<Object[]>>();
			
			heads.add(UPLOAD_HEAD);
			types.add(UPLOAD_TYPE);
			List<Object[]> list = new ArrayList<Object[]>();
			map.put("sheet1", list);

			// 生成excel文件(保存在服务器机上)
			try {
				WriteExcelUtil.writeCustomizeExcel(os, heads, types, map);
				// 导出文件(下载到客户机上,并删除服务器机上的excel文件)
				ExportUtil.exportFile(response, file, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
