package com.platform.report.send;

import java.io.Serializable;

/**
 * 
 * @author liukang
 * 模型2用
 */
public class DATA2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7116630896640649447L;
	
	private char s1;   //标识
	private float speed1;       //海底纵波声速
	private float speed2;       //横波声速
	private float jz;           //介质密度
	private float[] d1 = new float[4];        //纵波衰减系数
	private float[] d2 = new float[4];        //横波衰减系数
	private float num1;         //散射点数
	private float pu1;          //谱强度
	private float pu2;          //谱指数
	private float[] wind = new float[3];      //风速xyz
	private float[] fspeed = new float[3];    //海流速度xyz
	private float depth;		//海水深度
	private float speed3;       //声速
	private float[] d3= new float[4];        //衰减系数 
	private float pu3;          //谱系数
	private float pu4;		    //谱指数
	private float num2;		    //散射点数
	private float[] ang1 = new float[2];		//水平角
	private float[] ang2 = new float[2];      //垂直角
	private float[] ang3 = new float[2];		//方位角
	private float[] ang4 = new float[2];		//俯仰角
	private float ss;		    //声源级
	private float[] loc = new float[3];       //声源位置x
	private float[] speed = new float[3];     //声源速度x
	private float lm1;          //接收灵敏度
	private float cy1;          //采样率
	private float[] fre1 = new float[4];      //中心频率
	private float[] dk1 = new float[4];       //带宽
	private float mk1;          //脉宽
	private float[][] slocx = new float[36][3]; //阵元位置36
	private char num;  //阵元个数
	private char type1;//仿真类型
	private char[] type2 = new char[4];//信号形式
	private char len;  //文件名长度
	private char[] file = new char[255];//文件名
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public float getSpeed1() {
		return speed1;
	}
	public void setSpeed1(float speed1) {
		this.speed1 = speed1;
	}
	public float getSpeed2() {
		return speed2;
	}
	public void setSpeed2(float speed2) {
		this.speed2 = speed2;
	}
	public float getJz() {
		return jz;
	}
	public void setJz(float jz) {
		this.jz = jz;
	}
	public float[] getD1() {
		return d1;
	}
	public void setD1(float[] d1) {
		this.d1 = d1;
	}
	public float[] getD2() {
		return d2;
	}
	public void setD2(float[] d2) {
		this.d2 = d2;
	}
	public float getNum1() {
		return num1;
	}
	public void setNum1(float num1) {
		this.num1 = num1;
	}
	public float getPu1() {
		return pu1;
	}
	public void setPu1(float pu1) {
		this.pu1 = pu1;
	}
	public float getPu2() {
		return pu2;
	}
	public void setPu2(float pu2) {
		this.pu2 = pu2;
	}
	public float[] getWind() {
		return wind;
	}
	public void setWind(float[] wind) {
		this.wind = wind;
	}
	public float[] getFspeed() {
		return fspeed;
	}
	public void setFspeed(float[] fspeed) {
		this.fspeed = fspeed;
	}
	public float getDepth() {
		return depth;
	}
	public void setDepth(float depth) {
		this.depth = depth;
	}
	public float getSpeed3() {
		return speed3;
	}
	public void setSpeed3(float speed3) {
		this.speed3 = speed3;
	}
	public float[] getD3() {
		return d3;
	}
	public void setD3(float[] d3) {
		this.d3 = d3;
	}
	public float getPu3() {
		return pu3;
	}
	public void setPu3(float pu3) {
		this.pu3 = pu3;
	}
	public float getPu4() {
		return pu4;
	}
	public void setPu4(float pu4) {
		this.pu4 = pu4;
	}
	public float getNum2() {
		return num2;
	}
	public void setNum2(float num2) {
		this.num2 = num2;
	}
	public float[] getAng1() {
		return ang1;
	}
	public void setAng1(float[] ang1) {
		this.ang1 = ang1;
	}
	public float[] getAng2() {
		return ang2;
	}
	public void setAng2(float[] ang2) {
		this.ang2 = ang2;
	}
	public float[] getAng3() {
		return ang3;
	}
	public void setAng3(float[] ang3) {
		this.ang3 = ang3;
	}
	public float[] getAng4() {
		return ang4;
	}
	public void setAng4(float[] ang4) {
		this.ang4 = ang4;
	}
	public float getSs() {
		return ss;
	}
	public void setSs(float ss) {
		this.ss = ss;
	}
	public float[] getLoc() {
		return loc;
	}
	public void setLoc(float[] loc) {
		this.loc = loc;
	}
	public float[] getSpeed() {
		return speed;
	}
	public void setSpeed(float[] speed) {
		this.speed = speed;
	}
	public float getLm1() {
		return lm1;
	}
	public void setLm1(float lm1) {
		this.lm1 = lm1;
	}
	public float getCy1() {
		return cy1;
	}
	public void setCy1(float cy1) {
		this.cy1 = cy1;
	}
	public float[] getFre1() {
		return fre1;
	}
	public void setFre1(float[] fre1) {
		this.fre1 = fre1;
	}
	public float[] getDk1() {
		return dk1;
	}
	public void setDk1(float[] dk1) {
		this.dk1 = dk1;
	}
	public float getMk1() {
		return mk1;
	}
	public void setMk1(float mk1) {
		this.mk1 = mk1;
	}
	public float[][] getSlocx() {
		return slocx;
	}
	public void setSlocx(float[][] slocx) {
		this.slocx = slocx;
	}
	public char getNum() {
		return num;
	}
	public void setNum(char num) {
		this.num = num;
	}
	public char getType1() {
		return type1;
	}
	public void setType1(char type1) {
		this.type1 = type1;
	}
	public char[] getType2() {
		return type2;
	}
	public void setType2(char[] type2) {
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
		System.out.println("file len is"+file.length);
		for (int i = 0; i < file.length; i++) {
			System.out.println(file[i]);
			this.file[i] = file[i];
		}
		
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
