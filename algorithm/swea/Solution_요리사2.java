import java.util.Scanner;

/*
 * 조합을 이용해 N/2 식재료를 선택하기 
 * 선택한 재료 -> A
 * 나머지 재료 -> B
 * 선택한걸로 시너지 계산
 */

public class Solution_요리사2 {
	static int N; //식재료개수
	static int[][] synergy; //시너지
	static int answer; //정답(시너지차이)
	static boolean []selected; //선택된 재료 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 개수
		int T = sc.nextInt();		
		for(int tc = 1; tc<=T; tc++) {//테스트케이스만큼 반복
			//시너지의 차이 초기화
			answer=Integer.MAX_VALUE;
			//식재료의 개수
			N = sc.nextInt();
			//선택된 재료 저장할 배열
			selected=new boolean[N];
			//시너지를 저장할 배열
			synergy = new int[N][N];
			//synergy 배열에 입력받은 시너지 저장
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			comb(0,0);	
			//정답출력
			System.out.println("#"+tc+" "+answer);
		}
	}
	//조합구현하기
	public static void comb(int cnt, int start) {
		//A에 들어간 재료가 N/2개이면 다고른거-끝
		if(cnt==N/2) {
			//다골랐으면 계산하기			
			calc();
	        return;
	    }
	    for(int i=start; i<N;i++) {
	    	//몇번째 재료가 선택됐는지 저장
	    	selected[i] = true;
	        comb(cnt+1,i+1);
	        selected[i] = false;
	    }
	}
	
	//시너지 계산   -> 다고른거를 A에 넣고 안고를거를 B에 넣기
	public static void calc() {
		int A=0, B=0, diff=0;
		//synergy배열의 인덱스= 재료번호랑 같음
	    for(int i=0;i<N-1;i++) {
	        for(int j=i+1;j<N;j++) {
	        	//둘다 선택된 재료의 시너지 A에 더하기
	            if(selected[i] && selected[j]) {
	                A+=synergy[i][j]+synergy[j][i];
	            }
	            //둘다 안선택된 재료의 시너지 B에 더하기
	            else if(!selected[i] && !selected[j]) {
	                B+=synergy[i][j]+synergy[j][i];
	            }
	        }
	    }
	    //A랑 B차이의 절댓값
	    diff = Math.abs(A-B);
	    //두개중에 작은거를 answer
	    answer = Math.min(diff, answer);
	}
}
