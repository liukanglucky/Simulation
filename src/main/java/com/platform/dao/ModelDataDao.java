package com.platform.dao;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.Data1;
import com.platform.model.Data2;
import com.platform.model.Data3A;
import com.platform.model.Data3B;
import com.platform.model.Data5A;
import com.platform.model.Data5B;
import com.platform.model.Data7;
import com.platform.model.Data8;

public interface ModelDataDao {
	
	public int insertData1(Data1 data);
	public int insertData1B(Data1 data);
	public int insertData2(Data2 data);
	public int insertData3A(Data3A data);
	public int insertData3B(Data3B data);
	public int insertData5A(Data5A data);
	public int insertData5B(Data5B data);
	public int insertData7(Data7 data);
	public int insertData8(Data8 data);
	public Count countUser();
	public List<Data1> findDatasByPage(PageBean page);
	public Data1 findDatasById(int id);
	public int deleteData(int id);
}

