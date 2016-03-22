package com.platform.net;

import com.platform.util.ByteUtil;


public class ConvertResult {
	/**
	 * struct1{ char a 1/2/3/4, char[1000] b} model1 and model2 ,return num is 3   sizeof 1001
	 * struct2{char a 4,float[20] b,float[20] c ,float[20] d,float e ,float f, char g ,char h} model 3-model 6 sizeof256
	 * struct3{char ,float,float, int ,string} model7
	 * struct4{char 2/3, char[255],char[255],char[255],char[255]} model8
	 */
	
	
	/**
	 * 将返回结果转换为js可解析格式
	 * @param s
	 * @return
	 */
	//如果char是unsigned char（0-255的数字）
	//先末位加3个0变成byte数组 再ByteUtil.getInt
	public static String convertStruct1(byte[] recv){
		StringBuilder result = new StringBuilder();
		result.append(recv[0]+",");
		//高位
		byte[] temp = new byte[4];
		temp[1] = 0;
		temp[2] = 0;
		temp[3] = 0;
		
		for(int i = 1;i < 1001 ; i++){
			temp[0] = recv[i];
			
			//System.out.println(recv[i]+"");
			
			result.append(ByteUtil.getInt(temp));
			if(i!=1000)
				result.append("_");
		}
		
		return result.toString();
	}
	
	public static String convertStruct2(byte[] recv){
		StringBuilder result = new StringBuilder();
		
		result.append((int)recv[0]+",");
		
		for(int i = 4; i<252 ; i += 4){
			byte[] temp = new byte[4];
			temp[0] = recv[i];
			temp[1] = recv[i+1];
			temp[2] = recv[i+2];
			temp[3] = recv[i+3];
			result.append(ByteUtil.getFloat(temp));
			result.append("_");
		}
		
		result.append((int)recv[252]);
		result.append("_");
		result.append((int)recv[253]);
		
		return result.toString();
	}
	
	public static String convertStruct3(byte[] recv){
		StringBuilder result = new StringBuilder();
		result.append(""+(int)recv[0]+",");
		for(int i = 4; i<12 ; i += 4){
			byte[] temp = new byte[4];
			temp[0] = recv[i];
			temp[1] = recv[i+1];
			temp[2] = recv[i+2];
			temp[3] = recv[i+3];
			result.append(ByteUtil.getFloat(temp));
			result.append("_");
		}
		
		byte[] temp = new byte[4];
		temp[0] = recv[12];
		temp[1] = recv[13];
		temp[2] = recv[14];
		temp[3] = recv[15];
		result.append(ByteUtil.getInt(temp));
		result.append("_");
		
		for(int i = 16;i<1016;i++){
			result.append((char)recv[i]);
			if(i!=1015)
				result.append("_");
		}
		
		return result.toString();
	}
	
	public static String convertStruct4(byte[] recv){
		StringBuilder result = new StringBuilder();
		result.append(""+(int)recv[0]+",");
		//高位
		byte[] temp = new byte[4];
		temp[1] = 0;
		temp[2] = 0;
		temp[3] = 0;
		for(int i = 1;i < 1021;i++){
			temp[0] = recv[i];
			result.append(ByteUtil.getInt(temp));
			if(i!=1020)
				result.append("_");
		}
		return result.toString();
	}
}
