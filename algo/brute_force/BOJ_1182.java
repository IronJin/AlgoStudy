package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_1182 {

	static int s;
	static int n;
	static int arr[];
	static int count = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void rec_func(int sum, int depth, int k) {
		if(sum == s) {
			count++;
		}else if(depth > n) {
			return;
		}
		for(int i = k ; i < n ; i++) {
			sum += arr[i];
			rec_func(sum, depth+1, i+1);
			sum -= arr[i];
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		rec_func(0,0,0);
		System.out.println(count);
		
		
	}

}
