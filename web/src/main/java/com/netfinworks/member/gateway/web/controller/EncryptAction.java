/**
 * 
 */
package com.netfinworks.member.gateway.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netfinworks.member.gateway.common.GatewayConstant;
import com.netfinworks.member.gateway.enums.BaseField;
import com.netfinworks.member.gateway.service.SecurityService;
import com.netfinworks.member.gateway.util.DataConvertUtil;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: EncryptAction.java, v 0.1 2013-12-23 下午3:40:25 fjl Exp $
 */
@Controller
public class EncryptAction {

    @Resource
    private SecurityService securityService;

    @RequestMapping(value = "/encrypt.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> page(HttpServletRequest request, ModelMap model) throws Exception {
        Map<String, String> data = DataConvertUtil.paramCharsetConvert(request.getParameterMap(),
            GatewayConstant.charset_utf_8);

        
        String inputCharset = data.get(BaseField.INPUT_CHARSET.getCode());
        
        //卡号与户名加密
        securityService.encrypt(data, inputCharset);
        
        return data;
    }

}
