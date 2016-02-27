package com.platform.dao;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.Data1;
import com.platform.model.Data3A;

public interface ModelDataDao {
	
	public int insertData1(Data1 data);
	public int insertData1B(Data1 data);
	public int insertData2(Data1 data);
	public int insertData3A(Data3A data);
	public int insertData3B(Data1 data);
	public int insertData5A(Data1 data);
	public int insertData5B(Data1 data);
	public int insertData7(Data1 data);
	public int insertData8(Data1 data);
	public Count countUser();
	public List<Data1> findDatasByPage(PageBean page);
	public Data1 findDatasById(int id);
	public int deleteData(int id);
}

