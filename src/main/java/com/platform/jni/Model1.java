package com.platform.jni;

import com.platform.report.send.DATA1;

public class Model1 {
	static{
		System.load("/Users/songshaoying/Documents/phpworkspace/SimulationPlatform/src/main/java/com/platform/jni/model1.dylib");
	}
	
	/*
	private char s1;    //标识
	private float speed;        //航速    //采样率(分析方式下的解析,char类型位置不变)
	private float ang;          //航向    //声速
	private float fre;          //中心频率//发射声源级
	private float bre;          //带宽    //检测域
	private float cre;          //脉宽    //仿真总时间
	private float distence;     //中心距离//仿真开始时刻
	private float ang1;         //俯仰角  //距离
	private float ang2;         //水平角
	private float time;         //时间周期
	private float cy1;          //采样频率
	private float ss;           //声源级
	private float ang3;         //发射角 
	private float ang4;         //接收角
	private char type1;//仿真类型
	private char type2;//包络
	private char type3;//信号形式
	private char len1;  //数据文件名长度
	private char[] file1 = new char[100];//文件名
	private char len2;  //模型文件名长度
	private char[] file2 = new char[100];//文件名
	*/
	public native void getmodel1(char s1,float speed,char[] file1);
	public native void getmodel1Object(DATA1 data);
	
}
