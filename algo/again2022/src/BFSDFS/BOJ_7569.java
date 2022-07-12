package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_7569 {

	static int row;
	static int col;
	static int h;
	
	static int arr[][][];
	static int dist [][][];
	
	static int yr[] = {0,0,-1,1,0,0};
	static int xc[] = {1,-1,0,0,0,0};
	static int hz[] = {0,0,0,0,1,-1};
	
	static int answer = 0;
	static boolean can = true;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[row][col][h];
		dist = new int[row][col][h];
		
		for(int z = 0 ; z < h ; z++) {
			for(int i = 0 ; i < row ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < col ; j++) {
					arr[i][j][z] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
		for(int z = 0 ; z < h ; z++) {
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					if(arr[i][j][z] == 0) {
						can = false;
					}
					answer = Math.max(answer, dist[i][j][z]);
				}
			}
		}
		
		
		if(!can) {
			System.out.println(-1);
		}else {
			System.out.print(answer);
		}
		

	}
	
	static void bfs() {
		
		Queue<int []> q = new LinkedList<>();
		for(int z = 0 ; z < h ; z++) {
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					if(arr[i][j][z] == 1) {
						q.add(new int[] {i,j,z});
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			int curh = location[2];
			for(int i = 0 ; i < 6 ; i++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				int nexth = curh + hz[i];
				if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col && 0 <= nexth && nexth < h) {
					if(arr[nextrow][nextcol][nexth] == 0) {
						dist[nextrow][nextcol][nexth] = dist[currow][curcol][curh] + 1;
						arr[nextrow][nextcol][nexth] = 1;
						q.add(new int[] {nextrow, nextcol, nexth});
					}
				}
			}
		}
		
		
	}

}
