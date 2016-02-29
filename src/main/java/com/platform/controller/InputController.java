package com.platform.controller;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.platform.dao.ModelDataDao;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.report.send.DATA3A;
import com.platform.report.send.DATAFactory;
import com.platform.service.impl.ModelDataServiceImpl;
import com.platform.util.ObjectToFile;

@Controller
@RequestMapping("/input")
public class InputController extends BaseJsonAction{
	@Autowired
	ModelDataServiceImpl mdsi = new ModelDataServiceImpl();
	
	ObjectToFile otf = new ObjectToFile();
	
	@RequestMapping("/defaultData")
	public void defaultData1(HttpServletRequest request){
		
		String dataNum = (String) request.getParameter("id");
		String fileNum = (String) request.getParameter("fileid");
		System.out.println("fileNum=========="+fileNum);
				
		if(dataNum == null){
			this.setData(null);
			
			this.outPut();
		}
		
		Object input = null;
		String path = "";
		
		input = DATAFactory.getData(dataNum);
		path = request.getSession().getServletContext().getRealPath("data/data"+fileNum+".txt");
		input = input.getClass().cast(otf.objectDeSerialize(path));
		
		if(input == null){
			this.setData("");
			
			this.outPut();
			
			return;
		}
		
		Map<String,Object> map =  otf.objectToMap(input);
		
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
	
	
	@RequestMapping("/saveData")
	public void saveData(HttpServletRequest request){
		String str = request.getParameter("data");
		
		String dataNum = (String) request.getParameter("id");
		String fileNum = (String) request.getParameter("fileid");
		
		
		if(dataNum == null){
			this.setData(null);
			
			this.outPut();
		}
		
		//int num = Integer.parseInt(dataNum);
		
		Object input = null;
		String path = "";
		
		input = DATAFactory.getData(dataNum);
		path = request.getSession().getServletContext().getRealPath("data/data"+fileNum+".txt");
		
		if(!dataNum.equals("2")){
			otf.objectSerialize(otf.mapToObject(otf.stringToMap(str), input), path);
			System.out.println("=============================");
		}else{
//			input = DATAFactory.getData(dataNum);
//			path = request.getSession().getServletContext().getRealPath("data/data"+dataNum+".txt");
			Map<String,String> data2Map = otf.stringToMap(str);
			input = otf.mapToObject(data2Map, input);
			//二维数组
			if(data2Map.containsKey("slocx")){
				float[][] slocx = new float[36][3];
				String[] slocx_value = data2Map.get("slocx").split(",");
				if(slocx_value.length == 108){
					System.out.println("===============");
					for(int si = 0;si<36;si++){
						for(int sj = 0;sj<3;sj++){
							System.out.println("========"+slocx_value[3*si+sj]);
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
			
			otf.objectSerialize(input,path);
		}
		
			
		
		this.setData("保存成功");
		
		this.outPut();
	}
	
	
	/**
	 * 调用仿真模型
	 * @param request
	 */
	@RequestMapping("run")
	public void run(HttpServletRequest request){
		String str = request.getParameter("data");
		
		String dataNum = (String) request.getParameter("id");
		String fileNum = (String) request.getParameter("fileid");
		
		
		if(dataNum == null){
			this.setData(null);
			
			this.outPut();
		}
		
		//int num = Integer.parseInt(dataNum);
		
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
			
			//otf.objectSerialize(input,path);
		}
		
			
		
		this.setData("执行成功");
		
		this.outPut();
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
