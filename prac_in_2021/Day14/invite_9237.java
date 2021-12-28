import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.*;
public class invite_9237 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer a[] = new Integer[n];
		
		for(int i = 0 ; i < n ; i ++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, Collections.reverseOrder());
		
		for(int i = 0 ; i < n ; i++) {
			int sum = a[i] + i + 1;
			pq.add(sum);
		}
		
		System.out.println(pq.poll()+1);
		
	}

}
