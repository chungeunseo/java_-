package com.ssafy;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DOMTest {
	public static void main(String[] args) throws Exception {
		//공장
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		//일꾼
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//일꾼에게 문서 주기=파싱
		Document doc = builder.parse("persons.xml");
		NodeList nameList = doc.getElementsByTagName("name");
		for (int i =0;i<nameList.getLength();i++) {
			Node n = nameList.item(i);//<name>나길동</name>
			System.out.println(n.getTextContent());
		}
	}

}
