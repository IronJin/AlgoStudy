import java.io.*;
import java.util.StringTokenizer;


public class gasstation {

	
	//ó���� int �� ������ �κ������� �޾Ƽ� long �� ����
	//long �� ��� 21������� �ڸ����� ǥ���ϴ� int ���� �ξ� ���� ���� ǥ���� �� ����
	//int ���� 32��Ʈ long �� 64��Ʈ
	//�ð����⵵ n
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		//���� ������ �Ÿ�
		long a[] = new long[n-1];
		//������ ���ʹ� ����
		long b[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int j = 0;
		while(st.hasMoreTokens()) {
			a[j] = Integer.parseInt(st.nextToken());
			j++;
		}
		
		j = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while(st1.hasMoreTokens()) {
			b[j] = Integer.parseInt(st1.nextToken());
			j++;
		}
		//�� ó���� min �� ������ ó���Ÿ���ŭ �����ؾ��ϴ� min �� ù��° ������ �⸧������ ǥ��
		long min = b[0];
		//����
		long sum = 0;
		
		for(int i = 0 ; i < a.length ; i++) {
			if(min > b[i]) {
				min = b[i];
				sum += a[i] * min;
			}else {
				sum += a[i] * min;
			}
		}
		System.out.println(sum);
		
	}
}
