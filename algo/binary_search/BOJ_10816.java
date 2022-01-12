
/*
 * �ð��ʰ� ����Ǯ�� : ��Ұ��� �ߺ��� ����ϴ� ���¿��� ������ ���� �ش� �迭�� � �����ϴ����� Ȯ���ؾ� �ϴ� �����̴�.
 * ���� �ش� ��Ұ� ��� ������ �ִ��� ����ϴ°��� �߿��ϹǷ� �̸� �������� �ڷᱸ���� �ϳ� ����� ���� �߿��ϴ�.
 * ���� HashMap �� �̿��Ͽ� �ش� ���� � ����ִ��� value �� �����Ͽ� Ȯ���Ѵ�.
 * --> �ؽ������θ����ε� Ǯ �� �ְ� �̺�Ž�����θ����ε� Ǯ �� �ִ� �����̴�.
 * 
 * ���� ����Ǯ�� : upper bound �� lower bound �� Ȱ���Ѵ�.
 * StringBuilder �� Ȱ������ ������ �ð��ʰ��� ���� ���̰� ���� ��������.
 */

import java.io.*;
import java.util.*;


public class BOJ_10816 {

	static int n;
	static int A[];
	static int m;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int lower_bound(int left, int right, int x) {
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(A[mid] < x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	static int upper_bound(int left, int right, int x) {
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(A[mid] <= x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	static void pro() throws IOException  {
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			int B = Integer.parseInt(st.nextToken());
			int lower = lower_bound(0, A.length-1 , B);
			int upper = upper_bound(0, A.length-1 , B);
			sb.append(upper - lower).append(' ');
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		pro();
	}

}
