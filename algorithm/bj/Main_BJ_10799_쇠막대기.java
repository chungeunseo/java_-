import java.util.*;
import java.io.*;
/*
여는 괄호가 나오면 ?? 막대기 시작
여는 괄호와 닫는 괄호가 연달아 입력 ?? 레이저
  - 막대기 개수만큼 잘려진 조각의 숫자 추가
닫는 괄호가 나올 경우?? 막대기 끝 -> 막대기-1 조각+1
 */

public class Main_BJ_10799_쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<>();
		String str= br.readLine();
		String[] stick = str.split("");
		int len = str.length();
		int open=0,cnt=0,stick_num=0;
		for (int i=0;i<len;i++) {
			if(stick[i].equals("(")) {
				open++;
			}
			else if(stick[i].equals(")")&&stick[i-1].equals("(")) {
				open--;
				cnt+=open;
			}
			else{
				open--;
				stick_num++;
			}
		}
		cnt+=stick_num;
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

}
