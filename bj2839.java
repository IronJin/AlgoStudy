import java.io.*;

public class bj2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int  a = Integer.parseInt(br.readLine());
		
		//�ش� ���ڿ��� 5ų�α׷� ���� ������ �ִ��� ���� ���������� ��
		int n = a/5;
		// ������ ������ ���ؼ� �־��� ���� ����
		int count = 0;
		//�ִ���� 0������ �ݺ����� ����
		for(int i = n ; i >= 0 ; i--) {
			//�־��� ������ �ݺ��Ҷ����� �������� �ϱ⶧���� y�� ���� ����
			int y = a;
			//�־��� �������� 5ų�� ���� ���� ������ŭ ���ְ� �������� 3���� ������ �ȳ������� -1 �Ҵ�
			y = y - 5*i;
			if(y%3 != 0) {
				count = -1;
				//���������� �װ� 5ų�α׷� �ִ� ������ ���� �� �ִ� �����̹Ƿ� �׶��� ���������� i��
				//3���� ������������ ��(���� ����)�� �����ָ� ��
			}else {
				count = i+y/3;
				//for�� ������ �������� ���ϵ��� �Ͽ� for�� Ż��
				i = -1;
			}
		}
		
		System.out.println(count);
		
	}

}
