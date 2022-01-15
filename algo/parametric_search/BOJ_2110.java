import java.io.*;
import java.util.*;


//매개변수탐색의 대표적인 문제
//거리가 h일때 c개를 넘는지를 확인하고 안된다면 마지막에 저장된 답의 변수가 정답
//시간초과를 넘지않기 위한 팁 : 거리 h를 선정하는 방법은 이분탐색으로 정해야함

public class BOJ_2110 {

	static int n;
	static int c;
	static int A[];
	
	static boolean positive(int h) {
		int count = 1;
		int last = A[0];
		for(int i = 1 ; i < A.length ; i++) {
			if(A[i] - last >= h) {
				last = A[i];
				count++;
			}
		}
		return count >= c;
	}
	
	static void pro() {
		int left = 0;
		int right = 1000000000;
		while(left <= right) {
			int mid = (left + right)/2;
			if(positive(mid)) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		A = new int[n];
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(A);
		pro();
		
	}
}
