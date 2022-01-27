//�Ű�����Ž��
//������ ���̸� �̺�Ž������ ���ϰ� ������ ���̸� ��� �迭�� ���鿡 ���� ���������� ���� ���� M �� �Ѿ����

import java.io.*;
import java.util.*;

public class BOJ_16401 {

	static int m;
	static int n;
	static int arr[];
	
	static boolean para(int x) {
		int count = 0;
		for(int i = 0 ; i < n ; i++) {
			count += arr[i]/x;
		}
		return count >= m;
	}
	
	static void pro() {
		Arrays.sort(arr);
		
		int left = 1;
		int right = 1000000000;
		int answer = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(para(mid)) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
		
		
	}
}
