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
	private char s1;    //标识
	@StructField(order = 1)
	private float speed;        //航速    //采样率(分析方式下的解析,char类型位置不变)
	@StructField(order = 2)
	private float ang;          //航向    //声速
	@StructField(order = 3)
	private float fre;          //中心频率//发射声源级
	@StructField(order = 4)
	private float bre;          //带宽    //检测域
	@StructField(order = 5)
	private float cre;          //脉宽    //仿真总时间
	@StructField(order = 6)
	private float distence;     //中心距离//仿真开始时刻
	@StructField(order = 7)
	private float ang1;         //俯仰角  //距离
	@StructField(order = 8)
	private float ang2;         //水平角
	@StructField(order = 9)
	private float time;         //时间周期
	@StructField(order = 10)
	private float cy1;          //采样频率
	@StructField(order = 11)
	private float ss;           //声源级
	@StructField(order = 12)
	private float ang3;         //发射角 
	@StructField(order = 13)
	private float ang4;         //接收角
	@StructField(order = 14)
	private char type1;//仿真类型
	@StructField(order = 15)
	private char type2;//包络
	@StructField(order = 16)
	private char type3;//信号形式
	@StructField(order = 17)
	private char len1;  //数据文件名长度
	@StructField(order = 18)
	private char[] file1 = new char[100];//文件名
	@StructField(order = 19)
	private char len2;  //模型文件名长度
	@StructField(order = 20)
	private char[] file2 = new char[100];//文件名
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getAng() {
		return ang;
	}
	public void setAng(float ang) {
		this.ang = ang;
	}
	public float getFre() {
		return fre;
	}
	public void setFre(float fre) {
		this.fre = fre;
	}
	public float getBre() {
		return bre;
	}
	public void setBre(float bre) {
		this.bre = bre;
	}
	public float getCre() {
		return cre;
	}
	public void setCre(float cre) {
		this.cre = cre;
	}
	public float getDistence() {
		return distence;
	}
	public void setDistence(float distence) {
		this.distence = distence;
	}
	public float getAng1() {
		return ang1;
	}
	public void setAng1(float ang1) {
		this.ang1 = ang1;
	}
	public float getAng2() {
		return ang2;
	}
	public void setAng2(float ang2) {
		this.ang2 = ang2;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public float getCy1() {
		return cy1;
	}
	public void setCy1(float cy1) {
		this.cy1 = cy1;
	}
	public float getSs() {
		return ss;
	}
	public void setSs(float ss) {
		this.ss = ss;
	}
	public float getAng3() {
		return ang3;
	}
	public void setAng3(float ang3) {
		this.ang3 = ang3;
	}
	public float getAng4() {
		return ang4;
	}
	public void setAng4(float ang4) {
		this.ang4 = ang4;
	}
	public char getType1() {
		return type1;
	}
	public void setType1(char type1) {
		this.type1 = type1;
	}
	public char getType2() {
		return type2;
	}
	public void setType2(char type2) {
		this.type2 = type2;
	}
	public char getType3() {
		return type3;
	}
	public void setType3(char type3) {
		this.type3 = type3;
	}
	public char getLen1() {
		return len1;
	}
	public void setLen1(char len1) {
		this.len1 = len1;
	}
	public char[] getFile1() {
		return file1;
	}
	public void setFile1(char[] file1) {
		this.file1 = file1;
	}
	public char getLen2() {
		return len2;
	}
	public void setLen2(char len2) {
		this.len2 = len2;
	}
	public char[] getFile2() {
		return file2;
	}
	public void setFile2(char[] file2) {
		this.file2 = file2;
	}
	
	
	
}
