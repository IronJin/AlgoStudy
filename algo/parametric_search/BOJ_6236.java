//�ּҸ� ����ϴ� ����
//����ؾ��� �߿� ����Ʈ : left �� �迭�� �ִ���� �����ؾ��ϸ� right �� �־��� ��츦 ���������� 10����� �����ؾ���
//������ m �� 1�̰� n�� 10��, �迭�� ��� ���� 10000�� ��� 10���� ������ �Ǳ� �빮

import java.io.*;
import java.util.*;

public class BOJ_6236 {

	static int n;
	static int m;
	static int arr[];
	static int max = Integer.MIN_VALUE;
	
	static boolean para(int x) {
		//ó���� ������ �ѹ� �����ϸ鼭 �����ϴ°��̱� ������ ���� Ƚ���� 1���� ������
		int count = 1;
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum += arr[i];
			if(sum > x) {
				count++;
				sum = arr[i];
			}
		}
		return count <= m;
	}
	
	static void pro() {
		int left = max;
		int right = 1000000000;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			if(para(mid)) {
				right = mid - 1;
				answer = mid;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		pro();

	}

}
