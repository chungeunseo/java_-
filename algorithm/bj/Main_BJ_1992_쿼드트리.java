import java.util.Scanner;
//쿼드 트리(Quad Tree): 자식 노드가 4개인 트리
//영상을 4등분하여 그 조각의 수가 모두 같을때까지
public class Main_BJ_1992_쿼드트리 {
	
	public static int[][] video;// 흑백영상
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		//영상의 크기
		int N = sc.nextInt();
		video = new int[N][N];	
        //영상크기만큼  문자열 주어짐
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				//char로 받아오기때문에 '0'빼주면 int
				video[i][j] = str.charAt(j) - '0';
			}
		}		
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int x, int y, int size) {	
		// 압축이 가능할 경우 하나의 색상으로 압축
		if(zip(x, y, size)) {
			sb.append(video[x][y]);
			return;
		}
		//압축안되면 반으로쪼개기
		int newSize = size / 2;		
		sb.append('(');
		//왼쪽위
		QuadTree(x, y, newSize);		
		//오른쪽 위
		QuadTree(x, y + newSize, newSize);		
		//왼쪽아래
		QuadTree(x + newSize, y, newSize);			
		//오른쪽아래
		QuadTree(x + newSize, y + newSize, newSize);	
		sb.append(')');
	}
	
	// 압축이 가능한지 체크하는 메서드
	public static boolean zip(int x, int y, int size) {
		int num = video[x][y];	
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(num != video[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
 
}