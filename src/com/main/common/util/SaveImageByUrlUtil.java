package com.main.common.util;

import java.io.BufferedInputStream;  
import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.net.HttpURLConnection;  
import java.net.URL;


public class SaveImageByUrlUtil { 
	  
	 public static void saveToFile(String destUrl) {  
	 FileOutputStream fos = null;  
	 BufferedInputStream bis = null;  
	 HttpURLConnection httpUrl = null;  
	 URL url = null;  
	 int BUFFER_SIZE = 1024;  
	 byte[] buf = new byte[BUFFER_SIZE];  
	 int size = 0;  
	 try {  
		 url = new URL(destUrl);  
		 httpUrl = (HttpURLConnection) url.openConnection();  
		 httpUrl.connect();  
		 bis = new BufferedInputStream(httpUrl.getInputStream());  
		 fos = new FileOutputStream(new File("G:\\test.jpg"));  
		 while ((size = bis.read(buf)) != -1) {  
		    fos.write(buf, 0, size);  
	     }  
	     fos.flush();  
	 } catch (IOException e) {
		  
	 } catch (ClassCastException e) {
		 
	 } finally {  
		 try {  
			 fos.close();  
			 bis.close();  
			 httpUrl.disconnect();  
		 } catch (IOException e) {  
		 } catch (NullPointerException e) {  
		 }  
     }  
	 }  
	 public static void main(String[] args) {  
		 SaveImageByUrlUtil.saveToFile("http://qidian.qpic.cn/qdbimg/349573/c_7539673104047903/90");  
	 }  
}
