
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Concat {
	static boolean[][] adjMatrix;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     ==> ★ 반복문 밖에서 BufferedReader객체 생성하고 반복문 안에서 br.readLine()을 사용해야 함. 
		
		for(int tc =1; tc<=10;tc++) {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//          ==> ★ 반복문 안에서 입력객체 BufferedReader를 선언하면 안됩니다!! (프로그램 진행이 안된 원인임)
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int from = start;
			
			int to;//
			
			adjMatrix = new boolean[101][101];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				int input = Integer.parseInt(st.nextToken());
				
				if(i%2==1) {
					to = input;
					
					adjMatrix[from][to] = true;
					
				}else {
					from = input;
				}	
			}//노드 할당. head가 시작 부분
			
			int answer = bfs(start);
//			System.out.println(answer);
			System.out.println("#"+tc+" "+answer);
		}		
	}
	private static int bfs(int start) {

		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[101];
		int max=0;
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			max=0;//★ 새로운 queue의 요소를 얻은 후에 0으로 초기화한 상태에서 시작
			int tempSize = queue.size();
			for(int k=0; k<tempSize; k++) {//★ poll()은 현재 queue의 사이즈 만큼 반복
				int current = queue.poll();
				max = Math.max(max, current);//★ 밑의 주석처리된 최대값 구하기를 진행할 위치임. 
	            for(int i=1;i<=100;i++) {
					if(!visited[i] && adjMatrix[current][i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}
	//			if(tempSize == queue.size()) {   //★ queue의 사이즈는 계속 변동되어 지므로 적당하지 않은 비교 구문임
	//				max = Math.max(max, current);
	//			}
			}
		}
		
		
		return max;
	}

	
}
