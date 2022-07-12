package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_10026 {

	static int len;
	
	static int arr[][];
	static boolean visit[][];
	static boolean visit1[][];
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	static int general = 0;
	static int no_general = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		len = Integer.parseInt(st.nextToken());
		
		arr = new int[len][len];
		visit = new boolean[len][len];
		visit1 = new boolean[len][len];
		
		//R : 0 , G : 1 , B : 2
		for(int i = 0 ; i < len ; i++) {
			String a = br.readLine();
			for(int j = 0 ; j < len ; j++) {
				if(a.charAt(j) == 'R') {
					arr[i][j] = 0;
				}else if(a.charAt(j) == 'G') {
					arr[i][j] = 1;
				}else {
					arr[i][j] = 2;
				}
			}
		}
		
		for(int i = 0 ; i < len ; i++) {
			for(int j = 0 ; j < len ; j++) {
				if(visit[i][j] == false) {
					general++;
					general_bfs(i,j,arr[i][j]);
				}
				
				if(visit1[i][j] == false) {
					no_general++;
					nongeneral_bfs(i,j,arr[i][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(general).append(" ").append(no_general);
		System.out.println(sb.toString());
		
	}
	
	static void general_bfs(int startrow, int startcol, int curcolor) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startrow, startcol});
		visit[startrow][startcol] = true;
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				if(0 <= nextrow && nextrow < len && 0 <= nextcol && nextcol < len) {
					if(arr[nextrow][nextcol] == curcolor && visit[nextrow][nextcol] == false) {
						q.add(new int[] {nextrow, nextcol});
						visit[nextrow][nextcol] = true;
					}
				}
			}
		}
	}
	
	static void nongeneral_bfs(int startrow, int startcol, int curcolor) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {startrow, startcol});
		visit1[startrow][startcol] = true;
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				if(0 <= nextrow && nextrow < len && 0 <= nextcol && nextcol < len) {
					if(visit1[nextrow][nextcol] == false) {
						if(curcolor == 2 && arr[nextrow][nextcol] == curcolor) {
							q.add(new int[] {nextrow, nextcol});
							visit1[nextrow][nextcol] = true;
						}else if(curcolor != 2 && arr[nextrow][nextcol] != 2){
							q.add(new int[] {nextrow, nextcol});
							visit1[nextrow][nextcol] = true;
						}
					}
				}
			}
		}
		
	}

}
