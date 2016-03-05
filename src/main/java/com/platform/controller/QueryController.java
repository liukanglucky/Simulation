package com.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.ModelData;
import com.platform.model.PageBean;
import com.platform.model.QueryParameter;
import com.platform.model.User;
import com.platform.service.impl.ModelDataServiceImpl;

@Controller
@RequestMapping("/")
public class QueryController extends BaseJsonAction{
	@Autowired
	ModelDataServiceImpl mdsi = new ModelDataServiceImpl();
	
	@RequestMapping("query")
    public ModelAndView calManage(ModelMap modelMap){
        return new ModelAndView("query");
    }
	
	@RequestMapping("querySim")
    public void querySim(int dt,int mt,int sim,int stype,String comments,int currentPage,int pageSize){
		QueryParameter queryParameter = new QueryParameter(1, pageSize, currentPage);
		System.out.println("========================QueryController======================="+dt+mt+sim+stype+comments);
		queryParameter.setDt(dt);
		queryParameter.setMt(mt);
		queryParameter.setSim(sim);
		queryParameter.setStype(stype);
		int recordCount = mdsi.countModelData(queryParameter).getRecordCount();
		QueryParameter parameter = new  QueryParameter(recordCount, pageSize, currentPage);
		PageBean page =new PageBean(recordCount, pageSize, currentPage);
		parameter.setDt(dt);
		parameter.setMt(mt);
		parameter.setSim(sim);
		parameter.setStype(stype);
		List<ModelData> list = mdsi.querySim(parameter);
        this.data=list;
        this.page=page;
        this.outPutPage();
    }
	
	@RequestMapping("querySimById")
	public void querySimById(int id){
		ModelData modelData=mdsi.querySimById(id);
		this.data=modelData;
		this.outPut();
	}
	
	@RequestMapping("deleteModelDatas")
	public void deleteModelDatas(String idList){
		String id[] =idList.split(",");
		int ids[] = new int[id.length];
		for(int i=0;i<id.length;i++){
        	ids[i]= Integer.valueOf(id[i]).intValue();
        }
		mdsi.deleteData(ids);
	}
}
