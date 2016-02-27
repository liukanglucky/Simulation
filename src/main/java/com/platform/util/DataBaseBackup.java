package com.platform.util;

import java.io.File;
import java.io.IOException;

public class DataBaseBackup {
	
	public static void main(String[] args) {
		String filename="datadump";
		try {
		    DataBaseBackup.dataBackup("SYSTEM", "Aa123456",
		      "192.168.0.116:1521:XE", "/Users/wu/Git/SimulationPlatform/data", filename);
		   } catch (IOException e) {
		    e.printStackTrace();
		   } catch (InterruptedException e) {
		    e.printStackTrace();
		   }
	}
	
	 
	public static void dataBackup(String username, String password,
	   String netname, String filepath, String filename)
	   throws IOException, InterruptedException {
	  Runtime rt = Runtime.getRuntime();
	  Process processexp = null;
	  Boolean flag = checkCreatDir(filepath, filename);
	  if (flag) {
	   String exp = "exp " + username + "/" + password + "@" + netname
	     + " file=" + filepath + "/" + filename + ".dmp";
	   // int success = 0;
	   try {
	    processexp = rt.exec(exp);
	   } catch (IOException e) {
	    // success = -1;
	    e.printStackTrace();
	   }
	  }
	 }
	 
	 public static Boolean checkCreatDir(String dirPath, String filename) { // 目录是否存在
	  File file = new File(dirPath);
	  if (!file.exists()) {
	   file.mkdirs();
	   return true;
	  }
	  if (file.isDirectory()) {
	   if (file.listFiles().length > 0) {
	    String filenameTmp = filename + ".dmp";
	    File[] files = file.listFiles();
	    for (File flis : files) {
	     if (flis.getName().equals(filenameTmp)) {
	      return false;
	     }
	    }
	   }
	  }
	  return true;
	}


}
