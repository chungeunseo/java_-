import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());//전체 테스트케이스 개수
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());//학생들의 수
			int M = Integer.parseInt(br.readLine());//두학생의 키를 비교한 횟수
			
			int arr[][] = new int[N][N];
			
			for(int i =0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				arr[a][b] = 1;
			}
/*

1 5    
3 4    
5 4
4 2
4 6
5 2
===
0 4
2 3
4 3
3 1
3 5
4 1

     0  1  2  3  4  5  
  ---------------------
0 |           1
1 |           
2 |           1
3 |     1           1
4 |     1     1
5 |
*/
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][k]==1 && arr[k][j]==1) {
							arr[i][j]=1;
						}
					}
				}
			}
			
/*
     0  1  2  3  4  5  
  ---------------------
0 |     2     1     2
1 |           
2 |     2     1     2
3 |     1           1
4 |     1     1     2
5 |
	
*/		
			
			
/*
     0  1  2  3  4  5  
  ---------------------
0 |  X  1     1     1
1 |     X        
2 |     1  X  1     1
3 |     1     X     1
4 |     1     1  X  1
5 |                 X
	
			 */			
			
			int answer = 0;
			for(int i=0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(i==j)continue;
					if(arr[i][j]==0 && arr[j][i]==0) {
						answer--;
						break;
					}
				}
				answer++;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}//end main
}//end class