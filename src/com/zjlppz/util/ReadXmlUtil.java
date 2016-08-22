package com.zjlppz.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @创建作者：周健
 * @创建时间：2016-8-16
 * @创建版本：1.0
 * 
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
public class ReadXmlUtil {
	
//	private ReadXmlUtil readXmlUtil = null;
	
	private ReadXmlUtil(){
	}
	
//	public ReadXmlUtil newInstance(){
//		if(readXmlUtil==null){
//			readXmlUtil = new ReadXmlUtil();
//		}
//		return readXmlUtil;
//	}

	//获取配置文件在项目中的webroot下的webinf下的完整路径
	private static String filepath() {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = ClassLoader.getSystemClassLoader();
		}
		java.net.URL url2 = classLoader.getResource("");
		String ROOT_CLASS_PATH = url2.getPath() + "/";
		
		File rootFile = new File(ROOT_CLASS_PATH);
		String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";
		
		File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
		String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/";
		
		// 这里 SERVLET_CONTEXT_PATH 就是WebRoot的路径
		String path = SERVLET_CONTEXT_PATH + "/" + "WEB-INF/sql-mapping.xml";
		path = path.replaceAll("%20", " ");//转换空格
		return path;
	}

	private static Document getDocument() {
		// 1得文档构建工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2根据文档构建工厂得到文档构建器
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		// 3根据文档构建器得到文档对象(Document)
		File f = new File(filepath());
		Document document = null;
		try {
			document = db.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static Map<String, String> getElement(String elname) {
		Document document = getDocument();
		NodeList elementList = document.getElementsByTagName(elname);
		Map<String, String> eleMap = new HashMap<String, String>();
		for(int i = 0;i<elementList.getLength();i++){
			//循环遍历获取每一个
			Node book = elementList.item(i);
			//通过Node对象的getAttributes()方法获取属性值
			NamedNodeMap propertyAttributes = book.getAttributes();
			String key = propertyAttributes.item(0).getNodeValue();
			String value = book.getTextContent();
			eleMap.put(key, value);
		}
		return eleMap;
	}

}
