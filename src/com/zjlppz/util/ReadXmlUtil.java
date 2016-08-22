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
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-16
 * @�����汾��1.0
 * 
 * @�޸��ߣ�
 * @�޸İ汾��
 * @�޸�ʱ�䣺
 * @�޸�������
 * @��ʷ�汾��
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

	//��ȡ�����ļ�����Ŀ�е�webroot�µ�webinf�µ�����·��
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
		
		// ���� SERVLET_CONTEXT_PATH ����WebRoot��·��
		String path = SERVLET_CONTEXT_PATH + "/" + "WEB-INF/sql-mapping.xml";
		path = path.replaceAll("%20", " ");//ת���ո�
		return path;
	}

	private static Document getDocument() {
		// 1���ĵ���������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2�����ĵ����������õ��ĵ�������
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		// 3�����ĵ��������õ��ĵ�����(Document)
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
			//ѭ��������ȡÿһ��
			Node book = elementList.item(i);
			//ͨ��Node�����getAttributes()������ȡ����ֵ
			NamedNodeMap propertyAttributes = book.getAttributes();
			String key = propertyAttributes.item(0).getNodeValue();
			String value = book.getTextContent();
			eleMap.put(key, value);
		}
		return eleMap;
	}

}
