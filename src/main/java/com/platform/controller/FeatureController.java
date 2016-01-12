package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class FeatureController {
	
	@RequestMapping("featureManage")
    public ModelAndView featureManage(ModelMap modelMap){
        return new ModelAndView("feature");
    }
	
}
