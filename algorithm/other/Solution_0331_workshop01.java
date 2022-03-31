import java.io.*;
import java.util.*;

public class Solution_0331_workshop01 {
	   public static void main(String[] args) throws Exception{
		      Scanner in = new Scanner(System.in);
		      int N = in.nextInt();
		      // 순서 맞추기 위해, 배열인덱스 0번 버림 
		      int[] dp = new int[N+1]; 
		      
		      dp[1] = 2;
		      dp[2] = 3;
		      
		      if(N>=3) {
		         for (int i = 3; i <= N; i++) {
		            dp[i] = dp[i-2] + dp[i-1];
		         }
		      }
		      System.out.println(dp[N]);
		   }
}
