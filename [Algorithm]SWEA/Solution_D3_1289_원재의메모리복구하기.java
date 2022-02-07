import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int[] ans=new int[T];		
		for(int tc = 1; tc <= T; tc++)
		{
			String data = sc.next();
			int size = data.length();
			int N=0;  									//횟수
			if(data.startsWith("1")) {
				N++;
			}
			for (int i = 0; i <size-1; i++) {
				if(data.charAt(i) != data.charAt(i+1)) {
//					System.out.println(data.charAt(i)+"  "+data.charAt(i+1));
					N++;
				}
			}
//			ans[tc-1]=N;			
			System.out.println("#"+tc+" "+ N);
			
		}//테스트 케이스
		
		//출력-------------------------------------------------------
//		for(int i=0; i<T; i++){
//			System.out.println("#"+(i+1)+" "+ans[i]);
//		}
		sc.close();
	}//main
}

//===============================================================================
// startsWith(): 지정한 문자로 시작, endsWith(): 지정한 문자로 끝
/*
public class Test {
    public static void main(String[] args){
        String s1 = "This is Ssafy Zone!";
        System.out.println(s1.startsWith("this")); //false
        System.out.println(s1.startsWith("This")); //true
        
        String s2 = "This is Ssafy Zone!";
        System.out.println(s2.endsWith("zone"));   //false
        System.out.println(s2.endsWith("Zone!"));  //true
    }    
}
*/