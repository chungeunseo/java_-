import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_7576_토마토 {
	static class Point{
		int r; 
		int c;
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};//상하좌우
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();//열
		int N =sc.nextInt();//행
		
		int[][] map = new int[N][M];
		Queue<Point> queue = new LinkedList<>();//익은 토마토의 정보 저장
		
		//익은 토마토:1,  익지 않은 토마토:0, 토마토가 들어있지 않은 칸:-1
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) //익은 토마토
				  queue.add(new Point(i,j));
			}
		}
		
		while( !queue.isEmpty()) { //하루를 표현
			
			Point p = queue.poll();//익은 토마토를 꺼내자
			
			int r = p.r;
			int c = p.c;//익은 토마토의 위치 정보
			
			for(int i = 0; i<4; i++) {//익지 않은 토마토를 사방(좌우상하)으로 익히자
				int nr = r+dr[i];
				int nc = c+dc[i];
				if( nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length)
					//상자를 벗어나면 ArrayIndexOutOfBoundsException
					continue;
				if( map[nr][nc] == 0 ) {//익지 않은 토마토를 발견했다면
					map[nr][nc] = map[r][c]+1; //익히자 (몇개를 익혔는지 확인하기 위해 1씩 증가)
					queue.offer(new Point(nr,nc)); //익은 토마토의 정보를 저장
				}
			}
		}		
		
		//확인
//		for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//		}
		
		
		int max = 0;
		boolean isOk = true;
		
		//사방전파를 통해 익은 토마토의 정보 분석
		tomato:
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if( map[i][j] == 0 ) { //익지 않은 토마토가 존재한다면 (빈칸으로 인해 익힐수 없는 토마토가 있다면)
					isOk = false;
					break tomato;
				}
				if( max < map[i][j])
				   max = map[i][j];  
			}
//			if(!isOk)break;
		}
		System.out.println(isOk?max-1:-1); //전체 토마토가 익었을때 익힌 토마토의 카운트는 빼준다.
		sc.close();
	}//main


}//end class











