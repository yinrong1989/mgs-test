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
 * @version $Id: BalanceAction.java, v 0.1 2013-12-19 下午3:41:39 fjl Exp $
 */
@Controller
@RequestMapping("/balance.htm")
public class BalanceAction {

    
    @RequestMapping(method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "balance";
    }
}
