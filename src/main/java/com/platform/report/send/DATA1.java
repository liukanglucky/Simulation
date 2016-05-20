package com.platform.report.send;


import java.io.Serializable;
import java.util.Arrays;



/**
 * 模型1用
 */
public class DATA1 implements Serializable{

	private static final long serialVersionUID = -2297293241390496189L;
	
	@Override
	public String toString() {
		return "DATA1 [s1=" + s1 + ", speed=" + speed + ", ang=" + ang + ", fre=" + fre + ", bre=" + bre + ", cre="
				+ cre + ", distence=" + distence + ", ang1=" + ang1 + ", ang2=" + ang2 + ", time=" + time + ", cy1="
				+ cy1 + ", ss=" + ss + ", ang3=" + ang3 + ", ang4=" + ang4 + ", type1=" + type1 + ", type2=" + type2
				+ ", type3=" + type3 + ", len1=" + len1 + ", file1=" + Arrays.toString(file1) + ", len2=" + len2
				+ ", file2=" + Arrays.toString(file2) + ", dataindex=" + dataindex + ", cy=" + cy + ", dt=" + dt
				+ ", mt=" + mt + ", sim=" + sim + ", stype=" + stype + ", date1=" + date1 + ", time1=" + time1
				+ ", operator=" + operator + ", out1=" + out1 + ", out2=" + out2 + ", out3=" + out3 + ", out4=" + out4
				+ "]";
	}

	private char s1;    //标识
	private float[] speed = new float[30];        //航速    //采样率(分析方式下的解析,char类型位置不变)
	private float dbspeed ;						//由于数据库里只存第一个值，所以用dbspeed存储speed[0]
	
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
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public float[] getSpeed() {
		return speed;
	}
	public void setSpeed(float[] speed) {
		this.speed = speed;
		if(speed.length != 0)
			this.setDbspeed(speed[0]);
	}
	
	public float getDbspeed() {
		return dbspeed;
	}
	public void setDbspeed(float dbspeed) {
		this.dbspeed = dbspeed;
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
