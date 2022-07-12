package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_1697 {

	static int subin;
	static int younger;
	
	static boolean visit[] = new boolean[100001];
	static int dist[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int subin = Integer.parseInt(st.nextToken());
		int younger = Integer.parseInt(st.nextToken());
		
		bfs(subin);
		
		System.out.println(dist[younger]);

	}
	
	static void bfs(int subin) {
		
		Queue<Integer> q = new LinkedList<>();
		visit[subin] = true;
		q.add(subin);
		
		while(!q.isEmpty()) {
			
			int curx = q.poll();
			
			int nextx1 = curx - 1;
			int nextx2 = curx + 1;
			int nextx3 = curx * 2;
			
			if(0 <= nextx1 && nextx1 <= 100000) {
				if(visit[nextx1] == false) {
					visit[nextx1] = true;
					q.add(nextx1);
					dist[nextx1] = dist[curx] + 1;				
				}
								
			}
			
			if(0 <= nextx2 && nextx2 <= 100000) {
				if(visit[nextx2] == false) {
					visit[nextx2] = true;
					q.add(nextx2);
					dist[nextx2] = dist[curx] + 1;				
				}
			}
			
			if(0 <= nextx3 && nextx3 <= 100000) {
				if(visit[nextx3] == false) {
					visit[nextx3] = true;
					q.add(nextx3);
					dist[nextx3] = dist[curx] + 1;				
				}
			}
			
			
		}
		
	}

}
