package Two_Pointer;

import java.io.*;
import java.util.*;

public class BOJ_2559 {

	static int n;
	static int k;
	
	static int left;
	static int right;
	
	static int arr[];
	
	static int max = Integer.MIN_VALUE; //누적합 저장장소
	static int current = 0; //현재 값 저장장소
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//---------------------------------------------------------
		
		left = 0;
		right = k-1;
		for(int i = left ; i <= right ; i++) {
			current += arr[i];
		}
		
		max = Math.max(max, current);
		
		while(right < n-1) {
			right++;
			current -= arr[left];
			left++;
			current += arr[right];
			max = Math.max(max, current);
		}

		System.out.println(max);
		
	}

}
