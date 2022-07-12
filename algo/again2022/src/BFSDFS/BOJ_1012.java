package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_1012 {

	static int testcase;
	static int row;
	static int col;
	static int edges;
	static int miro[][];
	static boolean visit[][];
	
	static int result;
	
	static int xc[] = {0,0,-1,1};
	static int yr[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		for(int z = 0 ; z < testcase ; z++) {
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());
			
			miro = new int[row][col];
			visit = new boolean[row][col];
			
			for(int i = 0 ; i < edges ; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				miro[r][c] = 1;
			}
			
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					if(miro[i][j] == 1 && visit[i][j] == false) {
						dfs(i,j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
		

	}
	
	static void dfs(int startrow, int startcol) {
		
		visit[startrow][startcol] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nextrow = startrow + yr[i];
			int nextcol = startcol + xc[i];
			
			if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
				if(visit[nextrow][nextcol] == false && miro[nextrow][nextcol] == 1) {
					dfs(nextrow, nextcol);
				}
			}
			
		}
		
	}

}
