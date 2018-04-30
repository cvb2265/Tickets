package com.tickets.Tickets.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyMain {

	public static void main(String[] args) throws Exception {
		//复制3个goods图片，复制539次
		for(int i=0; i<539*3; i+=3) {
			for(int k=1; k<4; k++) {
				copy("D:\\aa\\"+k+".jpg", "D:\\aa\\outputs\\"+(i+k)+".jpg");
			}
		}
		//复制49个cover图片，复制11次
		for(int i=1; i<=529; i+=11) {
			for(int k=0; k<11; k++) {
				copy("D:\\ab\\"+i+".jpg", "D:\\ab\\outputs\\"+(i+k)+".jpg");
			}
		}
	}
	
	private static void copy(String url1, String url2) throws Exception {
		FileInputStream in = new FileInputStream(new File(url1));
		FileOutputStream out = new FileOutputStream(new File(url2));
		byte[] buff = new byte[512];
		int n = 0;
		while ((n = in.read(buff)) != -1) {
			out.write(buff, 0, n);
		}
		out.flush();
		in.close();
		out.close();
	}

}
