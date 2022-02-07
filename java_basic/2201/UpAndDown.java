package com.ssafy.ws01.step2;

import java.util.Scanner;

public class UpAndDown {
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int com= (int)(Math.random()*100)+1;//1~100
		int count=0;
		while(true) {
			System.out.println("게싱하세요!");
			int guess=scann.nextInt();
			count++;
			if(com==guess) {
				System.out.printf("정답입니다. 게싱 회수는 %d회입니다.\n",count);
				break;
			}else {
				if(com>guess) {
					System.out.printf("큰수를 입력하세요. 게싱 회수는 %d회입니다.\n",count);
				}else if(com<guess) {
					System.out.printf("작은수를 입력하세요. 게싱 회수는 %d회입니다.\n",count);
				}
			}
		}
	}

}