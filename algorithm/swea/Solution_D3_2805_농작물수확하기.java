import java.io.*;

public class Solution_D3_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int t = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		
		for (int tc = 1; tc <= t; tc++) { 
			int sum = 0; 
			int n = Integer.parseInt(br.readLine()); 
			int flg = n / 2; 
			int f = 0; 
			
			for (int i = 0; i < n; i++) { 
				String tmp = br.readLine(); 
				for (int j = 0; j < n; j++) { 
					if (i < flg) { 
						if (flg - i <= j && j <= flg + i) { 
							sum += tmp.charAt(j) - '0'; 
							} 
						} 
					else if (i > flg) { 
						if (flg - (n - i - 1) <= j && j <= flg + (n - i - 1)) { 
							sum += tmp.charAt(j) - '0'; 
							} 
						} else { 
							sum += tmp.charAt(j) - '0'; 
							} 
					} 
				} 
			sb.append("#" + tc + " " + sum + "\n"); 
			} 
		System.out.println(sb); 
		}
}
