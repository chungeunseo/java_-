import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //입력
		int [] Person = new int[9]; //9명의난쟁이
		int liar1=0;
		int liar2=0; //가짜난쟁이 두명 설정
		int sum = 0; //난쟁이 모자에 쓰인 숫자 합 저장할 변수
		for(int i = 0 ; i < 9; i++) {
			//일단 입력받은 모든 9명의 난쟁이들의 합 구하기
			Person[i]=sc.nextInt();
			sum += Person[i];
		}
		//난쟁이들을 숫자가 작은 순서로 정렬
		Arrays.sort(Person);
		//두 난쟁이의 합을 전체 합에서 뺀 값이 100이면 그 둘은 거짓말쟁이 난쟁이
		for(int i = 0 ; i<9;i++) {
			for(int j = 1 ; j < 9;j++) {
				if(Person[i]+Person[j]==sum-100) {
					liar1=i;
					liar2=j;
					break;
				}
			}
		}
		//정답 출력하기 -> 거짓말쟁이 난쟁이가 있는 인덱스 제외하고 난쟁이 숫자 출력
		for(int i = 0 ; i < 9;i++) {
			if(i==liar1||i==liar2) {
				continue;
			}
			System.out.println(Person[i]);
		}
	}

}
