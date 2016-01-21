package com.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ModelDao;
import com.platform.model.Count;
import com.platform.model.Model;
import com.platform.model.PageBean;
import com.platform.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{
	@Autowired
	private ModelDao modelDao;

	@Override
	public int insertModel(Model model) {
		return modelDao.insertModel(model);
	}

	@Override
	public int updateModel(Model model) {
		return modelDao.updateModel(model);
	}

	@Override
	public int deleteModel(int id) {
		return modelDao.deleteModel(id);
	}

	@Override
	public Count countModel() {
		return modelDao.countModel();
	}

	@Override
	public List<Model> findAllModel() {
		return modelDao.findAllModel();
	}

	@Override
	public List<Model> findModelsByName(String name) {
		return modelDao.findModelsByName(name);
	}

	@Override
	public List<Model> findModelsByPage(PageBean page) {
		return modelDao.findModelsByPage(page);
	}

	@Override
	public Model findModelById(int id) {
		return modelDao.findModelById(id);
	}
	
	
	
}
