package com.netfinworks.member.gateway.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BindingMemberAction {

	@RequestMapping(value="/bindingmember.htm", method = RequestMethod.GET)
    public String page(ModelMap model) {

        return "bindingmember";
    }
}
