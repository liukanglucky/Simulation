package com.platform.report.send;

import java.io.Serializable;

/**
 * 
 * @author liukang
 * 模型7用
 */
public class DATA7 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1553907902929907815L;
	private char s1;    //标识
	private char seacon;//海况
	private float wspeed;        //海面风速
	private float fspeed;        //海流速度
	private float rain;          //降雨量
	private int num1 ;           //每平方千米舰船数
	private float len;           //长度
	private float[] speed1 = new float[30];    //水面舰典型工况航速数组30
	private float[] speed2 = new float[30];    //与航速对应的螺旋桨转速30
	private float sspeed;        //螺旋桨末端转速
	private float fre;           //中心频率
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public char getSeacon() {
		return seacon;
	}
	public void setSeacon(char seacon) {
		this.seacon = seacon;
	}
	public float getWspeed() {
		return wspeed;
	}
	public void setWspeed(float wspeed) {
		this.wspeed = wspeed;
	}
	public float getFspeed() {
		return fspeed;
	}
	public void setFspeed(float fspeed) {
		this.fspeed = fspeed;
	}
	public float getRain() {
		return rain;
	}
	public void setRain(float rain) {
		this.rain = rain;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public float getLen() {
		return len;
	}
	public void setLen(float len) {
		this.len = len;
	}
	public float[] getSpeed1() {
		return speed1;
	}
	public void setSpeed1(float[] speed1) {
		this.speed1 = speed1;
	}
	public float[] getSpeed2() {
		return speed2;
	}
	public void setSpeed2(float[] speed2) {
		this.speed2 = speed2;
	}
	public float getSspeed() {
		return sspeed;
	}
	public void setSspeed(float sspeed) {
		this.sspeed = sspeed;
	}
	public float getFre() {
		return fre;
	}
	public void setFre(float fre) {
		this.fre = fre;
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
	private float up; //噪声信号上限
	private float down;//噪声信号下限
	public float getUp() {
		return up;
	}
	public void setUp(float up) {
		this.up = up;
	}
	public float getDown() {
		return down;
	}
	public void setDown(float down) {
		this.down = down;
	}
	
}
