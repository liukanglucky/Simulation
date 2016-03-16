package com.platform.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

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
	
	
	
	public static void main(String[] args) throws IOException {
		readFile("\\\\192.168.220.201\\D\\share\\test.txt","utf-8");
	}
}
