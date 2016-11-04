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
 * @version $Id: ActiveAction.java, v 0.1 2013-12-19 上午10:17:32 fjl Exp $
 */
@Controller
@RequestMapping("/active.htm")
public class ActiveAction {

    @RequestMapping(method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "active";
    }
}
