import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm) 
// O(N+M)

public class Main_BJ_1786_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();
		
		int tLen = T.length, pLen = P.length;
		
		//실패함수(부분일치테이블) 만들기 : 문자열 일치했다는 사실을 활용(일치했었던 정보를 저장하는 함수)
		//전처리 배열로 사용하면서 '문자열 일치정보'를 통해 맨 앞이 아닌 중간의 문자와 효율적인 비교하는 역할
		int[] fail = new int[pLen];
	    for(int i=1, j=0; i<pLen; i++){
	    // i:접미사 포인터(i=1부터 시작: 우리는 실패함수를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
	        while(j > 0 && P[i] != P[j]) {
	        	j = fail[j-1];  
	        }
	        if(P[i] == P[j]) fail[i] = ++j;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		//패턴에 일치하는 문자열의 시작위치를 저장 (일치 문자열의 수가 일정하지 않으므로 List사용)		
		
		// i : 기준텍스트의 인덱스 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLen; ++i) { 
			
			while(j>0 && T[i] != P[j]) j = fail[j-1]; 
			
			if(T[i] == P[j]) { //문자가 일치 한다면
				if(j == pLen-1) { //P의 마지막 문자라면 
					cnt++; // 카운트 증가
					list.add((i+1)-pLen+1); //인덱스는 0, 문제에서는 1부터 시작하기 때문에 +1 
					                        //계산된 위치의 첫번째 문자를 표현하기 위하여 +1
					j=fail[j];
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		for(int loc:list) {
		   System.out.print(loc+" ");
		}
	}
}