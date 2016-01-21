package com.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.Model;
import com.platform.service.impl.ModelServiceImpl;

@Controller
@RequestMapping("/")
public class ModelController extends BaseJsonAction{
	@Autowired
	private ModelServiceImpl msi;
	
	@RequestMapping("modelManage")
    public ModelAndView modelManage(ModelMap modelMap){
		List<Model> list = msi.findAllModel(); 
		modelMap.addAttribute("modelList",list);
        return new ModelAndView("model");
    }
	
	@RequestMapping("addModel")
    public ModelAndView addModel(String name,ModelMap modelMap){
		Model model=new Model();
		model.setName(name);
		int i = msi.insertModel(model);
		modelMap.addAttribute("info",i);
		List<Model> list = msi.findAllModel(); 
		modelMap.addAttribute("modelList",list);
        return new ModelAndView("model");
    }
	
	@RequestMapping("updateModel")
    public ModelAndView updateModel(int id,String name,ModelMap modelMap){
		Model model=new Model();
		model.setId(id);
		model.setName(name);
		int i = msi.updateModel(model);
		modelMap.addAttribute("info",i);
		List<Model> list = msi.findAllModel(); 
		modelMap.addAttribute("modelList",list);
        return new ModelAndView("model");
    }
	
	@RequestMapping("queryModelsByName")
    public ModelAndView queryModelByName(String name,ModelMap modelMap){
		List<Model> list = msi.findModelsByName(name); 
		modelMap.addAttribute("modelList",list);
        return new ModelAndView("model");
    }
	
	@RequestMapping("queryModelById")
    public  void queryModelById(HttpServletRequest request){
		int id = Integer.valueOf(request.getParameter("id")).intValue();
        this.setData(msi.findModelById(id)); 
        this.outPut();
    }
	
	@RequestMapping("deleteModels")
    public  void deleteModels(String idList){
		String id[] =idList.split(",");
        for(int i=0;i<id.length;i++){
        	msi.deleteModel(Integer.valueOf(id[i]).intValue());
        }
        List<Model> list = msi.findAllModel(); 
        this.setData(list);
        this.outPut();
    }
}
