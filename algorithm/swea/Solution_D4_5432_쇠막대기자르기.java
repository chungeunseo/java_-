import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_5432_쇠막대기자르기 {
   public static void main(String[] args) throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int T = Integer.parseInt(br.readLine()); //"2" --> 2
	  
/*
                   str.toCharArray()                  str.getBytes()
                    <-------------                ---------------->
        char[]ch                  String str="abc"                byte[]b	
        ={'a','b','c'}                                          ={97,98,99}
                    -------------->               <-----------------
           String str2 = new String(ch);        String str3 = new String(b);  
                    
                    
 */
	  
	  for(int tc=1; tc<=T;  tc++) {
		  char[]ch = br.readLine().toCharArray(); //"()(((()())(())()))(())"		  
		  //char[]ch= {'(',')','(','(','(','(',')','(',')',')','(','(',')',')','(',')',')',')','(','(',')',')'};
		  
		  int result=0,//조각 총 개수
		      metalRod=0;//(레이저 빔이 통과하는)쇠막대기 개수
		      
		  //문자 분석!!
		  for(int i=0; i<ch.length; i++) {
			  //레이저 찾기!!, 쇠막대 시작과 끝
			  if(ch[i]=='(') {//레이저 또는 쇠막대기의 시작
				  if(ch[i+1]==')') {//레이저 라면
					  result += metalRod;//레이저 빔 발사
					  i++;//레이저 다음으로 인덱스를 이동
				  }else {//쇠막대기 시작
					  metalRod++;
					  result++;
				  }
			  }else {//쇠막대기 끝
				  metalRod--;
			  }
		  }//문자 분석과 레이저 발사 끝
		  System.out.println("#"+tc+" "+result);
		  
	  }//테스트케이스
	  
   }//main
}//class






