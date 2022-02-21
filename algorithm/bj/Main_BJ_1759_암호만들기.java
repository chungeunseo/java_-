import java.util.Arrays;
import java.util.Scanner;

//L=4, c=atcisw
//1. 정렬: c=acistw
//2. 말을 네개 뽑기 => v
//3. 모음 한개 이상 자음 두개 이상 아니면 제외 => newarr

public class Main_BJ_1759_암호만들기 {
	//L개의 알파벳 소문자, 문자의 종류 C가지
	static int L,C;
	static char arr[],result[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		result = new char[C];
		visited = new boolean[C];
		for(int i=0;i<C;i++) {
			result[i] = sc.next().charAt(0);
		}
		Arrays.sort(result);
		combination(0, 0);
	}
	
	static void combination(int start,int cnt) {
		if(cnt==L) {
			int mo = 0;
			int ja = 0;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<C;i++) {
				if(visited[i]) {
					sb.append(result[i]);
					if(result[i]=='a'||result[i]=='e'||result[i]=='i'||result[i]=='o'||result[i]=='u') {
						mo++;
					}else {
						ja++;
					}			
				}
			}
			if(mo>=1 && ja>=2) System.out.println(sb);
		}
		//백트래킹
		for(int i=start;i<C;i++) {
			visited[i]=true;
			combination(i+1,cnt+1);
			visited[i]=false;
		}
	}	

}
