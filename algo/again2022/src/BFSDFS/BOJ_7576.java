package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_7576 {

	static int row;
	static int col;
	static int arr[][];
	static int dist[][];
	static boolean visit[][];
	
	static int result = 0;
	
	static boolean possible = true;
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		dist = new int[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0 ; i < row ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < col ; j++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		for(int i = 0 ; i < row ; i++) {
			if(!possible) break;
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					possible = false;
					break;
				}
				
				result = Math.max(dist[i][j], result);
				
			}
		}
		
		if(possible) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}

	}
	
	static void bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0 ; i < row ; i ++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 1) {
					q.add(new int[] {i,j});
					visit[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
					if(visit[nextrow][nextcol] == false && arr[nextrow][nextcol] == 0) {
						arr[nextrow][nextcol] = 1;
						visit[nextrow][nextcol] = true;
						dist[nextrow][nextcol] = dist[currow][curcol] + 1;
						q.add(new int[] {nextrow,nextcol});
					}
				}
			}
		}
		
	}

}
