package com.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.PageBean;
import com.platform.model.Simulation;
import com.platform.service.impl.SimServiceImpl;

@Controller
@RequestMapping("/")
public class SimController extends BaseJsonAction{
	@Autowired
	private SimServiceImpl ssi;
	
	@RequestMapping("simManage")
    public ModelAndView simManage(ModelMap modelMap){
		int recordCount = ssi.countSim().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<Simulation> list = ssi.findSimsByPage(page);
		modelMap.addAttribute("simList",list);
        return new ModelAndView("sim");
    }
	
	@RequestMapping("querySimByPage")
    public void querySimByPage(int currentPage,int pageSize){
		int recordCount = ssi.countSim().getRecordCount();
		PageBean page =new PageBean(recordCount,pageSize,currentPage);
		List<Simulation> list = ssi.findSimsByPage(page);
        this.data=list;
        this.page=page;
        this.outPutPage();
    }
	
	@RequestMapping("addSim")
    public ModelAndView addSim(String name,ModelMap modelMap){
		Simulation simulation=new Simulation();
		simulation.setName(name);
		int i = ssi.insertSim(simulation);
		modelMap.addAttribute("info",i);
		int recordCount = ssi.countSim().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<Simulation> list = ssi.findSimsByPage(page);
		modelMap.addAttribute("simList",list);
        return new ModelAndView("sim");
    }
	
	@RequestMapping("updateSim")
    public ModelAndView updateSim(int id,String name,ModelMap modelMap){
		Simulation simulation=new Simulation();
		simulation.setId(id);
		simulation.setName(name);
		int i = ssi.updateSim(simulation);
		modelMap.addAttribute("info",i);
		int recordCount = ssi.countSim().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<Simulation> list = ssi.findSimsByPage(page);
		modelMap.addAttribute("simList",list);
        return new ModelAndView("sim");
    }
	
	@RequestMapping("querySimsByName")
    public  ModelAndView querySimsByName(String name,ModelMap modelMap){
		List<Simulation> list = ssi.findSimsByName(name);
		modelMap.addAttribute("simList",list);
        return new ModelAndView("sim");
    }
	
	@RequestMapping("querySimById")
    public  void querySimById(HttpServletRequest request){
		int id = Integer.valueOf(request.getParameter("id")).intValue();
        this.setData(ssi.findSimById(id)); 
        this.outPut();
    }
	
	@RequestMapping("deleteSims")
    public  void BaseJsonAction(String idList){
		String id[] =idList.split(",");
        for(int i=0;i<id.length;i++){
        	ssi.deleteSim(Integer.valueOf(id[i]).intValue());
        }
        int recordCount = ssi.countSim().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		List<Simulation> list = ssi.findSimsByPage(page);
		this.data=list;
        this.page=page;
        this.outPutPage();
    }
	
}
