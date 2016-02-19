package com.platform.report.send;

import struct.StructClass;
import struct.StructField;

@StructClass
public class Struct1 { 
	@StructField(order = 0) 
		public char a;
	@StructField(order = 1)
		public float[] f = new float[2];
	@StructField(order = 2)
		public char[] c = new char[3];
	
	public Struct1(char para1,float[] para2,char[] para3) {
		// TODO Auto-generated constructor stub
		this.a = para1;
		this.f = para2;
		this.c = para3;
	}
}
