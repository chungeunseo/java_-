import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플 {
	static int T,N;
	static String[] card = new String[1001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
		
			for (int i = 0; i < N; i++) {
				card[i]=sc.next();
			}
			
			StringBuilder Ans = new StringBuilder();
			
			for (int i = 0; i < N; i++) {
				if(i%2==0) {
					Ans.append(" "+card[i/2]);
				}else if(N%2==0) {
					Ans.append(" "+card[N/2+i/2]);
				}else {
					Ans.append(" "+card[N/2+1+i/2]);
				}
			}
			
			System.out.printf("#%d%s\n",tc, Ans);
		}
		sc.close();
	}//main
}//end class
