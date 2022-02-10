import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
큐를 하나 만들고, 입력받은 n까지의 자연수를 넣는다.
<큐가 빌 때까지 반복>
  k번을 제거하고
  k번이 아니면 맨뒤로 이동! (poll한거를 add)
  poll: 첫번째값을 반환하고 제거
 */

public class Main_BJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//n이랑 k받아오기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> qq = new LinkedList<Integer>();
		// 큐에 N까지의 수 차례로 넣어주기
		for(int i = 1; i <= N; i++) {
			qq.add(i);
		}
		// N명의 사람이 모두 제거될 때까지, 즉 큐가 빌 때까지 반복 
		while(!qq.isEmpty()) {
			// K번째를 제거하기 위한 루프
			for(int j = 1; j <= K; j++) {
				if(j == K) {
					// K번을 제거
					sb.append(qq.poll() + ", ");
				} else {// K번이 아닐 때에는 맨 뒤로 이동
					qq.add(qq.poll());
				}				
			}
		}
		//맨뒤에 ,랑 공백이 같이 더해졌으므로 지우기
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}	

}
