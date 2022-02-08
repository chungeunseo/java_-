import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int N, M, index, num;
		LinkedList<String> list = new LinkedList<>();
		StringTokenizer  tokens;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());//암호문의 길이
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(tokens.nextToken());
			}
			M = Integer.parseInt(br.readLine());//명령어의 개수
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				tokens.nextToken();//Insert (명령어)
				index = Integer.parseInt( tokens.nextToken());//끼워넣을 (위치)인덱스
				num = Integer.parseInt( tokens.nextToken());//추가 암호문의 길이
				for (int j = index, end=index+num; j < end; j++) {
					list.add(j, tokens.nextToken());
				}
			}
			sb.append("#"+tc+" ");
			for (int i = 0; i < 10; i++) {//수정된 암호문 출력
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
			list.clear();
		}//테스트 케이스
		System.out.println(sb);
	}//main
}//end class
