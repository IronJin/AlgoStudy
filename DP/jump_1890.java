import java.io.*;
import java.util.StringTokenizer;

public class jump_1890 {

	static int n;
	static int miro[][];
	static long dp[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		dp = new long[n][n];
		miro = new int[n][n];
		
		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dp[0][0] = 1;
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j++) {
				
				//dp에 저장된 값이 0 일때는 검사할 필요가 없음
				//맨 오른쪽 아래는 검사할 필요가 없음
				if(dp[i][j] == 0 || i == n-1 && j == n-1) {
					continue;
				}
				
				if(i+miro[i][j] < n) {
					dp[i+miro[i][j]][j] += dp[i][j];
				}
				if(j + miro[i][j] < n) {
					dp[i][j+miro[i][j]] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[n-1][n-1]);
		
		
	}
}
