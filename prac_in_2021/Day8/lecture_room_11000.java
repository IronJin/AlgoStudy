import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//����Ǯ�̽ð� 2�ð�
//ȸ�ǽ� �����̶� ���������� ������� �����ϰ� ����ð� �������θ� �����ߴ��� ����Ǯ�̰� ����� ����
//ó���� �ؽ������� ���������� �ؽ����� foreach���� ���鼭 �ؽ��� ������ ������ �� ����
//���� ��Ÿ�ӿ��� �߻� - > ���ͳ� �˻��� �켱����ť�� ���ǽð��� ���۽ð��� �������� ������������ �����Ѵٴ� ��Ʈ�� ����
//�� �� 1�ð����� �ذ� -> ó�� �������� : ���ǽð��� �𸣰� ����ð��� �������� ����
//ť�� ���� ���� �������ִ� �޼ҵ�� poll ��� remove �ᵵ �������� ����
//poll �� ��� ���� ��ȯ���ְ� ���� �Ǵ� ����. ���̻� ������ �� ���°�� null �� ��ȯ/ remove�� ����ִ°�� ����ó���������
public class lecture_room_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//test���̽�
		int t = Integer.parseInt(br.readLine());
		
		int l[][] = new int[t][2];
		
		for(int i = 0 ; i < t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l[i][0] = Integer.parseInt(st.nextToken());
			l[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//���ǰ� �����ϴ� �ð��� �������� ��������/ ���۽ð��� ������� �����½ð��� ��������
		Arrays.sort(l, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
					return o1[0] - o2[0];
				
			}
		});
		

		//�켱����ť�� �� ������ ���ǽð� �迭�� ���۽ð��� ���� ��� �� �迭�� ����ð��� �켱����ť�� �־���
		//�ݴ�� �켱����ť�� �� ������ �迭�� ���۽ð��� �� ū��� ���� �켱����ť�� ���� �������ְ� ����迭�� ����ð��� �־��ָ��
		
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
