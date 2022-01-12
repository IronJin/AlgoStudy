
/*
 * 시간초과 문제풀이 : 요소값의 중복을 허용하는 상태에서 선택한 값이 해당 배열에 몇개 존재하는지를 확인해야 하는 문제이다.
 * 따라서 해당 요소가 몇개를 가지고 있는지 출력하는것이 중요하므로 이를 저장해줄 자료구조를 하나 만드는 것이 중요하다.
 * 따라서 HashMap 을 이용하여 해당 값이 몇개 들어있는지 value 로 저장하여 확인한다.
 * --> 해쉬맵으로만으로도 풀 수 있고 이분탐색으로만으로도 풀 수 있는 문제이다.
 * 
 * 정답 문제풀이 : upper bound 와 lower bound 를 활용한다.
 * StringBuilder 를 활용하지 않으면 시간초과가 나는 어이가 없는 문제였다.
 */

import java.io.*;
import java.util.*;


public class BOJ_10816 {

	static int n;
	static int A[];
	static int m;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int lower_bound(int left, int right, int x) {
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(A[mid] < x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	static int upper_bound(int left, int right, int x) {
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(A[mid] <= x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	static void pro() throws IOException  {
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			int B = Integer.parseInt(st.nextToken());
			int lower = lower_bound(0, A.length-1 , B);
			int upper = upper_bound(0, A.length-1 , B);
			sb.append(upper - lower).append(' ');
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		pro();
	}

}
