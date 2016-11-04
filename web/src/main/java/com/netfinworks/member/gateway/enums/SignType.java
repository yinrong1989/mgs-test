package com.netfinworks.member.gateway.enums;

/**
 * <p>支持的签名类型</p>
 * @author leelun
 * @version $Id: SignTypeKind.java, v 0.1 2013-9-2 下午2:29:35 lilun Exp $
 */
public enum SignType {

    MD5("MD5"), RSA("RSA");

    private String code;

    private SignType(String code) {
        this.code = code;

    }

    public static SignType getByCode(String code) {
        for (SignType ls : SignType.values()) {
            if (ls.code.equalsIgnoreCase(code)) {
                return ls;
            }
        }
        return null;
    }

    public boolean equalsCode(String code) {
        return getCode().equalsIgnoreCase(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
