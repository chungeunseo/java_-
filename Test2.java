
public class Test2 {

	public static void main(String[] args) {

		int[]  su=  { 45, 80, 68, 19, 34, 55, 27, 60, 27, 18 };
		//평균 찾기
		int sum=0; //배열 안의 전체 합을 0으로 초기화
		for(int i=0;i<su.length;i++) { //배열 안을 탐색
			sum +=su[i]; //배열 안의 모든 숫자를 더함
		}
		//배열 전체 합을 전체 개수로 나눠서 평균을 구함
		double avg = (double)sum/su.length;
		//배열의 요소들과 평균의 차이를 출력할 배열 생성
		double[] gap= new double[su.length];
		for(int j=0;j<su.length;j++) {//su의 요소를 탐색
			if(avg<su[j]) {//평균이 더 작다면
				gap[j]=su[j]-avg;//배열 요소에서 평균 빼기
			}
			else {//평균이 더 크다면
				gap[j]=avg-su[j];//평균에서 요소 빼기
			}
		}
		//배열 gap에서 최솟값 구하기 위해 적당히 큰 수로 초기화
		double min =100;
		int idx=0;
		for(int k=0;k<gap.length;k++)
		{//gap의 최솟값 구하기
			if(min>gap[k]) {
				//gap보다 min이 크면 min을 gap의 요소로 바꾸기
				min=gap[k];
				//최솟값일때의 인덱스 구하기
				idx=k;
			}
		}
		//정답 출력
		System.out.print(avg+" "+su[idx]);
		
	}
}
