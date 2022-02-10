import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2563_색종이 {
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        paper = new int[100][100];

        int sum = 0;
        for(int k=0; k<n; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            
            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    if(paper[i][j] == 0){
                        paper[i][j] = 1;
                        sum+=1;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
