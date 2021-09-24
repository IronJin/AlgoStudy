import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato_7576 {

	static int arr[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static Queue<int []> q = new LinkedList<>(); 
	//mÀÌ xÁÂÇ¥
	static int m;
	//nÀÌ yÁÂÇ¥
	static int n;
	
	static int count = 0;
	static int already = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					//j°¡ xÁÂÇ¥ , i °¡ y ÁÂÇ¥°¡µÊ
					q.add(new int[] {j,i});
					already++;
				}
			}
		}
		
		bfs();
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j ++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}else {
					count = Math.max(count, arr[i][j]);
				}
			}
		}
		
		System.out.println(count-1);
		
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int x = location[0];
			int y = location[1];
			
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextx = x+dx[i];
				int nexty = y+dy[i];
				if(nextx >= 0 && nexty >= 0 && nextx < m && nexty<n) {
					if(arr[nexty][nextx] == 0) {
						arr[nexty][nextx] = arr[y][x] +1;
						q.add(new int[] {nextx,nexty});
					}
				}
			}
		}
	}
	
}
