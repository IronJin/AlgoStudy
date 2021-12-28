import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class knight_move_7562 {

	static int miro[][];
	static boolean check[][];
	static int dx[] = {-2,-2,2,2,-1,-1,1,1};
	static int dy[] = {1,-1,1,-1,2,-2,2,-2};
	static int s;
	static int ax;
	static int ay;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int z = 0 ;  z<t ; z++) {
		
			s = Integer.parseInt(br.readLine());
			miro = new int[s][s];
			check = new boolean[s][s];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ax = Integer.parseInt(st.nextToken());
			ay = Integer.parseInt(st.nextToken());
			
			bfs(x,y);
			
			System.out.println(miro[ax][ay]);
		}
		
		
	}
	
	public static void bfs(int x , int y) {
		Queue<int []> q = new LinkedList<>();
		
		
		q.add(new int[] {y,x});
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			
			int locate[] = q.poll();
			
			if(ax == locate[0] && ay == locate[1]) return;
			
			for(int i = 0 ; i < 8 ; i++) {
				int rx = locate[0] + dx[i];
				int cy = locate[1] + dy[i];
				
				if(rx >= 0 && cy >= 0 && rx < s && cy < s) {
					if(!check[rx][cy]) {
						miro[rx][cy] = miro[locate[0]][locate[1]]+1;
						check[rx][cy] = true;
						q.add(new int[] {rx,cy});
					}
				}
			}
			
		}
	}
	
}
