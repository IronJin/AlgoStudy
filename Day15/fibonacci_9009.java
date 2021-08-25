import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
public class fibonacci_9009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int z = 0 ; z < t ; z++) {
			
			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> st = new Stack<>();
			
			st.add(0);
			st.add(1);
			while(true) {
				int a = st.pop();

				int b = st.pop();

				int c = a+b;

				//b a c ������ �־���� b�� �� �ڿ� �ִ� ���� ������ ���̱� ����
				// 0 1 2 �� abc ������ 1 0 2 �� ��
				st.add(b);
				st.add(a);
				st.add(c);
				//������ ������ n���� Ŀ���� ��� ���ÿ��� ���ְ� while ���� ��������
				if(st.peek() > n) {
					st.pop();
					break;
				}
			}
			
			//������������ ����ϱ� ���� �켱���� ť ����
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			//������ �� ���� n���� �۰ų� ������� n���� ���ְ� �� ���� �켱����ť�� ����
			while(n!=0) {
				int a = st.pop();
				if(a <= n) {
					n = n-a;
					pq.add(a);
				}
			}
			
			//�켱����ť�� �������� �ϳ��� ���� ���
			while(!pq.isEmpty()) {
				System.out.print(pq.poll()+" ");
			}
			System.out.println();
		}

	}

}
