package com.platform.report.send;

import java.io.Serializable;

/**
 * 
 * @author liukang
 * 模型3分析用(模型4A通用)
 */
public class DATA3A implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1001882944019923442L;
	
	private char s1;   //标识
	private float weight;       //吨位
	private float depth;        //水深
	private float speed;        //航速
	private float[] fre1 = new float[2];      //输出频率1-2
	private float cy1;          //采样率
	private float zy1;          //增益
	private float lm1;          //灵敏度
	private float num;  //阵元个数
	private float ss;           //模拟声纳采样率
	private float[] fre2 = new float[2];      //带通滤波频率1-2
	private float time1;          //数据起始时刻
	private float time2;          //数据总长度
	private float zy2;          //模拟增益
	private float lm2;          //模拟灵敏度
	private char type1;//仿真类型
	private char type2;//目标类型1:001；2:054A；3:039；4：Y7A;5：Y10
	private char len;  //文件名长度
	private char[] file = new char[255];//文件名
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getDepth() {
		return depth;
	}
	public void setDepth(float depth) {
		this.depth = depth;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float[] getFre1() {
		return fre1;
	}
	public void setFre1(float[] fre1) {
		this.fre1 = fre1;
	}
	public float getCy1() {
		return cy1;
	}
	public void setCy1(float cy1) {
		this.cy1 = cy1;
	}
	public float getZy1() {
		return zy1;
	}
	public void setZy1(float zy1) {
		this.zy1 = zy1;
	}
	public float getLm1() {
		return lm1;
	}
	public void setLm1(float lm1) {
		this.lm1 = lm1;
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}
	public float getSs() {
		return ss;
	}
	public void setSs(float ss) {
		this.ss = ss;
	}
	public float[] getFre2() {
		return fre2;
	}
	public void setFre2(float[] fre2) {
		this.fre2 = fre2;
	}
	public float getTime1() {
		return time1;
	}
	public void setTime1(float time1) {
		this.time1 = time1;
	}
	public float getTime2() {
		return time2;
	}
	public void setTime2(float time2) {
		this.time2 = time2;
	}
	public float getZy2() {
		return zy2;
	}
	public void setZy2(float zy2) {
		this.zy2 = zy2;
	}
	public float getLm2() {
		return lm2;
	}
	public void setLm2(float lm2) {
		this.lm2 = lm2;
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
	public char getLen() {
		return len;
	}
	public void setLen(char len) {
		this.len = len;
	}
	public char[] getFile() {
		return file;
	}
	public void setFile(char[] file) {
		this.file = file;
	}
	
	private int dataindex;
	private int cy;
	private int dt;
	private int mt;
	private int sim;
	private int stype;
	private int date1;
	private int time;//与DATA3A中数据启始时刻（time1）冲突，改为time
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
