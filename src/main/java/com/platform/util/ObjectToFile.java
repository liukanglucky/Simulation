package com.platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.platform.net.UdpClientSocket;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;

public class ObjectToFile {
	public  byte[] arraycat(byte[] buf1,byte[] buf2)
    {
	    byte[] bufret=null;
	    int len1=0;
	    int len2=0;
	    if(buf1!=null)
	    	len1=buf1.length;
	    if(buf2!=null)
	    	len2=buf2.length;
	    if(len1+len2>0)
	    	bufret=new byte[len1+len2];
	    
	    for (int i = 0; i < len1; i++) {
	    	bufret[i] = buf1[i];
		}
	    
	    for (int j = 0; j < len2; j++) {
			bufret[len1+j] = buf2[j];
		}
	    
	    return bufret;
    }
    
    public  byte[] float2byte(float f) {  
        
        // 把float转换为byte[]  
        int fbit = Float.floatToIntBits(f);  
          
        byte[] b = new byte[4];    
        for (int i = 0; i < 4; i++) {    
            b[i] = (byte) (fbit >> (24 - i * 8));    
        }   
          
        // 翻转数组  
        int len = b.length;  
        // 建立一个与源数组元素类型相同的数组  
        byte[] dest = new byte[len];  
        // 为了防止修改源数组，将源数组拷贝一份副本  
        System.arraycopy(b, 0, dest, 0, len);  
        byte temp;  
        // 将顺位第i个与倒数第i个交换  
        for (int i = 0; i < len / 2; ++i) {  
            temp = dest[i];  
            dest[i] = dest[len - i - 1];  
            dest[len - i - 1] = temp;  
        }  
          
        return dest;  
          
    }
    
    public  byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
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
											System.out.println(temp[j]);
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
					
					System.out.println(fields[i].getName()+",fieldType is "+type+",value is "+map.get(key));
					
					if(type.equals("char")){
						System.out.println(key + " fieldType is "+type+" ,map value is "+map.get(key)+" and int is"+Integer.parseInt(map.get(key).trim()));
						fields[i].set(obj, (char)map.get(key).trim().charAt(0));
//						fields[i].set(obj, (char)(Integer.parseInt(map.get(key).trim())));
//						System.out.println(fields[i].getName()+" in object is "+(int)fields[i].getChar(obj));
					}
					
					if(type.equals("int")){
						fields[i].set(obj, Integer.parseInt(map.get(key)));
					}
					
					if(type.equals("float")){
						fields[i].set(obj, Float.parseFloat(map.get(key)));
					}
					
					if(type.equals("char[]")){
						
						if(fields[i].getName().equals("file")||fields[i].getName().equals("file1")||fields[i].getName().equals("file2")
								||fields[i].getName().equals("name1")||fields[i].getName().equals("name2")||fields[i].getName().equals("name3")){
							String temp = map.get(key).trim();
							System.out.println("char[] map value is "+temp+" temp length is"+temp.length());
							char[] tempvalue =new char[temp.length()];
							
							for (int j = 0; j < temp.length(); j++) {
								tempvalue[j] = temp.charAt(j);
								System.out.println("temp is "+temp.charAt(j)+"");
							}
							fields[i].set(obj, tempvalue);
						}else{
							String[] temp = map.get(key).split(",");
							char[] tempvalue =new char[temp.length];
							for (int j = 0; j < temp.length; j++) {
								tempvalue[j] = temp[j].charAt(0);
							}
							fields[i].set(obj, tempvalue);
						}	
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
			str = str.substring(0,str.length()-1);
		
		String[] kvs = str.split(",");
		
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split(":");
			if(kv.length == 2){
				if(map.containsKey(kv[0])){
					map.put(kv[0], map.get(kv[0])+","+kv[1]);
				}else{
					map.put(kv[0], kv[1]);
				}
				
				System.out.println(kv[0]+":===="+map.get(kv[0]));
			}
		}
		
