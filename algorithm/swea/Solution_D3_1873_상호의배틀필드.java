import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {
	static int[] dy = { -1, 1, 0, 0 };//행
	static int[] dx = { 0, 0, -1, 1 };//열
	                 //상   하     좌    우

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			// 높이와 너비를 입력받음.
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][W]; //입력데이터 저장
			
			int[] pos = new int[2];// 전차의 위치를 두칸짜리 1차원배열에 저장하려고..  int pos={0,1} ==> 전차의 위치는 0행1열
			
			// 맵을 입력받고, 입력에서 전차가 발견되면 전차의 위치를 기억.			
			for (int i = 0; i < H; i++) {
				String s = sc.next();  //===> nextLine()의미 같이할까?    
				//         "1234"               "1234"
				
				map[i] = s.toCharArray();
				
				for (int j = 0; j < map[i].length; j++) {
					switch (map[i][j]) {
					case '<':
					case '>':
					case '^':
					case 'v'://탱크의 위치를 저장
						pos[0] = i;
						pos[1] = j;
						break;
					}
				}
			}

			//명령을 입력받음.
			int N = sc.nextInt();//명령어 수
			
			String oper = sc.next();
			for (int i = 0; i<N; i++) {//< oper.length(); i++) {
				//명령을 구분하기.
				char c = oper.charAt(i);
				switch (c) {
					case 'U':
						map[pos[0]][pos[1]] = '^';
						move(map, pos, 0);
						break;
					case 'D':
						map[pos[0]][pos[1]] = 'v';
						move(map, pos, 1);
						break;
					case 'L':
						map[pos[0]][pos[1]] = '<';
						move(map, pos, 2);
						break;
					case 'R':
						map[pos[0]][pos[1]] = '>';
						move(map, pos, 3);
						break;
					case 'S':
						shoot(map, pos);
						break;
				}//switch
			}
			System.out.print("#" + tc + " ");

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}

		}
	  sc.close();	
	}//main

	static void shoot(char[][] map, int[] pos) {
		int dir = 0;
		//현재 전차의 모양을 보고 방향을 결정
		switch (map[pos[0]][pos[1]]) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		
		
		//nph npw는 대포알이 날아가는 위치. 현재 전차의 위치에서 시작.
		int nph = pos[0];
		int npw = pos[1];
		
		while (true) {
			//방향으로 계속 이동.
			nph = nph + dy[dir];
			npw = npw + dx[dir];
			
			//밖으로 나가면 끝
			if (nph < 0 || npw < 0 || nph >= map.length || npw >= map[0].length)
				return;
			
			//벽을 만나면 부심(평지로 바꿈) 그리고 끝
			if (map[nph][npw] == '*') {
				map[nph][npw] = '.';
				return;
				
			  //강벽을 만나면 그냥 끝
			} else if (map[nph][npw] == '#')
				return;
		}//while

	}//shoot

	static void move(char[][] map, int[] pos, int dir) {
		// U, D, L, R

		//해당 방향으로 이동.
		int nph = pos[0] + dy[dir];
		int npw = pos[1] + dx[dir];
		//밖으로 나가는 거면 무효.
		if (nph < 0 || npw < 0 || nph >= map.length || npw >= map[0].length)
			return;
		//이동하는 위치가 평지여야 이동가능
		if (map[nph][npw] == '.') {
			//새로 이동하는 자리에 현재 전차를 갖다 놓고
			map[nph][npw] = map[pos[0]][pos[1]];
			//원래있던 자리를 평지로 바꿈.
			map[pos[0]][pos[1]] = '.';
			//전차의 위치 갱신
			pos[0] = nph;
			pos[1] = npw;
		}
	}//move
	
}