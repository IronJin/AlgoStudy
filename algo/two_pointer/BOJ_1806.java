
import java.io.*;
import java.util.*;

public class BOJ_1806 {

	static int n;
	static int s;
	static int A[];
	
	static void pro() {
		int left = 0;
		int right = 0;
		//초기값 --> left와 right 가 처음부터 시작하므로
		int sum = A[0];
		int length = Integer.MAX_VALUE;
		while(left <= A.length-1 && right <= A.length-1) {
			if(sum >= s) {
				length = Math.min(right - left + 1, length);
				//길이가 1보다 작은건 없으므로 그냥 바로 break 하고 답을 출력
				if(length == 1) {
					break;
				//그게 아니라면 left 포인터에 위치한 값을 sum에서 빼줌	
				}else {
					sum -= A[left];
				}
				left++;
			}else {
				right++;
				//오른쪽 포인터가 배열의 밖으로 나가면 종료를 해줘야 32번째 줄이 실행됨
				if(right > A.length-1) {
					break;
				}
				//넘지않는다면 오른쪽 포인터가 가르키는 배열의 값을 sum에 더해주어야함
				sum += A[right];
			}
		}
		if(length == Integer.MAX_VALUE) {
			length = 0;
		}
		System.out.println(length);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		
	}
}
