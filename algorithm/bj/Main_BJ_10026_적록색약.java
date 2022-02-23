import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1. map을 두가지 케이스로 (R,G,B) 입력받기
	- DFS탐색을 통해 해당 영역이 몇 개의 영역으로 나누어져 있는지 탐색
2. 1번의 그래프를 (R==G,B)맵으로 바꾸기
	- 해당 맵을 다시 DFS탐색을 통해 조사
 */
public class Main_BJ_10026_적록색약 {
	static int N;
	//전체 맵
	static int[][] map;
	//방문체크
	static boolean[][] visited;
	//상하좌우 탐색
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		//적록색약 아닌 사람이 봤을 때
		int noRGB=0;
		//적록색약인 사람이 봤을 때
		int yesRGB=0;
		//2차 배열에 입력받고 각 구역을 DFS로 탐색
		for(int i=0; i<N; i++) {
			String[] color = br.readLine().split("");
			for(int j=0; j<N; j++) {
				if(color[j].equals("R")) {
					map[i][j] = 1;
				}else if(color[j].equals("G")) {
					map[i][j] = 2;
				}else {
					map[i][j] = 3;
				}
				
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=1; k<4; k++) {
					if(!visited[i][j] && map[i][j] == k) {
						dfs(i,j,k);
						noRGB++;
					}
				}
			}
		}
		
		//적록색약 그래프 (R: 1 == G: 2), B: 3를 만들어준 다음 이 또한 DFS로 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] ==1 ) {
					map[i][j] = 2;
				}
			}
		}	
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=2; k<4; k++) {
					if(!visited[i][j] && map[i][j] == k) {
						dfs(i,j,k);
						yesRGB++;
					}
				}
			}
		}
		System.out.println(noRGB+" "+yesRGB);		
	}
	
	//dfs 구현
	static void dfs(int x, int y, int color) {	
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <0 || ny <0 || nx>N-1 || ny>N-1) continue;
			if(visited[nx][ny]) continue;
			
			if(map[nx][ny] == color) {
				dfs(nx,ny, color);
			}
		}
		
	}
}