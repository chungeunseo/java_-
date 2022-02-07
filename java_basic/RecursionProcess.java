package com.ssafy.hw02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecursionProcess {
	static int sum (int n) {
		if(n<=0) {
			return 0;
		} else {
			return n+sum(n-1);
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int result1 =sum(num1);
		int result2 =sum(num2);
		System.out.println("1부터 "+num1+"까지 합 : "+result1);
		System.out.println("1부터 "+num2+"까지 합 : "+result2);
	}

}
