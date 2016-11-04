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
 * @version $Id: MobileAction.java, v 0.1 2013-12-19 下午3:17:06 fjl Exp $
 */
@Controller
@RequestMapping("/mobile.htm")
public class MobileAction {

    @RequestMapping(method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "mobile";
    }
}
