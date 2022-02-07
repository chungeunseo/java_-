import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {
	
	static int[] score,cal; //입력된 점수,칼로리 저장
	static int answer = 0;
	static int N, L;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			answer = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			score=new int[N];
			cal=new int[N];
			
			for (int j = 0; j < N; j++) {
				score[j] = sc.nextInt();
				cal[j] = sc.nextInt();
			}
			
			hamburger(0, 0, 0);
			System.out.println("#" + i + " " + answer);
		}		
		sc.close();
	}

    static void hamburger(int idx, int sumScore, int sumCal) {
	if (idx == N) {
		if (answer < sumScore && sumCal <= L) {
			answer = sumScore;
		}			
		return;
	}
	//그 idx의 재료를 선택했으면 해당 재료의 점수랑 칼로리 더하고 다음 idx로 가기
	hamburger(idx + 1, sumScore + score[idx], sumCal + cal[idx]);
	//idx의 재료 안선택했으면 다음idx
	hamburger(idx + 1, sumScore, sumCal);
	}
}
