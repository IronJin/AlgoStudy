import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bipartite_graph_1707 {

	static ArrayList<Integer> list[];
	static int color[];
	static String str;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		for(int z = 0 ; z < t ; z++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			color = new int[n+1];
			
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
			str = "YES";
			for(int i = 1 ; i <=n ; i++) {
				if(color[i] == 0) {
					//bfs(i);
					color[i] = 1;
					dfs(i); 

				}
			}
			
			System.out.println(str);
			
			
			
		}//테스트 케이스 끝
		
		
		
		
	}
	
	public static void dfs(int a) {
		
		for(int nextnode : list[a]) {
			if(color[nextnode] == 0) {
				color[nextnode] = color[a] * -1;
				dfs(nextnode);
			}
			if(color[nextnode] == color[a]) {
				str = "NO";
				return;
			}
		}
	}
	
	
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(a);
		color[a] = 1;
		
		while(!q.isEmpty()) {
			int aa = q.poll();
			
			for(int nextnode : list[aa]) {
				if(color[nextnode] == 0) {
					color[nextnode] = color[aa] * -1;
					q.add(nextnode);
				}else if(color[nextnode] == color[aa]) {
					str = "NO";
					return;
				}
			}
		}
	}
	
	

}
