import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1260_DFS와BFS {
	static int N,M,V;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();//정점의 개수
		M=sc.nextInt();//간선의 개수
		V=sc.nextInt();//탐색 시작정점의 번호

		map=new int[N+1][N+1]; //정점이 숫자 1부터 시작하므로 0행과 0열은 사용하지 않음 ==> 대신 +1 을 해준다 
		
		for (int i = 1; i <= M; i++) {
			int start = sc.nextInt();
			int target = sc.nextInt();
			map[start][target]=1;//양방향표현
			map[target][start]=1;//양방향표현			
		}
		
		visited=new boolean[N+1]; //한번 탐색한 곳은 다시 탐색하지 않는다.
		dfs(map,V);  //깊이우선 탐색 시작
		
		visited=new boolean[N+1]; //이전 dfs로 방문체크 된 것을 기본값으로 초기화
		System.out.println();
		bfs(map);    //너비우선 탐색 시작
		sc.close();
	}//main
	
	private static void dfs(int[][] map, int v) {
		visited[v]=true;    //검색한 정점에 대한 방문체크
		System.out.print(v+" ");
		for (int i = 1; i <= N; i++) {//1~N : 숫자가 작은 값 부터 탐색
			if(map[v][i]==1 && !visited[i]) {
				dfs(map,i); //시작정점을 기준으로 연결요소가 보이면 그 연결요소를 시작 정점으로 계속 진행하는 깊이탐색 
			}
		}
	}//dfs

	private static void bfs(int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(V); //시작정점 Queue에 넣기
		visited[V]=true; //시작정점에 대한 방문체크
		while(!q.isEmpty()) {
			Integer p = q.poll(); //맨 앞에 있는(먼저 들어간) 정점 뽑기 p
			System.out.print(p+" ");
			for (int i = 1; i <= N; i++) {//1~N : 숫자가 작은 값 부터 탐색
				if(map[p][i]==1&&!visited[i]) { //p를 기준으로
					visited[i]=true;          //방문한 자식(연결)요소에 대한 방문 체크
					q.offer(i);               //모든 자식(연결)요소를 Queue에 넣기
				}
			}
		}
	}//bfs


}//class end
