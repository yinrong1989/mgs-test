package com.netfinworks.member.gateway.lang.type.stringcasters;

import com.netfinworks.member.gateway.lang.type.StringCaster;


public class BooleanStringCaster implements StringCaster<Boolean> {
	private static BooleanStringCaster instance;
	private BooleanStringCaster(){}
	
	/**
	 * 获取单例实例
	 */
	public static BooleanStringCaster getInstance(){
		instance = new BooleanStringCaster();
		return instance;
	}
	@Override
	public Boolean castFromString(String str) {
		return Boolean.parseBoolean(str);
	}
}
