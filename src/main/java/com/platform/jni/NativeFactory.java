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
	public static Object getNativeMethod(String dataType,Object data){
		Model m = new Model();
		
		Object obj = null;
		
		if(dataType.equals("1")){
			m.model1((DATA1) data);
		}
		
		if(dataType.equals("2")){
			m.model2((DATA2) data);
		}
		
		if(dataType.equals("3A")){
			obj = new DATA3A();
		}
		
		if(dataType.equals("3B")){
			m.model3B((DATA3B) data);
		}
		
		if(dataType.equals("5A")){
			m.model5A((DATA5A) data);
		}
		
		if(dataType.equals("5B")){
			m.model5B((DATA5B) data);
		}
		
		if(dataType.equals("7")){
			m.model7((DATA7) data);
		}
		
		if(dataType.equals("8")){
			m.model8((DATA8) data);
		}
		
		
		return obj;
	}
}
