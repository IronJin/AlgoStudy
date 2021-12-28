import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//문제풀이시간 2시간
//회의실 배정이랑 같은종료의 문제라고 생각하고 종료시간 기준으로만 생각했던게 문제풀이가 길어진 요인
//처음에 해쉬셋으로 접근했으나 해쉬셋은 foreach문을 돌면서 해쉬셋 내용을 삭제할 수 없음
//따라서 런타임에러 발생 - > 인터넷 검색후 우선순위큐와 강의시간을 시작시간을 기준으로 오름차순으로 정리한다는 힌트를 얻음
//그 후 1시간동안 해결 -> 처음 에러이유 : 강의시간을 모르고 종료시간을 기준으로 정렬
//큐의 맨위 값을 삭제해주는 메소드로 poll 대신 remove 써도 정답으로 인정
//poll 의 경우 값을 반환해주고 삭제 되는 것임. 더이상 삭제할 게 없는경우 null 값 반환/ remove는 비어있는경우 예외처리해줘야함
public class lecture_room_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//test케이스
		int t = Integer.parseInt(br.readLine());
		
		int l[][] = new int[t][2];
		
		for(int i = 0 ; i < t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l[i][0] = Integer.parseInt(st.nextToken());
			l[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//강의가 시작하는 시간을 기준으로 오름차순/ 시작시간이 같은경우 끝나는시간을 오름차순
		Arrays.sort(l, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
					return o1[0] - o2[0];
				
			}
		});
		

		//우선순위큐에 맨 위보다 강의시간 배열의 시작시간이 작은 경우 그 배열의 종료시간을 우선순위큐에 넣어줌
		//반대로 우선순위큐의 맨 위보다 배열의 시작시간이 더 큰경우 현재 우선순위큐의 값을 삭제해주고 현재배열의 종료시간을 넣어주면됨
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(0);
		for(int i = 0 ; i < t ; i++) {
			if(l[i][0] >= pq.peek()) {
				pq.poll();
				pq.add(l[i][1]);
			}else {
				pq.add(l[i][1]);
			}
		}
		
		System.out.println(pq.size());
		
	}

}
