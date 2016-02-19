package com.platform.report.receive;

import struct.StructClass;
import struct.StructField;

@StructClass
public class Response1 {
	@StructField(order = 0) 
	public char[] a = new char[3];
	@StructField(order = 1)
	public float[] f = new float[3];
	
	
}
