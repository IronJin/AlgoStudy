package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_1987 {

	static int row;
	static int col;
	
	static char arr[][];
	static boolean visit[]; //LENGTH : 26
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new char[row][col];

		for(int i = 0 ; i < row ; i++) {
			String a = br.readLine();
			for(int j = 0 ; j < col ; j++) {
				arr[i][j] = a.charAt(j);
			}
		}
	
		
		visit = new boolean[26];
		visit[arr[0][0]-65] = true;
		dfs(0,0,0);
		
		System.out.println(answer+1);
		
	}
	
	static void dfs(int currow, int curcol, int depth) {
		
		answer = Math.max(depth, answer);
		
		for(int i = 0 ; i < 4 ; i ++) {
			int nextrow = currow + yr[i];
			int nextcol = curcol + xc[i];
			if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
				if(visit[arr[nextrow][nextcol]-65] == false) {
					visit[arr[nextrow][nextcol]-65] = true;
					dfs(nextrow, nextcol, depth+1);
					visit[arr[nextrow][nextcol]-65] = false;
				}
			}
		}
		
		
	}
	
	
	

}
