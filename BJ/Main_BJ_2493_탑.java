import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		Stack<int[]> st = new Stack<>();
		
		for(int n = 1; n <= N; n++) {
			//현재 탑의 높이
			int now = Integer.parseInt(stz.nextToken());
			while(!st.empty()) {
				// 이전 탑의 높이가 현재 높이보다 작다? pop
				if(st.peek()[1] < now) st.pop(); 
				else { // 이전 탑의 높이가 현재 높이보다 크다? 이전 탑의 높이
					System.out.print(st.peek()[0] + " ");
					break;
				}
			}
			// 스택이 비었으면 0
			if(st.isEmpty()) System.out.print("0 "); 
			// 현재 탑 push
			st.push(new int[] {n, now});
		}
	}
}