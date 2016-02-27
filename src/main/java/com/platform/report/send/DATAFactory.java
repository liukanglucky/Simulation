package com.platform.report.send;

/**
 * 
 * @author liukang
 * 实例化输入参数工厂方法
 * 
 */
public class DATAFactory {
	public static Object getData(String dataType){
		Object obj = null;
		
		if(dataType.equals("1")){
			obj = new DATA1();
		}
		
		if(dataType.equals("2")){
			obj = new DATA2();
		}
		
		if(dataType.equals("3A")){
			obj = new DATA3A();
		}
		
		if(dataType.equals("3B")){
			obj = new DATA3B();
		}
		
		if(dataType.equals("5A")){
			obj = new DATA5A();
		}
		
		if(dataType.equals("5B")){
			obj = new DATA5B();
		}
		
		if(dataType.equals("7")){
			obj = new DATA7();
		}
		
		if(dataType.equals("8")){
			obj = new DATA8();
		}
		
		
		return obj;
	}
}
