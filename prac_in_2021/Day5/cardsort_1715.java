import java.util.PriorityQueue;
import java.util.Scanner;

//���� Ʋ�Ȱ� ���� Ȯ��
//�켱���� ť �� �̿��ؾ���
//�ּ� �� �켱���� ť �����ϸ� ���� Ǯ �� ����
//ó�� �����Ѱ��� ������� ���� �� ����ؼ� �����ָ鼭 �����
//�ݷ� 10 10 10 10 ���� ��� (10+ 10) + (10+10) + 20+20
//�� Ǯ�̰��� ��� 10 + 10 + 20 + 10 + 30+ 10
public class cardsort_1715 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//�׽�Ʈ ���̽� �Է�
		int t = sc.nextInt();
		int sum = 0;
		int result = 0;
		//�ּ� �� ������ ���� �켱���� ť��
		//���� �켱����ť�� ������ ��������� ���� ��� �ּҰ��̳� �ִ밪�� ������ ã�Ƴ��� ���� ��������Ʈ�� ���·� ������� �ڷᱸ��
		//�켱���� ť�� �켱������ ���� ������� ��Ҹ� ��������/ ���Ḯ��Ʈ�� ǥ���� �����ϴٴ� �Ҹ�
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < t ; i ++) {
			pq.add(sc.nextInt());
		}
	
		while(pq.size() != 1) {
			sum = pq.poll() + pq.poll();
			result += sum;
			pq.add(sum);
			}
		System.out.println(result);
		
	}
}

