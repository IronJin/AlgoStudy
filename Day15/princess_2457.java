import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class princess_2457 {

	//�Ǵ³�¥�� ���ؤ��� �������� / ���� ��¥�� �������� ��������
	//96�ۿ��� Ʋ�����ϴ�.... ������ �˾����ϴ� 
	//�� �������� �𸣰����� ������ ���
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int f[][] = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) * 100;
			int b = Integer.parseInt(st.nextToken());
			
			f[i][0] = a+b;
			
			int c = Integer.parseInt(st.nextToken()) * 100;
			int d = Integer.parseInt(st.nextToken());
			
			f[i][1] = c+d;
		}
		
		Arrays.sort(f, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		            if(o1[0] == o2[0]){
		                 //������� �迭�� �ι�° ���� �������� ������������ ����/ ������������ �Ϸ��� o1,o2�� ������ �ٲٸ��
		    	    return o1[1] - o2[1];
		            }else {
		                //�⺻������ �迭�� �պκ��� ������������ �������� / ������������ �Ϸ��� o1, o2�� ������ �ٲٸ��
		                return o1[0] - o2[0];   
		            }
		    }
		});

		int max = 0;
		int idx = 0;
		//301 ���Ͽ��� ���� ū ���� ã��
		for(int i = 0 ; i < n ; i++) {
			if(f[i][0] <= 301) {
				if(max < f[i][1]) {
					max = f[i][1];
				}
			}else {
				//301���� ū ���� ������ ���� �ε��� ���� �� break;
				idx = i;
				break;
			}
		}
		
		//
		boolean boo = true;
		
		//ó������ �� ���� ��¥�� 1130���� ū ��� �Ҹ����� �������� ���� ��
		//���� �ϳ��� �ɴ°����� ������ �����ϹǷ� 1���
		if(max > 1130) {
			System.out.println(1);
			boo = false;
		}
		
		//�ϳ������� �����ʴ°�� if�� ��
		if(boo) {
			//�ʱⰪ�� ������ 2��. �ֳ��ϸ� ������ 3�� 1������ �ϳ� �����
			//���⼭ �ϳ��� ���� �����̱� ������
			int count = 2;
			int max1 = 0;
			for(int i = idx ; i < n ; i++) {
				//max���� �Ǵ³��� ���� ��¥�� ���³��� ���� ū ���� ��
				//���³��� ���� ū���� max1 �� ����
				if(f[i][0] <= max) {
					if(max1 < f[i][1]) {
						max1 = f[i][1];
					}
				//max���� �Ǵ³��� �� ū ���� ������ ���
				}else {
					//max1 �� max���� �Ǵ³��� �������� ���³��� ���� ū���� ���� ����Ǿ� �ִµ�
					//max1 ���� ũ�ٴ°��� �߰��� ���� �� ��ٴ� �̾߱� �̹Ƿ� count �� 0 ������ ���̻� �� �;��� break;
					if(max1 < f[i][0]) {
						count = 0;
						break;
					//���� ������ �������� �ʴ´ٸ� ������ �Ǵ³��� ���³��� ���� ū���� max1 ���� �۴ٴ� �̾߱� �̹Ƿ�
					//�ض��� �ʰ� �̾����ٴ� �̾߱�
					}else {
						//���� max �� max1 �� �־��ְ�
						//���� index���� �ٽ� �˻��ϱ� ���� i-- ���� for���� ������ i++�� �Ǳ⶧��
						max = max1;
						i--;
						//���� �ϳ� �� �����Ѱ��̱� ������ count++����
						count++;
					}
				}
				//for���� ���������� ������ ���� ���³��� 1130���� ū ��찡 ����� ���̻� ��츦 �� ������������
				//break;
				if(max1 > 1130) {
					break;
				}
			}
			//�� �˻��ϰ� �������� ���³��� ���� ū ��찡 1130�� ���ѱ�� ��쿡�� ������ ���� ���� �Ұ��ϹǷ�
			//���� ����ϴ� count ������ 0
			if(max1 <= 1130) {
				count = 0;
			}
			System.out.println(count);
		}
		
	}

}
