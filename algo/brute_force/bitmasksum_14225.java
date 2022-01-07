package brute_force;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bitmasksum_14225 {

	static int n;
	static int[] arr;
	static int answer;
	static HashSet<Integer> hs = new HashSet<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		answer = 1;
		
		while(true) {
			if(hs.contains(answer)) {
				answer++;
			}else {
				break;
			}
		}
		
		System.out.println(answer);

	}
	
	public static void dfs(int length, int sum) {
		if(length == n) {
			hs.add(sum);
			return;
		}
		
		dfs(length +1, sum+arr[length]);
		dfs(length +1 , sum);
	}

}
