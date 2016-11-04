package com.netfinworks.member.gateway.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * <p>注释</p>
 * @author fjl
 * @version $Id: IndexAction.java, v 0.1 2013-12-18 下午3:55:42 fjl Exp $
 */
@Controller
public class IndexAction {
    
    @RequestMapping(value = "/index.htm",method = RequestMethod.GET)
    public String home( ModelMap model) {

        return "index";
    }
}
