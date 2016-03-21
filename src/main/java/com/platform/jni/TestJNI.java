package com.platform.jni;

import com.platform.report.send.*;
import com.platform.util.ObjectToFile;

public class TestJNI {
	public static void main(String[] args) {
//		Model1 m = new Model1();
//		DATA1 d = new DATA1();
//		d.setS1('a');
//		char[] file1 = {'a','c','d'};
//		d.setFile1(file1);
//		m.getmodel1Object(d);
		
		
		Model m = new Model();
//		DATA2 d2 = new DATA2();
//		d2.setS1((char)2);
//		float[][] slocx = new float[36][3];
//		
//		String sl = "1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,108.0";
//		String[] sss = sl.split(",");
//		
//		if(sss.length == 108 ){
//			for (int i = 0; i < 36; i++) {
//				for (int j = 0; j < 3; j++) {
//					slocx[i][j] = Float.parseFloat(sss[i*3+j]);
//				}
//			}
//		}
//		
//		d2.setSlocx(slocx);
//		float[] wind = {9f,8f,7f};
//		char[] file = {'a','e','f'};
//		d2.setFile(file);
//		d2.setWind(wind);
//		d2.setSpeed(wind);
//		m.model2(d2);
		
		//Object o = new Object();
		
		ObjectToFile otf = new ObjectToFile();
//		DATA3B d3a = new DATA3B();
//		DATA3B d3a2 = new DATA3B();
//		//直接赋值好使
//		char s1 = 2;
//		d3a.setS1(s1);
//		d3a.setWeight(68000f);
//		d3a.setSpeed(18);
//		d3a.setDepth(10);
//		d3a.setCy1(16);
//		d3a.setZy1(80);
//		d3a.setLm1(-200);
//		d3a.setNum1(48);
//		d3a.setSs(166);
//		d3a.setNum2(5f);
//		d3a.setFre2(2);
//		d3a.setType1((char)3);
//		d3a.setType2((char)1);
//		float[] xp = {600f,700f,800f,1000f,1500f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
//		float[] xp2 = {17f,15f,13f,12f,11f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
//		float[] de = {0.9f,0.8f,0.7f,0.5f,0.4f,0.4f,0.8f,0.9f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
//		d3a.setXp1(xp);
//		d3a.setXp2(xp2);
//		d3a.setDe(de);
//		float[] fre1 = {100f,8000f};
//		d3a.setFre1(fre1);
//		
//		//反序列化，强转不好使
//		DATA3B d = (DATA3B) otf.objectDeSerialize("/Users/songshaoying/Documents/phpworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimulationPlatform/data/data3B.txt");
//		Object o  = otf.objectDeSerialize("/Users/songshaoying/Documents/phpworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimulationPlatform/data/data3B.txt");
//		System.out.println(o instanceof DATA3B);
//		System.out.println(d.getFre1()[0]);
//		char t = d.getType1();
//		float[] f = new float[2];
//		f = d3a.getFre1();
//		d3a2.setType1(t);
//		d3a2.setFre1(f);
//		System.out.println("de is "+d.getDe()[0]);
//		System.out.println("type1 is "+d.getType1());
//		System.out.println("type2 is "+d.getType2());
//		System.out.println("call native method");
//		
////		m.model3B(d3a); //native
////		m.model3B(d3a2); //native
//		char type1 = 3;
////		System.out.println(d.getType1() == 3);
////		System.out.println(type1);
////		d.setType1(type1);
//		m.model3B(d); //native
		
		
		
//		DATA2 data2 = (DATA2) otf.objectDeSerialize("/Users/songshaoying/Documents/phpworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimulationPlatform/data/data2.txt");
//		m.model2(data2);
		
//		DATA1 data1 = (DATA1) otf.objectDeSerialize("/Users/songshaoying/Documents/phpworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimulationPlatform/data/data1B.txt");
//		m.model1(data1);
		
//		DATA5A data5A = (DATA5A) otf.objectDeSerialize("/Users/songshaoying/Documents/phpworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimulationPlatform/data/data5A.txt");
//		System.out.println(data5A.getType1());
//		m.model5A(data5A);
		
		DATA5B data5B = (DATA5B) otf.objectDeSerialize("/Users/songshaoying/Documents/phpworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimulationPlatform/data/data5B.txt");
		m.model5B(data5B);
	}
}
