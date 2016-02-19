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
import java.util.Map;

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
											tempValue += temp[j]+",";
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
	
	
	
	public static void main(String[] args) {
		ObjectToFile otf = new ObjectToFile();
		
		DATA2 data2 = new DATA2();
		data2.setS1('a');
		
		System.out.println(otf.objectSerialize(data2, "WebContent/data/data2.txt"));
		
		data2 = (DATA2)otf.objectDeSerialize("WebContent/data/data2.txt");
		
		System.out.println(data2.getS1());
	}
	
	
	
}
