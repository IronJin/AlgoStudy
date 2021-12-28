import java.io.*;
public class reverse_17609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] str = new String[n];
		
		for(int i = 0 ; i < n ; i ++) {
			str[i] = br.readLine();
			int a = 0;
			int b = str[i].length()-1;
			int diff = 0;
			int left = 0;
			int right = 0;
			
			//�˻��ϴٰ� Ʋ���ų����� �׶��� ���ʰ� �������� ����Ű�� �ε����� left�� right�� ����
			while(a<b) {
				if(str[i].charAt(a) == str[i].charAt(b)) {
					a++;
					b--;
				}else {
					left = a;
					right = b;
					//�ϴ� ������ �ϳ� ���ٴ� ǥ�ø� ����
					diff++;
					break;
				}
			}
			
			//���� ��ĭ �ǳʶٰ���� ����
			//���� a�� b�� �ε������� a�� �ϳ� �������� ������ ����
			//diff�� 1�϶��� ����
			//���⼭�� ������ ����� diff �� ������ �ϳ� ������
			if(diff == 1) {
				a++;
				while(a<b) {
					if(str[i].charAt(a) == str[i].charAt(b)) {
						a++;
						b--;
					}else {
						diff++;
						break;
					}
				}
			}
			
			//������ �ϳ� �ǳʶٰ� ������ �غ����� ������ �������� ������ �״�� �ΰ� �����ʸ� ������
			if(diff == 2) {
				a = left;
				b = right;
				b--;
				while(a<b) {
					if(str[i].charAt(a) == str[i].charAt(b)) {
						a++;
						b--;
					}else {
						diff++;
						break;
					}
				}
			}
			
			if(diff == 0) {
				System.out.println(0);
			//diff ���� ó������ ���涧 1 , ���ʰ˻��Ҷ� ��������� 2 �� �� 3�̵Ǹ� �����ʰ˻絵 ����������ٴ� ����
			}else if(diff > 0 && diff<=2) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
			
			
		}

	}

}
