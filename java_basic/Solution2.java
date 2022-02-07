package com.ssafy.ws02.step3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	
//	static int N;
/*	
	public void isRange(int row,int col,int N) {//범위 안에 있다면 true 리턴
//		if()//0<=검사<N
		if(row<0 || row>=N || col<0 || col>=N) {
			return false;
		}
		return true;
	}
*/	
	public static void main(String[] args) {
		//scanner 방법 다 익히기
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		//행증감
		int[] dy= {-1,1,0,0,-1,-1,1,1};
		//열증감
		int[] dx = {0,0,-1,1,-1,1,-1,1};
		
		
		for(int tc=1;tc<=T;tc++) {
			int N=scan.nextInt();
			char[][]map=new char[N][N];
			//입력받기
			for(int i=0;i<N;i++) {//행인덱스
				for(int j=0;j<N;j++) {//열인덱스
					//공백이 들어가는 입력??? 
					//==> next(), nextInt(), nextDouble() 사용
					//만약 입력이 GBGBGG처럼 공백 없으면??
					//==> next() + charAt(0) => next로 받아서 char 뽑기
					map[i][j] = scan.next().charAt(0);
				}
			}
			//입력값 확인!!
		//	for(int i=0;i<N;i++) {//행인덱스
		//		for(int j=0;j<N;j++) {//열인덱스
		//			System.out.print(map[i][j]);
		//		}
		//		System.out.println();
		//	}
		//	for(char[]ch:map) {
		//		System.out.println(Arrays.toString(ch));
		//	}
			int ans=0;//빌딩의 최대 높이
			for(int i=0;i<N;i++) {//행인덱스
				for(int j=0;j<N;j++) {//열인덱스
					int bCount=0;
					boolean isBuilding=true;
					//빌딩을 찾아라 ==> 'B'
					char ch = map[i][j];
					if(ch =='B') {//빌딩을 올릴 수 있다면
						for(int k=0;k<8;k++) {//8방향 탐색(0~7인덱스)
							int ny= i+dy[k];
							int nx=j+dx[k];
							
//							isRange(ny,nx);
							
							if(ny>=0 && ny<N &&
								nx>=0 && nx<N){
								if(map[ny][nx]=='G'){
									bCount=2;
									isBuilding=false;
									break;
								}
							}
						}
						if(isBuilding) {//8방향에 'G'가 없음을 확인!!
							for(int r=0;r<N;r++) {
								if(map[i][r]=='B') {
									bCount++;
								}
								if(map[r][j]=='B') {
									bCount++;
								}
								
							}
							bCount--;
						}
						if(ans<bCount)//최대값 갱신
							ans = bCount;
					}//'B'를 만났다면
					
				}//inner for
			}//outer for
			//[행][열]. [상하][좌우]
			//좌우 검사: 열이+1,-1 [그대로][원래+-1] dx/ col
			//상하 검사: 행이+1,-1 [원래+-1][그대로] dy/ row
			
			System.out.println("#"+tc+" "+ans);
			
		}//for
		scan.close();
	}//main

}
