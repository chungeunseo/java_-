import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {

	static int N, max,totalCnt, min,map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i==0 || j==0 || i==N-1 || j==N-1) && map[i][j] ==1) continue;  // 가장자리에 위치한 코어는 이미 연결한 것으로 간주한다. 
					if(map[i][j]==1) { // 가장자리가 아닌 코어는 리스트에 추가 
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			go(0,0);
			System.out.println("#"+t+" "+min);
		}
	}
	private static void go(int index,int cCnt) { //cCnt : 현재까지 연결된 코어수 

		// 가지치기 
		if(totalCnt-index+cCnt<max) return; // totalCnt-index: 남은 코어수 
		
		if(index == totalCnt) {
			int res = getLength();
			if(max<cCnt) {
				max = cCnt;
				min = res;
			}else if(max==cCnt) {
				if(min>res) min = res;
			}
			return;
		}
		
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		
		for (int d = 0; d < 4; d++) {
			if(isAvailable(r, c, d)) { // 해당방향으로 가장자리까지 닿을 수 있다면 전원연결 가능 
				setStatus(r, c, d, 2);
				go(index+1,cCnt+1); // 다음 코어로 넘어감 
				setStatus(r, c, d, 0);
			}
		}
		go(index+1,cCnt); // 해당 코어를 전원에 연결하지 않고 다음 코어로 넘어감 
	}
	
	private static boolean isAvailable(int r,int c ,int d) {
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			if(map[nr][nc]>=1) return false; //  다른 코어나 전선을 만나면 불가 
		}
		return true;
	}
	
	private static void setStatus(int r,int c,int d, int s) {
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			map[nr][nc] = s;
		}
	}
	
	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) ++lCnt; 
			}
		}
		return lCnt;
	}
}