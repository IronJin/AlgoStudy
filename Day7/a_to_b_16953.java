import java.io.*;
import java.util.StringTokenizer;

public class a_to_b_16953 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		//b�� a���� �۾����ų� �������ų� ���̻� �ȳ������������� �ݺ�
		while(a<b) {
			count++;
			//������ ���ڰ� 1�ΰ�� �װ������ְ� 10��ŭ ������ ���� b�� ����
			if(b%10 == 1) {
				b = b/10;
			//Ȧ���ΰ�� �������;���
			}else if(b%2 == 1) {
				break;
			//�׳� �������� ��쿡�� 2�� ������
			}else {
				b= b/2;
			}
		}
		
		//Ȧ���ΰ�� �������ͼ��� �������ְų� �ݺ����� �������� ���
		if(a==b) {
			System.out.println(count+1);
		//Ȧ���� ��� ���������ų� 2�� �������־��µ� �׺��� �� �������� �����Ҽ� ���� ��
		}else {
			System.out.println(-1);
		}
	}

}
