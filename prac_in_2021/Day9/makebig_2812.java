import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

//ó���� �ð��ʰ����� �ָ��� ����
//������ ž���� ������� �׳� ���ÿ� ����ؼ� �߰�
//������ ž���� ���� ���ÿ� �߰��Ϸ��� ���� ū ��� ������ ž�� ��� �����س����鼭 ���ÿ� �߰��Ϸ��� ������ ū���� �����ų�
//������ �������� ���Ϲ� ����
//31��° ������ ���鼭 i�� �����ذ��� 27��°�� ���ÿ����� �˰� ���ÿ� �ش� index�� ���� �������ַ��� ������
//���⼭ �ð��ʰ��� ���� �׳� ���ø����� �ذ��Ϸ�����
//Ʋ�Ƚ��ϴ� �ι� ���� : ������ ž�� �ѹ��� ���ؼ� ���ϰ� �ֵ� ����⶧��
//������ ž�� �� ū���� ���ö����� �������� �ߴµ� �����ϰ� �־���. �׷��� while �� ������ ��������
//468ms

public class makebig_2812 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//����
		int l = Integer.parseInt(st.nextToken());
		
		//���찳 ����
		int cnt = Integer.parseInt(st.nextToken());

		//���ڿ��ι��� �ι�°��
		//�߰� ���ڿ� �ϳ��� �������ֱ� ����
		StringBuffer str = new StringBuffer(br.readLine());
	
		Stack<Integer> stack = new Stack<>();
		//���ڿ� ��ó�� �ε����� ������ ���ÿ� ���ϱ� ó���� �׳� �ٷ� ����
		stack.add(str.charAt(0)-'0');
		for(int i = 1 ; i < l ; i++) {
			//���찳�� 0�� �Ǹ� ����
			if(cnt == 0) {
				stack.add(str.charAt(i) - '0');
				continue;
			}

			//������ ž���� �۰ų� ������� ���ÿ� �߰�����
			if(stack.peek() >= str.charAt(i)-'0') {
				stack.push(str.charAt(i) - '0');
			}else {
				while(cnt!=0 && !stack.isEmpty() && stack.peek() < str.charAt(i)-'0') {
					stack.pop();
					cnt--;
				}
				stack.add(str.charAt(i)-'0');
			}
		}
		
		//���� ���찳�� �� �������Ѱ�� �׳� ������ ž�� ����ؼ� �����ָ��
		while(cnt != 0) {
			stack.pop();
			cnt--;
		}
	
		//��Ʈ�����۸� ����ؾ� ��Ʈ���� ���������������� �߰� ���ڿ��� �����ϰų� �߰�����
		StringBuffer ab = new StringBuffer();
		
		//������ �ε��� �� �Ʒ����� ��Ʈ���� �߰�
		for(int i = 0 ; i < stack.size() ; i++) {
			ab.append(stack.get(i));
		}
		
		//���
		System.out.println(ab.toString());
	
	
	}

}
