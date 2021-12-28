import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class tree_11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�׽�Ʈ ���̽�
		int t = Integer.parseInt(br.readLine());
		int count[] = new int[t];
		for(int i = 0 ; i < t ; i++) {
			int a = Integer.parseInt(br.readLine());
			int b[] = new int[a];
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			while(st.hasMoreTokens()) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			//�Է��� ������ ���� ū���� �迭�� �߾ӿ� �־��ְ� ���������� ����
			int m = 0;
			if(a%2 == 1) m = a/2;
			if(a%2 == 0) m = a/2-1;
			b[m] = pq.poll();
			int z = 1;
			while(!pq.isEmpty()) {
				b[m+z] = pq.poll();
				if(pq.isEmpty()) break;
				b[m-z] = pq.poll();
				z++;
			}
			int max = Math.abs(b[0] - b[a-1]);
			for(int j = 0 ; j < a-1 ; j++) {
				if(max < Math.abs(b[j]-b[j+1])) {
					max = Math.abs(b[j] - b[j+1]);
				}
			}
			System.out.println(max);
		}
		
	}
}
