//두 수의 합 문제
//자기자신을 선택한 후 자기자신보다 오른쪽에 있는 배열을 이분탐색을 통해 해결

import java.io.*;
import java.util.*;

public class BOJ_3273 {

	static int n;
	static int arr[];
	static int x;
	static int count = 0;
	
	static int bin(int left, int right, int target) {
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;

	}
	
	static void pro() {
		Arrays.sort(arr);
		for(int i = 0 ; i < n-2 ; i++) {
			int target = x-arr[i];
			int index = bin(i+1,arr.length-1,target);
			if(i + 1 <= index && index <= arr.length -1 && arr[index] == target) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		pro();
	}

}
