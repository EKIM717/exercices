package com.windframework.shiro.demo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class FileUtil {

	/**
	 * 创建文件或文件夹
	 * @param fileFolder
	 * @param fileName
	 * @return
	 */
	public static File fileCreate(String fileFolder, String fileName) {
		File folder = new File(fileFolder);
		File file = new File(fileFolder + "/" + fileName);
		//如果文件夹不存在，则创建文件夹
		if (folder.exists() == false) {
			folder.mkdirs();	//多级目录
//			foder.mkdir();	//只创建一级目录
		}
		//如果文件不存在，则创建文件
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * 删除文件或文件夹
	 * @param file
	 */
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				deleteFile(f);
			}
			file.delete();
		} else if (file.isFile()) {
			file.delete();
		}
	}
	
	public static byte[] file2byte(File file) {
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
	
	public static File byte2File(byte[] buf, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			file = new File(filePath + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(buf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}

	public static File unjarFile(String path, Class<?> clazz, String fileName) throws IOException {
		File file = new File(path + "/" + clazz.getSimpleName() + "/" + fileName);
		if (!file.exists()) {
			URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
			String filePath = URLDecoder.decode(url.getPath(), "utf-8");	//转化为utf-8编码
			JarFile jarFile = new JarFile(filePath);
			Enumeration<JarEntry> jarEntrys = jarFile.entries();
			while (jarEntrys.hasMoreElements()) {
				JarEntry jarEntry = jarEntrys.nextElement();
				if (jarEntry.getName().indexOf(fileName) > -1) {
					XmlFileParser.writeXml(jarFile.getInputStream(jarEntry), file);
				}
			}
			jarFile.close();
		}
		return file;
	}

	/**
	 * 解压jar里面的配置文件到对应job文件配置
	 * @param fileName
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static File unjarFile(String fileName, Object object) throws IOException {
		File file = new File("resources/" + object.getClass().getSimpleName() + "/" + fileName);
		if (!file.exists()) {
			URL url = object.getClass().getProtectionDomain().getCodeSource().getLocation();
			String filePath = URLDecoder.decode(url.getPath(), "utf-8");	//转化为utf-8编码
			JarFile jarFile = new JarFile(filePath);
			Enumeration<JarEntry> jarEntrys = jarFile.entries();
			while (jarEntrys.hasMoreElements()) {
				JarEntry jarEntry = jarEntrys.nextElement();
				if (jarEntry.getName().indexOf(fileName) > -1) {
					XmlFileParser.writeXml(jarFile.getInputStream(jarEntry), file);
				}
			}
			jarFile.close();
		}
		return file;
	}
	
	/**
	 * 为避免路径"/"问题，统一使用此初始化方法
	 * @param path
	 * @return
	 * @throws MalformedURLException
	 * @throws SmbException 
	 */
	public static SmbFile newSmbFile(String path) throws MalformedURLException, SmbException {
		path = path.replace(File.separator, "/");
		SmbFile file = new SmbFile(path);
		if (file.isDirectory()) {
			path += "/";
			file = new SmbFile(path);
		}
		return file;
	}

	public static SmbFile createSmbFile(String fileFolder, String fileName) throws SmbException, MalformedURLException {
		SmbFile folder = newSmbFile(fileFolder);
		SmbFile file = newSmbFile(fileFolder + "/" + fileName);
		//如果文件夹不存在，则创建文件夹
		if (folder.exists() == false) {
			folder.mkdirs();	//多级目录
//			foder.mkdir();	//只创建一级目录
		}
		//如果文件不存在，则创建文件
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * smb方式处理文件
	 * @param file
	 * @throws SmbException
	 */
	public static void deleteFile(SmbFile file) throws SmbException {
		if (file.isDirectory()) {
			SmbFile[] files = file.listFiles();
			for (SmbFile f : files) {
				deleteFile(f);
			}
			file.delete();
		} else if (file.isFile()) {
			file.delete();
		}
	}
	
	public static byte[] file2byte(SmbFile file) throws IOException {
		byte[] buffer = null;
		SmbFileInputStream fis = new SmbFileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int n;
		while ((n = fis.read(b)) != -1) {
			bos.write(b, 0, n);
		}
		fis.close();
		bos.close();
		buffer = bos.toByteArray();
		return buffer;
	}
	
	/**
	 * 
	 * @param localFile
	 * @param remoteFile
	 * @return 
	 * @throws IOException 
	 */
	public static void copy2Smb(File localFile, SmbFile remoteFile) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(localFile));
			out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
			byte[] buffer = new byte[1024];
			while (in.read(buffer) != -1) {
				out.write(buffer);
				buffer = new byte[1024];
			}
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param localFile
	 * @param remoteFile
	 * @return 
	 * @throws IOException 
	 */
	public static void copy2SmbWithDirectory(File localFile, SmbFile remoteFile) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (localFile.isDirectory()) {
				for (File file : localFile.listFiles()) {
					if (file.isDirectory()) {
						String fileName = file.getName();
						SmbFile targetFile = FileUtil.newSmbFile(remoteFile.getPath() + File.separator + fileName + File.separator);
						if (!targetFile.exists() || !targetFile.isDirectory()) {
							targetFile.mkdirs();
						}
						copy2SmbWithDirectory(file, targetFile);
					} else {
						String fileName = file.getName();
						SmbFile targetFile = FileUtil.newSmbFile(remoteFile.getPath() + File.separator + fileName + File.separator);
						copy2SmbWithDirectory(file, targetFile);
					}
				}
			} else {
				in = new BufferedInputStream(new FileInputStream(localFile));
				out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
				byte[] buffer = new byte[1024];
				while (in.read(buffer) != -1) {
					out.write(buffer);
					buffer = new byte[1024];
				}
			}
		} finally {
			try {
				if (null != out) {
					out.close();
				}
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param localFile
	 * @param remoteFile
	 * @throws IOException 
	 */
	public static void copy2Smb(SmbFile localFile, SmbFile remoteFile) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new SmbFileInputStream(localFile));
			out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
			byte[] buffer = new byte[1024];
			while (in.read(buffer) != -1) {
				out.write(buffer);
				buffer = new byte[1024];
			}
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param localFile
	 * @param remoteFile
	 * @throws IOException 
	 */
	public static void copy2Smb(byte[] buffer, SmbFile remoteFile) throws IOException {
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
			out.write(buffer);
			buffer = new byte[1024];
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
