import java.io.*;

//¥‰¿ª ∫Ω
public class make_to_one_1463 {

	static int n;
	static int dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		dp[1] = 0;
		
		int answer = recur(n);
		System.out.println(answer);
	}

	static int recur(int a) {
		if(a != 1 && dp[a] == 0) {
			if(a % 6 == 0) {
				dp[a] = Math.min(Math.min(recur(a/3), recur(a/2)), recur(a-1))+1;
			}else if(a%3 == 0) {
				dp[a] = Math.min(recur(a/3), recur(a-1))+1;
			}else if(a%2 == 0) {
				dp[a] = Math.min(recur(a/2), recur(a-1))+1;
			}else {
				dp[a] = recur(a-1)+1;
			}
		}
		return dp[a];
	}
}
