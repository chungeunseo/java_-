import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[][] check;
	static int sx,sy;
	static int sSize = 2;
	static int result =  0;
	static int minX, minY;
	static final int  MIN_VALUE = 21;
	static int minDist;
	static int eatCnt = 0;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		check = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					sx = j;
					sy = i;
					map[i][j] = 0;
				}
			}
		}
		while(true) {
			//			체크배열 생성 클리어 및 minX,minY 초기화
			checkFill();
			//			상어 찾기
			bfs(sx,sy);
			//			상어 먹을수 있나 없나 판단 후 반복 체크
			if(minX != MIN_VALUE && minY != MIN_VALUE) {
				result = result + check[minY][minX];
				eatCnt++;
				if(eatCnt == sSize) {
					sSize++;
					eatCnt = 0;
				}
				map[minY][minX] = 0;
				sx = minX;
				sy = minY;
			}else {
				break;
			}
		}

		System.out.println(result);
		sc.close();
	}//main
	
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		check[y][x] = 0;  // 상어가 이동되면 0으로 변경하기
		Point p = new Point(x,y);
		q.offer(p);
		while(!q.isEmpty()) {
			p = q.poll();
			y = p.y;
			x = p.x;
			for(int i = 0 ; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx < 1 || nx > N || ny < 1 || ny > N) {
					continue;
				}
				if(check[ny][nx] != -1) {
					continue;  // 이동했던 적이 있으면 안가기
				}
				if(map[ny][nx] > sSize) {
					continue; // 물고기가 상어보다 크면 이동 안함
				}
				check[ny][nx] = check[y][x] + 1; // 기존에 있던 이동횟수에 1 증가하기

				if(map[ny][nx] != 0 && map[ny][nx] < sSize) { //물고기가 있고, 그 물고기가 상어 사이즈보다 작은 경우
					if(minDist > check[ny][nx]) { // 거리가 크면 가까운 값으로 변경 
						minX = nx;
						minY = ny;
						minDist = check[ny][nx];
					}else if(minDist == check[ny][nx]) { // 거리가 같으면 왼쪽 상단을 위치로 설정
						if(minY == ny){
							if(minX > nx){
								minX = nx;
							}
						}else if(minY > ny){
							minX = nx;
							minY = ny;
						}
					}
				}
				q.offer(new Point(nx, ny));
			}			
		}
	}
	static void checkFill() {
		for(int i = 0; i < check.length; i++) {
			Arrays.fill(check[i],-1);
		}
		minX = minY =  MIN_VALUE;
		minDist = Integer.MAX_VALUE;
	}
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
