package com.netfinworks.member.gateway.lang.type.stringcasters;

import com.netfinworks.member.gateway.lang.type.StringCaster;

public class StringStringCaster implements StringCaster<String> {
	private static StringStringCaster instance;
	private StringStringCaster(){}

	/**
	 * 获取单例实例
	 */
	public static StringStringCaster getInstance(){
		instance = new StringStringCaster();
		return instance;
	}
	@Override
	public String castFromString(String str) {
		return str;
	}
}
