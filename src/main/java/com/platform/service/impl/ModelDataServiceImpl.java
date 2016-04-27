package com.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ModelDataDao;
import com.platform.model.Count;
import com.platform.model.ModelData;
import com.platform.model.PageBean;
import com.platform.model.QueryParameter;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.report.send.DATA3A;
import com.platform.report.send.DATA3B;
import com.platform.report.send.DATA5A;
import com.platform.report.send.DATA5B;
import com.platform.report.send.DATA7;
import com.platform.report.send.DATA8;
import com.platform.service.ModelDataService;
import com.platform.util.DataAndTime;

@Service
public class ModelDataServiceImpl implements ModelDataService{
	@Autowired
	private ModelDataDao modelDataDao;

	@Override
	public int insertData3A(DATA3A data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData3A(data);
	}

	@Override
	public int insertData1(DATA1 data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData1(data);
	}

	@Override
	public int insertData1B(DATA1 data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData1B(data);
	}

	@Override
	public int insertData2(DATA2 data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData2(data);
	}

	@Override
	public int insertData3B(DATA3B data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData3B(data);
	}

	@Override
	public int insertData5A(DATA5A data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData5A(data);
	}

	@Override
	public int insertData5B(DATA5B data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData5B(data);
	}

	@Override
	public int insertData7(DATA7 data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData7(data);
	}

	@Override
	public int insertData8(DATA8 data) {
		data.setDate1(Integer.valueOf(DataAndTime.getDate()).intValue());
		data.setTime1(Integer.valueOf(DataAndTime.getTime()).intValue());
		return modelDataDao.insertData8(data);
	}
	
	
	public int insertFactory(String dataType,Object data,int operator){
		if(dataType.equals("1")){
			 DATA1 temp= (DATA1)data;
			 temp.setOperator(operator);
			return this.insertData1(temp);
		}
		
		if(dataType.equals("1B")){
			 DATA1 temp= (DATA1)data;
			 temp.setOperator(operator);
			return this.insertData1B(temp);
		}
		
		if(dataType.equals("2")){
			DATA2 temp= (DATA2)data;
			 temp.setOperator(operator);
			return this.insertData2(temp);
		}
		
		if(dataType.equals("3A")){
			DATA3A temp= (DATA3A)data;
			 temp.setOperator(operator);
			return this.insertData3A(temp);
		}
		
		if(dataType.equals("3B")){
			DATA3B temp= (DATA3B)data;
			temp.setOperator(operator);
			return this.insertData3B(temp);
		}
		
		if(dataType.equals("4A")){
			DATA3A temp= (DATA3A)data;
			temp.setOperator(operator);
			return this.insertData4A(temp);
		}
		
		if(dataType.equals("4B")){
			DATA3B temp= (DATA3B)data;
			temp.setOperator(operator);
			return this.insertData4B(temp);
		}
		
		
		
		if(dataType.equals("5A")){
			DATA5A temp= (DATA5A)data;
			temp.setOperator(operator);
			return this.insertData5A(temp);
		}
		
		if(dataType.equals("5B")){
			DATA5B temp= (DATA5B)data;
			temp.setOperator(operator);
			return this.insertData5B(temp);
		}
		
		if(dataType.equals("6A")){
			DATA5A temp= (DATA5A)data;
			temp.setOperator(operator);
			return this.insertData6A(temp);
		}
		
		if(dataType.equals("6B")){
			DATA5B temp= (DATA5B)data;
			temp.setOperator(operator);
			return this.insertData6B(temp);
		}
		
		if(dataType.equals("7")){
			DATA7 temp= (DATA7)data;
			temp.setOperator(operator);
			return this.insertData7(temp);
		}
		
		if(dataType.equals("8")){
			DATA8 temp= (DATA8)data;
			temp.setOperator(operator);
			return this.insertData8(temp);
		}
		
		//mybatis sql 执行成功返回1 不成功返回0 无对应方法返回2
		return 2;
	}

	@Override
	public int findMaxId() {
		return modelDataDao.findMaxId();
	}

	@Override
	public Count countModelData(QueryParameter queryParameter) {
		return modelDataDao.countModelData(queryParameter);
	}

	@Override
	public List<ModelData> querySim(QueryParameter queryParameter) {
		return modelDataDao.querySim(queryParameter);
	}

	@Override
	public ModelData querySimById(int id) {
		return modelDataDao.querySimById(id);
	}

	@Override
	public int deleteData(int[] ids) {
		return modelDataDao.deleteData(ids);
	}

	@Override
	public int backupModelData(String tableName) {
		// TODO Auto-generated method stub
		return modelDataDao.backupModelData(tableName);
	}

	@Override
	public int addPrimaryKey(String tableName) {
		// TODO Auto-generated method stub
		return modelDataDao.addPrimaryKey(tableName);
	}

	@Override
	public int deleteCurTableContent(String tableName) {
		// TODO Auto-generated method stub
		return modelDataDao.deleteCurTableContent(tableName);
	}

	@Override
	public int importBackupTable(String tableName) {
		// TODO Auto-generated method stub
		return modelDataDao.importBackupTable(tableName);
	}

	@Override
	public int dropBackupTable(String tableName) {
		// TODO Auto-generated method stub
		return modelDataDao.dropBackupTable(tableName);
	}

	@Override
	public List<String> getTableList() {
		// TODO Auto-generated method stub
		return modelDataDao.getTableList();
	}

	@Override
	public List<String> getTableListByPage(PageBean page) {
		// TODO Auto-generated method stub
		return modelDataDao.getTableListByPage(page);
	}

	@Override
	public Count countBackup() {
		// TODO Auto-generated method stub
		return modelDataDao.countBackup();
	}

	@Override
	public int insertData4A(DATA3A data) {
		// TODO Auto-generated method stub
		return modelDataDao.insertData3A(data);
	}

	@Override
	public int insertData4B(DATA3B data) {
		// TODO Auto-generated method stub
		return modelDataDao.insertData3B(data);
	}

	@Override
	public int insertData6A(DATA5A data) {
		// TODO Auto-generated method stub
		return modelDataDao.insertData5A(data);
	}

	@Override
	public int insertData6B(DATA5B data) {
		// TODO Auto-generated method stub
		return modelDataDao.insertData5B(data);
	}
	
}
