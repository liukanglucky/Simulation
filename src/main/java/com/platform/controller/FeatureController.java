package com.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.Feature;
import com.platform.model.PageBean;
import com.platform.service.impl.FeatureServiceImpl;

@Controller
@RequestMapping("/")
public class FeatureController extends BaseJsonAction{
	
	@Autowired
	private FeatureServiceImpl fsi;
	
	@RequestMapping("featureManage")
    public ModelAndView featureManage(ModelMap modelMap){
		int recordCount = fsi.countFeature().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<Feature> list = fsi.findFeaturesByPage(page); 
		modelMap.addAttribute("featureList",list);
        return new ModelAndView("feature");
    }
	
	@RequestMapping("queryFeatureByPage")
    public void queryFeatureByPage(int currentPage,int pageSize){
		int recordCount = fsi.countFeature().getRecordCount();
		PageBean page =new PageBean(recordCount,pageSize,currentPage);
		List<Feature> list = fsi.findFeaturesByPage(page); 
        this.data=list;
        this.page=page;
        this.outPutPage();
    }
	
	@RequestMapping("addFeature")
    public ModelAndView addFeature(String name,ModelMap modelMap){
		Feature feature=new Feature();
		feature.setName(name);
		int i = fsi.insertFeature(feature);
		modelMap.addAttribute("info",i);
		int recordCount = fsi.countFeature().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<Feature> list = fsi.findFeaturesByPage(page); 
		modelMap.addAttribute("featureList",list);
        return new ModelAndView("feature");
    }
	
	@RequestMapping("updateFeature")
    public ModelAndView updateFeature(int id,String name,ModelMap modelMap){
		Feature feature=new Feature();
		feature.setId(id);
		feature.setName(name);
		int i = fsi.updateFeature(feature);
		modelMap.addAttribute("info",i);
		int recordCount = fsi.countFeature().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<Feature> list = fsi.findFeaturesByPage(page); 
		modelMap.addAttribute("featureList",list);
        return new ModelAndView("feature");
    }
	
	@RequestMapping("queryFeaturesByName")
    public  ModelAndView queryFeaturesByName(String name,ModelMap modelMap){
		List<Feature> list = fsi.findFeaturesByName(name);
		modelMap.addAttribute("featureList",list);
        return new ModelAndView("feature");
    }
	
	@RequestMapping("queryFeatureById")
    public  void queryFeatureById(HttpServletRequest request){
		int id = Integer.valueOf(request.getParameter("id")).intValue();
        this.setData(fsi.findFeatureById(id)); 
        this.outPut();
    }
	
	@RequestMapping("deleteFeatures")
    public  void deleteFeatures(String idList){
		String id[] =idList.split(",");
        for(int i=0;i<id.length;i++){
        	fsi.deleteFeature(Integer.valueOf(id[i]).intValue());
        }
        int recordCount = fsi.countFeature().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		List<Feature> list = fsi.findFeaturesByPage(page); 
		this.data=list;
        this.page=page;
        this.outPutPage();
    }
}
