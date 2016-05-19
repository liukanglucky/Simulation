package com.platform.jni;

import com.platform.report.send.DATA1;
import com.platform.report.send.DATA2;
import com.platform.report.send.DATA3A;
import com.platform.report.send.DATA3B;
import com.platform.report.send.DATA5A;
import com.platform.report.send.DATA5B;
import com.platform.report.send.DATA7;
import com.platform.report.send.DATA8;

public class NativeFactory {
	public static void getNativeMethod(String dataType, Object data,
			String simType) {
		Model m = new Model();

		// Object obj = null;

		if (dataType.equals("1")) {
			DATA1 obj = (DATA1) data;
			obj.setType1('2');// 2对应分析
			m.model1(obj);
		}
		if (dataType.equals("1B")) {
			DATA1 obj = (DATA1) data;
			obj.setType1('1');// 1对应仿真
			m.model1(obj);
		}

		if (dataType.equals("2")) {
			DATA2 obj = (DATA2) data;
			obj.setS2('1');
			if(simType.equals("1")){
				obj.setType1('1');
			}else{
				obj.setType1('2');
			}
			m.model2(obj);
		}

		if (dataType.equals("3A")) {
			DATA3A obj = (DATA3A) data;
			obj.setType1('2');
			m.model3A(obj);
		}
		if (dataType.equals("4A")) {
			DATA3A obj = (DATA3A) data;
			// obj.setType2('1');
			obj.setType1('2');
			m.model4A(obj);
		}

		if (dataType.equals("3B")) {
			DATA3B obj = (DATA3B) data;
			obj.setType1('1');
			System.out.println("这是调用native方法之前：" + obj.getType1() + "___"
					+ obj.getType2() + "------" + obj.getFre1()[0]);
			m.model3B(obj);
		}

		if (dataType.equals("4B")) {
			DATA3B obj = (DATA3B) data;
			// obj.setType2('1');
			obj.setType1('1');
			System.out.println("这是调用native方法之前：" + obj.getType1() + "___"
					+ obj.getType2() + "------" + obj.getFre1()[0]);
			m.model4B(obj);
		}

		if (dataType.equals("5A")) {
			m.model5A((DATA5A) data);
		}

		if (dataType.equals("6A")) {
			m.model6A((DATA5A) data);
		}

		if (dataType.equals("5B")) {
			m.model5B((DATA5B) data);
		}
		if (dataType.equals("6B")) {
			m.model6B((DATA5B) data);
		}

		if (dataType.equals("7")) {
			DATA7 obj = (DATA7) data;

			if (simType.equals("0")) {
				obj.setS1('7');
			} else {
				obj.setS1('5');
			}
			m.model7(obj);
		}

		if (dataType.equals("8")) {
			DATA8 obj = (DATA8) data;
			if (simType.equals("0")) {
				obj.setS1('6');
			} else {
				obj.setS1('1');
			}
			m.model8(obj);
		}

		// return obj;
	}
}
