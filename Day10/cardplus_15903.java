import java.io.*;
import java.util.*;
public class cardplus_15903 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//카드 개수
		int n = Integer.parseInt(st.nextToken());
		
		//합체 개수
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			int a = Integer.parseInt(st.nextToken());
			pq.add(a);
		}
		int sum = 0;
		for(int i = 0 ; i < m ; i++) {
			int a = pq.poll() + pq.poll();
			pq.add(a);
			pq.add(a);
		}

		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}

}
