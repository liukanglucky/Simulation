package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ModelDataDao;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.report.send.DATA3A;
import com.platform.report.send.DATA3B;
import com.platform.report.send.DATA5A;
import com.platform.report.send.DATA5B;
import com.platform.report.send.DATA7;
import com.platform.report.send.DATA8;
import com.platform.service.ModelDataService;

@Service
public class ModelDataServiceImpl implements ModelDataService{
	@Autowired
	private ModelDataDao modelDataDao;

	@Override
	public int insertData3A(DATA3A data) {
		return modelDataDao.insertData3A(data);
	}

	@Override
	public int insertData1(DATA1 data) {
		return modelDataDao.insertData1(data);
	}

	@Override
	public int insertData1B(DATA1 data) {
		return modelDataDao.insertData1B(data);
	}

	@Override
	public int insertData2(DATA2 data) {
		return modelDataDao.insertData2(data);
	}

	@Override
	public int insertData3B(DATA3B data) {
		return modelDataDao.insertData3B(data);
	}

	@Override
	public int insertData5A(DATA5A data) {
		return modelDataDao.insertData5A(data);
	}

	@Override
	public int insertData5B(DATA5B data) {
		return modelDataDao.insertData5B(data);
	}

	@Override
	public int insertData7(DATA7 data) {
		return modelDataDao.insertData7(data);
	}

	@Override
	public int insertData8(DATA8 data) {
		return modelDataDao.insertData8(data);
	}
	
	
}
