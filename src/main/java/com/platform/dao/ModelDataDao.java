package com.platform.dao;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.report.send.*;

public interface ModelDataDao {
	
	public int insertData1(DATA1 data);
	public int insertData1B(DATA1 data);
	public int insertData2(DATA2 data);
	public int insertData3A(DATA3A data);
	public int insertData3B(DATA1 data);
	public int insertData5A(DATA1 data);
	public int insertData5B(DATA1 data);
	public int insertData7(DATA1 data);
	public int insertData8(DATA1 data);
	public Count countUser();
	public List<DATA1> findDatasByPage(PageBean page);
	public DATA1 findDatasById(int id);
	public int deleteData(int id);
}

