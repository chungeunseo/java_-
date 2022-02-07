import java.util.Scanner;
import java.util.Stack;
/*
Scanner + Stack
스택에 1부터 n까지의 수를 넣고 빼는 과정을 통해  수열 만들수 있는지
push 는 오름차순
입력받은 value 값까지 push한 이력이 없을 경우 
stack에 value 값까지 push 한 후 마지막 원소를 pop
 출력해야 할 것은 + 또는 - 이므로 StringBuilder 을 사용하여 
push할 땐 '+'를, pop할 때는 '-' 를 저장
*/
public class Main_BJ_1874_스택수열 {
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장
		
		Stack<Integer> stack = new Stack<>();		
		int N = in.nextInt();		
		int start = 0;
		
		// N 번 반복		
		while(N -- > 0) {
			//입력받은 숫자만큼 정수를 스택에 push
			//예제에서 처음 수열 입력값이 4이므로
			//1부터 4까지 정수를 스택에 push
			int value = in.nextInt();
			
			if(value > start) {
				// start + 1부터 입력받은 value 까지 push를 한다.
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');	// + 를 저장한다. 
				}
				//숫자를 push 할때는 오름차순이어야 해서 어디까지 입력했는지 알기위해
				//변수 start를 value로 초기화.
				//여기서는 4까지 push 했기 때문에 다음에 push할라고 하면 5부터 하기 위해서 초기화
				start = value; 
			}
			
			// 스택의 맨 위에 있는 원소가 입력받은 값과 같지 않다면?? NO 출력하기
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;	
			}
			//같으면 pop
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
	}
}
