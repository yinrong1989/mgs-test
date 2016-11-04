package com.netfinworks.member.gateway.lang.type.stringcasters;

import com.netfinworks.member.gateway.lang.type.StringCaster;


public class DoubleStringCaster implements StringCaster<Double> {
	private static DoubleStringCaster instance;
	private DoubleStringCaster(){}
	
	/**
	 * 获取单例实例
	 */
	public static DoubleStringCaster getInstance(){
		instance = new DoubleStringCaster();
		return instance;
	}
	@Override
	public Double castFromString(String str) {
		return Double.parseDouble(str);
	}
}
