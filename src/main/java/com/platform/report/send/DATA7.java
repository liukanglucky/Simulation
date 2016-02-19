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
	
	
}
