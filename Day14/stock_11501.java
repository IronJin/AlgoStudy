import java.io.*;
import java.util.StringTokenizer;
public class stock_11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		//�׽�Ʈ ���̽� for��
		for(int z = 0 ; z < t ; z++) {
			//�ֽĹ迭�� ũ�� �Է�
			int n = Integer.parseInt(br.readLine());
			long sto[] = new long[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				sto[i] = Integer.parseInt(st.nextToken());
			}
			
			//�տ��� �˻������� ���� ū ���� �������������� ������ �ֽ��� ��� �����
			//���� �ڿ������� �˻��ؾ���
			
			//�ڿ��� �˻������� �ִ밡 ���� ���� �ִ밪�� ã�°��̹Ƿ� �ڿ������� �˻��ϴ°� ����
			//�ʱⰪ�� �迭�� �ǵް��� ���� ū���̶�� �����ϰ� ��
			long max = sto[n-1];
			long answer = 0;
			for(int i = n-2 ; i >= 0 ; i--) {
				//max ������ ū ���� ������ ��� �׳� �ٷ� max ������ �ٲ���
				if(sto[i] > max) {
					max = sto[i];
				//max �� �� ū��� max���� �ֽİ����� ������ ������
				}else if(sto[i] < max) {
					answer += max - sto[i];
				}
			}
			
			System.out.println(answer);
			
			
		}//�׽�Ʈ ���̽� �ϳ� ��
		
		
		
	}

}
