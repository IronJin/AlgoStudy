/*
 * 1. 벽을 세번을 세우는데 브루트포스로 벽을 세개를 세움
 * 2. 벽을 세개를 다 세운경우 바이러스에 대해 BFS 탐색을 통해 바이러스를 퍼뜨림
 * 3. BFS 탐색이 끝난 후 격자에서 0의 개수를 세면됨
 */

import java.io.*;
import java.util.*;

public class BOJ_14502 {

	static int row;
	static int col;
	static int arr[][];
	static int x[] = {0,0,-1,1};
	static int y[] = {1,-1,0,0};
	static int answer = 0;
	
	static void pro() {
		dfs(0);
		System.out.println(answer);
	}
	
	
	//벽을 세번을 세워야함
	static void dfs(int depth) {
		if(depth == 3) {
			answer = Math.max(answer, bfs());
			return;
		}
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(depth+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	//벽을 세번 세우고 난뒤 바이러스가 존재하는곳을 먼저 큐에 넣어준후 벽이 아닌곳을 탐색
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int copy[][] = new int[row][col];
		boolean visit[][] = new boolean[row][col];
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				copy[i][j] = arr[i][j];
				if(copy[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			//System.out.println(currow +" "+curcol);
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow+y[i];
				int nextcol = curcol+x[i];
				if(nextrow >= 0 && nextrow < row && nextcol >= 0 && nextcol < col) {
					if(visit[nextrow][nextcol] == false && copy[nextrow][nextcol] == 0) {
						visit[nextrow][nextcol] = true;
						copy[nextrow][nextcol] = 2;
						q.add(new int[] {nextrow, nextcol});
					}
				}
			}
		}
		
		int count = 0;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(copy[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < col ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
		
	}

}
