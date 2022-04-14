import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9205_맥주마시면서걸어가기 {
	
    private static Point[] arr;
    private static int n;
    private static boolean[] visited;
    private static boolean flag;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            
            arr = new Point[n+2];
            visited = new boolean[n+2];
        
            for (int i=0; i<n+2; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            }
            
            visited[0] = true;
            flag = false;
            
            dfs(arr[0].x, arr[0].y, arr[0].idx);
            
            if (flag) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
        
    }
    
    public static void dfs(int x, int y, int idx) {
        if (x == arr[n + 1].x && y == arr[n + 1].y) {
            flag = true;
            return;
        }
        
        for (int i = 0; i < n + 2; i++) {
            int distance = Math.abs(x - arr[i].x) + Math.abs(y - arr[i].y);
            if (flag)
                return;
            if (idx != i) {
                if (!visited[i] && distance <= 1000) {
                    visited[i] = true;
                    dfs(arr[i].x, arr[i].y, arr[i].idx);
                }
            }
        }
        
    }
    
    static class Point {
        int x,y,idx;
        
        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
}
