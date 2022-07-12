package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_2667 {

	static int len;
	static int apt[][];
	static boolean visit[][];
	
	//static int count;
	static ArrayList<Integer> result = new ArrayList<>();
	
	static int xc[] = {0,0,1,-1};
	static int yr[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		
		apt = new int[len][len];
		visit = new boolean[len][len];
		
		for(int i = 0 ; i < len ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < len ; j++) {
				if(str.charAt(j) == '1') {
					apt[i][j] = 1;
				}
			}
		}
		
		for(int i = 0 ; i < len ; i++) {
			for(int j = 0 ; j < len ; j++) {
				if(visit[i][j] == false && apt[i][j] == 1) {
					result.add(bfs(i,j));
				}
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.println(result.get(i));
		}

	}
	
	static void dfs(int startrow, int startcol) {
		
		visit[startrow][startcol] = true;
		//count ++;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nextrow = startrow + yr[i];
			int nextcol = startcol + xc[i];
			if(0 <= nextrow && nextrow < len && 0 <= nextcol && nextcol < len) {
				if(visit[nextrow][nextcol] == false && apt[nextrow][nextcol] == 1) {
					dfs(nextrow, nextcol);
				}
			}
		}
		
	}
	
	static int bfs(int startrow, int startcol) {
		
		int count = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startrow, startcol});
		visit[startrow][startcol] = true;
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			count++;
			for(int i = 0 ; i < 4 ; i ++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				
				if(0 <= nextrow && nextrow < len && 0 <= nextcol && nextcol < len) {
					if(visit[nextrow][nextcol] == false && apt[nextrow][nextcol] == 1) {
						q.add(new int[] {nextrow, nextcol});
						visit[nextrow][nextcol] = true;
					}
				}
			}
			
		}
		
		return count;
		
	}

}
