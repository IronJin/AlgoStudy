import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;

//풀이시간 한시간
public class homework_13904 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a[][] = new int[n][2];
		
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());		
		}
		int count = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		//day 를 기준으로 내림차순 정렬
		//같을때도 점수를 내림차순 정렬
		Arrays.sort(a, new Comparator<int[]>() {
		    public int compare(int[] o1, int[] o2) {
		            if(o2[0] == o1[0]){
		    	    return o2[1] - o1[1];
		            }else {
		                return o2[0] - o1[0]  ;    
		            }
		    }
		});

		//내림차순 정렬이므로 입력된 케이스중 가장 큰 날짜를 초기 day 변수값으로 설정
		int day = a[0][0];
		//i는 배열 인덱스를 가리킬 변수임
		int i = 0;
		
		//day가 0이되면 종료
		while(day !=0) {
			//정렬된 배열을 기준으로 앞쪽부터 살펴봄 day보다 큰 day를 가지고 있는 경우
			//그 인덱스의 점수를 우선순위큐에 넣어줌
			//day 가 i가 가리키는 인덱스의 day보다 클때까지 진행함
			//i!=n 인 이유는 배열의 day값이 day 변수 값보다 모두 클수 있기때문
			while(i != n) {
				if(day <= a[i][0]) {
					pq.add(a[i][1]);
					i++;	
				}else break;
			}
			
			//pq 가 비어있지 않다면 그중에서 가장 큰 점수값을 count 에 더해주고 하루를 소비했으므로 pq.poll 해줌
			if(!pq.isEmpty()) {
				count += pq.poll();
				day--;
			//else 를 쓴 이유는 pq가 비어있을경우 poll 할때 오류가 날 수 있기 때문
			}else day--; continue;
		}
		
		
		System.out.println(count);
		
	}

}
