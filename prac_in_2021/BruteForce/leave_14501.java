package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class leave_14501 {
	static int answer = 0;
	static int n;
	static int arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		
		arr = new int[n+1][2];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				arr[i][0] = a;
				arr[i][1] = b;
		}
		
		//for(int i = 0 ; i < n+1 ; i++) {
			//System.out.println(arr[i][0] + " " + arr[i][1]);
		//}
		
		dfs(1,0);
		
		System.out.println(answer);
	}

	public static void dfs(int day, int sum) {
		if(day > n) {
			answer = Math.max(answer, sum);
			return;
		}
		
		if(day + arr[day][0] <= n+1) dfs(day + arr[day][0], sum + arr[day][1]);
		else dfs(day + arr[day][0] , sum);

		dfs(day+1,sum);
	}
	
}
