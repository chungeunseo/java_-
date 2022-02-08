import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_D3_1228_암호문5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		StringBuilder sb = new StringBuilder();
		int cnt=1;
		while( (line = br.readLine())!=null) {
			int N = Integer.parseInt(line); //암호문의 길이
			sb.append("#").append(cnt++).append(" ");
			LinkedList<String> list= new LinkedList<>();
			StringTokenizer tokens = new StringTokenizer(br.readLine());//," ");
			while(tokens.hasMoreTokens()) {
				list.add(tokens.nextToken());
			}
			int M = Integer.parseInt(br.readLine());//명령어의 개수 
			tokens = new StringTokenizer(br.readLine(), "I");
			while(tokens.hasMoreTokens()) {
				StringTokenizer sub=new StringTokenizer(tokens.nextToken());
				int index = Integer.parseInt(sub.nextToken());
				int len = Integer.parseInt(sub.nextToken());
				ArrayList<String> subList = new ArrayList<>(len);
				while(sub.hasMoreTokens()) {
					subList.add(sub.nextToken());
				}
				list.addAll(index, subList);
			}
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}//main
}//end class

