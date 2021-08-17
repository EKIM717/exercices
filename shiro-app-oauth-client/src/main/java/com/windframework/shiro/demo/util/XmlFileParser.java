/**
 * 
 */
package com.windframework.shiro.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lijk
 *
 */
public final class XmlFileParser {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 是否在解析的时候进行验证
	 */
	private static boolean VALIDATING_OF_PARSER = false;

	private static String CLASSPATH = null;
	
	private Document doc = DocumentHelper.createDocument();
	
	public XmlFileParser() {
		try {
			CLASSPATH = XmlFileParser.class.getClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			logger.info("CLASSPATH 加载失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出xml文件
	 * @param is
	 * @param file
	 * @throws IOException
	 */
	public static void writeXml(InputStream is, File file) throws IOException {
		FileOutputStream fos = null;
		file = FileUtil.fileCreate(file.getParentFile().getAbsolutePath(), file.getName());
		try {
			//打开一个已存在文件的输出流
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//将输入流is写入文件输出流fos中
		int ch = 0;
		try {
			while ((ch = is.read()) != -1) {
				fos.write(ch);
			}
		} finally {
			fos.close();
			is.close();
		}
	}

	/**
	 * 从指定的文件路径创建Document对象
	 * @param path XML数据路径
	 * @param filename 文件名，是否带后缀[.xml]均可
	 */
	public void createDocument(String path, String filename) throws Exception {
		path = path.trim();
		filename = filename.trim();

		if (!filename.substring(filename.lastIndexOf(".") + 1).equals("xml"))
			filename += ".xml";

		String fullPath = CLASSPATH + "/" + path + "/" + filename;
		createDocument(new File(fullPath.replaceAll("(/\\s*)+", "/")));
	}

	/**
	 * 从指定的文件对象创建Document对象
	 * @param path XML数据文件对象
	 */
	public void createDocument(File file) throws Exception {
		createDocument(new FileInputStream(file));
	}

	/**
	 * 从指定的输入流创建Document对象
	 * @param path XML数据输入流对象
	 */
	public void createDocument(InputStream is) throws Exception {
		SAXReader reader = new SAXReader();
		if (VALIDATING_OF_PARSER) {
			reader.setValidation(true);
			reader.setProperty(
					"http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");
		}
		doc = reader.read(is);
	}

	/**
	 * 得到根节点
	 * @return 根节点
	 */
	public Element getRoot() {
		return doc.getRootElement();
	}
	
	public Element getElement(Element e, String childName) {
		return e.element(childName);
	}
	
	public List<Element> getElements(Element e, String childName) {
		List<Element> ret = new ArrayList<Element>();
		for (Iterator<?> it = e.elements(childName).iterator(); it.hasNext();)
			ret.add((Element) it.next());
		return ret;
	}
	
	public List<Element> getElements(Element e) {
		List<Element> ret = new ArrayList<Element>();
		for (Iterator<?> it = e.elements().iterator(); it.hasNext();)
			ret.add((Element) it.next());
		return ret;
	}
	
	/**
	 * 得到指定节点下指定路径的元素值
	 * @param e 节点
	 * @param childName 下一节点名
	 * @return
	 */
	public String getText(Element e, String childName) {
		return e.elementText(childName);
	}
	
	public List<String> getTexts(Element e, String childName) {
		List<Element> el = this.getElements(e, childName);
		List<String> ret = new ArrayList<String>();
		for (Element element : el)
			ret.add(element.getText());
		return ret;
	}
	
	public List<String> getTexts(Element e) {
		List<String> ret = new ArrayList<String>();
		for (Element element : this.getElements(e))
			ret.add(element.getText());
		return ret;
	}
	
	/**
	 * 得到指定节点下指定路径的元素值
	 * @param parent 开始节点
	 * @param xPath XPath路径
	 * @return 节点值
	 */
	public static String getNodeText(Node parent, String xPath) {
		Node selectNode = parent.selectSingleNode(xPath);
		if (null == selectNode) {
			return null;
		}
		return selectNode.getText();
	}

	/**
	 * 设置在解析过程中是否验证
	 * @param validating 指定在解析过程中是否验证
	 */
	public static void setValidating(boolean validating) {
		VALIDATING_OF_PARSER = validating;
	}

	/**
	 * 确定在解析过程中是否进行验证
	 * @return 指出在解析过程中是否进行验证
	 */
	public static boolean isValidating() {
		return VALIDATING_OF_PARSER;
	}

}
