import java.io.*;
import java.util.*;

//답을 보지않고 혼자의 힘으로 해결함
public class countingisland_4963 {

	static int row;
	static int col;
	static int miro[][];
	static boolean visit[][];
	static int answer = 0;
	static int dx[] = {1,-1,0,0,1,1,-1,-1};
	static int dy[] = {0,0,1,-1,1,-1,1,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			if(row == 0 && col == 0) {
				break;
			}
			miro = new int[row][col];
			for(int i = 0 ; i < row ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < col ; j++) {
					miro[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visit = new boolean[row][col];
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					if(miro[i][j] == 1 && visit[i][j] == false) {
						answer ++;
						dfs(j,i);
					}
				}
			}
			System.out.println(answer);
		}
		
	}
	public static void dfs(int x , int y) {
		visit[y][x] = true;
		
		for(int i = 0 ; i < 8 ; i++) {
			int nextx = dx[i] + x;
			int nexty = dy[i] + y;
			if(nextx >= 0 && nexty >= 0 && nextx < col && nexty < row) {
				if(miro[nexty][nextx] == 1 && visit[nexty][nextx] == false) {
					dfs(nextx,nexty);
				}
			}
		}
	}

}
