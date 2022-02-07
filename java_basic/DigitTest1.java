package com.ssafy.ws01.step3;
/**
 * 직각삼각형 모양의 숫자 출력하는 클래스
 */
public class DigitTest1 {
	public static void main(String[] args) {
		int num=1;
		for (int i=0; i<5; i++) {
			for (int j=0; j<i;j++) {
				System.out.print("   ");
			}
			for (int k=0;k<5-i;k++) {
					System.out.printf("%3d", num);
					num++;
			}
			System.out.println();
			}
		}
	}

