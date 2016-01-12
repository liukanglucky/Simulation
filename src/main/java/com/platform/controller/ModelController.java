package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ModelController {
	
	@RequestMapping("modelManage")
    public ModelAndView modelManage(ModelMap modelMap){
        return new ModelAndView("model");
    }
	
}
