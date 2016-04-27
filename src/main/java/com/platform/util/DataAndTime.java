package com.platform.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DataAndTime {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");  
    private static SimpleDateFormat tf = new SimpleDateFormat("HHmmss");  
    public static String getDate(){  
        return df.format(new Date());  
    }
    public static String getTime(){  
        return tf.format(new Date());  
    } 
}
