import java.util.Scanner;

/*
dfs -> 모든 곳 들리기
백트래킹 -> cost > answer ==> return
-> 총 비용 구한 후 최솟값 구하기
 */
public class Main_Jungol_1681_해밀턴순환회로 {
	static int N;
	//최솟값 구하기
	static int answer = Integer.MAX_VALUE;
	//방문체크
	static boolean[] visited;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//입력받기
				map[i][j] = sc.nextInt();
			}
		}//입력끝
		//dfs 호출
		dfs(0, 0, 0);
		System.out.println(answer);
	}
	
	//dfs 구현
	public static void dfs(int start, int idx, int cost) {	
		// 중간 비용이 정답보다 클다면 끝내기!!
		if ( cost >= answer) {
			return;
		}
		// 모든 경우를 다 했다면??
		if ( idx == N-1) {
			// 다시 회사로 돌아오는 길이 있다면?!!!
			if ( map[start][0] !=0 ) {
				//정답의 최솟값 구하기
				answer = Math.min(answer, cost + map[start][0]);
			}				
			return;	
		}						
		for( int i=1; i<N; i++) {
			// 그쪽으로 가는 길이 있으면서 && 방문 false면
			if ( map[start][i] != 0 && !visited[i]) { 
				//방문체크하기
				visited[i] = true;
				dfs(i, idx+1, map[start][i] + cost);
				visited[i] = false;
			}
		}		
	}

}
