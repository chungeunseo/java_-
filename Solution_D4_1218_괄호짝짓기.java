import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder("");
		for (int i = 1 ; i <=10 ; i ++) { //testCase
			int count = Integer.parseInt(br.readLine());
			int index = 0;
			String s = br.readLine();
			char[] c = s.toCharArray();
			char[] stack = new char[count];
			for(int j = 0 ; j < count ; j++) {
				stack[index] = c[j];
				if(j>=1) {
					if(stack[index]  == ')' && stack[index-1] == '(') {
						index -= 2;
					}else if(stack[index]==']'&& stack[index-1] == '[') {
						index -= 2;
					}else if(stack[index]=='}'&& stack[index-1] == '{') {
						index -= 2;
					}else if(stack[index]=='>'&& stack[index-1] == '<') {
						index -= 2;
					}
					
				}				
				index ++;
			}
			if(index == 0) {
				sb.append("#").append(i).append(" ").append(1).append("\n");
			}else {
				sb.append("#").append(i).append(" ").append(0).append("\n");
			}
		}
		System.out.print(sb);
	}

}
