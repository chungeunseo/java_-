package com.ssafy.ws01.step3;

/**
 * 모래시계 모양의 숫자 출력하는 클래스
 */
public class DigitTest2 {

	public static void main(String[] args) {
		  int sum = 1;
		  for (int i = 0 ; i < 3 ; i++) {
		   for (int j = 0 ; j < i ; j++)
		    System.out.print("   ");
		   
		   for (int j = 0 ; j < 5-(2*i) ; j++) {
		    System.out.printf("%3d", sum);
		    sum++;
		   }
		   
		   for (int j = 0 ; j < i ; j++)
		    System.out.print("   ");
		   
		   System.out.println();
		  }
		 
		  for (int i = 3-1 ; i > 0 ; i--) {
		   for (int j = 0 ; j < i-1 ; j++)
		    System.out.print("   ");
		   
		   for (int j = 5 ; j > (i-1)*2 ; j--) {
		    System.out.printf("%3d", sum);
		    sum++;
		   }
		   
		   for (int j = 0 ; j < i ; j++)
		    System.out.print("   ");
		   
		   System.out.println();
		  }
		 
	}
}