package com.netfinworks.member.gateway.lang.type;

public interface StringCaster<T> {
	T castFromString(String str);
}