		return map;
	}
	
	/**
	 * object to byte array
	 * use for udp connect
	 * @param obj
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public byte[] objectToByteArray(Object obj){
		byte[] res =null;
		Class c = obj.getClass();
		Field[] fields = c.getDeclaredFields();
		if(fields.length <= 14 )
			return res;
		String type = "";
		try{
			for (int i = 1; i < fields.length-13; i++) {
				//System.out.println(fields[i].getName());
				type = fields[i].getType().getSimpleName();
				//访问private方法
				fields[i].setAccessible(true);
				
				System.out.println(fields[i].getName()+" is "+type+" value:"+fields[i].get(obj));
				
				if(type.equals("char")){
					res = this.arraycat(res,this.charToByte(fields[i].getChar(obj)));
				}
				
				if(type.equals("float")){
					res = this.arraycat(res,this.float2byte(fields[i].getFloat(obj)));
				}
				
				if(type.equals("char[]")){
					Object temp  = fields[i].get(obj);
					if(temp.getClass().isArray()){
						char[] temp2  = (char[])temp;
						for (int j = 0; j < temp2.length; j++) {
							res = this.arraycat(res,this.charToByte(temp2[j]));
						}
					}
				}
				
				if(type.equals("float[]")){
					Object temp  = fields[i].get(obj);
					if(temp.getClass().isArray()){
						float[] temp2  = (float[])temp;
						for (int j = 0; j < temp2.length; j++) {
							res = this.arraycat(res,this.float2byte(temp2[j]));
						}
					}
				}
				
				if(type.equals("float[][]")){
					Object temp  = fields[i].get(obj);
					if(temp.getClass().isArray()){
						float[][] temp2  = (float[][])temp;
						for (int j = 0; j < temp2.length; j++) {
							for (int k = 0; k < temp2[j].length; k++) {
								res = this.arraycat(res,this.float2byte(temp2[j][k]));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	public boolean MapToFile(Map<String,Object> map,String path){
		boolean flag = false;
		File file = new File(path);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			Iterator<Map.Entry<String,Object>> entries = map.entrySet().iterator(); 
			String key = "";
			String value = "";
			while(entries.hasNext()){
			    Map.Entry<String,Object> entry = (Map.Entry<String,Object>) entries.next();  
			  
			    key = (String)entry.getKey();  
			  
			    value = (String) entry.getValue(); 
			    
			    fw.write(key+":"+value+"\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		ObjectToFile otf = new ObjectToFile();
		
		DATA2 data2 = new DATA2();
		data2.setS1('a');
		data2.setSpeed1(2f);
		char[] type2 = {'c','1','1','1'};
		data2.setType2(type2);
//		
//		System.out.println(otf.objectSerialize(data2, "WebContent/data/data2.txt"));
//		
//		data2 = (DATA2)otf.objectDeSerialize("WebContent/data/data2.txt");
		
//		Map<String,String> map =  otf.stringToMap("speed1:1,pu1:3,speed2:1,pu2:2,jz:0,wind:0.0,wind:0.0,wind:0.0,num1:0,fspeed:0.0,fspeed:0.0,fspeed:0.0,depth:0,d2:0.0,d2:0.0,d2:0.0,d2:0.0,num2:0,speed3:0,d1:0.0,d1:0.0,d1:0.0,d1:0.0,ang1:0.0,pu3:0,d3:0.0,d3:0.0,d3:0.0,d3:0.0,ang1:0.0,ang2:0.0,ang2:0.0,ang3:0.0,ang3:0.0,slocx:1.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:0.0,slocx:108.0,ang4:0.0,cy1:0,dk1:0.0,dk1:0.0,dk1:0.0,dk1:0.0,ang4:0.0,mk1:0,fre1:0.0,fre1:0.0,fre1:0.0,fre1:0.0,ss:0,num: ,loc:0.0,loc:0.0,loc:0.0,pu4:0,lm1:0,speed:0.0,speed:0.0,speed:0.0,type1:3,type2:1,type2:1,type2:1,type2:1,");
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
		
//		DATA1 data1 = new DATA1();
//		data1.setCy1(1.4f);
//		data1.setType1('c');
//		data1.setType2('d');
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
		
		System.out.println(data2.getSpeed1());
		
		byte[] byteofdata2 = otf.objectToByteArray(data2);
		
		System.out.println(byteofdata2.length);
		for (int i = 0; i < byteofdata2.length; i++) {
			System.out.println(byteofdata2[i]);
		}
		
		System.out.println(otf.float2byte(2f)[1]);
	}
	
	
	
}
