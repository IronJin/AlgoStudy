import java.util.HashSet;
import java.util.Scanner;

public class airport_10775 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//����Ʈ ��
		int g = sc.nextInt();
		//����� ��
		int p = sc.nextInt();
		
		int gi[] = new int[p];
		
		for(int i = 0 ; i < p ; i++) {
			gi[i] = sc.nextInt();
		}
		
		HashSet<Integer> set = new HashSet<>();
		int ans = 0;
		int a = gi[0];
		int i = 0;
		while(a!=0 || i == p) {
			//�ؽ��� ���� ����Ʈ�� ��ŷ�� �Ǿ��ִ°�� ���� ����Ʈ���� ���ڸ� ���� ����Ʈ Ȯ��
			if(set.contains(a)) {
				a--;
			//������ �Ǿ����� �ʴٸ�
			}else {
				//�������Ʈ��ȣ �־��ְ� ���� ����� Ȯ��
				set.add(a);
				i++;
				a = gi[i];
				ans ++;
			}
		}
		System.out.println(ans);
		
	}

}
