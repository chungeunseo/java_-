import java.util.Scanner;

public class Main_BJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = N/5;
		int answer=0;
		if(N%5==0) {
			answer=max;
		}else {
			for(int i=max;i>=0;i--) {
				if((N-i*5)%3==0) {
					answer= i+((N-i*5)/3);
					break;
				}else {
					answer=-1;
				}
			}
		}
		System.out.println(answer);
	}
}
