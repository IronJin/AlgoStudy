//������ �̺�Ž������ �����ؾߵ�
//ù��° �迭�� 10�������� �ι�° �迭�� 10�� �����̹Ƿ� ����Ž���� 100���̶�� �ð��� �ɸ��⶧��

import java.io.*;
import java.util.*;

public class BOJ_1920 {
	
	static int n;
	static int m;
	static int A[];
	static int B[];
	
	static int bin(int left, int right, int x) {
		while(left <= right) {
			int mid = (left + right)/2;
			if(A[mid] < x) {
				left = mid+1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	static void pro() {
		Arrays.sort(A);
		for(int i = 0 ; i < m ; i++) {
			int answer = 0;
			int index = bin(0,A.length-1,B[i]);
			if(0 <= index && index <= A.length-1 && A[index] == B[i]) {
				answer = 1;
			}
			System.out.println(answer);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[n];
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		B = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		pro();
	}

}
