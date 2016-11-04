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
import com.netfinworks.member.gateway.model.SignData;
import com.netfinworks.member.gateway.service.SecurityService;
import com.netfinworks.member.gateway.util.DataConvertUtil;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: SignAction.java, v 0.1 2013-12-19 下午4:48:30 fjl Exp $
 */
@Controller
public class SignAction {
    @Resource
    private SecurityService securityService;

    @RequestMapping(value = "/sign.json", method = RequestMethod.POST)
    @ResponseBody
    public SignData page(HttpServletRequest request, ModelMap model) throws Exception {
        Map<String, String> data = DataConvertUtil.paramCharsetConvert(request.getParameterMap(),
            GatewayConstant.charset_utf_8);

        String sign_type = data.get(BaseField.SIGN_TYPE.getCode());
        String inputCharset = data.get(BaseField.INPUT_CHARSET.getCode());
        securityService.filter(data);
        return securityService.sign(data, inputCharset, sign_type);
    }
}
