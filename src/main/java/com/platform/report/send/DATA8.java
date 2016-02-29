package com.platform.report.send;

import java.io.Serializable;

/**
 * 
 * @author liukang
 * 模型8用
 */
public class DATA8 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6679333793318757079L;
	private char s1;   //标识
	private float fre;          //中心频率
	private float wspeed;       //海面风速
	private char type1;//海底地貌
	private char num1; //海深个数
	private float[] sead = new float[3]; //海深文件[2]表示：垂直深度步长
	private float ss1;          //海面反射系数
	private float ss2;          //海底衰减系数
	private float len1;         //输出距离步长
	private float len2;         //最大距离
	private int num2;           //射线数量
	private float len3;         //收发间距
	private char type2;//海况
	private float[] cord = new float[2];      //发射换能器初始坐标
	private char type3;//发射阵信息
	private float ss3;          //发射指向性
	private float sn;           //发射声源级
	private char type4;//发射信号形式
	private float dep;          //接收深度
	private char type5;//接收阵信息
	private float[] frew = new float[2];      //工作频段2
	private int num3;           //计算频率点数
	private char type6; //海底底质类型
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public float getFre() {
		return fre;
	}
	public void setFre(float fre) {
		this.fre = fre;
	}
	public float getWspeed() {
		return wspeed;
	}
	public void setWspeed(float wspeed) {
		this.wspeed = wspeed;
	}
	public char getType1() {
		return type1;
	}
	public void setType1(char type1) {
		this.type1 = type1;
	}
	public char getNum1() {
		return num1;
	}
	public void setNum1(char num1) {
		this.num1 = num1;
	}
	public float[] getSead() {
		return sead;
	}
	public void setSead(float[] sead) {
		this.sead = sead;
	}
	public float getSs1() {
		return ss1;
	}
	public void setSs1(float ss1) {
		this.ss1 = ss1;
	}
	public float getSs2() {
		return ss2;
	}
	public void setSs2(float ss2) {
		this.ss2 = ss2;
	}
	public float getLen1() {
		return len1;
	}
	public void setLen1(float len1) {
		this.len1 = len1;
	}
	public float getLen2() {
		return len2;
	}
	public void setLen2(float len2) {
		this.len2 = len2;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public float getLen3() {
		return len3;
	}
	public void setLen3(float len3) {
		this.len3 = len3;
	}
	public char getType2() {
		return type2;
	}
	public void setType2(char type2) {
		this.type2 = type2;
	}
	public float[] getCord() {
		return cord;
	}
	public void setCord(float[] cord) {
		this.cord = cord;
	}
	public char getType3() {
		return type3;
	}
	public void setType3(char type3) {
		this.type3 = type3;
	}
	public float getSs3() {
		return ss3;
	}
	public void setSs3(float ss3) {
		this.ss3 = ss3;
	}
	public float getSn() {
		return sn;
	}
	public void setSn(float sn) {
		this.sn = sn;
	}
	public char getType4() {
		return type4;
	}
	public void setType4(char type4) {
		this.type4 = type4;
	}
	public float getDep() {
		return dep;
	}
	public void setDep(float dep) {
		this.dep = dep;
	}
	public char getType5() {
		return type5;
	}
	public void setType5(char type5) {
		this.type5 = type5;
	}
	public float[] getFrew() {
		return frew;
	}
	public void setFrew(float[] frew) {
		this.frew = frew;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public char getType6() {
		return type6;
	}
	public void setType6(char type6) {
		this.type6 = type6;
	}
	
	
	private int dataindex;
	private int cy;
	private int dt;
	private int mt;
	private int sim;
	private int stype;
	private int date1;
	private int time1;
	private int operator; 
	private String out1;
	private String out2;
	private String out3;
	private String out4;
	public int getCy() {
		return cy;
	}
	public void setCy(int cy) {
		this.cy = cy;
	}
	public int getDt() {
		return dt;
	}
	public void setDt(int dt) {
		this.dt = dt;
	}
	public int getMt() {
		return mt;
	}
	public void setMt(int mt) {
		this.mt = mt;
	}
	public int getSim() {
		return sim;
	}
	public void setSim(int sim) {
		this.sim = sim;
	}
	public int getStype() {
		return stype;
	}
	public void setStype(int stype) {
		this.stype = stype;
	}
	public int getDate1() {
		return date1;
	}
	public void setDate1(int date1) {
		this.date1 = date1;
	}
	public int getTime1() {
		return time1;
	}
	public void setTime1(int time1) {
		this.time1 = time1;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public String getOut1() {
		return out1;
	}
	public void setOut1(String out1) {
		this.out1 = out1;
	}
	public String getOut2() {
		return out2;
	}
	public void setOut2(String out2) {
		this.out2 = out2;
	}
	public String getOut3() {
		return out3;
	}
	public void setOut3(String out3) {
		this.out3 = out3;
	}
	public String getOut4() {
		return out4;
	}
	public void setOut4(String out4) {
		this.out4 = out4;
	}
	public int getDataindex() {
		return dataindex;
	}
	public void setDataindex(int dataindex) {
		this.dataindex = dataindex;
	}
	
	
}
