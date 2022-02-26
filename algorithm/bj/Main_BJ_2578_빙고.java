package practice;

import java.util.Scanner;

public class Main_BJ_2578_빙고 {
	static int ans;
	static int[][] myBingo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		myBingo = new int[5][5];
	
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				myBingo[i][j]=sc.nextInt();
			}
		}//
		for(int i=0;i<25;i++) {
			int num=sc.nextInt();
			ans++;
			for(int a=0;a<5;a++) {
				for(int b=0;b<5;b++) {
					if(myBingo[a][b] == num) {
						myBingo[a][b]=0;
						if(check(a,b)>=3) {
							System.out.println(ans);
							return;
						}
					}
				}
			}		
		}
	}
	
	public static int check(int r, int c) {
		int cnt=0;
		//가로체크
		for(int i=0;i<5;i++) {
			int zeroCnt=0;
			for(int j=0;j<5;j++) {
				if(myBingo[i][j]==0) {
					zeroCnt++;
				}
			}
			if(zeroCnt==5) {
				cnt++;
			}
			
		}
		for(int i=0;i<5;i++) {
			int zeroCnt2=0;
			for(int j=0;j<5;j++) {
				if(myBingo[j][i]==0) {
					zeroCnt2++;
				}
			}
			if(zeroCnt2==5) {
				cnt++;
			}
		}
		int zeroCnt3=0;
		for(int i=0;i<5;i++) {		
			if(myBingo[i][i]==0) {
				zeroCnt3++;
			}
			if(zeroCnt3==5) {
				cnt++;
			}
		}
		int zeroCnt4=0;
		for(int i=0;i<5;i++) {
			if(myBingo[i][4-i]==0) {
				zeroCnt4++;
			}
			if(zeroCnt4==5) {
				cnt++;
			}
		}
		return cnt;
	}
	
}
