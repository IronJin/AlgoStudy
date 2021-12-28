package greedy2;

import java.io.*;
import java.util.*;
import java.util.Comparator;

public class tour_lecture_2109 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		int a[][] = new int[n][2];

		for(int i = 0 ; i < n ; i ++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		//뒤를 기준으로 내림차순 정렬
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		int day = a[0][1];
		int answer = 0;
		int i = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		while(day!=0){
			while(i!=n) {
				if(day <= a[i][1]) {
					pq.add(a[i][0]);
					i++;
				}else break;
			}
			
			if(!pq.isEmpty()) {
				answer += pq.poll();
				day--;
			}else day--; continue;
		}
		
		System.out.println(answer);
	}

}
