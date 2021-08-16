import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//������ ���� : �ֻ����� ���ڸ� ���� ���Ƿ� �����ϴ°��� �ƴ� �������ִ°���
//�̹� �������ִ°��̶������ �ָ��ؾ���
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
			
			
			
			//���� ���� ���� ���� �� 2��
			sum = 2*n*n*first;

			//���� ���� ���� ���� �� 2�� ���� �ִ� �� 2��
			sum += 2*(2*n*second + (n*n-2*n)*first);

			//���� ū ���� ������ �� ����
			sum += 4*third + (4*n-8)*second + (n*n-4*n+4)*first;
		}
		
		System.out.println(sum);
	}

}
