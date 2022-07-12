package BFSDFS;

import java.io.*;
import java.util.*;

/**
 * 다시 해결할것
 * @author 82105
 *
 */
public class BOJ_1520 {

	static int row;
	static int col;
	
	static int arr[][];
		
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	static int answer = 0;
	
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
		
		
		System.out.println(arr[row-1][col-1]);
		dfs(0,0);
		
		
		
		System.out.println(answer);
	

	}
	
	static void dfs(int currow, int curcol) {
		
		
		if(currow == row-1 && curcol == col-1) {
			answer++;
			return;
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			int nextrow = currow + yr[i];
			int nextcol = curcol + xc[i];
			if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
				if(arr[nextrow][nextcol] < arr[currow][curcol] && arr[nextrow][nextcol] > arr[row-1][col-1]) {
					dfs(nextrow, nextcol);
				}
			}
		}
		
	}
	

}
