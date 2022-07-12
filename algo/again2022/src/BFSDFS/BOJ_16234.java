package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_16234 {

	static int len;
	static int L;
	static int R;
	
	static boolean conti;
	
	static int arr[][];
	static boolean visit[][];
	
	static int answer = 0;
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		len = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[len][len];
		
		for(int i = 0 ; i < len ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < len ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();

	}
	
	static void pro() {
		
		while(true) {
			conti = false;
			
			visit = new boolean[len][len];
			
			for(int i = 0 ; i < len ; i++) {
				for(int j = 0 ; j < len ; j++) {
					if(visit[i][j] == false) {
						bfs(i,j);
					}
				}
			}
			
			
			if(!conti) break;
			
			answer++;
			
		}
		
//		for(int i = 0 ; i < len ; i++) {
//			for(int j = 0 ; j < len ; j++) {
//				System.out.print(arr[i][j] +" ");
//			}
//			System.out.println();
//		}
//		
		System.out.println(answer);
		
	}
	
	static void bfs(int startrow, int startcol) {
		
		ArrayList<int []> list = new ArrayList<>();
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startrow, startcol});
		visit[startrow][startcol] = true;
		list.add(new int[] {startrow, startcol});
		
		int total = arr[startrow][startcol];
		int count = 1;
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				if(0 <= nextrow && nextrow < len && 0 <= nextcol && nextcol < len) {
					if(visit[nextrow][nextcol] == false) {
						if(L <= Math.abs(arr[currow][curcol] - arr[nextrow][nextcol]) && Math.abs(arr[currow][curcol] - arr[nextrow][nextcol]) <= R) {
							conti = true;
							count++;
							total += arr[nextrow][nextcol];
							visit[nextrow][nextcol] = true;
							list.add(new int[] {nextrow,nextcol});
							q.add(new int[] {nextrow, nextcol});
						}
					}
				}
			}
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			int rowpoint = list.get(i)[0];
			int colpoint = list.get(i)[1];
			arr[rowpoint][colpoint] = total/count;
		}
		
		
		
	}

}
