package com.ssafy.hw02;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrint extends PrintProcess{

	@Override
	public void print(String str) {
		try {
			FileWriter out = new FileWriter("fileout_hw06.txt");
			out.write(str);
			out.close();
			System.out.println("파일입력 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
   
}
