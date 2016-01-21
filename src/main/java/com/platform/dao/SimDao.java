package com.platform.dao;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.Simulation;

public interface SimDao {
	
	public int insertSim(Simulation simulation);
	public int updateSim(Simulation simulation);
	public Count countSim();
	
	
	public List<Simulation> findAllSim();
	public List<Simulation> findSimsByName(String name);
	public List<Simulation> findSimsByPage(PageBean page);
	public Simulation findSimById(int id);
 	
	public int deleteSim(int id);
}
