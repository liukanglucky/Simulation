package com.platform.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.platform.net.ConvertResult;

public class FileUtil {
	
	//读取文件
	public static String readFile(String sourceFilePath,String encode) throws IOException{
		File file = new File(sourceFilePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),encode));
		StringBuilder sb = new StringBuilder();
		String sLine = null;
		while((sLine = br.readLine())!=null){
			sb.append(sLine);
			sb.append("\r\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//读取文件,并将文件转换为byte数组
	public byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length
		&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
		throw new IOException("Could not completely read file "
					+ file.getName());
		}
		fi.close();
		return buffer;
	}

	
	/**
	 * NIO way
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] getContentByNIO(String filename) throws IOException {

		File f = new File(filename);
		if (!f.exists()) {
			throw new FileNotFoundException(filename);
		}

		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		//readFile("\\\\192.168.220.201\\D\\share\\test.txt","utf-8");
		byte[] result = (new FileUtil()).getContentByNIO("/Users/songshaoying/Desktop/IP.txt");
		System.out.println(result.length);
		
		System.out.println(ConvertResult.convertMt(result));
		
		
//		for(int i=0 ; i<result.length;i=i+28){
//			
//			
//			byte[] temp = Arrays.copyOfRange(result, i,i+28);
//			for (int j = 0; j < temp.length; j++) {
//				System.out.print(temp[j]+",");
//			}
//			System.out.println("");
//			byte[] ip = {temp[0],temp[1],temp[2],temp[3],0,0,0,0};
//			
//			
//			System.out.println("ip is "+ByteUtil.getLong(ip));
//			
//			byte[] type = {temp[4],0,0,0};
////			byte[] name = Arrays.copyOfRange(temp, 24, 152);
//			
//			System.out.println("type is "+ByteUtil.getInt(type));
//			System.out.print("name is ");
//			for(int j = 8;j <=23;j++ ){
//				byte[] temp2 = {temp[j],0,0,0};
//				
//				System.out.print(""+ByteUtil.getChar(temp2)+"");
//				
//			}
//			
//			System.out.println("");
//			byte[] index = {temp[24],0,0,0};
//			System.out.println("index is "+ByteUtil.getInt(index));
//			System.out.println("===＝＝＝＝＝");
////			System.out.println(ByteUtil.getInt(index));
//		}
//		byte[] tsb = {2,0,-88,64};
//		System.out.println(ByteUtil.getString(tsb));
//		
//		BigInteger big = new BigInteger(tsb);
//		System.out.println(big.toString());
//		byte[] bigarray = big.toByteArray();
//		for (int i = 0; i < bigarray.length; i++) {
//			System.out.println(bigarray[i]);
//		}
		
	}
}
