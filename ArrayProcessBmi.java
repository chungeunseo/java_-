package com.ssafy.hw04;

public class ArrayProcessBmi {
	
	public static void print2d(double[][] result) {
        double m = result.length;
        double n = result[0].length;
        System.out.println("idx\t만 나이\t몸무게kg\t키m");
        for (int i = 0; i < m; i++) {
        	System.out.print("학원생"+(i+1)+"\t");
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
		double[][] arr= {{21,53.2,1.673},
				{35,90.3,1.781},{28,70.7,1.653},
				{25,75.1,1.811},{31,62.0,1.532}};
		print2d(arr);
		double ageTotal=0;
		double kgTotal=0;
		double cmTotal=0;
		for (int i=0;i<arr.length;i++) {
			ageTotal +=arr[i][0];
			kgTotal +=arr[i][1];
			cmTotal +=arr[i][2];
		}
		double ageAverage,kgAverage,cmAverage;
		ageAverage=ageTotal/5;
		kgAverage=kgTotal/5;
		cmAverage=cmTotal/5;
		System.out.printf("평균\t%.3f\t%.3f\t%.3f",ageAverage, kgAverage,cmAverage);
	}
}
