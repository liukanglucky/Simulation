package com.platform.jni;

import com.platform.report.send.*;

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
		
		
		DATA3A d3a = new DATA3A();
		char s1 = 1;
		d3a.setS1(s1);
		float[] fre1 = {2f,3f};
		d3a.setFre1(fre1);
		m.model3A(d3a);
	}
}
