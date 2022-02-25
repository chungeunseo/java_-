import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BJ_17144_미세먼지안녕 {

	static int R,C,T;
	static int[][]room,roomSpreadCnt;
	static int airCleaner;
	
	//4방-상우하좌
	static int[]dr= {-1,0,1, 0};
	static int[]dc= { 0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());//행
		C = Integer.parseInt(st.nextToken());//열
		T = Integer.parseInt(st.nextToken());//시간(초)
		
		room = new int[R][C]; //입력정보
		roomSpreadCnt = new int[R][C]; //먼지확산 카운트

		//데이터 입력
        for (int i = 0; i < R; i++) {
          st = new StringTokenizer(in.readLine()," ");//행단위의 입력처리(공백구분자)
          for (int j = 0; j < C; j++) {
              room[i][j]=Integer.parseInt(st.nextToken());
              if(room[i][j]==-1) airCleaner=i;//공기청정기의 위치 저장 (첫째열 고정이므로 행의 정보만 저장)
          }
		}
        
        //시간만큼 반복
        for (int t = 0; t < T; t++) {
          initArray(roomSpreadCnt);
          for (int i = 0; i < R; i++) {//미세먼지확산 
            for (int j = 0; j < C; j++) {
//            	if(room[i][j]==0 || room[i][j]==-1) continue;
            	if(room[i][j]<1) continue;//미세먼지가 있는곳에서 시작
            	int div = room[i][j]/5;//미세먼지 5등분 (4방향으로 확산될 미세먼지양 구하기)
            	
            	int cnt=0;
            	for(int k=0; k<4; k++) {//사방 확산
            		
            		int nr=i+dr[k];
            		int nc=j+dc[k];
            		
            		if(nr<0 || nr>=R || nc<0 || nc>=C || room[nr][nc]==-1) continue; //room범위를 벗어나가나 공기청정기를 만나면 skip
            		
            		cnt++;
            		roomSpreadCnt[nr][nc]+=div;//확산된 미세먼지 누적시키기  		
            	}
            	room[i][j]=room[i][j]-div*cnt;//4방향 미세먼지 확산후 기준이 된 미세먼지 값을 변경           
            }
          }
          
//          ※   미세먼지 확산 확인  
//          for (int i= 0; i < R; i++) {
//        	 System.out.println(Arrays.toString(room[i]));
//          }          
          
          
        //누적된 값(roomSpreadCnt)을 원본(room)에 반영
        for (int i= 0; i < R; i++) {
      	  for (int j = 0; j < C; j++) {
      		  if(room[i][j]==-1) continue;//공기청정기 제외
      		  room[i][j]+=roomSpreadCnt[i][j];
      	  }
        }
        
//        System.out.println("============확산 반영 확인===============");
//        for (int i= 0; i < R; i++) {
//        	System.out.println(Arrays.toString(room[i]));
//        }
          

          
		//공기청정기 가동(아래)
        //    1
        //-------->           
        //^        |
        //|4       |2  
        //|        v
        //<-------
        //    3
        
        //위의 그림에서 1번을 실행 : 배열의 오른쪽 쉬프트[22,33,44,55]    
        //쉬프트결과 [22,22,33,44]  ==>문제발생) 값 54가 손실, 2번 방향 진행시 값 55를 쉬프트할수 없다ㅜㅜ
        //그래서 아래와 같이 순서를 변경하면 문제 해결^^
        
        //공기청정기 가동(아래)
        //    4
        //-------->           
        //^       |
        //|1      |3  
        //|       v
        //<-------
        //    2

        //1
        for(int i=airCleaner+2; i<R; i++) {
//        	System.out.println(">>>"+ i+":"+room[i][0]);
        	room[i-1][0]=room[i][0];
        }
        
        //2
        for(int i=1; i<C; i++) {
//        	System.out.println(">>>"+ i+":"+room[R-1][i]);
        	room[R-1][i-1]=room[R-1][i];
        }
        
        //3
        for(int i=R-2; i>=airCleaner; i--) {
//        	System.out.println(">>>"+ i+":"+room[i][C-1]);
        	room[i+1][C-1]=room[i][C-1];
        }

        //4
        for(int i=C-2; i>0; i--) {
//        	System.out.println(">>>"+ i+":"+room[airCleaner][i]);
        	room[airCleaner][i+1]=room[airCleaner][i];
        }
        room[airCleaner][1]=0;//공기청정기 나가는곳 바로앞에 0초기화 
        

        //공기청정기 가동(위)
        //    2  
        //<-------
        //|        ^
        //|1       |3
        //v        |  
        //-------->           
        //    4      
        
        airCleaner--; //공기청정기 위치 윗쪽으로 변경

        
        //1
        for(int i=airCleaner-2; i>=0; i--) {
//        	System.out.println(">>>"+ i+":"+room[i][0]);
        	room[i+1][0]=room[i][0];
        }
        //2
        for(int i=1; i<C; i++) {
//        	System.out.println(">>>"+ i+":"+room[0][i]);
        	room[0][i-1]=room[0][i];
        }

        //3
        for(int i=1; i<=airCleaner; i++) {
//        	System.out.println(">>>"+ i+":"+room[i][C-1]);
        	room[i-1][C-1]=room[i][C-1];
        }
        //4
        for(int i=C-2; i>0; i--) {
//        	System.out.println(">>>"+ i+":"+room[airCleaner][i]);
        	room[airCleaner][i+1]=room[airCleaner][i];
        }
        room[airCleaner][1]=0;//공기청정기 나가는곳 바로앞에 0초기화 
        
        airCleaner++; //공기청정기 위치 아래쪽으로 변경
		}//시간반복
        
        
//        System.out.println("============공기청정기 가동확인===============");
//        for (int i= 0; i < R; i++) {
//        	System.out.println(Arrays.toString(room[i]));
//        }
		
        int cnt=0;
        for (int i= 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		cnt +=  room[i][j];
        	}
        }
        System.out.println(cnt+2);//공기청정기에서 -2된 값을 보완
        
	}//main

	private static void initArray(int[][] roomSpreadCnt) {
		for (int i = 0; i < roomSpreadCnt.length; i++) {
		    Arrays.fill(roomSpreadCnt[i], 0);
		}
	}
}//end class
