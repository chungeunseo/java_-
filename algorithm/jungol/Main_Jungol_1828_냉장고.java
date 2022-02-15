import java.util.*;
public class Main_Jungol_1828_냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//화학물질의 수
		int N = sc.nextInt();
		//최저온도와 최고온도 저장할 배열
		int[][] temp = new int[N][2];
		//냉장고 개수 저장
		int cnt=1;
		for(int i=0;i<N;i++) {
			//최저온도와 최고온도 저장
			temp[i][0] = sc.nextInt();
			temp[i][1] = sc.nextInt();
		}
		//최고온도 정렬
		Arrays.sort(temp, new Comparator<int[]>() {
			@Override
			public int compare(int[] a,int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		//처음으로 들어온 온도를 maxTemp에 저장
		int maxTemp = temp[0][1];
		for(int i=0;i<N;i++) {
			//최저온도와 최고온도보다 maxTemp가 크면??
			if(temp[i][0]<=maxTemp) {
				if(temp[i][1]<maxTemp) {
					//갱신해준다
					maxTemp = temp[i][1];
				}
				continue;
			} else {
				//최저온도가 maxTemp보다 크면?
				//max는 최고온도가 되고 냉장고 증가
				maxTemp = temp[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
