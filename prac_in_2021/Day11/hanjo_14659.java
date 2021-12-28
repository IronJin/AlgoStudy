import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//우선순위큐를 사용
//배열에 넣어주고 배열의 첫번째부터 작은게 나오면 카운트증가 큰게 나오는 순간 맥스값 바꿔주고 카운트 우선순위큐에 넣어준후 0으로 초기회
//맥스값을 기준으로 작은게 나올때까지 다시 카운트
public class hanjo_14659 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a[] = new int[n];

		for(int i = 0 ; i < n ; i ++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int max = a[0];
		
		for(int i = 1 ; i < n ; i++) {
			if(max > a[i]) {
				count++;
			}else if(max < a[i]) {
				max = a[i];
				pq.add(count);
				count = 0;
			}
			//맥스보다 작은상태로 반복문이 끝나기전에 최대힙구조 우선순위큐에 값을 넣어주어야함
			if(i == n-1) {
				pq.add(count);
			}
		}
		
		//가장큰 값 호출
		System.out.println(pq.poll());
	}

}
