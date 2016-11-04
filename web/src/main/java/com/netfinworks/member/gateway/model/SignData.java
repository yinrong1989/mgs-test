/**
 * 
 */
package com.netfinworks.member.gateway.model;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: SignData.java, v 0.1 2013-12-19 下午7:40:43 fjl Exp $
 */
public class SignData {
    private String  src;

    private String  sign;

    private String  signType;

    private boolean success;
    
    private String  signLinkStr;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSignLinkStr() {
        return signLinkStr;
    }

    public void setSignLinkStr(String signLinkStr) {
        this.signLinkStr = signLinkStr;
    }
}
