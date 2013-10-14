package com.toolkit.lang;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * XML和java对象的相互转换
 */
public abstract class XmlConverter {
	
	final static public String Object2XML(Object obj) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(bos);
		xmlEncoder.writeObject(obj);
		xmlEncoder.close();
		
		try {
			return new String(bos.toByteArray(), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	final static public Object XML2Object(String xml) {
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new ByteArrayInputStream(
					xml.getBytes("iso8859-1")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		XMLDecoder xmlDecoder = new XMLDecoder(bis);
		Object obj = xmlDecoder.readObject();
		xmlDecoder.close();
		return obj;
	}
	
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><pos><po name=\"user\" class=\"java.lang.String\" table=\"user\" id=\"id\"></po></pos></root>";
		Object object = XML2Object(xml);
		System.out.println(object);
	}
}
