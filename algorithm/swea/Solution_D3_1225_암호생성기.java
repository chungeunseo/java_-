import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {
	static Queue<Integer> queue= new LinkedList<Integer>();
	static int N=8;
	
	public static void main(String[] args){
		int T = 10;
		Scanner scan = new Scanner(System.in);
		for (int tc = 1; tc <=T; tc++) {
			int  tcNum = scan.nextInt();
			queue.clear();//이전 암호 제거
			for (int i = 0; i <N; i++) {
				queue.offer(scan.nextInt());//각 테케 8개의 수를 Queue에 입력
			}
			makeSecretCode();//암호숫자 생성
			System.out.print("#"+tcNum+" ");
			for (int num : queue) {
				System.out.print(num+" ");
			}
			System.out.println();
		}//테스트 케이스
		scan.close();
	}//main
	
	private static void makeSecretCode() {
		boolean isDone = false;
		int num=0;
		
		top://레이블명:
		while(!isDone) {
			for (int i = 1; i <=5; i++) {
				num = queue.poll() -i;	//맨 앞에 숫자 추출해서 암호로 변경
				if(num<=0) {//암호생성 끝나는 조건
					num = 0;
					isDone = true;
				}
				queue.offer(num);//가장 끝에 추가
				if(isDone) {
					break top;//break 레이블명;
				}
			}
		}
	}
}