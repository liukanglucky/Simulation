package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ModelDataDao;
import com.platform.report.send.DATA3A;
import com.platform.service.ModelDataService;

@Service
public class ModelDataServiceImpl implements ModelDataService{
	@Autowired
	private ModelDataDao modelDataDao;

	@Override
	public int insertData3A(DATA3A data) {
		return modelDataDao.insertData3A(data);
	}
	
	
}
