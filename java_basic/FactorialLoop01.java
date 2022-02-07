package com.ssafy.ws01;

import java.util.Scanner;

/**
 * 팩토리얼 구하기
 * @author 조효은
 * @since 2022.01.17
 */
public class FactorialLoop01 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요: ");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int fac=n;
		int s=1;
		//초기 조건 반복 스텝 조건 반복 스텝  조건 끝
		while(fac!=0) {
			s=s*fac;
			fac--;
		}
		
		System.out.printf("%d!=%d",n,s);
		
	}

}