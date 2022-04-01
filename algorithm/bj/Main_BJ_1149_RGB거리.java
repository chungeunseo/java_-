import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
         
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
		int N = Integer.parseInt(br.readLine());//집의 수(2<=N<=1000)
 
		int[][] memoCost = new int[N][3];//칠하는 비용을 저장하는 배열
 
		int r=0,g=1,b=2;//빨강,초록,파랑  (배열의 열 인덱스 표현) 반드시 필요하지 않지만 가독성을 높여준다.
		
		//데이터 입력
		for (int i = 0; i < N; i++) { 
			st = new StringTokenizer(br.readLine().trim(), " "); 
			memoCost[i][r] = Integer.parseInt(st.nextToken());
			memoCost[i][g] = Integer.parseInt(st.nextToken());
			memoCost[i][b] = Integer.parseInt(st.nextToken()); 
		}
		
 
		// 서로 다른 색의 칠하는 비용의 최소값 누적  (앞의 집과 비교하여 최소로 드는 비용을 누적하여 간다)
		for (int i = 1; i < N; i++) {
			memoCost[i][r] += Math.min(memoCost[i-1][g], memoCost[i-1][b]);
			memoCost[i][g] += Math.min(memoCost[i-1][r], memoCost[i-1][b]);
			memoCost[i][b] += Math.min(memoCost[i-1][r], memoCost[i-1][g]);
		}
		
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(memoCost[i]));
//		}
 
		// 모든 집을 칠하는 비용의 최소값 출력
		System.out.println(Math.min(Math.min(memoCost[N-1][r], memoCost[N-1][g]), memoCost[N-1][b]));
	}
}




