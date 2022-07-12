package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_1260 {

	static int n;
	static int m;
	static int v; //startnode
	static ArrayList<Integer> list[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1 ; i < list.length ; i++) {
			Collections.sort(list[i]);
		}
		
		visit = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		visit = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		visit[start] = true;
		sb.append(start).append(" ");
		
		for(int i = 0 ; i < list[start].size() ; i++) {
			int nextnode = list[start].get(i);
			if(visit[nextnode] == true) continue;
			visit[nextnode] = true;
			dfs(nextnode);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int curnode = q.poll();
			sb.append(curnode).append(" ");
			for(int i = 0 ; i < list[curnode].size() ; i++) {
				int nextnode = list[curnode].get(i);
				if(visit[nextnode] == true) continue;
				q.add(nextnode);
				visit[nextnode] = true;
			}
		}
		
	}

}
