/*
4
1 7
2 6
3 8
4 9

1
*/
import java.util.Scanner;

public class Main_BJ_2961_도영이가만든맛있는음식 {

	static Food[] foods;
	static int N;
	static int min = Integer.MAX_VALUE;

	static class Food {
		int sour;
		int bitter;
		public Food(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			builder.append(sour);
			builder.append(",");
			builder.append(bitter);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		foods = new Food[N];
		for (int i = 0; i < N; i++) {
//			Food f = new Food();
//			f.sour = sc.nextInt();// 신맛 
//			f.bitter = sc.nextInt();// 쓴맛
			foods[i] = new Food(sc.nextInt(), sc.nextInt());
		}//데이터 입력
		
		solve(0, 1, 0);//카운트(인덱스),신맛,쓴맛
		System.out.println(min);//최소 차이를 출력
		sc.close();
	}
	
	private static void solve(int cnt, int sour, int bitter) {
		if (cnt == N) {
			if (sour == 1 && bitter == 0) { //선택하지 않은 값 제거
				return;
			}
			if (min > Math.abs(sour - bitter)) {//신맛과 쓴맛의 최소 차이 구하기
				min = Math.abs(sour - bitter);
			}
			return;
		}

		solve(cnt + 1, sour * foods[cnt].sour, bitter + foods[cnt].bitter);
		solve(cnt + 1, sour, bitter);
	}


}