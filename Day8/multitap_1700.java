import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//�ü���� page replacement ��� �� optimal page replacement �� �Ȱ��� �˰���
//���� �������� ������ �ʴ� �������� ��� �������� �����ϴ� �˰���
//�޸� ������ page�� ���� ũ���� frame ���� ������ �� frame �� �� ���ִ� ��� �ٸ� ��������
//�޸𸮿� �Ҵ�޾ƾ� �ϴ� ��Ȳ�϶� ���� �������� ������ �ʴ� frame�� victim frame ���� �����ϴ� ���
//�̷л� ������ �˰��������� �ü�������� ���߿� � ���μ����� �̸� ������ �𸣱� ������ ���������� ������ �����
//�㳪 �� ���������� ������ ��� ���ڱ�⸦ �������� �����ֱ⶧���� �� ���� ������ ��ü �˰����� �����
//������� Ǯ�鼭 ���� �� �˰� ������ �� ������ ������ ������� ���� ��
//hashset ����ؼ� ǰ - ����Ǯ�̽ð� 3�ð�;...

//�� �ܷ� FIFO �˰��� -> ���� �������� �������� �޸𸮿��� �������ִ� �˰���
//LRU(least recently used) : ���� ���� ������ ���� �������� ��ü���ִ� �˰���
//FIFO�˰��� ���� ȿ�����̸� ���� �ü������ �������
public class multitap_1700 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int elec[] = new int[k];
		
		st = new StringTokenizer(br.readLine());
		int z = 0;
		while(st.hasMoreTokens()) {
			elec[z] = Integer.parseInt(st.nextToken());
			z++;
		}
		
		//������� ������ ���亯�� ����
		int ans = 0;

		//���� �ִ��� ������ �� �� ����.
		//�迭ó�� ũ�⸦ �̸� ������ �ʿ䵵������ ������ �ƴ� ������
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0 ; i < k ; i ++) {
			//�ؽ����� �ܼ�Ʈ��� �ϴ� ����
			//�ܼ�Ʈ�� ���� ���� ������ ���ڱ�Ⱑ �����ִ��� Ȯ��
			//�����ִ°�� �׳� ������ �� ���ڱ�� Ȯ���ϸ��
			//1. �ܼ�Ʈ�� ����ִ��� Ȯ���ϰ� ����ִ� �ܼ�Ʈ�� �ִ°�� ���� ���������� ���ڱ�Ⱑ �����ִ��� Ȯ��
			if(set.contains(elec[i])) continue;
			
			//2.�Ȳ����ִ°�� �ܼ�Ʈ�� �����ִ��� Ȯ�� �����ִ°�츦 Ȯ���ؾ���
			//3.�׷���찡 �ƴ϶�� �Ʒ��� �ִ� if���� �ǳʶٰ� �׳� ���簪�� �ؽ��¿� �߰����ָ��
			//�ؽ� ����� ���� ó���� �Է��� ũ�Ⱑ �Ǹ� if������ ���� �ƴϸ� else�� �����
			if(set.size() == n) {
				int idx = -1, target = 0;
				for(int t : set) {
					int tidx = 999;
					for(int j = i+1; j < k ; j++) {
						if(t == elec[j]) {
							tidx = j;
							break;
						}
					}
					//�ؽ��¿� ����ִ����ڱ�Ⱑ ���߿� ���� ���� ���ڱ���� ���
					//index�� �ٲ����� ����.
					//�׳� �� ���� �ٷ� �ؽ��¿��� ���ָ��
					if(tidx == 999) {
						target = t;
						break;
					}else {
						if(tidx > idx) {
							idx = tidx;
							target = elec[idx];
						}
					}
				}
				//target�� �ش��ϴ� ���� �ؽ����� ������
				set.remove(target);
				ans++;
			}//if���� ��
			
			//��������� �׳� �ڵ����� �߰��ǰ�
			//������� �ʴٸ� �ٷξ��� if������ ��� �� ���ڱ�Ⱑ ������ �� ������ ��
			set.add(elec[i]);
		}
	
	
	
	
	System.out.println(ans);
	
	
	}
}
