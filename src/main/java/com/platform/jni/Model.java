package com.platform.jni;

import com.platform.report.send.*;

public class Model {
	static {
		// String path = Model.class.getResource("/").getPath();
		// System.out.println(path);
		// windows
		//System.load("C:\\model.dll");
		// mac
		System.load("/Users/songshaoying/Documents/phpworkspace/SimulationPlatform/src/main/java/com/platform/jni/model.dylib");
	}

	public native void model1(DATA1 data);

	public native void model2(DATA2 data);

	public native void model3A(DATA3A data);

	public native void model3B(DATA3B data);

	public native void model4A(DATA3A data);

	public native void model4B(DATA3B data);

	public native void model5A(DATA5A data);

	public native void model5B(DATA5B data);

	public native void model6A(DATA5A data);

	public native void model6B(DATA5B data);

	public native void model7(DATA7 data);

	public native void model8(DATA8 data);
}
