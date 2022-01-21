
//���Ѿ��� ��Ʈ�� �ϴ� ���� �ְ� �Ǵ� ����
//�������� ���� �������� para �Լ��� �������� ���� Ʋ�� ���� �Ф�
//right �� �迭�߿��� ���� ū������ �����ϸ��

/*
 * Ʋ�ȴ� �κ� ����
 * left �� right �� ������ left�� �������� n<= left ��� �����־����Ƿ� n���� ������
 * max ���� ���������� �ʰ� right�� m���� ������
 * para�Լ��� �⺻������ ������� �ʾ���
 */


import java.io.*;
import java.util.*;

public class BOJ_2512 {

	static int n;
	static int arr[];
	static int m;
	static int max = 0;
	
	//x�� �ǹ��ϴ� ���� �ִ� ���Ѿ��� �ǹ���
	static boolean para(int x) {
		
		int sum = 0;
		for(int i = 0  ; i < n ; i++) {
			sum += Math.min(x, arr[i]);
		}
		
		//�ִ� ���Ѿ��� ���س��� �� ���� ������ ������� ���������� true�� �ݳ��ϸ��
		return sum <= m;
	}
	
	static void pro() {
		int left = 0;
		int right = max;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(para(mid)) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		m = Integer.parseInt(br.readLine());
		pro();
	}

}
