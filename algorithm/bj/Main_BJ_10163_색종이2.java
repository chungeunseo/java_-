import java.util.ArrayList;
import java.util.Scanner;

public class Main_BJ_10163_색종이2 {
	
   static class Paper{
	    int startX,startY,width,height;
        int cnt;
		public Paper(int startX, int startY, int width, int height) {
			super();
			this.startX = startX;
			this.startY = startY;
			this.width = width;
			this.height = height;
		}	    
   }   
   
   
   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int N = sc.nextInt();
	  ArrayList<Paper> papers = new ArrayList<>(); 
	  int [][]map;//2. 그림그리기 준비
	  int y,x;
	      y=x=0;
	  
	  for(int i=0; i<N; i++) {
		  //1. x와 y가 명확해야 한다!!

		  int startX=sc.nextInt();
		  int startY=sc.nextInt();
		  
		  int width= sc.nextInt();
		  int height = sc.nextInt();
                                 
		  papers.add(new Paper(startX, startY, width, height));
		  
		  //그림판 전체사이즈 얻기
		  if(y<startY+height) y=startY+height;
		  if(x<startX+width) x=startX+width;
	  }
	  
//	  System.out.println(y);
//	  System.out.println(x);
	  map = new int [y][x];
	  
	  for(int cnt=1; cnt<=N; cnt++) {	  
		  Paper paper = papers.get(cnt-1);
//		  System.out.println("startY="+ paper.startY);
//		  System.out.println("startX="+ paper.startX);
//		  System.out.println("height="+ paper.height);
//		  System.out.println("width="+ paper.width);
//		  System.out.println("------------------------");
//		  System.out.println("i="+paper.startY+"~"+(paper.startY+ paper.height));
//		  System.out.println("j="+paper.startX+"~"+(paper.startX+ paper.width));
//		  System.out.println("========================");
		  
	      //그리기
		  for(int i= paper.startY; i< paper.startY+ paper.height; i++) {
			  for(int j=paper.startX; j< paper.startX+ paper.width; j++) {
//				  System.out.println(i+","+j);				  
			      map[i][j]=cnt;
			  }
		  } 
	  }
	  
	  //확인
//	  for(int i=0; i<y; i++) {
//		  System.out.println(Arrays.toString(map[i]));
//	  }
	  
	  for(int k=0; k<N; k++) {
		  int confirm=k+1;
		  //숫자세기
		  for(int i=0; i<y; i++) {
			  for(int j=0; j<x; j++) {
//				  System.out.println(i+":"+j);
				  if(map[i][j]==confirm)
				  papers.get(k).cnt++;
			  }
		  }
	  }
	  
	  //숫자출력
	  for(int i=0; i<N; i++) {
		  System.out.println(papers.get(i).cnt);
	  }
	  
	  
	  
	  sc.close();
   }//main
}//end class
