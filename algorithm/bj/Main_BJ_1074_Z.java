import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1074_Z {
    public static int count;//정답: 행열인덱스에 해당하는 숫자를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 2 3 1
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());//찾을 행 인덱스
        int c = Integer.parseInt(st.nextToken());//찾을 열 인덱스

        solve(N, c, r);
        System.out.println(count);
    }

    public static void solve(int N, int x, int y) {
        if (N == 0) { //더이상 쪼갤수 없는 Z사각형
            return;
        }

        int len = (int) Math.pow(2, N); //2의 2승 --> 4행4열
		//double d = Math.pow(double a, double b)// a의 b승의 결과~!!
		//시프트연산으로 표현? 1을 기준으로 2진수를 표현
		//          d = a<<b
		//          d = 1<<N        0001        
		//              1<<1        0010
		//              1<<2        0100
		//              1<<3        1000
		        
        int size = len * len;
        int partLen = len / 2;

        if (x < partLen && y < partLen) {
        	solve(N - 1, x, y);
        } else if (partLen <= x && y < partLen) {
            count += (size / 4);
            solve(N - 1, x - partLen, y);
        } else if (x < partLen && partLen <= y) {
            count += (size / 4) * 2;
            solve(N - 1, x, y - partLen);
        } else if (partLen <= x && partLen <= y) {
            count += (size / 4) * 3;
            solve(N - 1, x - partLen, y - partLen);
        }
    }
}