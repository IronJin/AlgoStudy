/*
 * 기본적인 이분탐색 문제 두번째 배열의 값들을 첫번째 수첩배열에서 이분탐색을 통해 존재하는지만을 확인해주면 되는 문제
 * 
 * 초반에 틀린 이유 : 출력에 많은시간이 드는데 만약 최악의 경우 한줄한줄 출력해줄경우 엄청난 시간이 소요되기 때문에 틀렸음
 * -- 해결방법 -> StringBuilder 를 통해 케이스당 한번만 출력하도록함
 */

import java.io.*;
import java.util.*;

public class BOJ_2776 {

	static int t;
	static int n;
	static int m;
	static int arr1[];
	static int arr2[];
	static StringBuilder sb;
	
	static void bin_sear(int x) {
		int left = 0;
		int right = n-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(arr1[mid] < x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		if(0 <= left && left < n) {
			if(arr1[left] == x) {
				sb.append(1);
			}else {
				sb.append(0);
			}
		}else {
			sb.append(0);
		}
	}
	
	static void pro() {
		Arrays.sort(arr1);
		for(int i = 0 ; i < m ; i++) {
			int x = arr2[i];
			bin_sear(x);
			if(i < m-1) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		int testcase = 0;
		while(testcase < t) {
			sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());
			arr1 = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(br.readLine());
			arr2 = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < m ; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			pro();
			testcase++;
		}

	}

}
