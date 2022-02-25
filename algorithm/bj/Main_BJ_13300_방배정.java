import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_13300_방배정 {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int N= sc.nextInt();//수학여행 참가 종 학생수
	   int K= sc.nextInt();//한 방의 최대 인원수
	   
	   int [][]roomCheck = new int[7][2];//기본방에 대한 표현
	   
	   //데이터 입력
//	   for(int i=0; i<N; i++) {
	   for(int i=1; i<=N; i++) {//배열 행 인덱스(학년을 표현)
		   int S= sc.nextInt();//성별(0:여학생, 1:남학생)
		   int Y= sc.nextInt();//학년
		   
		   if(S%2==0) roomCheck[Y][0]++;//여학생 인원수 추가
		   else       roomCheck[Y][1]++;//남학생 인원수 추가
	   }
	   
	   //데이터 확인
//	   for (int i = 0; i < roomCheck.length; i++) {
//		 System.out.println(Arrays.toString(roomCheck[i]));
//	   }

	   int roomCount=0; //최소방의 개수
	   //문제풀기(알고리즘구현)
//       for(int i=1; i<=6; i++) {//학년행을 표현  (i==학년)
//    	   roomCheck[i][0]/=K;
//    	   roomCheck[i][1]/=K;
//    	   //생각없이 나누어 봄(기본적인 생각/규칙) ==> 답이 안나와 ==> 배열값 확인해봄 ==> 문제발생 인지 ==> 해결
//    	   
//    	   roomCount += roomCheck[i][0]+roomCheck[i][1];
//       }
	   
       for(int i=1; i<=6; i++) {//학년행을 표현  (i==학년)
           //입력된 특정학년 특정성별의 개수가 1이상이라면
    	   if(roomCheck[i][0]>1) {//여학생
    		   int t=0;
    		   if(roomCheck[i][0]%K>0) t=1; //나머지가 발생하였다면 방추가
    		   
    		   roomCheck[i][0]/=K;
    		   roomCheck[i][0]+=t;//방증가
    	   }
    	   if(roomCheck[i][1]>1) {//남학생
    		   boolean t=false;
    		   if(roomCheck[i][1]%K>0) t=true; //나머지가 발생하였다면 방추가
    		   
    		   roomCheck[i][1]/=K;
    		   if(t)roomCheck[i][1]++;//방증가
    	   }
    	   roomCount += roomCheck[i][0] + roomCheck[i][1];//각학년의 필요한 방의 수를 누적
       }	   
	   
       //데이터 확인
//	   for (int i = 0; i < roomCheck.length; i++) {
//		 System.out.println(Arrays.toString(roomCheck[i]));
//	   }
	   
	   
	   System.out.println(roomCount);
	   
	   sc.close();
   }//main
}









