import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class apart_2667 {

	static int n;
	static int miro[][];
	static boolean check[][];
	static int dn[] = {0,0,-1,1};
	static int dm[] = {1,-1,0,0};
	static boolean checkd[][];
	static PriorityQueue<Integer> dpq = new PriorityQueue<>();
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		miro = new int[n][n];
		check = new boolean[n][n];
		checkd = new boolean[n][n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			for(int j = 0 ; j < n ; j++) {
				miro[i][j] = str.charAt(j) -'0';
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(miro[i][j] != 0 && !checkd[i][j]) {
					//pq.add(bfs(i,j));
					dfs(i,j);
					dpq.add(ans);
					ans = 0;
				}
			}
		}
		
		System.out.println(dpq.size());
		while(!dpq.isEmpty()) {
			System.out.println(dpq.poll());
		}
		
	}
	
	public static int bfs(int y, int x) {
		int count = 1;
		Queue<int []> pq = new LinkedList<>();
		pq.add(new int[] {y,x});
		check[y][x] = true;
		while(!pq.isEmpty()) {
			int location[] = pq.poll();
		for(int i = 0 ; i < 4 ; i++) {
			int nn = location[0] + dn[i];
			int mm = location[1] + dm[i];
			if(nn >= 0 && mm >= 0 && nn <n && mm <n) {
				if(!check[nn][mm] && miro[nn][mm] != 0) {
					pq.add(new int[] {nn,mm});
					check[nn][mm] = true;
					count++;
				}
			}
		}
		}
		return count;
	}
	
	public static void dfs(int y, int x) {
		if(checkd[y][x]) return;
		ans ++;
		checkd[y][x] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int a = y + dn[i];
			int b = x + dm[i];
			if(a >= 0 && b>= 0 && a< n && b< n) {
				if(!checkd[a][b] && miro[a][b] != 0) {
					dfs(a,b);
				}
			}
		}
		
	}

}
