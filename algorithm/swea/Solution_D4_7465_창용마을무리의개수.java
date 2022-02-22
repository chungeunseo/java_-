import java.util.Scanner;
/*
서로 알고 지내는 무리가 몇 개인가??? -> 그래프의 개수
1. DFS로 완전탐색
2. 완전 탐색이 다하고 아직 방문하지 노드가 있는지 확인
3. 있다면 다른 그래프가 또 존재한다는 거
4. 또 다른 노드를 정해서 완전 탐색을 다시
5. 위에꺼를 계속 반복함
 */
public class Solution_D4_7465_창용마을무리의개수 {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T;
        //테스트케이스개수
        T=sc.nextInt();
        for(int tc = 1; tc <= T; tc++)
        {
        	//N을 입력받고
            int N = sc.nextInt();
            int M = sc.nextInt();
            //N*N 크기의 2차원 배열(graph)
            graph = new int[N+1][N+1];
            //정답 저장
            int answer = 1;
            //N 크기의 배열(visited)
            visited = new boolean[N+1];
            for(int i=0; i<M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
                graph[b][a] = 1;
            }
            for(int i=1; i<N+1; i++){
                if(!visited[i]){
                    dfs(i, N+1);
                    for(int j=1; j<N+1; j++) {
                        if(!visited[j]) {
                            answer++;
                            break;
                        }
                    }
                }
            }
            System.out.println("#"+tc+" "+answer);
        }
        sc.close();
    }
    //dfs 구현
    static void dfs(int n, int total) {
        if(!visited[n]) {
           visited[n] = true;
           for(int i=1; i<total; i++){
               if(graph[n][i]==1 && !visited[i]) dfs(i, total);
           }
        }
    }
}
