import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//������ü�� ������ �������� �����ɷȴ� ����

public class delivery_8980 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//���� ����
		int n = Integer.parseInt(st.nextToken());
		//�ù� �뷮
		int c = Integer.parseInt(st.nextToken());

		//�ù� ����
		int m = Integer.parseInt(br.readLine());
		
		//���������� �ù� �ּ� �뷮
		int t[] = new int[n];
		
		int info[][] = new int[m][3];
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			//������ ����
			info[i][0] = Integer.parseInt(st.nextToken());
			//�޴� ����
			info[i][1] = Integer.parseInt(st.nextToken());
			//�ù�뷮
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//�޴� ������ �������� �������� ����
		//�޴� ������ ������� �����¸����� �������� �������� ����
		Arrays.sort(info, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		            if(o1[1] == o2[1]){
		                 //������� �迭�� �ι�° ���� �������� ������������ ����/ ������������ �Ϸ��� o1,o2�� ������ �ٲٸ��
		            	return o1[0] - o2[0];
		            }else {
		                //�⺻������ �迭�� �պκ��� ������������ �������� / ������������ �Ϸ��� o1, o2�� ������ �ٲٸ��
		                return o1[1] - o2[1];      
		            }
		    }
		});

		for(int i = 0 ; i < t.length ; i++) {
			t[i] = c;
		}
		
		int count = 0;
		
		for(int i = 0 ; i < m ; i ++) {
			//�ִ� �ѵ��� ����
			//min �� �ּҸ� ���ϴ� ���̿����ϹǷ� �ù� �ִ�뷮���� ū 10001�� �ʱⰪ���� ����
			int min=10001;
			for(int j = info[i][0] ; j< info[i][1] ; j++) {
				if(t[j] < min) {
					min = t[j];
				}
			}
			
			//�ִ� �ѵ����� �ù� �뷮�� �������
			//������ �ִ� �ѵ��� �ù�뷮��ŭ ����
			if(info[i][2] < min) {
				for(int j = info[i][0] ; j < info[i][1] ; j++) {
					t[j] -= info[i][2];
				}
				count += info[i][2];
			//�װ� �ƴ϶�� ������ �ִ��ѵ� ��ŭ ����
			}else {
				for(int j = info[i][0] ; j < info[i][1] ; j++) {
					t[j] -= min;
				}
				count += min;
			}
				
		}
		
		System.out.println(count);
		
	}

}
