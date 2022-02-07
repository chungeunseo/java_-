
public class Test1 {

	public static void main(String[] args) {

		for(int i=1;i<=5;i++) {//5줄 출력
			for (int j=1;j<=i;j++) {//한 줄에 출력되는 별의 개수
				System.out.print("*"); //별 출력
			}
			System.out.println(); //별 출력 후 줄 바꿈
		}

		
	}
}
