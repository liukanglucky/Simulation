package com.platform.report.send;

/**
 * 定义每个模型返回参数数量
 * @author liukang
 *
 */
public class RecvNum {
	public static int recvNum(String dataType){
		int num = 0;
		
		if(dataType.equals("1")){
			num = 4;
		}
		
		if(dataType.equals("2")){
			num = 4;
		}
		
		if(dataType.equals("3A")){
			num = 4;
		}
		
		if(dataType.equals("3B")){
			num = 4;
		}
		
		if(dataType.equals("5A")){
			num = 4;
		}
		
		if(dataType.equals("5B")){
			num = 4;
		}
		
		if(dataType.equals("7")){
			num = 1;
		}
		
		if(dataType.equals("8")){
			num = 1;
		}
		
		
		return  num;
	}
}
