package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class QueryController {
	
	@RequestMapping("querySim")
    public ModelAndView calManage(ModelMap modelMap){
        return new ModelAndView("query");
    }
	
}