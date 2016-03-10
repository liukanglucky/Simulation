package com.platform.jni;

import com.platform.report.send.DATA1;

public class Model1 {
	static{
		System.load("/Users/songshaoying/Documents/phpworkspace/SimulationPlatform/src/main/java/com/platform/jni/model1.dylib");
	}
	
	public native void getmodel1(DATA1 data1);
		
}
