package com.platform.service;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.Model;
import com.platform.model.PageBean;

public interface ModelService {
	
	public int insertModel(Model model);
	public int updateModel(Model model);
	public int deleteModel(int id);
	public Count countModel();
	
	
	public List<Model> findAllModel();
	public List<Model> findModelsByName(String name);
	public List<Model> findModelsByPage(PageBean page);
	public Model findModelById(int id);
 	
	
}
