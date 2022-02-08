import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int test_case = 1; test_case<=T;test_case++) {
	            int N = sc.nextInt();
	            int M = sc.nextInt();
	            int[] arr = new int[N+1];
	            
	            for(int i=0;i<N;i++) arr[i] = sc.nextInt();
	            
	            int ans=-1;
	            for(int i=0;i<N;i++) {
	                for(int j=i+1;j<N;j++) {
	                    if(arr[i] + arr[j] <=M) ans = Math.max(ans, arr[i]+arr[j]);
	                }
	            }
	            System.out.println("#"+test_case+" "+ans);
	        }
	    }
}
