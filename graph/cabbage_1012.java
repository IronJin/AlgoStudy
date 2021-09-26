import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cabbage_1012 {

	static int arr[][];
	//정답을 출력할 것
	static int count;
	static boolean visit[][];
	static int n;
	static int m;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//테스트 케이스
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int test = 0 ; test < t ; test++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visit = new boolean[n][m];
			for(int i = 0 ; i < k ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
						
				arr[y][x] = 1;
			}
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(arr[i][j] == 1 && !visit[i][j]) {
						dfs(j,i);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			
		}	
	}
	
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			visit[location[1]][location[0]] = true;
			for(int i = 0 ; i < 4 ; i++) {
				int nextx = location[0] + dx[i];
				int nexty = location[1] + dy[i];
				if(nextx >= 0 && nexty >= 0 && nextx <m && nexty<n) {
					if(arr[nexty][nextx] == 1 && !visit[nexty][nextx]) {
						q.add(new int[] {nextx,nexty});
						visit[nexty][nextx] = true;
					}
				}
			}
		}
		
	}
	
	public static void dfs(int x, int y) {
		visit[y][x] = true;
		
		for(int i = 0 ; i < 4 ; i ++) {
			int nextx = dx[i] + x;
			int nexty = dy[i] + y;
			
			if(nextx >= 0 && nexty >= 0 && nextx < m && nexty<n) {
				if(arr[nexty][nextx] == 1 && !visit[nexty][nextx]) {
					dfs(nextx,nexty);
				}
			}
		}
		
	}
	

}
