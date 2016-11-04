/**
 * 
 */
package com.netfinworks.member.gateway.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>注释</p>
 * @author fjl
 * @version $Id: EnterpriseAction.java, v 0.1 2013-12-19 上午10:13:09 fjl Exp $
 */
@Controller
public class    EnterpriseAction {

    @RequestMapping(value="/enterprise.htm",method = RequestMethod.GET)
    public String page1(ModelMap model) {

        return "enterprise";
    }
    
    @RequestMapping(value="/enterpriseinfo.htm",method = RequestMethod.GET)
    public String page2(ModelMap model) {

        return "enterpriseinfo";
    }
    
    
}
