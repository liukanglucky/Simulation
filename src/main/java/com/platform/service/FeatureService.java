package com.platform.service;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.Feature;
import com.platform.model.PageBean;

public interface FeatureService {
	
	public int insertFeature(Feature feature);
	public int updateFeature(Feature feature);
	public int deleteFeature(int id);
	public Count countFeature();
	
	
	public List<Feature> findAllFeature();
	public List<Feature> findFeaturesByName(String name);
	public List<Feature> findFeaturesByPage(PageBean page);
	public Feature findFeatureById(int id);
 	
	
}
