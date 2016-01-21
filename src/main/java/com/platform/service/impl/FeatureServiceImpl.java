package com.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.FeatureDao;
import com.platform.model.Count;
import com.platform.model.Feature;
import com.platform.model.PageBean;
import com.platform.service.FeatureService;

@Service
public class FeatureServiceImpl implements FeatureService {
	@Autowired
	private FeatureDao featureDao;
	@Override
	public int insertFeature(Feature feature) {
		return featureDao.insertFeature(feature);
	}

	@Override
	public int updateFeature(Feature feature) {
		return featureDao.updateFeature(feature);
	}

	@Override
	public int deleteFeature(int id) {
		return featureDao.deleteFeature(id);
	}

	@Override
	public Count countFeature() {
		return featureDao.countFeature();
	}

	@Override
	public List<Feature> findAllFeature() {
		return featureDao.findAllFeature();
	}

	@Override
	public List<Feature> findFeaturesByName(String name) {
		return featureDao.findFeaturesByName(name);
	}

	@Override
	public List<Feature> findFeaturesByPage(PageBean page) {
		return featureDao.findFeaturesByPage(page);
	}

	@Override
	public Feature findFeatureById(int id) {
		return featureDao.findFeatureById(id);
	}

}
