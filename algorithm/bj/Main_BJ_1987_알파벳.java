import java.util.Scanner;
/*
DFS, 백트래킹을 이용해 구현
1. (0, 0)부터 시작해서 상하좌우로 이동
  --> 이차원 배열 범위를 넘지 않는 곳
  --> 방문하지 않았던 곳
2. 이동할 곳에 있는 알파벳이 str에 포함 안되어있다면 
  --> str에 추가하고 길이도 +1
3. 매 DFS마다 길이와 최장 길이를 저장할 long의 값을 비교
  --> 더 긴걸로 업데이트
 */

public class Main_BJ_1987_알파벳 {
	static String[][] board;
	static boolean[][] visited;
	static int R, C;
	static int longest = 0;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		board = new String[R][C];
		visited = new boolean[R][C];
		
		sc.nextLine();
		
		for(int i = 0; i < R; i++) {
			String temp = sc.nextLine();
			
			for(int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j) + "";
			}
		}
		visited[0][0] = true;
		dfs(0, 0, board[0][0], 1);
		
		System.out.println(longest);
	}
	
	public static void dfs(int x, int y, String str, int length) {
		if(longest < length) {
			longest = length;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny])
				continue;
			
			if(!str.contains(String.valueOf(board[nx][ny]))) {
				visited[nx][ny] = true;
				dfs(nx, ny, str+board[nx][ny], length+1);
				visited[nx][ny] = false;
			}
		}
	}

}