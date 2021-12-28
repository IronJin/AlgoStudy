import java.io.*;
import java.util.Arrays;

public class bj_rope_2217 {

	//���� ���� �ִ� �߷��� ������ ������ ���� �� ������ ������ŭ �����ָ� ��
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int a[] = new int[n];
		
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		int max = 0;
		
		int i = 0;
		//���� �ͺ��� ������ ���� �������� �ϳ��� �������鼭 �ִ� �߷��� ���� ��Ĵ�� ���
		//��������̶�� �ϸ� ���� ���� �ִ� �߷��� ������ ������ �������� ����ϴ� ���
		while(i != n) {
			if(max <= a[i] * (n-i)) {
			max = a[i] * (n-i);
			}
			i++;
		}
		System.out.println(max);
	}
}
