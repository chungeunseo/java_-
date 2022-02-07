import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) { 
			int N = sc.nextInt();//NxN 전체 배열 크기
			int M = sc.nextInt();//MxM 파리채 크기
		
			int[][] flyArr = new int[N][N];
			
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++)
					flyArr[i][j] = sc.nextInt();//셀당 파리수 입력

			int ans = 0;//정답을 담을 변수 초기화
			
			for (int i=0; i<N; i++) {//전체 배열 행 인덱스
				for (int j=0; j<N; j++) {//전체 배열 열 인덱스
					
					int sum = 0;//파리채 영역 합 초기화
					
					//파리채 영역내의 파리합 구하기
//					for (int x=i; x<i+M; x++) {
//						for (int y=j; y<j+M; y++) {
//							sum += flyArr[x][y];
//						}
//					}
//					==> java.lang.ArrayIndexOutOfBoundsException발생					
					
					//파리채 영역내의 파리합 구하기
					for (int x=i; i+M<=N && x<i+M; x++) {//행의 인덱스가 전체 fly배열을 넘지 않게 조건 추가
						for (int y=j; j+M<=N && y<j+M; y++) {//열의 인덱스가 전체 fly배열을 넘지 않게 조건 추가
							sum += flyArr[x][y];
						}
					}

					
					if (ans < sum)//파리를 더 많이 퇴치할 수 있는 영역이 있다면
					  ans = sum; 
				}
			}
			System.out.printf("#%d %d%n", tc, ans);
		}
		sc.close();
	}
}