import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

//진짜 짜증나는 문제 ㅠㅠ
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
					//만약 처음부터 모든 보석의 무게를 충족하는 가방이 나오게 되면
					//마지막에 이거를 추가해줘야함;
					//내가 이부분을 처리를 해주지 않거나 z = l 로 해줬는데 이러한 경우 l은 n을 넘지않아
					//우선순위 큐에 보석 정보 가격의 맨 마지막 배열에 있는값이 계속해서 중복되게 들어감
					z = l+1 ;
				}else {
					z = l;
					l = n;
				}
			}
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		//구글에 나와있는 모든 사람들은 이런식으로 for문을 구현
		//내가 구현한 위의 코드와 실행시간은 10ms 로 차이가 거의 없다고 봐야함
		/*
		 	for (int i = 0, l = 0; i < k; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (l < n && j[l][0] <= c[i]) {
                pq.offer(j[l++][1]);
            }
 
            // 우선순위 큐에 있는 요소를 하나 빼서 가방에 넣음.
            // 이 때, 우선순위 큐는 내림차순 정렬이 되어있으므로
            // 첫 번째 요소는 가장 큰 가격을 의미함.
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
		 */
		
		
		
		
		System.out.println(sum);
		
	}

}
