package algoprac;


//���� 4�� 1,2,3 �� �������� ��Ÿ���� ����� ���� ���Ͻÿ�
//���� n�� �������� 1,2,3�� �������� ��Ÿ���� �ִ� ����� ��
public class recurprac_association {

	public static int recur(int n) {
		
		if(n == 1) {
			return 1;
		}else if(n ==2) {
			return 2;
		}else if(n == 3) {
			return 4;
		}else {
			return recur(n-1) + recur(n-2) + recur(n-3);
		}
	}
	
	public static void main(String[] args) {
		
		int answer = recur(5);
		System.out.println(answer);
		
	}

}
