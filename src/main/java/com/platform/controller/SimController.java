package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SimController {
	
	@RequestMapping("simManage")
    public ModelAndView simManage(ModelMap modelMap){
        return new ModelAndView("sim");
    }
	
	@RequestMapping("simAdd")
    public ModelAndView simAdd(ModelMap modelMap){
        return new ModelAndView("simAdd");
    }
	
}
