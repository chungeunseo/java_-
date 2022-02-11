import java.util.Scanner;

public class Main_BJ_16926_배열돌리기1 {
    static int N, M, R;
    static int[] dy = { 0, 1, 0, -1 };//행인덱스
    static int[] dx = { 1, 0, -1, 0 };//열인덱스
                      //우   하   좌    상
                                      
    static int[][] arr;
 
    public static void main(String[] args) {
    	/*
    	    1. 반시계방향 회전  ==>    쉬프트 숫자 이동  (맨 위의 행,  맨우측의 열,  맨아래 행,  맨좌측의 열)
    	    2. 반시계방향 회전 사각형의 수 / 기준 (행열)인덱스
    	    
    	 */
    	
    	
        Scanner sc = new Scanner(System.in);
        
        //배열의 크기 N*M
        N = sc.nextInt(); // 행크기 
        M = sc.nextInt(); // 열크기
        R = sc.nextInt(); // 회전 수
 
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();//배열 숫자 입력
            }
        }
 
        int s = Math.min(N, M) / 2;// 1회전에서 돌려야하는 사각형의 개수      4/2  = 2    ,   5/2 = 2
 
        for (int i = 0; i < R; i++) {//회전수만큼 반복
            rotate(s);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");//회전 결과 출력
            }
            System.out.println();
        }
       sc.close();
    }//main
 
    public static void rotate(int s) {
        for (int i = 0; i < s; i++) {
        	
            int dir = 0;//우   하   좌    상
            int sy = i; //rotate 시작위치 행   0   1    2
            int sx = i; //rotate 시작위치 열   0   1    2
            int value = arr[sy][sx]; //4행4열  시작지점==> arr[0][0] , arr[1][1]
                                     //8행8열  시작지점==> arr[0][0] , arr[1][1] , arr[2][2] , arr[3][3]
            //int value == int temp
            
            
            while (dir < 4) {//dir=0,1,2,3
                int ny = sy + dy[dir];//ny = 0, 0, 0
                int nx = sx + dx[dir];//nx = 1, 2, 3
 
                if (ny >= i && nx >= i && ny < N - i && nx < M - i) {//배열의 범위를 넘어섰다면, 바깥 로테이션 범위를 넘어섰다면
                    arr[sy][sx] = arr[ny][nx]; //값 시프트
 
                    sy = ny; //이동
                    sx = nx; //이동
                } else {
                    dir++;
                }
            }
            arr[i + 1][i] = value;
        }
    }
}