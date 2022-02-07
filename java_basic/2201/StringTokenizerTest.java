package com.ssafy;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	
  public static void main(String[] args) {
	//StringTokenizer : 문자열 데이터를 특정 구분자(delimiter)로 분리해주는 클래스
	  
	  //StringTokenizer(String str,String delim)
	  //str---> 기준문자열,   delim---> 구분자
	  //token(토큰): 분리된 각각의 데이터!!
	  
	 String tel="010--4567"; 
	 StringTokenizer st = new StringTokenizer(tel, "-");
	 StringTokenizer st2 = new StringTokenizer(tel);
	 //기본=> 공백 한칸!!
	 //st=["010","123","4567"]
	 
	 //String nextToken()  
	 //String tel1 = st.nextToken();
	/* System.out.println(st.nextToken());
	 System.out.println(st.nextToken());
	 System.out.println(st.nextToken());*/ 
	 
	 //st=["010","123","4567"]
	 while(st.hasMoreTokens()) {//st에 토큰데이터를 가지고 있다면 true 리턴
		 System.out.println(st.nextToken());//토큰 데이터 뽑아오기
		 //nextToken() st=["123","4567"]
		 //nextToken() st=["4567"]
		 //nextToken() st=[]				 
	 } 
	 
	 //--------------------------------------------------
	 //String tel="010-123-4567";
	 //tel.split(String regex) : 특정문자를 통해 데이터를 분리!!
	 System.out.println("==================");
	 String [] tels = tel.split("-");//tels[]={"010","123","4567"};
	 for(int i=0; i<tels.length; i++) {
		 System.out.println("tels["+i+"]="+tels[i]);
	 }
	 
	 
	 
  }//main

}







