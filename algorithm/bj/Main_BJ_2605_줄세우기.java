package practice;

import java.util.Scanner;

public class Main_BJ_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		int[] student = new int[num];
		for(int i=0;i<num;i++) {
			student[i]=sc.nextInt();
		}
		int[] ans = new int[num];
		int[] tmp = new int[num];
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				tmp[j]=ans[j];
			}
			ans[i-student[i]]=i+1;
			for(int j=i-student[i];j<num-1;j++) {
				ans[j+1]=tmp[j];
			}
		}
		for(int i=0;i<num;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
