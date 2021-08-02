import java.util.Scanner;

//��ǥ���� �׷��� �˰���
//disjoint set(���μ� ����) �˰����̶�� �Ҹ�
//find �� ����Ǿ��ִ��� Ȯ�����ִ� �Լ�

public class union_find_10775 {
	
	static int[] gate = new int[100001];

	
	//�ܿ��
	public static int find(int x){
		if(x == gate[x]) return x;
		return gate[x] = find(gate[x]);
	}
	
	//�θ��带 ��ġ�� �Լ�
	//�ܿ��
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		//�� ������������ �θ� ������
		//b�� �� ��������
		if(a != b) {
			gate[a] = b;
		}
		
	}
	
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
		
		int ans = 0;
		
		//�迭�ϳ��ϳ��� �׷��� �����̶�� �����ϰ� ���� �̾����ִ»��°� �ƴ�
		//��, �ڱ� �迭��ȣ�� ���� �ڱ� �ڽ��� ����Ű�� �ִ� ������
		for(int i = 1 ; i <= g ; i++) {
			gate[i] = i;
		}
		
		for(int i = 0 ; i < p ; i++) {
			int v = find(gi[i]);
			if(v == 0) break;
			//1~v �߿��� ���� ū ���� ��ŷ�Ѱ��̹Ƿ� �׺��� �Ѵܰ� ���� ������ �����شٰ� �����ϸ��
			//�ٵ� v-1�� 
			union(v, v-1);
			ans++;
		}
		System.out.println(ans);
	}

}
