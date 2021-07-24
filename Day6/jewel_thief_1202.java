import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class jewel_thief_1202 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//보석, 가방 개수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//가격의 합
		long sum = 0;
		
		//보석 정보 2차원 배열 입력
		int j[][] = new int[n][2];
		
		//가방 무게 정보 배열 입력
		int c[] = new int[k];
		
		//보석정보 입력
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			//무게
			j[i][0] = Integer.parseInt(st.nextToken());
			//가격
			j[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		//가방 무게 정보 입력
		for(int i = 0 ; i < k ; i ++) {
			st = new StringTokenizer(br.readLine());
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		//가방 오름차순 정렬 무게 정렬
		Arrays.sort(c);

		//보석무게 오름차순 정렬 / 같으면 가격 내림차순 정렬
		Arrays.sort(j, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				if(o1[0] == o2[0]) {
					return o2[0] - o1[0];
				}
				
				return o1[0] - o2[0];
			}
		});
		
		//가격을 최대 힙 구조로 저장해주는 우선순위 큐 선언
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int z = 0;
		for(int i = 0 ; i < k ; i ++) {
			for(int l = z ; l < n ; l++) {
				if(c[i] >= j[l][0]) {
					pq.offer(j[l][1]);
				}else {
					z= l;
				}
			}
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		
		
		
		System.out.println(sum);
		
	}

}
