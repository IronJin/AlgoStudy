import java.io.*;
import java.util.*;

public class BOJ_1012 {

	static int t;
	//가로 길이
	static int m;
	//세로길이
	static int n;
	//배추가 심어진 위치의 개수
	static int gar;
	static int arr[][];
	static boolean visit[][];
	
	static int xc[] = {0,0,-1,1};
	static int yr[] = {1,-1,0,0};
	
	static void dfs(int row, int col) {
		
		visit[row][col] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nextrow = yr[i]+row;
			int nextcol = xc[i]+col;
			if(0<= nextrow && nextrow < n && 0 <= nextcol && nextcol < m) {
				if(arr[nextrow][nextcol] == 1 && visit[nextrow][nextcol] == false) {
					dfs(nextrow, nextcol);
				}
			}
		}
		
	}
	
	static void bfs(int row, int col) {
		visit[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row,col});
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = yr[i]+location[0];
				int nextcol = xc[i]+location[1];
				if(0 <= nextrow && nextrow < n && 0 <= nextcol && nextcol < m) {
					if(arr[nextrow][nextcol] == 1 && visit[nextrow][nextcol] == false) {
						q.add(new int[] {nextrow, nextcol});
						visit[nextrow][nextcol] = true;
					}
				}
			}
		}
		
	}
	
	static void pro() {
		
		int answer = 0;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					answer++;
					dfs(i,j);
					//bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		int testcase = 0;
		while(testcase < t) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			gar = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visit = new boolean[n][m];
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					visit[i][j] = false;
				}
			}
			
			for(int i = 0 ; i < gar ; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r= Integer.parseInt(st.nextToken());
				arr[r][c] = 1;
			}
			
			pro();
			testcase++;
		}
		
		
	}

}
