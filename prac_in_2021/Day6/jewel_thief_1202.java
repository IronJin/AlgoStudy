import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

//��¥ ¥������ ���� �Ф�
public class jewel_thief_1202 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����, ���� ���� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//������ ��
		long sum = 0;
		
		//���� ���� 2���� �迭 �Է�
		int j[][] = new int[n][2];
		
		//���� ���� ���� �迭 �Է�
		int c[] = new int[k];
		
		//�������� �Է�
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			//����
			j[i][0] = Integer.parseInt(st.nextToken());
			//����
			j[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		//���� ���� ���� �Է�
		for(int i = 0 ; i < k ; i ++) {
			st = new StringTokenizer(br.readLine());
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		//���� �������� ���� ���� ����
		Arrays.sort(c);

		//�������� �������� ���� / ������ ���� �������� ����
		Arrays.sort(j, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				if(o1[0] == o2[0]) {
					return o2[0] - o1[0];
				}
				
				return o1[0] - o2[0];
			}
		});
		
		
		
		//������ �ִ� �� ������ �������ִ� �켱���� ť ����
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int z = 0;
		for(int i = 0 ; i < k ; i ++) {
			for(int l = z ; l < n ; l++) {
				if(c[i] >= j[l][0]) {
					pq.offer(j[l][1]);
					//���� ó������ ��� ������ ���Ը� �����ϴ� ������ ������ �Ǹ�
					//�������� �̰Ÿ� �߰��������;
					//���� �̺κ��� ó���� ������ �ʰų� z = l �� ����µ� �̷��� ��� l�� n�� �����ʾ�
					//�켱���� ť�� ���� ���� ������ �� ������ �迭�� �ִ°��� ����ؼ� �ߺ��ǰ� ��
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
		
		//���ۿ� �����ִ� ��� ������� �̷������� for���� ����
		//���� ������ ���� �ڵ�� ����ð��� 10ms �� ���̰� ���� ���ٰ� ������
		/*
		 	for (int i = 0, l = 0; i < k; i++) {
            // ���� ������ ���Ժ��� �۰ų� ���� ������ ��� �켱���� ť�� ����.
            while (l < n && j[l][0] <= c[i]) {
                pq.offer(j[l++][1]);
            }
 
            // �켱���� ť�� �ִ� ��Ҹ� �ϳ� ���� ���濡 ����.
            // �� ��, �켱���� ť�� �������� ������ �Ǿ������Ƿ�
            // ù ��° ��Ҵ� ���� ū ������ �ǹ���.
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
		 */
		
		
		
		
		System.out.println(sum);
		
	}

}
