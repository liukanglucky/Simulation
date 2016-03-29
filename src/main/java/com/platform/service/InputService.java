package com.platform.service;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.platform.report.send.DATAFactory;
import com.platform.util.ObjectToFile;

@Service
public class InputService {
	
	ObjectToFile otf = new ObjectToFile();
	
	/**
	 * 根据页面传入字符串返回实体类
	 * @param dataNum
	 * @param str
	 * @return
	 */
	public Object reutrnObject(String dataNum , String str){
		Object input = null;
		
		input = DATAFactory.getData(dataNum);
		
		if(!dataNum.equals("2")){
			otf.mapToObject(otf.stringToMap(str), input);
		}else{
			Map<String,String> data2Map = otf.stringToMap(str);
			input = otf.mapToObject(data2Map, input);
			//二维数组
			if(data2Map.containsKey("slocx")){
				float[][] slocx = new float[36][3];
				String[] slocx_value = data2Map.get("slocx").split(",");
				if(slocx_value.length == 108){
					for(int si = 0;si<36;si++){
						for(int sj = 0;sj<3;sj++){
							slocx[si][sj]=Float.parseFloat(slocx_value[3*si+sj]);
						}
					}
					//利用反射赋值
					Class c = input.getClass();
					try {
						Field f = c.getDeclaredField("slocx");
						f.setAccessible(true);
						f.set(input, slocx);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		
		
		return input;
	}
	
}
