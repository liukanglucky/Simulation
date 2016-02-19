package com.platform.controller;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.util.ObjectToFile;

@Controller
@RequestMapping("/input")
public class InputController extends BaseJsonAction{
	
	@RequestMapping("/defaultData2")
	public void defaultData1(HttpServletRequest request){
		
		ObjectToFile otf = new ObjectToFile();
		
		DATA2 data2 = new DATA2();
		
		String path = request.getSession().getServletContext().getRealPath("data/data2.txt");
		
		data2 = (DATA2)otf.objectDeSerialize(path);
		
		Map<String,Object> map =  otf.objectToMap(data2);
		
		Iterator entries = map.entrySet().iterator();  
		  
		while (entries.hasNext()) {  
		  
		    Map.Entry entry = (Map.Entry) entries.next();  
		  
		    String key = (String)entry.getKey();  
		  
		    Object value = (Object) entry.getValue();  
		  
		    System.out.println("Key = " + key + ", Value = " + value);  
		  
		}
		
		this.setData(map);
		
		this.outPut();
		
		
		//return map;
	}
	
	
	
	
	public static void main(String[] args) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		ObjectToFile otf = new ObjectToFile();
		DATA1 data1 = new DATA1();
		
		data1 = (DATA1)otf.objectDeSerialize("data/data1.txt");
//		Class c  = Class.forName("com.platform.report.send.DATA2");
//		Field[] f = c.getDeclaredFields();
//		
//		System.out.println(f.length);
//		
//		for(int i = 1; i<f.length;i++){
//			System.out.println(f[i].getType().getSimpleName() +"   "+ f[i].getName());
//			Field tempField = c.getDeclaredField(f[i].getName());
//			
//			//实例化这个类赋给o  
//		    //Object o = c.newInstance();  
//		    
//		    //打破封装  
//			tempField.setAccessible(true); //使用反射机制可以打破封装性，导致了java对象的属性不安全。  
//		    //给o对象的id属性赋值"110"  
//			tempField.set(data1, 'a'); //set  
//		    //get  
//		    System.out.println(tempField.get(data1));
//		}
		
		DATA2 data3 = new DATA2();
		//ObjectToFile otf = new ObjectToFile();
		data3.setS1('a');
		
		//float[] d1 = {1f,2f,3f,4f};
		
		//data2.setD1(d1);
		
		Map<String,Object> map =  otf.objectToMap(data1);
		
		Iterator entries = map.entrySet().iterator();  
		  
		while (entries.hasNext()) {  
		  
		    Map.Entry entry = (Map.Entry) entries.next();  
		  
		    String key = (String)entry.getKey();  
		  
		    Object value = (Object) entry.getValue();  
		  
		    System.out.println("Key = " + key + ", Value = " + value);  
		  
		} 
		
	}
}
