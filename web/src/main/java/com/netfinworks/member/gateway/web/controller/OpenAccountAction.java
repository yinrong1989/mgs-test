/*
 * Copyright 2015 netfinworks.com, Inc. All rights reserved.
 */
package com.netfinworks.member.gateway.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>开户处理类</p>
 *
 * @author matrix
 * @version $Id: OpenAccountAction.java, v 0.1 2015年7月10日 上午10:25:08 shucunbin Exp $
 */

@Controller
public class OpenAccountAction {
    
    /**
     * 进入开户页面
     * 
     * @param model 模型对象
     * @return 视图名称（tiles里定义名称）
     */
    @RequestMapping(value = "/openaccount.htm",method = RequestMethod.GET)
    public String page(ModelMap model) {
        return "openaccount";
    }
}