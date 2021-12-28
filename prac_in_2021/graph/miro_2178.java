import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class miro_2178 {

	static int n;
	static int m;
	static int miro[][];
	static boolean check[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
			
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		miro = new int[n][m];
		check= new boolean[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0 ; j < str.length() ; j++) {
				miro[i][j] = str.charAt(j) -'0';
			}
		}
		
		bfs(0,0);
		System.out.println(miro[n-1][m-1]);

	}
	
	public static void bfs(int x, int y) {
		Queue<int []> pq = new LinkedList<>();
		pq.add(new int [] {x,y});
		check[x][y] = true;
		while(!pq.isEmpty()) {
			int location[] = pq.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int mm = location[1] + dx[i];
				int nn = location[0] + dy[i];
				if(mm>=0 && nn>=0 && nn<n && mm<m ) {
					if(!check[nn][mm] && miro[nn][mm] != 0) {
					pq.add(new int[] {nn,mm});
					check[nn][mm] = true;
					miro[nn][mm] = miro[location[0]][location[1]] +1;
					}
				}
			}
		}
	}
}
