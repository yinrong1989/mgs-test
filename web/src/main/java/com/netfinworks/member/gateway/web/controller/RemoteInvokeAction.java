/**
 * 
 */
package com.netfinworks.member.gateway.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netfinworks.member.gateway.common.GatewayConstant;
import com.netfinworks.member.gateway.enums.BaseField;
import com.netfinworks.member.gateway.service.RemoteService;
import com.netfinworks.member.gateway.service.SecurityService;
import com.netfinworks.member.gateway.util.DataConvertUtil;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: RemoteInvokeAction.java, v 0.1 2013-12-20 下午2:13:50 fjl Exp $
 */
@Controller
public class RemoteInvokeAction {
    @Resource
    private RemoteService remoteService;
    
    @Resource
    private SecurityService securityService;

    @RequestMapping(value="/remoteService.json",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> post(HttpServletRequest request, ModelMap model) throws Exception {
        Map<String, String> data = DataConvertUtil.paramCharsetConvert(request.getParameterMap(),
            GatewayConstant.charset_utf_8);
        String sign_type = data.get(BaseField.SIGN_TYPE.getCode());
        String inputCharset = data.get(BaseField.INPUT_CHARSET.getCode());

        Map<String,String> result = null;
        try {
            securityService.filter(data);
            result = remoteService.invoke(data, inputCharset);
            String sign = result.get("sign");
            String success = result.get("is_success");
            if(StringUtils.hasText(sign)){
                boolean verifySign = securityService.verify(result, inputCharset,sign, sign_type);
                if(verifySign){
                    result.put("验证签名", "成功");
                }else{
                    result.put("验证签名", "失败");
                }
            }
            result.put("success", "false");
            if(StringUtils.hasText(success)){
                if("T".equals(success)){
                    result.put("success", "true");
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new HashMap<String,String>();
            result.put("success","false");
            result.put("error", e.getMessage());
            return result;
        }
    }
}
