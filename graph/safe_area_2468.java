import java.io.*;
import java.util.*;

public class safe_area_2468 {

	static int n;
	static int miro[][];
	static boolean visit[][];
	static boolean visitcopy[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int max = 0;
		miro = new int[n][n];
		visit = new boolean[n][n];
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, miro[i][j]);
			}
		}
		int count = 0;
		for(int i = 0 ; i < max ; i++) {
			count = copy(miro,i);
			answer = Math.max(answer, count);
		}

		System.out.println(answer);
	}
	
	public static int copy(int area[][], int h) {
		int ans = 0;
		int mirocopy[][] = area;
		visitcopy = visit;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				visitcopy[i][j] = false;
			}
		}
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j++) {
				if(mirocopy[i][j] <= h) {
					visitcopy[i][j] = true;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n; j++) {
				if(visitcopy[i][j] == false) {
					bfs(j,i);
					ans++;
				}
			}
		}
		return ans;
	}
	
	public static void bfs(int x, int y) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int curx = location[0];
			int cury = location[1];
			visitcopy[cury][curx] = true;
			for(int i = 0 ; i < 4 ; i++) {
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];
				if(nextx >= 0 && nexty >= 0 && nextx<n && nexty < n) {
					if(visitcopy[nexty][nextx] == false) {
						q.add(new int[] {nextx,nexty});
						visitcopy[nexty][nextx] = true;
					}
				}
			}
		}
	}
}
