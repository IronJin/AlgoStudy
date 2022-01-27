//매개변수탐색
//과자의 길이를 이분탐색으로 정하고 정해진 길이를 모든 배열의 값들에 대해 나누었을때 몫의 값이 M 을 넘어야함

import java.io.*;
import java.util.*;

public class BOJ_16401 {

	static int m;
	static int n;
	static int arr[];
	
	static boolean para(int x) {
		int count = 0;
		for(int i = 0 ; i < n ; i++) {
			count += arr[i]/x;
		}
		return count >= m;
	}
	
	static void pro() {
		Arrays.sort(arr);
		
		int left = 1;
		int right = 1000000000;
		int answer = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(para(mid)) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
		
		
	}
}
