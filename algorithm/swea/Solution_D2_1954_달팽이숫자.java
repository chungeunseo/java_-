import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스개수
		//이동 순서가 오른쪽, 아래, 왼쪽, 위 순서이다
		//이거에 맞게 dx, dy 설정
		int[]dx= {0,1,0,-1};
		int[]dy= {1,0,-1,0};
		for(int tc=1;tc<=T;tc++) {
			int N =sc.nextInt(); //달팽이크기 N*N			
			int result[][]=new int[N][N]; //정답 넣을 이차원배열
			//N이 1이면 1만 들어가니까 따로 처리
			if(N==1) {
				System.out.println("#"+tc);
				System.out.println(1);
				continue;
			}
			int x=0;
			int y=0;
			int dir=0; //처음 방향은 0(오른쪽)
			for(int i=0;i<N*N;i++) {
				result[x][y]=i+1;
				x+=dx[dir];
				y+=dy[dir];
				//범위 벗어나면 방향 전환해야함 (N보다 많이가면 안돼)
				//오른쪽-> 아래(0->1)
				//아래-> 왼쪽 (1->2)
				//왼쪽 -> 위(2->3)
				//위 -> 오른쪽 (3->0)
				if(x>=N || y>=N || x<0 || y<0) {
					//원래 위치로 돌리기
					x-=dx[dir];
					y-=dy[dir];
					dir=(dir+1)%4;
					//방향 바꾸고 다시 이동
					x+=dx[dir];
					y+=dy[dir];
				}
				//가야되는데 값이 있는 경우(앞이 막힌경우)
				if(result[x][y]!=0) {
					//원래 위치로 돌리기
					x-=dx[dir];
					y-=dy[dir];
					dir=(dir+1)%4;
					//방향 바꾸고 다시 이동
					x+=dx[dir];
					y+=dy[dir];
				}
			}
			//결과출력
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(result[i][j]+ " ");
				}
				System.out.println();
			}
		}
		
	}
}
