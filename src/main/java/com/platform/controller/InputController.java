package com.platform.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.platform.dao.ModelDataDao;
import com.platform.jni.NativeFactory;
import com.platform.net.ConvertFactory;
import com.platform.net.ConvertResult;
import com.platform.net.UdpServerSocket;
import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.report.send.DATA3A;
import com.platform.report.send.DATAFactory;
import com.platform.report.send.RecvNum;
import com.platform.service.InputService;
import com.platform.service.impl.ModelDataServiceImpl;
import com.platform.util.FileUtil;
import com.platform.util.ObjectToFile;

@Controller
@RequestMapping("/input")
public class InputController extends BaseJsonAction{
	@Autowired
	ModelDataServiceImpl mdsi = new ModelDataServiceImpl();
	
	@Autowired
	InputService inputService = new InputService();
	
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
		
		String dataNum = (String) request.getParameter("fileid");
		String fileNum = (String) request.getParameter("fileid");
		
		System.out.println("dataNum is "+dataNum);
		
		if(dataNum == null){
			this.setData(null);
			
			this.outPut();
		}
		
		//int num = Integer.parseInt(dataNum);
		
		Object input = null;
		String path = "";
		
		input = DATAFactory.getData(dataNum);
		path = request.getSession().getServletContext().getRealPath("data/data"+fileNum+".txt");
		System.out.println("=============="+path);
		
		input = inputService.reutrnObject(dataNum, str);
		
		otf.objectSerialize(input,path);
		
		String out1 = (String) request.getParameter("output1");
		String out2 = (String) request.getParameter("output2");
		String out3 = (String) request.getParameter("output3");
		String out4 = (String) request.getParameter("output4");
		String para = (String) request.getParameter("para");
		Class c = input.getClass();
		
		//填写其他参数
		if(dataNum.equals("1") ||dataNum.equals("1B")|| dataNum.equals("2")){
			//利用反射赋值
			try {
				Field f = c.getDeclaredField("out1");
				f.setAccessible(true);
				f.set(input, out1);
				
				f = c.getDeclaredField("out2");
				f.setAccessible(true);
				f.set(input, out2);
				
				f = c.getDeclaredField("out3");
				f.setAccessible(true);
				f.set(input, out3);
				
				f = c.getDeclaredField("out4");
				f.setAccessible(true);
				f.set(input, out4);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//填写其他参数
		if(dataNum.equals("3A") || dataNum.equals("3B") ||dataNum.equals("4A") || dataNum.equals("4B") || dataNum.equals("5A") || dataNum.equals("5B")|| dataNum.equals("6A") || dataNum.equals("6B")){
			//利用反射赋值
			try {
				Field f = c.getDeclaredField("out1");
				f.setAccessible(true);
				f.set(input, out1);
				
				f = c.getDeclaredField("out2");
				f.setAccessible(true);
				f.set(input, out2);
				
				f = c.getDeclaredField("out3");
				f.setAccessible(true);
				f.set(input, out3);
				
				String[] paraStringArray = para.split("_");
				if(paraStringArray.length == 64){
					float[] temp  = new float[20];
					for(int i = 0;i<20;i++){
						temp[i] = Float.parseFloat(paraStringArray[i]);
					}
					
					f = c.getDeclaredField("xp1");
					f.setAccessible(true);
					f.set(input, temp);
					
					for(int i = 20;i<40;i++){
						temp[i-20] = Float.parseFloat(paraStringArray[i]);
					}
					f = c.getDeclaredField("xp2");
					f.setAccessible(true);
					f.set(input, temp);
					
					for(int i = 40;i<60;i++){
						temp[i-40] = Float.parseFloat(paraStringArray[i]);
					}
					f = c.getDeclaredField("de");
					f.setAccessible(true);
					f.set(input, temp);
					
					f = c.getDeclaredField("outp1");
					f.setAccessible(true);
					f.set(input, Float.parseFloat(paraStringArray[60]));
					
					f = c.getDeclaredField("outp2");
					f.setAccessible(true);
					f.set(input, Float.parseFloat(paraStringArray[61]));
					
					f = c.getDeclaredField("outp3");
					f.setAccessible(true);
					f.set(input,paraStringArray[62].charAt(0));
				}	
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(dataNum.equals("7") || dataNum.equals("8") ){
			Field f;
			try {
				f = c.getDeclaredField("out1");
				f.setAccessible(true);
				f.set(input, out1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//插入数据库
		try {
			int maxid = mdsi.findMaxId();
			System.out.println("========maxid is "+maxid );
			Field dataindex = input.getClass().getDeclaredField("dataindex");
			dataindex.setAccessible(true);
			dataindex.set(input, maxid+1);
			mdsi.insertFactory(dataNum, input);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				
		Object input = null;
		
		input = DATAFactory.getData(dataNum);
		
		input = inputService.reutrnObject(dataNum, str);
		
		//发送数据
		NativeFactory.getNativeMethod(dataNum, input);
		//等待执行成功信号
//		String serverHost = "192.168.220.202";  
//        int serverPort = 21168;  
        String serverHost = "127.0.0.1";  
        int serverPort = 1111;  
        UdpServerSocket udpServerSocket = null;
		try {
			udpServerSocket = new UdpServerSocket(serverHost, serverPort);
			long start = System.currentTimeMillis();
			long now = 0L;
			
			List<byte[]> result = new ArrayList<byte[]>();
			//根据模型ID获得应该接收参数个数
			int num = RecvNum.recvNum(dataNum);
			while (true) { 
				now = System.currentTimeMillis();
				//执行超时 5分钟超时
				if((now - start) / (1000*60) >= 3){
					this.setData("Exec_error:执行超时");
					this.outPut();
					return;
				}
	            
				if(result.size() >= num ){
					break;
				}
				
				byte[] rcv1 = new byte[1200];
				rcv1 = udpServerSocket.receive();  
				//rcv1指向同一个地址
				result.add(rcv1.clone());
				System.out.println("receive report num "+result.size());
	        }
			
			//解析byte数组
			List<String> r = ConvertFactory.convert(dataNum, result);
			
//			for (int i = 0; i < r.size(); i++) {
//				System.out.println("Result is ============="+r.get(i));
//			}
			
			this.setData(r);
			//this.setData("执行成功");
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setData("Exec_error:执行失败"+e.toString());
		}finally{
			udpServerSocket.close();
		}
		this.outPut();
	}
	
	
	/**
	 * 调用仿真模型时返回形成的实体类
	 * @param request
	 */
	@RequestMapping("getObjct")
	public void getObject(HttpServletRequest request){
		String str = request.getParameter("data");
		String dataNum = (String) request.getParameter("id");

		Object input = null;
		input = inputService.reutrnObject(dataNum, str);
		System.out.println("--------------getObjct--------------");
//		JSONObject json = JSONObject.fromObject(input);
//		
//		System.out.println(json.toString());
		this.setData(input);
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
