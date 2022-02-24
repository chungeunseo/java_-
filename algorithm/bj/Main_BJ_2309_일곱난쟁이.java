package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] nanjang = new int[9];
		int sum=0;
		for (int i=0;i<9;i++) {
			nanjang[i]=sc.nextInt();
			sum+=nanjang[i];
		}
		int min = sum-100;
		int nonan1=0,nonan2=0;
		for (int i=0;i<9;i++) {
			for(int j=1;j<9;j++) {
				if(nanjang[i]+nanjang[j]==min) {
					nonan1=i;
					nonan2=j;
				}
			}
		}
		int[] realnan = new int[9];
		for(int i=0;i<9;i++) {
			if(i!=nonan1 && i!=nonan2) {
				realnan[i]=nanjang[i];
			}
		}
		Arrays.sort(realnan);
		for(int i=2;i<9;i++) {
			System.out.println(realnan[i]);
		}
	}
}
