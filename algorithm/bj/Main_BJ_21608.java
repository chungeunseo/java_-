import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 
      --> 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
      
학생마다 좋아하는 학생 : ArrayList와 Set
  -> Set.contains로 좋아하는애가 존재하는지 확인
  --  좋아하는 학생이면 10점, 빈자리면 1점
  --> 가장 높은 숫자에 배치

 */


public class Main_BJ_21608 {

		static int N, result;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st;
	    	N = Integer.parseInt(br.readLine());
	    	//학생수
	    	int sNum = N*N;
	    	ArrayList<Set<Integer>> like = new ArrayList<>();
	    	for(int i = 0; i <= sNum; i++)
	    		like.add(new HashSet<Integer>());
	    	int idx;
	    	//학생들 순서
	    	int[] order = new int[sNum];
	    	for(int i = 0; i < sNum; i++) {
	    		st = new StringTokenizer(br.readLine());
	    		idx = Integer.parseInt(st.nextToken());
	    		order[i] = idx;
	    		for(int j = 0; j < 4; j++) {
	    			like.get(idx).add(Integer.parseInt(st.nextToken()));
	    		}
	    	} // 입력 완료
	    	
	    	//학생들이 앉을 자리 N*N
	    	int[][] seat = new int[N][N];
	    	//xy 탐색
	    	int[] dy = {-1,1,0,0};
	    	int[] dx = {0,0,-1,1};
	    	
	    	int y,x, score = 0, maxScore, tempY = -1, tempX = -1;
	    	// 학생의 순서대로 한명씩 좌석에 배치
	    	for(idx = 0; idx < sNum; idx++) {
	    		// 처음 비교 값을 -1 
	    		// 나중에 인접한 좋은 학생이 0명일 때를 대비
	    		maxScore = -1;		
	    		// 0,0 부터 n-1, n-1까지 탐색
	    		for(int i = 0; i < N; i++) {
	    			for(int j = 0; j < N; j++) {
	    				//0이 아니면 계속 탐색
	    				if(seat[i][j] != 0)
	    					continue;
	    				score = 0;
	    				// 현재 좌석의 상 하 좌 우를 탐색하여 점수를 매긴다.
	    				for(int k = 0; k < 4; k++) {
	    					y = i + dy[k];
	    					x = j + dx[k];
	    					// 해당하는 좌석에 선호하는 학생이 있으면
	    					if(isIn(y,x) && like.get(order[idx]).contains(seat[y][x]))
	    						//좋아하는애면 10점
	    						score += 10;
	    					else if(isIn(y,x) && seat[y][x] == 0)
	    						//없으면 1점
	    						score += 1;
	    				}
						// maxScore와 비교해서 현재 좌석의 점수가 높으면 현재 위치 저장
	    				if(score > maxScore) {
	    					tempY = i;
	    					tempX = j;
	    					maxScore = score;
	    				}
	    			}
	    		}
	    		seat[tempY][tempX] = order[idx];
	    	}
	    	
	    	//만족도 계산
	    	//cnt: 인접한 학생의 수
	    	int result = 0, cnt;
	    	for(int i = 0; i < N; i++) {
	    		for(int j = 0; j < N; j++) {
	    			cnt = 0;

	    			for(int k = 0; k < 4; k++) {
						y = i + dy[k];
						x = j + dx[k];
						// 각 좌석의 상하좌우에 선호하는 학생이 앉아 있으면
						if(isIn(y,x) && like.get(seat[i][j]).contains(seat[y][x])) {
							cnt++;
						}
	    			}
	    			// 인접한 학생의 수가 0이 아닐때만 계산
	    			// cnt가 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000
	    			// 10 ^(cnt-1)
	    			if(cnt != 0)
	    				result += (int) Math.pow(10, cnt - 1);
	    		}
	    	}

	    	System.out.println(result);
	    	br.close();
		}

		// 주어진 범위 안에 있는지 확인하는 함수
	    public static boolean isIn(int y, int x){
	        if(y < 0 || y >= N || x < 0 || x >= N)
	            return false;
	        return true;
	    }


}
