import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//�켱����ť�� ���
//�迭�� �־��ְ� �迭�� ù��°���� ������ ������ ī��Ʈ���� ū�� ������ ���� �ƽ��� �ٲ��ְ� ī��Ʈ �켱����ť�� �־����� 0���� �ʱ�ȸ
//�ƽ����� �������� ������ ���ö����� �ٽ� ī��Ʈ
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
			//�ƽ����� �������·� �ݺ����� ���������� �ִ������� �켱����ť�� ���� �־��־����
			if(i == n-1) {
				pq.add(count);
			}
		}
		
		//����ū �� ȣ��
		System.out.println(pq.poll());
	}

}
