package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_13549 {

	static int subin;
	static int younger;
	
	static boolean visit[] = new boolean[100001];
	static int dist[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		subin = Integer.parseInt(st.nextToken());
		younger = Integer.parseInt(st.nextToken());
		
		bfs(subin);
		
		System.out.println(dist[younger]);
		
	}
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
		
			
			int next1 = cur * 2;
			int next2 = cur - 1;
			int next3 = cur + 1;

			
			
			if(0 <= next1 && next1 <= 100000) {
				if(visit[next1] == false) {
					q.add(next1);
					visit[next1]=true;
					dist[next1] = dist[cur];
				}
			}
			
			if(0 <= next2 && next2 <= 100000) {
				if(visit[next2] == false) {
					q.add(next2);
					visit[next2]=true;
					dist[next2] = dist[cur] + 1;
				}
			}
			
			if(0 <= next3 && next3 <= 100000) {
				if(visit[next3] == false) {
					q.add(next3);
					visit[next3]=true;
					dist[next3] = dist[cur] + 1;
				}
			}
			
		}
		
	}

}
