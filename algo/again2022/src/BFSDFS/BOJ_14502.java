package BFSDFS;

import java.io.*;
import java.util.*;

/**
 * 1. 벽을 먼저 세운다.
 * 
 * 2. dfs 를 통해 바이러스를 퍼뜨린다.
 *
 * 3. 0의 개수를 세준다.
 */
public class BOJ_14502 {

	static int row;
	static int col;
	
	static int arr[][];
	static boolean visit[][];
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	static int result = 0;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		
		//1 : 벽 / 2 : 바이러스 / 0 : 안전구역
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < col ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//벽을 먼저 세울것
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(i,j,1);
					arr[i][j] = 0;
				}
			}
		}
		
		System.out.println(result);
		
		
	}
	
	static void wall(int startrow, int startcol ,int depth) {
		if(depth == 3) {
			bfs();
		}else {
			for(int i = startrow ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					if(i == startrow && j == startcol) {
						j = startcol;
						continue;
					}
					
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						wall(i,j,depth+1);
						arr[i][j]=0;
					}
					
				}
			}
		}
		
	}
	
	
	static void bfs() {
		visit = new boolean[row][col];
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 2) {
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
						q.add(new int[] {nextrow, nextcol});
						visit[nextrow][nextcol] = true;
					}
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 1 || visit[i][j] == true) {
					continue;
				}else {
					count++;
				}
			}
		}
		
		result = Math.max(count, result);
		
	}

}
