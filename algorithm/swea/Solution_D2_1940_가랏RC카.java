import java.util.Scanner;

public class Solution_D2_1940_가랏RC카 {
   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  
	  int T = sc.nextInt();
	  for (int tc = 1; tc <= T; tc++) {
		 int N=sc.nextInt(); //명령어의 수 
		 int v=0; //가속도의 변화  
		 int distance=0;//이동한 거리
		 
		 for(int i=0; i<N; i++) {//명령어 수만큼 반복
			int command = sc.nextInt(); //가속, 감속, 속도 유지 명령어
//			if(명령어가 0이 아닌경우)
//			switch~case 명령어1 case 명령어2일 경우
			switch(command) {
			   case 1: //가속
			     v+=sc.nextInt(); //가속도의 변화값  ※주의: 0의 명령어인 경우 입력받을 값 없음!!
			     break;
			   case 2: //감속
				 v-=sc.nextInt(); //가속도의 변화값  ※주의: 0의 명령어인 경우 입력받을 값 없음!!
			}
			
			//만약 속도가 음수값이 나온다면 속도를 0으로 초기화
			if(v<0) v=0;
			
//			distance = distance+v; 
			distance += v; 
		 }//for
		  
		 System.out.println("#"+tc+" "+distance);
	  }//테스트 케이스
	  
	  sc.close();
   }//main
}
