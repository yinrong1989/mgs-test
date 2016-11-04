package com.netfinworks.member.gateway.lang.util;

public class GlobalResource {
	private static GlobalResource instance;
	private GlobalResource(){}

	/**
	 * 获取单例实例
	 */
	public synchronized static GlobalResource getInstance(){
		if(instance == null){
			instance = new GlobalResource();
		}
		return instance;
	}

	private XmlResource xmlResource;
	public void setXmlResourceFile(String xmlResourceFile) {
		xmlResource = XmlResource.localizationLoad(xmlResourceFile);
	}

	public <T> T get(String key){
		if (xmlResource != null){
			return (T) xmlResource.get(key);
		}
		return null;
	}

	public <T> T get(String key,T defaultValue){
		if (xmlResource != null) {
			return (T)xmlResource.get(key,defaultValue);
		}
		return defaultValue;
	}
}
