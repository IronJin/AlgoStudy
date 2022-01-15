
/*
 * 문제 : 나무 자르기
 * 해결방법
 * 1. 원하는길이 M을 얻기 위해 자를 수 있는 최대 높이 H는 얼마인가?? 를 뒤집는다.
 * 2. 어떤 높이 H로 잘랐을때 원하는길이 M만큼을 얻을 수 있는가? 이 방법으로 접근한다.
 * 3. mid 는 내가 설정한 어떤 높이 H이다.
 * 4. positive(int h) 함수에서 이를 자를 수 있는지를 확인한다.
 * 즉, 높이 H는 0부터 20억 까지 설정할 수 있고 이분 탐색의 mid 값을 높이로 활용해 마지막 가능한 높이를 출력한다.
 */
import java.io.*;
import java.util.*;

public class BOJ_2805 {

	static int n;
	static int m;
	static int A[];
	
	static boolean positive(int h) {
		long sum = 0;
		for(int i = 0 ; i < n ; i++) {
			if(A[i] > h) {
				sum += A[i] - h;
			}
		}
		return sum >= m;
	}
	
	static void pro() {
		
		int left = 0;
		int right = 2000000000;
		int mid;
		while(left <= right) {
			mid = (left + right)/2;
			if(positive(mid)) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		//right 는 mid 를 높이 h라고 했을때 가능한 높이 h의 최대 높이를 가리키는 index이고
		//index 는 곧 자를 나무의 높이 h를 의미하므로 right 를 출력하면됨.
		System.out.println(right);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		
		
	}
}
