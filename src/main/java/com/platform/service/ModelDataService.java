package com.platform.service;

import com.platform.report.send.*;


public interface ModelDataService {
	public int insertData1(DATA1 data);
	public int insertData1B(DATA1 data);
	public int insertData2(DATA2 data);
	public int insertData3A(DATA3A data);
	public int insertData3B(DATA3B data);
	public int insertData5A(DATA5A data);
	public int insertData5B(DATA5B data);
	public int insertData7(DATA7 data);
	public int insertData8(DATA8 data);
	public int findMaxId();
}
