
import java.io.*;

public class DP_2156 {

	static int n;
	static int g[];
	static int dp[];
	//다이나믹 프로그래밍도 어렵다...
	//다이나믹 프로그래밍 첫문제라 답을 보고 품
	//설명이라도 잘해보자
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		g = new int[n];
		dp = new int[n];
		
		for(int i = 0 ; i < n ; i ++) {
			g[i] = Integer.parseInt(br.readLine());
		}
				
		if(n == 1) {
			System.out.println(g[0]);
		}else if(n == 2) {
			System.out.println(g[0] + g[1]);
		}else {
			dp[0] = g[0];
			dp[1] = g[0]+g[1];
			dp[2] = Math.max(dp[1], Math.max(dp[0] + g[2], g[1] + g[2]));
			
			for(int i = 3 ; i < n ; i++) {
				dp[i] = Math.max(dp[i-3] + g[i] + g[i-1], dp[i-2] + g[i]);
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			
			System.out.println(dp[n-1]);
		}
		
	}

}
