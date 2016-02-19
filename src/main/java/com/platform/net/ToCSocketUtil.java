package com.platform.net;

public class ToCSocketUtil {

	// 将有符号的char转换成无符号的char
	public static char[] ToUnsignedChar(char[] signChar) {
		for (int i = 0; i < signChar.length; i++) {
			int x = ((byte) signChar[i]) >= 0 ? signChar[i]
					: ((byte) signChar[i]) + 256;
			signChar[i] = (char) x;
		}
		return signChar;
	}
	
	public static char ToUnsignedChar(char c){
		int x = ((byte) c) >= 0 ? c
				: ((byte) c) + 256;
		c = (char) x;
		return c;
	}
	
}
