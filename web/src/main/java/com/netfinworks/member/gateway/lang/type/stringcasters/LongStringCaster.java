package com.netfinworks.member.gateway.lang.type.stringcasters;

import com.netfinworks.member.gateway.lang.type.StringCaster;


public class LongStringCaster implements StringCaster<Long> {
	private static LongStringCaster instance;
	private LongStringCaster(){}

	/**
	 * 获取单例实例
	 */
	public static LongStringCaster getInstance(){
		instance = new LongStringCaster();
		return instance;
	}
	@Override
	public Long castFromString(String str) {
		return Long.parseLong(str);
	}
}
