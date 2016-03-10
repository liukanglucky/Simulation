package com.platform.jni;

import com.platform.report.send.DATA1;

public class TestJNI {
	public static void main(String[] args) {
		Model1 m = new Model1();
		DATA1 d = new DATA1();
		d.setS1('a');
		d.setFile1(null);
		m.getmodel1(d);
	}
}
