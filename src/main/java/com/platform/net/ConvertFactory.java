package com.platform.net;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liukang
 * 根据modelid 将返回报文转换成指定结果
 */
public class ConvertFactory {
	
	public static List<String> convert(String dataType , List<byte[]> list){
		List<String> result = new LinkedList<String>();
		
		if(dataType.equals("1") || dataType.equals("2")){
			for (int i = 0; i < list.size(); i++) {
				result.add(ConvertResult.convertStruct1(list.get(i)));
			}
		}
		
		if(dataType.equals("3A") || dataType.equals("3B")||dataType.equals("5A") || dataType.equals("5B")){
			for (int i = 0; i < list.size(); i++) {
				System.out.println("标识位是："+list.get(i)[0]);
				if(list.get(i)[0] == 4){
					result.add(ConvertResult.convertStruct2(list.get(i)));
				}else{
					result.add(ConvertResult.convertStruct1(list.get(i)));
				}	
			}
		}
		
		if(dataType.equals("7")){
			result.add(ConvertResult.convertStruct3(list.get(0)));
		}
		
		if(dataType.equals("8") ){
			
		}
		
		return result;
	}
	
}
