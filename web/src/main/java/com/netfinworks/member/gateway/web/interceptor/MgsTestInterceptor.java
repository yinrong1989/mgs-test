/**
 * 
 */
package com.netfinworks.member.gateway.web.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.netfinworks.member.gateway.lang.util.GlobalResource;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: MgsTestInterceptor.java, v 0.1 2013-12-19 下午2:24:14 fjl Exp $
 */
public class MgsTestInterceptor implements HandlerInterceptor {

    @Resource
    private GlobalResource globalResource;
    
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                                Exception arg3) throws Exception {

    }


    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                           ModelAndView mav) throws Exception {
        Map<String,Object> model = mav.getModel();
        
        model.put("partner_id", globalResource.get("partner_id"));
        model.put("identity_type", globalResource.get("identity_type"));
        
        model.put("md5_key", globalResource.get("md5.key"));
        model.put("merchant_private_key", globalResource.get("merchant.private.key"));
        model.put("wallet_public_key", globalResource.get("wallet.public.key"));
        
        model.put("page", mav.getViewName());
    }


    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        return true;
    }

}
