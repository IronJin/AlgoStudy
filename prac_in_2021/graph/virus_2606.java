import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class virus_2606 {
	//arrayList �� bfs �� �̿��Ͽ� �ذ�
	//����� ������ ���°��̹Ƿ� ����Ž���� ����
	static ArrayList<Integer> list[];
	static boolean visit[];
	static boolean visitdfs[];
	static int countdfs=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		visitdfs = new boolean[n+1];
		for(int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		int link = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ; i < link ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		int answer = bfs(1);
		System.out.println(answer-1);
			
		int answerdfs = dfs(1);
		System.out.println(answerdfs);
	}
	
	public static int bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		q.add(node);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			if(visit[a]) {
				continue;
			}
			visit[a] = true;
			count++;
			for(int nextnode : list[a]) {
				q.add(nextnode);
			}
		}
		
		
		return count;
		
	}
	
	//��͸� �̿��ϴ°��̹Ƿ� �ϴ� �����ϸ� �޼ҵ�(�Լ�)�� �������� ����������Ѵ�.
	public static int dfs(int node) {
		visitdfs[node] = true;
		for(int nextnode : list[node]) {
			if(!visitdfs[nextnode]) {
				countdfs++;
				dfs(nextnode);
			}
		}
		return countdfs;
		
	}
}
