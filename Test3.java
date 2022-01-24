import java.util.Scanner;

public class Test3 {


	public void execute(String msg) {
		// 구현 하세요.
		//빈도수를 저장할 배열 초기화하기
		int cnt []= new int [10];
		//입력받는 string을 한글자씩 배열에 저장
		String num[] = msg.split("");
		//입력받은 string을 int로 변환
		int inum[]= new int [num.length];
		for(int i=0;i<num.length;i++) {//배열안에서 한개씩 int로 바꾸기
			inum[i]= Integer.parseInt(num[i]);
		}
		//inum안의 숫자 빈도수 구하기
		for(int i=0;i<inum.length;i++) {
			for(int j=0;j<10;j++) {
				if(inum[i]==j) {
					cnt[j]++;//숫자 찾을때마다 카운트하기
				}
			}
		}
		for(int i=0;i<10;i++) {//결과 출력
			if(cnt[i]>0) {//0보다 큰 빈도만 출력하기
				System.out.println(i+" : "+cnt[i]);
			}
		}
		
	}
	public static void main(String[] args) {
		Test3 c=new Test3();
		c.execute("53290539955364534323455987827332679340558347453272569584"); 
		System.out.println("=======");
		c.execute("13334444555557777777"); 
	}
}
