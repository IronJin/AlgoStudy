//최소를 출력하는 문제
//고려해야할 중요 포인트 : left 는 배열의 최대부터 시작해야하며 right 는 최악의 경우를 생각했을때 10억부터 시작해야함
//이유는 m 이 1이고 n이 10만, 배열의 모든 값이 10000일 경우 10억이 정답이 되기 대문

import java.io.*;
import java.util.*;

public class BOJ_6236 {

	static int n;
	static int m;
	static int arr[];
	static int max = Integer.MIN_VALUE;
	
	static boolean para(int x) {
		//처음에 무조건 한번 인출하면서 시작하는것이기 때문에 인출 횟수는 1부터 시작함
		int count = 1;
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum += arr[i];
			if(sum > x) {
				count++;
				sum = arr[i];
			}
		}
		return count <= m;
	}
	
	static void pro() {
		int left = max;
		int right = 1000000000;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			if(para(mid)) {
				right = mid - 1;
				answer = mid;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		pro();

	}

}
