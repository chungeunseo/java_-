/*
Test4.java : 팀원 평균

[테스트케이스]

5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("Test4.txt"));
		
		int testcase = in.nextInt();
		for (int i = 0; i < testcase; i++) {
			//한 조에 몇명인지 받아오기
			int peopleNum = in.nextInt();
			//각 조의 점수 합을 구하기 위해 총점을 초기화
			int sum=0;
			//각 조의 점수를 배열에 저장
			int tc[] = new int[peopleNum];
			//각 조의 명 수 만큼 배열에 저장
			for(int k=0;k<peopleNum;k++) {	
				tc[k]=in.nextInt();
			}
			//각 조의 점수의 합 구하기
			for(int j=0;j<tc.length;j++) {
				sum+=tc[j];
			}
			//평균을 넘는 사람의 명수를 셀 변수 지정
			int cnt=0;
			//평균 구하기
			double avg = (double)sum/peopleNum;
			//평균 넘는 사람 카운트
			for(int m=0;m<tc.length;m++) {
				if(tc[m]>avg) {
					cnt++;
				}
			}
			//평균 넘는사람을 전체 사람 수로 나누어 퍼센트 구하기
			double pct = (double)cnt/peopleNum;
			double pct2 = pct*100;
			//출력하기
			System.out.print("#"+(i+1)+" ");
			System.out.printf("%.3f",pct2);
			System.out.print("%");
			System.out.println();


		}
		in.close();
	}
}
