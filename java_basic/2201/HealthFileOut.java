package com.ssafy.hw08.step2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HealthFileOut {
	public static void main(String[] args) {
		File file = new File("fileout_hw02.txt");
		if(file.exists()) {
			BufferedReader inFile;
			try {
				inFile = new BufferedReader(new FileReader(file));
				String sLine=null;
				while((sLine=inFile.readLine())!=null) {
					System.out.println(sLine);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
