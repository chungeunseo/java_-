import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {
   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  
	  for(int tc=1; tc<=10; tc++) {//테스트케이스 숫자 표현
	    int result=0;
		
	    int maxDumpCnt = sc.nextInt();//상자를 옮길수 있는 최대 횟수
        int[] nums = new int[100]; //100개의 박스높이 입력받을 공간 확보    
	    
        for(int i=0; i<100; i++) {//배열 인덱스
           nums[i] = sc.nextInt(); //데이터 입력	
        }
        
        int dumpCnt=0;//상자를 옮긴 횟수
        
        while(true) {//반복적으로 박스를 이동
        	Arrays.sort(nums);//기본이 오름차순 정렬
        	
        	if(nums[99]-nums[0]<=1   ||   
        	   maxDumpCnt <= dumpCnt)//탈출 조건: 1. 평탄작업이 끝났다면 (박스의 높이차이가 1또는 0)   2. 최대덤프수를 만족했을때
        	break;
        	
        	//계속진행 OK
        	//nums[99] = nums[99]-1;
        	nums[99]--;
        	nums[0]++;
        	
        	dumpCnt++;
        }//while
        result = nums[99]-nums[0];
	    System.out.println("#"+tc+" "+result);
	  }//테케
	  sc.close();
   }//main
}
