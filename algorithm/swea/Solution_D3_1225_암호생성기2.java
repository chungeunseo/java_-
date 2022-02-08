import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Solution_D3_1225_암호생성기2{
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        while(  (str=br.readLine()) != null  ) {  }
        
        
        while(sc.hasNext()) {   
            list.clear();//이전 암호 제거
            int tcNum = sc.nextInt();
            for(int i = 0; i < 8;i++) {
                list.add(sc.nextInt());//각 테케 8개의 수를 List에 입력
            }
            
            boolean flag = false;
            while(!flag) {
                 
                for(int i = 1; i <= 5;i++) {
                    int num = list.remove(0);//가장 먼저 추가된 값 삭제
                    num -= i;//1에서 5까지 차례대로 감소
                    
                    if(num <= 0) {//암호생성 끝나는 조건
                        num = 0;    
                        list.add(num);
                        flag = true;
                        break;

                    }else {
                        list.add(num);//가장 끝에 추가
                    }                                       
                }                 
            }//while           
             
            System.out.print("#" + tcNum);
             
            for(int i = 0; i <list.size();i++) {
                System.out.print(" " + list.get(i));
            }//생성된 8자리 숫자 암호 출력
            
            System.out.println();
        }
       sc.close(); 
    }//main 
}