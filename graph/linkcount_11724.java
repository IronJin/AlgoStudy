import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class linkcount_11724 {

	static ArrayList<Integer> list[];
	static int count = 0;
	static boolean check[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		check = new boolean[n+1];
		
		for(int i = 0 ;  i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 0 ; i< m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1 ; i <= n ; i++) {
			if(!check[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(a);
		
		while(!q.isEmpty()) {
			a = q.poll();
			if(check[a]) continue;
			check[a] = true;
			for(int nextnode : list[a]) {
				q.add(nextnode);
			}
		}
	}

}
