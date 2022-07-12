package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_2178 {

	static int row;
	static int col;
	static int miro[][];
	static int dist[][];
	static boolean visit[][];
	static int result;
	static int startrow = 1;
	static int startcol = 1;
	
	static int xc[] = {0,0,-1,1};
	static int yr[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		miro = new int[row+1][col+1];
		dist = new int[row+1][col+1];
		visit = new boolean[row+1][col+1];
		
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1 ; j <= col ; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dist[1][1] = 1;
		
		for(int i = 1 ; i <= row ; i++) {
			String a = br.readLine();
			for(int j = 1 ; j <= col ; j++) {
				if(a.charAt(j-1) == '1') {
					miro[i][j] = 1;
				}
			}
		}
		
		bfs(1,1);
		
		result = dist[row][col];
		
		System.out.println(result);
	}
	
	static void bfs(int startrow, int startcol) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startrow, startcol});
		visit[startrow][startcol] = true;
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow + xc[i];
				int nextcol = curcol + yr[i];
				
				if(1 <= nextrow && nextrow <= row && 1 <= nextcol && nextcol <= col) {
					if(visit[nextrow][nextcol] == false && miro[nextrow][nextcol] == 1) {
						if(dist[nextrow][nextcol] > dist[currow][curcol] + 1) {
							q.add(new int[] {nextrow, nextcol});
							dist[nextrow][nextcol] = dist[currow][curcol] + 1;
							visit[nextrow][nextcol] = true;
						}
					}
				}
			}
		}
		
	}

}
