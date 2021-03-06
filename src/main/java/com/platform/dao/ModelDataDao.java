package com.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.platform.model.Count;
import com.platform.model.ModelData;
import com.platform.model.PageBean;
import com.platform.model.QueryParameter;
import com.platform.report.send.*;

public interface ModelDataDao {
	
	public int insertData1(DATA1 data);
	public int insertData1B(DATA1 data);
	public int insertData2(DATA2 data);
	public int insertData3A(DATA3A data);
	public int insertData3B(DATA3B data);
	public int insertData4A(DATA3A data);
	public int insertData4B(DATA3B data);
	public int insertData5A(DATA5A data);
	public int insertData5B(DATA5B data);
	public int insertData6A(DATA5A data);
	public int insertData6B(DATA5B data);
	public int insertData7(DATA7 data);
	public int insertData8(DATA8 data);
	public int findMaxId();
	public Count countModelData(QueryParameter queryParameter);
	public List<ModelData> querySim(QueryParameter queryParameter);
	public ModelData querySimById(int id);
	public int deleteData(@Param("ids")int ids[]);
	
	public int backupModelData(@Param("tableName") String tableName);
	public int addPrimaryKey(@Param("tableName") String tableName);
	public int deleteCurTableContent(@Param("tableName")String tableName);
	public int importBackupTable(@Param("tableName") String tableName);
	public int dropBackupTable(@Param("tableName") String tableName);
	public List<String>getTableList();
	public List<String>getTableListByPage(PageBean page);
	public Count countBackup();
	
}

