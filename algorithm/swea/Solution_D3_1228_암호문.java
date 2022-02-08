import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_1228_암호문 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int N, M, index, num;
		ArrayList<String> list = new ArrayList<>();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();//암호문의 길이
			for (int i = 0; i < N; i++) {
				list.add(sc.next());
			}
			M = sc.nextInt();//명령어의 개수
			for (int i = 0; i < M; i++) {
				sc.next();//Insert (명령어)
				index = sc.nextInt();//끼워넣을 (위치)인덱스
				num = sc.nextInt(); //추가 암호문의 길이
				for (int j = index, end=index+num; j < end; j++) {
					list.add(j,sc.next());
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < 10; i++) {//수정된 암호문 출력
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			list.clear();
		}//테스트 케이스
		sc.close();
	}//main
}//end class
