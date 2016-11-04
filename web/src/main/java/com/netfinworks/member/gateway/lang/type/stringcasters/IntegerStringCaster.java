package com.netfinworks.member.gateway.lang.type.stringcasters;

import com.netfinworks.member.gateway.lang.type.StringCaster;


public class IntegerStringCaster implements StringCaster<Integer> {
	private static IntegerStringCaster instance;
	private IntegerStringCaster(){}

	/**
	 * 获取单例实例
	 */
	public static IntegerStringCaster getInstance(){
		instance = new IntegerStringCaster();
		return instance;
	}
	@Override
	public Integer castFromString(String str) {
		return Integer.valueOf(str);
	}
}
