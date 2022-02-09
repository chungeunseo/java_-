import java.util.Scanner;

public class Solution_D4_1861_정사각형방 {
	
	static int[][] visited; //방문횟수누적을 위해 int자료형
	static int[][] data; //숫자를 담을 배열
	static int[] dy = {-1, 1,  0, 0};
	static int[] dx = { 0, 0, -1, 1};
	                 //상    하    좌    우
	static int N;//배열크기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();//배열크기 입력
			
			data = new int[N][N];    //숫자저장 배열
			visited = new int[N][N]; //방문여부체크와 연속된 방문수 저장
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					data[i][j] = sc.nextInt(); //데이터 입력
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j] == 0)  //최초 방문이라면
						dfs(i, j);          //행과 열의 정보를 가지고 시작
				}
			}
			result(tc);//결과 출력
		}	
		sc.close();
	}//main
	
	static void dfs(int row, int col) {
		visited[row][col] = 1; //최초 방문 1부터 시작
	    
	    for (int i = 0; i < 4; i++) {//상하좌우 방향에 대해 진행
	    	
	        int ny = row + dy[i]; //ny: 방향 진행한 새로운 행인덱스
	        int nx = col + dx[i]; //nx: 방향 진행한 새로운 행인덱스
	 
	        if (!isRange(ny, nx)) continue; //배열의 범위를 벗어나는 방향의 인덱스라면 다음 방향을 선택
	        
	        if (data[ny][nx] == data[row][col] + 1) {//새위치의 값이 현재위치보다 1큰값이라면 (조건에 부합)
	            if (visited[ny][nx] == 0) //방문 안한 칸인지
	            		dfs(ny, nx);  //+1 찾는 작업을 진행 
	            
	            visited[row][col] = Math.max(visited[row][col], visited[ny][nx] + 1); //방문길이수를 저장	            
	        }	        
	    }
	}
	 
	static void result(int tc) {//테스트 케이스에 대한 결과값 출력
	    int cnt = 0;
	    int num = Integer.MAX_VALUE; //여기서는 작은 값을 출력하기 위해 초기값을 큰값으로 초기화
	 
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            if (cnt < visited[i][j]) { //연속된 +1의 방문한 길이가 크다면
	                cnt = visited[i][j];   //연속하여 가장 길게 방문한 갯수를 저장 
	                num = data[i][j];
	            }
	            else if (cnt == visited[i][j]) {
	                num =Math.min(num, data[i][j]);  //동일한 방문길이를 갖는다면 적은 숫자를 선택
	            }
	        }
	    }	 
	    System.out.println("#" + tc + " " + num + " " + cnt); //테스트 케이스마다 구해서 최소num의 최대방문cnt출력
	}
	 
	
	static boolean isRange(int ny, int nx) {//새로 진행하는 위치가 배열의 범위를 넘어섰는지 조건 체크
		return (ny >= 0 && ny < N && nx >= 0 && nx < N);		
	} 

}
