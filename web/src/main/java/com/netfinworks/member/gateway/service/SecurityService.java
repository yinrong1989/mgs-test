/**
 * 
 */
package com.netfinworks.member.gateway.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.netfinworks.mag.util.sign.MD5;
import com.netfinworks.mag.util.sign.RSA;
import com.netfinworks.mag.util.tools.MagCore;
import com.netfinworks.member.gateway.enums.BaseField;
import com.netfinworks.member.gateway.enums.SignType;
import com.netfinworks.member.gateway.lang.util.GlobalResource;
import com.netfinworks.member.gateway.model.SignData;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: SecurityService.java, v 0.1 2013-12-20 下午3:03:30 fjl Exp $
 */
@Service
public class SecurityService {
    private static Logger  logger = LoggerFactory.getLogger(SecurityService.class);

    @Resource
    private GlobalResource globalResource;

    /**
     * 签名
     * @param data
     * @param charset
     * @param signType
     * @return
     */
    public SignData sign(Map<String, String> data, String charset, String signType) {
        SignData signData = new SignData();
        signData.setSignType(signType);

        Map<String, String> src = MagCore.paraFilter(data);
        if(logger.isInfoEnabled()){
            logger.info("签名原字符串：{}",MagCore.createLinkString(src,false));
        }
        try {
            if (SignType.RSA.getCode().equals(signType)) {
                signData.setSign(MagCore.buildRequestByRSA(src,
                    (String) globalResource.get("merchant.private.key"), charset));
                signData.setSuccess(true);
            } else if (SignType.MD5.getCode().equals(signType)) {
                signData.setSign(MagCore.buildRequestByMD5(src,
                    (String) globalResource.get("md5.key"), charset));
                signData.setSuccess(true);
            } else {
                signData.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            signData.setSuccess(false);
        }
        
        try {
            Map<String, String> result = MagCore.buildRequestPara(src, signType, (String) globalResource.get("merchant.private.key"), charset);
            //System.out.println(result);
            String linkString = MagCore.createLinkString(result, true);
            signData.setSignLinkStr(linkString);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            signData.setSignLinkStr("错误拼接请求信息");
        }
        return signData;
    }

    /**
     * 验证签名
     * @param map
     * @param charset
     * @param signType
     * @return
     */
    public boolean verify(Map<String, String> map, String charset, String sign,String signType) {
        Map<String, String> tmp = MagCore.paraFilter(map);
        String str = MagCore.createLinkString(tmp, false);
        if (signType.equalsIgnoreCase("MD5")) {
            return verifyMd5(str, sign, charset);
        } else if (signType.equalsIgnoreCase("RSA")) {
            return verifyRSA(str, sign, charset);
        }
        return false;
    }

    private boolean verifyMd5(String src, String sign, String charset) {
        boolean result = false;
        if (logger.isInfoEnabled()) {
            logger.info("verify sign with MD5:src ={},sign={}", new Object[] { src, sign });
        }
        try {
            result = MD5.verify(src, sign, (String)globalResource.get("md5.key"), charset);
        } catch (Exception e) {
            logger.error("MD5 verify failure:src ={},sign={}", new Object[] { src, sign });
            logger.error("MD5 verify failure", e);
        }
        return result;
    }

    private boolean verifyRSA(String src, String sign, String charset) {
        boolean result = false;
        if (logger.isInfoEnabled()) {
            logger.info("verify sign with RSA:src ={},sign={}", new Object[] { src, sign });
        }
        try {
            result = RSA.verify(src, sign, (String)globalResource.get("wallet.public.key"), charset);
        } catch (Exception e) {
            logger.error("RSA verify failure:src ={},sign={}", new Object[] { src, sign });
            logger.error("RSA verify failure", e);
        }
        return result;
    }
    
    /**
     * 使用钱包公钥加密
     * @param src
     * @param charset
     * @return
     */
    public String encrypt(String src ,String charset){
        if (logger.isDebugEnabled()) {
            logger.debug("encrypt src:{} ,charset:{} with:RSA", src, charset);
        }

        try {
            byte[] bytes = RSA.encryptByPublicKey(src.getBytes(charset), (String)globalResource.get("wallet.public.key"));
            return Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            logger.error("RSA encrypt failure:src={},charset={}",src, charset);
            logger.error("RSA encrypt failure",e);
        }
        return null;
    }
    
    
    public void encrypt(Map<String, String> data,String charset){
        String service = data.get(BaseField.SERVICE.getCode());
        if("create_bank_card".equals(service)){
            String bank_account_no = data.get("bank_account_no_src");
            String account_name = data.get("account_name_src");
            if(StringUtils.hasText(bank_account_no)){
                String enc = encrypt(bank_account_no, charset);
                data.put("bank_account_no", enc);
            }
            
            if(StringUtils.hasText(account_name)){
                String enc = encrypt(account_name, charset);
                data.put("account_name", enc);
            }
        }
    }
    
    public void filter(Map<String, String> data){
        if(data.containsKey("bank_account_no_src")){
            data.remove("bank_account_no_src");
        }
        if(data.containsKey("account_name_src")){
            data.remove("account_name_src");
        }
    }
}
