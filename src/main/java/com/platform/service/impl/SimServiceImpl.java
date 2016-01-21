package com.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.SimDao;
import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.Simulation;
import com.platform.service.SimService;

@Service
public class SimServiceImpl implements SimService{
	@Autowired
	private SimDao simDao;

	@Override
	public int insertSim(Simulation simulation) {
		return simDao.insertSim(simulation);
	}

	@Override
	public int updateSim(Simulation simulation) {
		
		return simDao.updateSim(simulation);
	}

	@Override
	public int deleteSim(int id) {
	
		return simDao.deleteSim(id);
	}

	@Override
	public Count countSim() {
	
		return simDao.countSim();
	}

	@Override
	public List<Simulation> findAllSim() {
	
		return simDao.findAllSim();
	}

	@Override
	public List<Simulation> findSimsByName(String name) {
		return simDao.findSimsByName(name);
	}

	@Override
	public List<Simulation> findSimsByPage(PageBean page) {
		return simDao.findSimsByPage(page);
	}

	@Override
	public Simulation findSimById(int id) {
		return simDao.findSimById(id);
	}

	
}
