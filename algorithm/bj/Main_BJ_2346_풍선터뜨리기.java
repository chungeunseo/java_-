import java.io.*; 
import java.util.*;
 
public class Main_BJ_2346_풍선터뜨리기 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
		int[] arr = new int[N]; 
		boolean[] visited = new boolean[N]; 
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		for (int i = 0; i < N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken()); 
			} 
		StringBuilder sb = new StringBuilder(); 
		int now_idx=0, now_val=0, cnt=0; 
		while(true) { 
			visited[now_idx]=true; 
			sb.append((now_idx+1)+" "); 
			cnt++; 
			if(cnt==N) 
				break; 
			int val_cnt=0; 
			now_val = arr[now_idx]; 
			if(now_val > 0) { 
				while(true) { 
					now_idx++; 
					if(now_idx==N) 
						now_idx=0; 
					if(!visited[now_idx]) { 
						val_cnt++; 
						if(val_cnt==now_val) break; 
						} 
					} 
				}else { 
					now_val = Math.abs(now_val); 
					while(true) { 
						now_idx--; 
						if(now_idx==-1) now_idx=N-1; 
						if(!visited[now_idx]) { 
							val_cnt++; 
							if(val_cnt==now_val) 
								break; 
							} 
						} 
					} 
			} 
		System.out.println(sb);
	}
}
