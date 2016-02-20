package com.platform.report.send;


import java.io.Serializable;

import struct.StructClass;
import struct.StructField;

@StructClass

/**
 * 模型1用
 */
public class DATA1 implements Serializable{

	private static final long serialVersionUID = -2297293241390496189L;
	
	@StructField(order = 0)
	public char s1;    //标识
	@StructField(order = 1)
	public float speed;        //航速    //采样率(分析方式下的解析,char类型位置不变)
	@StructField(order = 2)
	public float ang;          //航向    //声速
	@StructField(order = 3)
	public float fre;          //中心频率//发射声源级
	@StructField(order = 4)
	public float bre;          //带宽    //检测域
	@StructField(order = 5)
	public float cre;          //脉宽    //仿真总时间
	@StructField(order = 6)
	public float distence;     //中心距离//仿真开始时刻
	@StructField(order = 7)
	public float ang1;         //俯仰角  //距离
	@StructField(order = 8)
	public float ang2;         //水平角
	@StructField(order = 9)
	public float time;         //时间周期
	@StructField(order = 10)
	public float cy1;          //采样频率
	@StructField(order = 11)
	public float ss;           //声源级
	@StructField(order = 12)
	public float ang3;         //发射角 
	@StructField(order = 13)
	public float ang4;         //接收角
	@StructField(order = 14)
	public char type1;//仿真类型
	@StructField(order = 15)
	public char type2;//包络
	@StructField(order = 16)
	public char type3;//信号形式
	@StructField(order = 17)
	public char len1;  //数据文件名长度
	@StructField(order = 18)
	public char[] file1 = new char[100];//文件名
	@StructField(order = 19)
	public char len2;  //模型文件名长度
	@StructField(order = 20)
	public char[] file2 = new char[100];//文件名
	
}
