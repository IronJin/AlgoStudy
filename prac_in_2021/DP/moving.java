import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class moving {

	static int n;
	static int m;
	static int miro[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		miro = new int[n+1][m+1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= m ; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				miro[i][j] += Math.max(miro[i-1][j], Math.max(miro[i-1][j-1], miro[i][j-1]));
			}
		}
		
		System.out.println(miro[n][m]);
		
	}
}
