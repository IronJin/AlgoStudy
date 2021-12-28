import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 �׸��� ������ Ǭ ������ �ƴ�
 ex) ������ 17�̶�� ���ڰ� �־���
 �̷��� ��� �迭�߿��� �̺��� ���� ���ں��� ���ִ°���
 ������ ������ ��� 1 1 2 3 6 7 30 �̴ϱ� �迭���� 17���� ���� ���ڴ� 7
 ���ְ� �����Ŵ� 10 ���⼭ �״��� �迭���� �����ϴ� ���� ���ڴ� 6
 �״����� 3 �״����� 1
 �̷������� Ȱ���س����鼭 ���ٺ��� �������� ���ϴ� ���ڰ� ����� ������ ����
 �̷��� ��� �ι�° ���Ϲ��� �� ������ ���͵� ������ ���ϴ� �����̹Ƿ� break �� ���� ���������� �� �� �׽�Ʈ�� ���ڸ� ���
 */

//�׽�Ʈ �ð� 1584ms

public class balance_2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int b[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b);
		
		int j;
		int c= 1;
		int i = b.length-1;
		
		while(true) {
			//j�� �ݺ����� ���ǹǷ� ���� ���� �׽�Ʈ���� ���� c�� �����ϰ�
			//���Ǵ� ���� j�� �ϵ��� �̷������� ������ ����
			j = c;
		while(i >= 0) {
			//���� ��� ��
			if(b[i] <= j) {
				//�ش��ϴ� �����߸� j���� ���ְ� ���� �� ���� �����߸� �˻��ϱ� ���� i--����
				j = j-b[i];
				i--;
				//���� j�� 0�� �Ǽ� �ԷµǾ� �ִ� �����߷� ����� ������ 
				if(j==0) {
					//���� �׽�Ʈ���� ���� 1���� �� ū���� �ٽ� �迭�� ���� ū ���Ժ��� ������ֱ� ����
					//i ���� �迭�� ���� ū ���Ժ��� �������ְ�
					i = b.length-1;
					//���� �׽�Ʈ���� ������ 1ū���� �׽�Ʈ�ϱ� ���� c++ ����
					//�̷��� ������ ���� 39��° �ٿ��� j�� ������ �ٽ� j�� ���
					c++;
					break;
				}
			//���� �߰� �� ū ���� ���� �� ���� �����߸� �˻��ϱ����� i --
			}else if(b[i] > j) {
				i--;
			}
		}
		//�̰� ���°�� while �ݺ������� ���������� ����
		//�迭�� 0��°���� ������ ���Դµ� ���� ���� 0�� �ƴ϶� �����ִ� ��� �ݺ��� Ż��
		if(j != 0) {
			break;
		}
		}
		
		//���԰� 0�� ���� �ʰ� ���� �׽�Ʈ���� ���� ���
		System.out.println(c);
		
	}
}
