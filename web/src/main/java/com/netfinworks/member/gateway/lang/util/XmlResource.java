package com.netfinworks.member.gateway.lang.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.netfinworks.member.gateway.lang.type.StringCaster;
import com.netfinworks.member.gateway.lang.type.stringcasters.*;

/**
 * xml资源加载器
 */
public class XmlResource {
	private static Map<String, StringCaster<?>> stringCasters = new HashMap<String, StringCaster<?>>();
	static {
		stringCasters.put("int", IntegerStringCaster.getInstance());
		stringCasters.put("integer", IntegerStringCaster.getInstance());
		stringCasters.put(Integer.class.getName(), IntegerStringCaster.getInstance());

		stringCasters.put("long", LongStringCaster.getInstance());
		stringCasters.put(Long.class.getName(), LongStringCaster.getInstance());

		stringCasters.put("float", FloatStringCaster.getInstance());
		stringCasters.put(Float.class.getName(), FloatStringCaster.getInstance());

		stringCasters.put("double", DoubleStringCaster.getInstance());
		stringCasters.put(Double.class.getName(), DoubleStringCaster.getInstance());

		stringCasters.put("string", StringStringCaster.getInstance());
		stringCasters.put(String.class.getName(), StringStringCaster.getInstance());

		stringCasters.put("bigdecimal", BigDecimalStringCaster.getInstance());
		stringCasters.put(BigDecimal.class.getName(), BigDecimalStringCaster.getInstance());

		stringCasters.put("bool", BooleanStringCaster.getInstance());
		stringCasters.put("boolean", BooleanStringCaster.getInstance());
		stringCasters.put(Boolean.class.getName(), BooleanStringCaster.getInstance());


	}
	

	private Map<String,Object> properties;

	private void addProperty(String name,Object value){
		if (properties == null){
			properties = new HashMap<String, Object>();
		}
		properties.put(name,value);
	}

	/**
	 * 从xml输入流加载资源
	 * @param in
	 * @return
	 */
	public static  XmlResource load(InputStream in){
		try {
			Document document = new SAXReader().read(in);
			//解析document
			Element root = document.getRootElement();
			XmlResource instance = new XmlResource();

			List<Element> elements = root.elements();
			for(Element element : elements){
				String type = element.getName();
				String name = element.attributeValue("name");
				//处理array
				if ("array".equals(type) || "list".equals(type)){
					ListResource listResource = new ListResource();
					instance.addProperty(name, listResource);
					List<Element> subs = element.elements();
					for(Element sub : subs){
						String subType = sub.getName();
						String subName = sub.attributeValue("name");
						String subValue = sub.getTextTrim();
						StringCaster<?> caster = stringCasters.get(subType);
						if (caster != null){
							listResource.list.add(subValue);
						}
					}
				}else{
					String value = element.getText();
					StringCaster<?> caster = stringCasters.get(type);
					if (caster != null){
						instance.addProperty(name, caster.castFromString(value));
					}
				}
			}

			return instance;
		} catch (DocumentException e) {
		    throw new RuntimeException("资源文件解析出错",e);
		}
	}

	/**
	 * 本地化加载
	 * @param xmlFile
	 * @param locale
	 * @return
	 */
	public static  XmlResource localizationLoad(String xmlFile, Locale locale){
		String filePrefix = xmlFile.substring(0, xmlFile.lastIndexOf('.'));

		String country = locale.getCountry();
		String lang = locale.getLanguage();

		File f = new File(filePrefix + "_" + lang + "_" + country + ".xml");
		if (!f.exists() || f.isDirectory()){
			f = new File(filePrefix + "_" + lang + ".xml");
			if (!f.exists() || f.isDirectory()){
				f = new File(xmlFile);
			}
		}

		try {
			return load(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("资源文件没有找到",e);
		}

	}

	public static XmlResource localizationLoad(String xmlFile){
		Locale locale = Locale.getDefault();
		return localizationLoad(xmlFile,locale);
	}

	public <T> T get(String key){
		return (T)get(key,null);
	}

	public <T> T get(String key,T defaultValue){
		if (properties != null) {
			Object value = properties.get(key);
			if (value != null){
				if (value instanceof ListResource){
					return  (T)((ListResource)value).list;
				}else{
					return (T)value;
				}
			}
			return defaultValue;
		}
		return defaultValue;
	}

	private static class ListResource {
		private List<Object> list = new ArrayList<Object>();
	}

}
