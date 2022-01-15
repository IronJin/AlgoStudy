
/*
 * ���� : ���� �ڸ���
 * �ذ���
 * 1. ���ϴ±��� M�� ��� ���� �ڸ� �� �ִ� �ִ� ���� H�� ���ΰ�?? �� �����´�.
 * 2. � ���� H�� �߶����� ���ϴ±��� M��ŭ�� ���� �� �ִ°�? �� ������� �����Ѵ�.
 * 3. mid �� ���� ������ � ���� H�̴�.
 * 4. positive(int h) �Լ����� �̸� �ڸ� �� �ִ����� Ȯ���Ѵ�.
 * ��, ���� H�� 0���� 20�� ���� ������ �� �ְ� �̺� Ž���� mid ���� ���̷� Ȱ���� ������ ������ ���̸� ����Ѵ�.
 */
import java.io.*;
import java.util.*;

public class BOJ_2805 {

	static int n;
	static int m;
	static int A[];
	
	static boolean positive(int h) {
		long sum = 0;
		for(int i = 0 ; i < n ; i++) {
			if(A[i] > h) {
				sum += A[i] - h;
			}
		}
		return sum >= m;
	}
	
	static void pro() {
		
		int left = 0;
		int right = 2000000000;
		int mid;
		while(left <= right) {
			mid = (left + right)/2;
			if(positive(mid)) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		//right �� mid �� ���� h��� ������ ������ ���� h�� �ִ� ���̸� ����Ű�� index�̰�
		//index �� �� �ڸ� ������ ���� h�� �ǹ��ϹǷ� right �� ����ϸ��.
		System.out.println(right);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		
		
	}
}
