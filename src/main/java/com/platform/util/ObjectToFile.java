package com.platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;

public class ObjectToFile {
	
	
	/**
	 * 序列化对象
	 * @param object
	 * @param path
	 * @return
	 */
	@SuppressWarnings({ "finally", "resource" })
	public boolean objectSerialize(Object object,String path){
		boolean flag = false;
		
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(new FileOutputStream (new File(path)));
			oo.writeObject(object);
			flag = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return flag;
		}
	}
	
	
	/**
	 * 反序列化
	 * @param path
	 * @return
	 */
	@SuppressWarnings({ "resource", "finally" })
	public Object objectDeSerialize(String path){
		Object object = null;
		
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(path)));
			object =ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			return object;
		}
		
	}
	
	
	/**
	 * object to Map
	 * @param thisObj
	 * @return
	 */
	public static Map<String,Object> objectToMap(Object thisObj) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Class c;
		try {
			c = Class.forName(thisObj.getClass().getName());
			//获取fields并转换成map
			Field[] fields = c.getDeclaredFields();
			
			Map<String,Integer> fieldMap = new HashMap<String,Integer>();
			
			for (int i = 0; i < fields.length; i++) {
				fieldMap.put(fields[i].getName(), new Integer(i));
			}
			
			
			Method[] m = c.getMethods();
			
			for (int i = 0; i < m.length; i++) {
				String method = m[i].getName();
				if (method.startsWith("get")) {
					try {
						//通过invoke调用get方法
						Object value = m[i].invoke(thisObj);
						//if (value != null) {
						if (true) {
							String key = method.substring(3);
							key = key.substring(0, 1).toLowerCase() + key.substring(1);
							//根据fieldMap获得field对象，判断类型，加入结果map
							if(fieldMap.get(key) != null){
								String fieldType = fields[(int)fieldMap.get(key)].getType().getSimpleName();
								//System.out.println("fieldType is "+fieldType);
								if(fieldType.equals("float[]")){
									
									Object tempO =  m[i].invoke(thisObj);
									if(tempO.getClass().isArray()){
										
										float[] temp = (float[]) tempO;
										
										String tempValue = "";
										for (int j = 0; j < temp.length; j++) {
											tempValue += temp[j]+",";
										}
										map.put(key, tempValue);
									}
									
								}else{
									if(fieldType.equals("char[]")){
										
										Object tempO =  m[i].invoke(thisObj);
										char[] temp = (char[]) tempO;
										
										String tempValue = "";
										for (int j = 0; j < temp.length; j++) {
											tempValue += String.valueOf(temp[j])+",";
										}
										map.put(key, tempValue);
									}else{
										if(fieldType.equals("float[][]")){
											Object tempO =  m[i].invoke(thisObj);
											if(tempO.getClass().isArray()){
												
												float[][] temp = (float[][]) tempO;
												
												String tempValue = "";
												for (int j = 0; j < temp.length; j++) {
													for(int k = 0; k < temp[j].length;k++){
														tempValue += temp[j][k]+",";
													}	
												}
												map.put(key, tempValue);
											}
										}else{
											map.put(key, value);
										}
									}
								}
								
							}
							
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("error:" + method);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * map转object
	 * @param map
	 * @param thisObj
	 * @return
	 */
	public Object mapToObject(Map<String,String> map,Object obj){
		Class c = null ;
		
		try {
			c =Class.forName(obj.getClass().getName());
			//获取fields
			Field[] fields = c.getDeclaredFields();
			String key = "";
			String type = "";
			for (int i = 0; i < fields.length; i++) {
				key = fields[i].getName();
				
				if(map.containsKey(key)){
					type = fields[i].getType().getSimpleName();
					//访问private方法
					fields[i].setAccessible(true);
					
					//System.out.println("fieldType is "+type);
					
					if(type.equals("char")){
						fields[i].set(obj, map.get(key).charAt(0));
					}
					
					if(type.equals("float")){
						fields[i].set(obj, Float.parseFloat(map.get(key)));
					}
					
					if(type.equals("char[]")){
						String[] temp = map.get(key).split(",");
						char[] tempvalue =new char[temp.length];
						for (int j = 0; j < temp.length; j++) {
							tempvalue[j] = temp[j].charAt(0);
						}
						fields[i].set(obj, tempvalue);
					}
					
					if(type.equals("float[]")){
						String[] temp = map.get(key).split(",");
						float[] tempvalue =new float[temp.length];
						for (int j = 0; j < temp.length; j++) {
							tempvalue[j] = Float.parseFloat(temp[j]);
							
						}
						fields[i].set(obj, tempvalue);
					}
					
		
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	/**
	 * 前台字符串转map
	 * @param str
	 * @return
	 */
	public Map<String,String> stringToMap(String str){
		Map<String,String> map = new HashMap<String,String>();
		if(str.length()<=1)
			return null;
		if(str.endsWith(","))
			str = str.substring(0,str.length()-2);
		
		String[] kvs = str.split(",");
		
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split(":");
			if(kv.length == 2){
				if(map.containsKey(kv[0])){
					map.put(kv[0], map.get(kv[0])+","+kv[1]);
				}else{
					map.put(kv[0], kv[1]);
				}
			}
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		ObjectToFile otf = new ObjectToFile();
		
//		DATA2 data2 = new DATA2();
//		data2.setS1('a');
//		data2.setSpeed1(2f);
//		char[] type2 = {'1','1','1','1'};
//		data2.setType2(type2);
//		
//		System.out.println(otf.objectSerialize(data2, "WebContent/data/data2.txt"));
//		
//		data2 = (DATA2)otf.objectDeSerialize("WebContent/data/data2.txt");
		
//		Map<String,String> map =  otf.stringToMap("speed1:2,pu1:3,speed2:0,pu2:0,jz:0,wind:0.0,wind:0.0,wind:0.0,num1:0,fspeed:0.0,fspeed:0.0,fspeed:0.0,depth:0,d2:0.0,d2:0.0,d2:0.0,d2:0.0,num2:0,speed3:0,d1:0.0,d1:0.0,d1:0.0,d1:0.0,ang1:1.0,pu3:0,d3:0.0,d3:0.0,d3:0.0,d3:0.0,ang1:2.0,ang2:0.0,ang2:0.0,ang3:0.0,ang3:0.0,slocx:1.0,slocx:2.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:3.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,ang4:0.0,cy1:0,dk1:0.0,dk1:0.0,dk1:0.0,dk1:0.0,ang4:0.0,mk1:0,fre1:0.0,fre1:0.0,fre1:0.0,fre1:0.0,ss:0,num:,loc:0.0,loc:0.0,loc:0.0,pu4:0,lm1:0,speed:0.0,speed:0.0,speed:0.0,utype:海洋环境,type2:1,type2:1,type2:1,type2:1,");
//		
//		Iterator entries = map.entrySet().iterator();  
//		  
//		while (entries.hasNext()) {  
//		  
//		    Map.Entry entry = (Map.Entry) entries.next();  
//		  
//		    String key = (String)entry.getKey();  
//		  
//		    String value = (String) entry.getValue();  
//		  
//		    System.out.println("Key = " + key + ", Value = " + value);  
//		  
//		}
		
//		System.out.println(data2.getSpeed1());
		
		DATA1 data1 = new DATA1();
//		data1.setCy1(1.4f);
//		data1.setType1('0');
//		data1.setType2('0');
//		System.out.println(otf.objectSerialize(data1, "WebContent/data/data1.txt"));
		
		
//		Map<String,String> map2 = new HashMap<String,String>() ;
//		
//		map2.put("ang", "0");
//		
//		map2.put("ang4","1.4");
//		
//		map2.put("file1", "a,a,a,a,c,c,c,c,c");
//		
//		DATA1 data1_new = new DATA1();
//		
//		otf.mapToObject(map, data1_new);
//		
//		System.out.println(data1_new.getCy1());
		
//		String json1 = JSON.toJSONString(data1);
//		System.out.println(json1);
		
	}
	
	
	
}
