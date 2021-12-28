import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//���� ������� ���Ѵ�.
//�̷�ã��� ����� �����̴�. ������ �ѹ� �湮�Ѱ��� �ִܰŸ��� �� ���ۿ� ����.
//�׷��Ƿ� �׳� q�� �����ִ¹��� �� �־��ְ� �湮ó���ϵ��� ���� ��尪�� + 1 ���ذ��� �湮�� ��忡 �־��ָ�ȴ�.

public class hide_and_seek_1697 {

	static int n;
	static int k;
	static int count = 0;
	static int arr[] = new int[100001];
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(k==n) {
			System.out.println(0);
		}else {
			bfs(n);
			System.out.println(arr[k]);
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(x);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			if(node == k) {
				return;
			}
			int firstnode = node - 1;
			if(firstnode >= 0 && firstnode <= 100000) {
				if(arr[firstnode] == 0) {
					arr[firstnode] = arr[node] + 1;
					q.add(firstnode);
				}
			}
			int secondnode = node + 1;
			if(secondnode >= 0 && secondnode <= 100000) {
				if(arr[secondnode] == 0) {
					arr[secondnode] = arr[node] + 1;
					q.add(secondnode);
				}
			}
			int tele = 2 * node;
			if(tele >= 0 && tele <= 100000) {
				if(arr[tele] == 0) {
					arr[tele] = arr[node] + 1;
					q.add(tele);
				}
			}
		}
	}
	
}
