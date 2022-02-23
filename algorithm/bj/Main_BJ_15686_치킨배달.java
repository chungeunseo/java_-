import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//치킨 집을 M개만큼 선택
//각 집과의 치킨거리의 합이 가장 작을 때 구하기

public class Main_BJ_15686_치킨배달 {
    static int N, M, ans = Integer.MAX_VALUE;
    static boolean[] v;
    static List<int[]> home, chicken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                switch (sc.nextInt()) {
                	//switch를 활용해 입력 값이 1일 때는 home에 추가 
                    case 1:
                        home.add(new int[]{i, j});
                        break;
                    //2일 때는 chicken에 위치들을 추가
                    case 2:
                        chicken.add(new int[]{i, j});
                        break;
                }
        }
        //치킨집의 크기만큼 v배열을 생성
        v = new boolean[chicken.size()];
        comb(-1, 0);
        System.out.println(ans);
    }

    //1번, 2번 치킨집을 선택하는 경우 == 2번, 1번 치킨집을 선택하는 경우
    //combination을 활용
    static void comb(int idx, int cnt) {
 		//cnt의 값이 M과 같아지면
        if (cnt == M) {
            int dist = 0;
            for (int[] h : home) {
                int tmp = Integer.MAX_VALUE;
                for (int i = 0; i < v.length; i++) {
                //선택한 치킨집과 집과의 거리 중 최소값을 누적
                    if (v[i])
                        tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
                }
                dist += tmp;
            }
            //ans값 갱신
            ans = Math.min(ans, dist);
            return;
        }

        for (int i = idx + 1; i < v.length; i++) {
        	//선택할 때마다 v 배열에 true로 표시하고cnt값을 증가
            v[i] = true;
            //재귀를 통해 선택한 idx값을 넘겨주며 idx의 다음 인덱스의 치킨집만을 선택
            comb(i, cnt + 1);
            v[i] = false;
        }
    }
}
