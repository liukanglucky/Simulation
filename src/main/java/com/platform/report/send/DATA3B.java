package com.platform.report.send;

import java.io.Serializable;

/**
 * 
 * @author liukang
 * 模型3仿真用
 */
public class DATA3B implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1297522996111353186L;
	
	private char s1;   //标识
	private float weight;       //吨位
	private float depth;        //水深
	private float speed;        //航速
	private float[] fre1 = new float[2];      //输出频率1-2
	private float cy1;          //采样率
	private float zy1;          //增益
	private float lm1;          //灵敏度
	private float num1; //阵元个数
	private float ss;           //速度对应谱级
	private float fre2;         //轴频频率
	private float num2; //螺旋桨叶片数
	private float[] xp1 = new float[20];      //线谱频率20
	private float[] xp2 = new float[20];      //线谱强度20
	private float[] de = new float[20];       //调制深度20
	private char type1;//仿真类型
	private char type2;//目标类型
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
	public float getNum1() {
		return num1;
	}
	public void setNum1(float num1) {
		this.num1 = num1;
	}
	public float getSs() {
		return ss;
	}
	public void setSs(float ss) {
		this.ss = ss;
	}
	public float getFre2() {
		return fre2;
	}
	public void setFre2(float fre2) {
		this.fre2 = fre2;
	}
	public float getNum2() {
		return num2;
	}
	public void setNum2(float num2) {
		this.num2 = num2;
	}
	public float[] getXp1() {
		return xp1;
	}
	public void setXp1(float[] xp1) {
		this.xp1 = xp1;
	}
	public float[] getXp2() {
		return xp2;
	}
	public void setXp2(float[] xp2) {
		this.xp2 = xp2;
	}
	public float[] getDe() {
		return de;
	}
	public void setDe(float[] de) {
		this.de = de;
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
	
	float outp1;//调制谱轴频频率
	float outp2;//频带内总声级
	char outp3;//螺旋桨叶片数
	public float getOutp1() {
		return outp1;
	}
	public void setOutp1(float outp1) {
		this.outp1 = outp1;
	}
	public float getOutp2() {
		return outp2;
	}
	public void setOutp2(float outp2) {
		this.outp2 = outp2;
	}
	public char getOutp3() {
		return outp3;
	}
	public void setOutp3(char outp3) {
		this.outp3 = outp3;
	}
	
}
