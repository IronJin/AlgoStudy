//����Ǯ�� ���
/*
 * �Ȱ��� ���Ұ� �ִ��� �˻��ϱ� ���ؼ��� right �����Ͱ� �̵��Ҷ� ����Ű�� ���Ұ� 
 * ���� 1 ���� 100000 ���̿� ��Ÿ������ Ȯ���ؾ���
 * ��, ������ 1���� 100000 �� �ε����� ������ �迭�� 1�� ���������ְ� ������ right �� �̵��� ���� �ʴ´�.
	##�߰����� �� : ������ ���̰� 100000�� �ִ��̰� ���� 1���� 10������ �����ϹǷ� ��� �� �ٸ� ����� �����Ҷ�
	50���� ��찡 ���´�. �� ���� int������ �Ѿ�Ƿ� long ���� ǥ���ؾ��Ѵ�.
 */


import java.io.*;
import java.util.*;


public class BOJ_13144 {

	static int n;
	static int arr[];
	static int counting[] = new int[100001];
	
	static void pro() {
		long answer = 0;
		
		for(int left = 0, right = -1 ; left < n ; left++) {
			while (right+1 <= n-1 && counting[arr[right+1]] == 0) {
				right ++;
				counting[arr[right]] ++;
			}
			
			answer += right - left + 1;
			
			counting[arr[left]]--;
			
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
		
		
	}
}
