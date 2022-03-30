import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import java.util.PriorityQueue; 
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리 {
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine()); 
		for(int tc=1;tc<=T;tc++) { 
			st = new StringTokenizer(br.readLine()); 
			int V = Integer.parseInt(st.nextToken()); 
			int E = Integer.parseInt(st.nextToken()); 
			ArrayList<node>[] list = new ArrayList[V+1]; 
			for(int i=0;i<=V;i++) { 
				list[i] = new ArrayList<>(); 
				} 
			for(int i=0;i<E;i++) { 
				st = new StringTokenizer(br.readLine()); 
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken()); 
				int w = Integer.parseInt(st.nextToken());
				list[x].add(new node(y, w));
				list[y].add(new node(x, w)); 
				} 
			boolean[] visited = new boolean[V+1]; 
			PriorityQueue<node> q = new PriorityQueue<node>(); 
			q.add(new node(1,0)); 
			int cnt = 0; 
			long res = 0; 
			while(!q.isEmpty()) { 
				node now = q.poll(); 
				if(visited[now.x]) 
					continue;
				res += now.w; 
				visited[now.x] = true; 
				if (++cnt == V) { 
					break; 
					} 
				for(int i=0;i<list[now.x].size();i++) { 
					node next = list[now.x].get(i); 
					if(visited[next.x] == true) 
						continue; 
					q.add(next); 
					} 
				} 
			sb.append("#").append(tc).append(" ").append(res).append("\n"); 
			} 
		System.out.println(sb); 
		} 
	} 
	
	class node implements Comparable<node>{ 
		int x; 
		long w; 
		public node(int x, long w) { 
			super(); 
			this.x = x; 
			this.w = w; 
			} 
	
		@Override public int compareTo(node o) { 
			return (this.w - o.w)>0? 1:-1; 
			}
			
}
