import java.util.Scanner;

public class Solution_D5_1247_최적경로 {
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); //고객의 수.
			
			int cx = sc.nextInt(); //회사의 x좌표
			int cy = sc.nextInt(); //회사의 y좌표
			
			int hx = sc.nextInt(); //집의 x좌표
			int hy = sc.nextInt(); //집의 y좌표
			
			int[][] customers = new int[N][2]; //고객들의 좌표를 저장할 배열
			
			for(int i = 0; i < customers.length; i++) {
				customers[i][0] = sc.nextInt();
				customers[i][1] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			permutation(customers, new boolean[N], 0, hx, hy, cx, cy, 0);
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}//main
	/**

	 *  customers : 고객들의 위치가 저장된 배열
	 *  visited : 각 고객에 대한 방문 체크 배열
	 *  dist : 현재까지 누적거리.
	 *  destx : 최종 도착해야 하는 집의 좌표
	 *  desty : 최종 도착해야 하는 집의 좌표
	 *  lastx : 마지막 방문했던 좌표
	 *  lasty : 마지막 방문했던 좌표
	 *  idx : 현재 방문할 고객의 idx
	 */
	static void permutation(int[][] customers, boolean[] visited, int dist, 
			              int destx, int desty, int lastx, int lasty,int idx) {

		//기저파트. 모든 고객을 방문하면 종료
		if( idx == customers.length ) {
			//지금까지 걸어온 거리에다가. 현재 방문했던 위치에서 마지막 목적지인 집 까지의 거리를 더 더하자.
			//해서 그 거리가 최소값이라면 갱신.
			int ndist = Math.abs(lastx - destx) + Math.abs(lasty - desty);
			dist += ndist;
			if( ans > dist )
				ans = dist;
			return;
		}
		
		//재귀호출파트. N명의 고객에 대해 반복돌면 재귀호출
		for(int i = 0; i < customers.length; i++) {
			if( ans < dist ) {
				return;
			}
			if( visited[i] )
				continue;
			
			visited[i] = true;
			//현재 위치에서. 다음 방문할 고객까지의 거리를 계산
			int ndist = Math.abs(lastx- customers[i][0]) + Math.abs(lasty-customers[i][1]);
			permutation(customers, visited, dist+ndist, destx, desty, customers[i][0], customers[i][1], idx+1);
			visited[i] = false;
		}		
	}
}

