package BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_2606 {

	static int computer;
	static int edge;
	static ArrayList<Integer> list[];
	static boolean visit[];
	static StringTokenizer st;
	
	static int dfscount = 0;
	static int bfscount = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		computer = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		list = new ArrayList[computer+1];
		for(int i = 1 ; i <= computer ; i++) {
			list[i] = new ArrayList<>();
		}
		visit = new boolean[computer+1];
		
		for(int i = 0 ; i < edge ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		visit = new boolean[computer+1];
		bfs(1);
		System.out.println(dfscount-1);
		//System.out.println(bfscount-1);
		
		
	}
	
	static void dfs(int start) {
		visit[start] = true;
		dfscount++;
		
		for(int i = 0 ; i < list[start].size() ; i++) {
			int curnode = list[start].get(i);
			if(visit[curnode] == false) {
				dfs(curnode);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int curnode = q.poll();
			bfscount ++;
			for(int i = 0 ; i < list[curnode].size() ; i++) {
				int nextnode = list[curnode].get(i);
				if(visit[nextnode] == false) {
					q.add(nextnode);
					visit[nextnode] = true;
				}
			}
			
		}
	}

}
