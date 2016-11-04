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
 * @version $Id: BankcardAction.java, v 0.1 2013-12-19 下午3:42:38 fjl Exp $
 */
@Controller
public class BankcardAction {

    @RequestMapping(value="/bankcard.htm", method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "bankcard";
    }

    @RequestMapping(value="/unbundlingbankcard.htm", method = RequestMethod.GET)
    public String page2(ModelMap model) {

        return "unbundlingbankcard";
    }

    @RequestMapping(value="/querycardbin.htm", method = RequestMethod.GET)
    public String page3(ModelMap model) {

        return "querycardbin";
    }

}
