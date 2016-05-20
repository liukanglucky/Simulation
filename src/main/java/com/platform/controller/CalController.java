package com.platform.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.net.ConvertResult;
import com.platform.util.FileUtil;

@Controller
@RequestMapping("/")
public class CalController extends BaseJsonAction{
	
    @Value("#{configProperties['jni.mtpath']}")
    private String mtpath ;
    
	@RequestMapping("calManage")
    public ModelAndView calManage(ModelMap modelMap){
        return new ModelAndView("cal");
    }
	
	@RequestMapping("loadMt")
	public void loadMt() throws IOException{
		System.out.println("------------mt path is "+mtpath);
		byte[] result = (new FileUtil()).getContentByNIO(mtpath);
		String data  = ConvertResult.convertMt(result);
		this.setData(data);
		this.outPut();
		return;
	}
}
