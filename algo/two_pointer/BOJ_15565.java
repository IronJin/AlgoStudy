
import java.io.*;
import java.util.*;


public class BOJ_15565 {

	static int n;
	static int k;
	static int arr[];
	static int answer = -1;
	
	static void pro() {

		int right = -1;
		int count = 0;
		
		
		for(int left = 0 ; left < n ; left++) {
			
			
			while(right+1 < n && count < k) {
				right++;
				if(arr[right] == 1) {
					count++;
				}
			}
			
			//���� Ʋ�ȴ� �κ�
			//���� k �� 2�̰� �迭���� 1�� �ϳ��ۿ� ������ -1 �� ����ؾ���
			//��, count == k �� �������� ���Ѵٸ� answer �� ó������ -1 �� ���·� �����ؾ���
			//����, count == k �� �����ϴ� ��� answer �� -1 �϶��� answer�� ó�� length�� �����������
			//�װ� �ƴ϶�� �ּ� ���� ũ�⸦ ���ؾ���
			if(count == k) {
				if(answer == -1) {
					answer = right - left + 1;
				}else {
					answer = Math.min(answer, right - left + 1);
				}
			}
			//System.out.println(right +" "+left);
			//System.out.println(answer);
			
			//���� �� ���ư��� �ִ� ���, �� left �� �ϳ� �����ؾ��ϴµ� ���� ��ġ�� left �� �����ϴ� ���� 1�̶��
			//count���� �ϳ� �������
			if(arr[left] == 1) {
				count--;
			}
			
			//right �� �̹� ������ �����߰� count �� k���� ������� ���̻� �����ϴ� ������ �����Ƿ�
			//�ݺ����� �����Ͽ��� ��
			if(right == n-1 && count < k) {
				break;
			}
	
		}//for�� ����
		
		//�� ���
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		

		
	}

}
