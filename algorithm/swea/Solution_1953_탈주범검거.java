import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거{

	static int  N,M,R,C,L,map[][];
	static int visited[][];

	static String[] type = {
			null,"0123","01","23","03","13","12","02"
	};
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());	
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];

			for(int i=0; i<N; ++i) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			int answer=0;
			for(int i=0; i<N; i++) {
			   for(int j=0; j<M; j++) {	
				 if(visited[i][j]>0)answer++;
			   }
			}

			System.out.println("#"+t+" "+answer);
		}
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {R,C});
		visited[R][C] = 1;
		
		int current[],r,c,nr,nc, dir;
		String info = null;

			while(!queue.isEmpty()) {
				
				current = queue.poll();
				r = current[0];
				c = current[1];
				
				if(visited[r][c]==L) continue;
				
				info = type[map[r][c]];
				
				for(int d=0,length=info.length(); d<length; ++d) {
					dir = info.charAt(d) - '0';

					nr = r + dr[dir];
					nc = c + dc[dir];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M 
							 && map[nr][nc] != 0 
							 && visited[nr][nc]==0 
							 && type[map[nr][nc]].contains(Integer.toString((5-dir)%4))){
						queue.offer(new int[] {nr,nc});
						visited[nr][nc] = visited[r][c]+1;
					}
				}				
			}
	}
}