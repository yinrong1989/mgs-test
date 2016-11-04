package com.netfinworks.member.gateway.lang.type.stringcasters;

import java.math.BigDecimal;

import com.netfinworks.member.gateway.lang.type.StringCaster;

public class BigDecimalStringCaster implements StringCaster<BigDecimal> {
	private static BigDecimalStringCaster instance;
	private BigDecimalStringCaster(){}
	
	/**
	 * 获取单例实例
	 */
	public static BigDecimalStringCaster getInstance(){
		instance = new BigDecimalStringCaster();
		return instance;
	}
	@Override
	public BigDecimal castFromString(String str) {
		return new BigDecimal(str);
	}
}
