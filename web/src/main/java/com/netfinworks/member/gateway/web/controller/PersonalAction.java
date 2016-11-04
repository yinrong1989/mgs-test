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
 * @version $Id: PersonalAction.java, v 0.1 2013-12-18 下午3:55:17 fjl Exp $
 */
@Controller
public class PersonalAction {

    @RequestMapping(value="/personal.htm", method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "personal";
    }

    @RequestMapping(value="/personal2.htm", method = RequestMethod.GET)
    public String page2(ModelMap model) {

        return "personal2";
    }

    @RequestMapping(value="/personalinfo.htm", method = RequestMethod.GET)
    public String page3(ModelMap model) {

        return "personalinfo";
    }

    @RequestMapping(value="/personalmerchant.htm", method = RequestMethod.GET)
    public String page4(ModelMap model) {

        return "personalmerchant";
    }

    @RequestMapping(value="/merchant.htm", method = RequestMethod.GET)
    public String page5(ModelMap model) {

        return "merchant";
    }

    @RequestMapping(value="/bindingemail.htm", method = RequestMethod.GET)
    public String page6(ModelMap model) {

        return "bindingemail";
    }

    @RequestMapping(value="/updateaccountstatus.htm", method = RequestMethod.GET)
    public String page7(ModelMap model) {

        return "updateaccountstatus";
    }
}
