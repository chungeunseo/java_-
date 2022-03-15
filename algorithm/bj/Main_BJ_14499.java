import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
원래 주사위   동쪽으로 굴릴때      서쪽으로 굴릴때     남쪽으로 굴릴때     북쪽으로 굴릴때
  1          1            1            6           3
2 3 4      3 4 6        6 2 3        2 1 4       2 5 4
  5          5            5            3           6
  6          2            4            5           1

 */
public class Main_BJ_14499 {
	
	static int[] dice = new int[7];
	//지도 크기: 세로N 가로 M
	//주사위 좌표 x,y
	static int N,M,x,y;
	static int[][] map; //지도
	//주사위 좌표 이동
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//(행M,열N) = (x,y)
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		//명령의 개수 K
		int K = Integer.parseInt(st.nextToken());
		//지도 입력
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		st = new StringTokenizer(br.readLine());
		//K만큼 움직이는거 받아오기
		for(int i=0; i<K; i++) {
			int d = Integer.parseInt(st.nextToken());
			move(d);
		}
		
	}
	//이동명령
	static void move(int d) {
		//지도에서의 위치 - 동서남북 중 이동할 좌표 
		int mapx = x + dx[d-1];
		int mapy = y + dy[d-1];
		//계산한 좌표가 지도를 벗어나면 무시
		if(mapx <0 || mapy < 0 || mapx > M-1 || mapy > N-1) 
			return;
		//계산된 좌표로 주사위 이동하기
		roll(d, mapx, mapy);
		x = mapx; 
		y = mapy;	
	}

	// 동:1 서:2 남:3 북:4
	static void roll(int d, int x, int y) {
		int tmp = dice[3];
		switch(d) {
		case 1:
//			원래 주사위   동쪽으로 굴릴때      
//			  1          1    
//			2 3 4      3 4 6  
//			  5          5 
//			  6          2
			dice[3] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
			
		case 2:
//			원래 주사위   서쪽으로 굴릴때   
//			  1          1       
//			2 3 4      6 2 3       
//			  5          5         
//			  6          4      
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
//			원래 주사위   남쪽으로 굴릴때
//			  1          6          
//			2 3 4      2 1 4      
//			  5          3       
//			  6          5       
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = tmp;
			break;
		case 4:
//			원래 주사위   북쪽으로 굴릴때
//			  1          3
//			2 3 4      2 5 4
//			  5          6
//			  6          1
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		//지도 값이 0이면 주사위의 바닥값을 복사
		if(map[y][x] == 0) {
			map[y][x] = dice[6];
		} else {
			//지도 값이 0이 아니면 주사위 바닥에 값을 복사하고 지도는 0으로
			dice[6] = map[y][x];
			map[y][x] =0;
		}
		System.out.println(dice[3]);
		
	}	

}
