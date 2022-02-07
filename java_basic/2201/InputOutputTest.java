package com.ssafy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InputOutputTest {
	/*
	    "a.txt"의 내용  ==>  abcd
			문제)  'a.txt'파일을 읽어서 그 내용을 콘솔에 출력하시오.
			문제)  'a.txt'파일을 읽어서 char[] ch=new char[5] 에 출력하시오.
		"a.txt"의 내용  ==>  abcdefgh
			문제)  'a.txt'파일 내용 중 첫번째 문자부터 4개를 읽어 char배열에 출력하시오.
			문제)  'a.txt'파일 내용 중 두번째 문자부터 4개를 읽어 char배열에 출력하시오.
		=====================================================================================
		읽기 - byte단위(InputStream), 문자단위(Reader)  -  파일읽기  (FileInputStream, FileReader)
		쓰기 - byte단위(OutputStream), 문자단위(Writer)  -  파일쓰기 (FileOutputStream, FileWriter)	
	*/
	
	public static void main(String[] args) {
//		FileReader fr = new FileReader("c:"+File.separator+"ssafy"+File.separator+"a.txt");
		
		//JDK6버전
//		FileReader fr=null;
//		try {
//			 fr= new FileReader("a.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//			   if(fr != null)	
//				 fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		//JDK7버전
		try (FileReader fr= new FileReader("a.txt")){ 
			//문제)  'a.txt'파일을 읽어서 그 내용을 콘솔에 출력하시오.
//			int i;
//			while( (i=fr.read())  != -1 ) {
//				System.out.print((char)i);
//			}
			
			//문제)  'a.txt'파일을 읽어서 char[] ch=new char[5] 에 출력하시오.
//			char[] ch=new char[5];
//			fr.read(ch);  //fr == 'a.txt'  fr을 읽어서 ch에 복사
//			System.out.println(Arrays.toString(ch));
			
			
			
//			문제)  'a.txt'파일 내용 중 첫번째 문자부터 4개를 읽어 char배열에 출력하시오.
//			fr.read(cbuf, 시작인덱스offset, length)
//			char[] ch=new char[5];
//            fr.read(ch,0,4);
//			System.out.println(Arrays.toString(ch));
			
			
//			문제)  'a.txt'파일 내용 중 두번째 문자부터 4개를 읽어 char배열에 출력하시오.
			char[] ch=new char[5];
																
			fr.read(ch,1,4);
			System.out.println(Arrays.toString(ch));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//main
}//end class










