import java.util.Scanner;

public class dongjun_2847 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int n[] = new int[t];
		
		for(int i = 0 ; i < t ; i ++) {
			n[i] = sc.nextInt();
		}
		int count = 0;
		
		//�� ������ ����/ �� �迭�� �� ���������� �˻��ؼ� �� ���� �迭���� ���� ���̸� ���� �迭�� ���� -1��ŭ���̳��� ���ָ��
		for(int i = n.length-1 ; i >0 ; i--) {
			if(n[i] <= n[i-1]) {
				int minus = n[i] -1;
				count += n[i-1] - minus;
				n[i-1] = minus;
			}
		}
		System.out.println(count);

	}

}
