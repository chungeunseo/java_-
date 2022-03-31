import java.io.*;
import java.util.*;

public class Solution_0331_workshop02 {
	   public static void main(String[] args) throws Exception{
		      Scanner in = new Scanner(System.in);
		      int N = in.nextInt();
		      int[] dp = new int[N+1]; 
		      
		      dp[1] = 2;
		      dp[2] = 5;
		      
		      if(N>=3) {
		         for (int i = 3; i <=N; i++) {
		            dp[i] = dp[i-1]*2 + dp[i-2];
		         }
		      }		      
		      System.out.println(dp[N]);

		   }
}
