

import java.io.*;
import java.util.*;

public class BOJ_2343 {

	static int n;
	static int m;
	static int arr[];
	
	static boolean para(int l) {
		int sum = 0;
		int count = 1;
		for(int i = 0 ; i < n ; i++) {
			if(sum + arr[i] > l) {
				if(arr[i] > l) {
					count = m+1;
					break;
				}else {
					sum = arr[i];
				}
				count++;
			}else {
				sum += arr[i];
			}
		}
		return count <= m;
	}
	
	static void pro() {
		int left = 0;
		int right = 1000000000;
		int answer = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(para(mid)) {
				answer = mid;
				right = mid - 1;
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
		arr= new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();

	}

}
