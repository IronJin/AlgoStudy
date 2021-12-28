import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//문제의 요점 : 주사위에 숫자를 내가 임의로 배정하는것이 아닌 쓰여져있는것임
//이미 쓰여져있는것이라는점에 주목해야함
public class cubePlus_1041 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());

		long cube[] = new long[6];
		
		long sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < 6 ; i++) {
			cube[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n == 1) {
			Arrays.sort(cube);
			for(int i = 0 ; i < 5 ; i++) {
				sum += cube[i];
			}
		}else {
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			long first;

			long second;
			
			long third;
			
			long min;
			
			if(cube[0] < cube[5]) {
				pq.add(cube[0]);
			}else {
				pq.add(cube[5]);
			}
			
			if(cube[1] < cube[4]) {
				pq.add(cube[1]);
			}else {
				pq.add(cube[4]);
			}
			
			if(cube[2] < cube[3]) {
				pq.add(cube[2]);
			}else {
				pq.add(cube[3]);
			}
			
			first = pq.poll();
			second = pq.poll();
			third = pq.poll();
			
			
			
			//제일 작은 값을 가진 면 2개
			sum = 2*n*n*first;

			//제일 작은 값을 가진 면 2개 옆에 있는 면 2개
			sum += 2*(2*n*second + (n*n-2*n)*first);

			//가장 큰 값을 가지는 맨 윗면
			sum += 4*third + (4*n-8)*second + (n*n-4*n+4)*first;
		}
		
		System.out.println(sum);
	}

}
