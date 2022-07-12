package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_11724 {

	static int n;
	static int m;
	
	static boolean visit[];
	static ArrayList<Integer> list[];
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i = 0 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1 ; i <= n ; i++ ) {
			if(visit[i] == false) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		//-------------------
		visit = new boolean[n+1];
		result = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			if(visit[i] == false) {
				bfs(i);
				result++;
			}
		}
		
		//System.out.println(result);
		
		

	}
	
	static void dfs(int startnode) {
		
		visit[startnode] = true;
		
		for(int i = 0 ; i < list[startnode].size() ; i++) {
			int nextnode = list[startnode].get(i);
			if(visit[nextnode] == false) {
				dfs(nextnode);
			}
		}
		
	}
	
	static void bfs(int startnode) {
	
		Queue<Integer> q = new LinkedList<>();
		q.add(startnode);
		visit[startnode] = true;
		
		while(!q.isEmpty()) {
			int curnode = q.poll();
			for(int i = 0 ; i < list[curnode].size() ; i++){
				int nextnode = list[curnode].get(i);
				if(visit[nextnode] == false) {
					q.add(nextnode);
					visit[nextnode] = true;
				}
			}
		}
		
	}
}
