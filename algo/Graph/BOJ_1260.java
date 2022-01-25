import java.io.*;
import java.util.*;

public class BOJ_1260 {

	static int n;
	static int m;
	static int v;
	//dfs 에서 사용될 방문정점
	static boolean dfsvisited[];
	//bfs 에서 사용될 방문정점
	static boolean bfsvisited[];
	static ArrayList<Integer> list[];
	
	static void DFS(int v) {
		dfsvisited[v] = true;
		System.out.print(v+" ");
		for(int i = 0 ; i < list[v].size() ; i++) {
			if(dfsvisited[list[v].get(i)]) {
				continue;
			}
			DFS(list[v].get(i));
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		bfsvisited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int i = 0 ; i < list[x].size() ; i++) {
				if(bfsvisited[list[x].get(i)]) {
					continue;
				}
				q.add(list[x].get(i));
				bfsvisited[list[x].get(i)] = true;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		dfsvisited = new boolean[n+1];
		bfsvisited = new boolean[n+1];
		list = new ArrayList[n+1];
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
		
		for(int i = 0 ; i < list.length ; i++) {
			Collections.sort(list[i]);
		}
		
		DFS(v);
		System.out.println();
		BFS(v);
	}

}
