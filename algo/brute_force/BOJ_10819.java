
/*
 * ��Ʈ��ŷ���� �ذ��� �� �ִ� ����
 * n���� ���ڸ� n�� �̴°��̹Ƿ� �湮üŷ�� �ϸ鼭 ���Ѱ��� ���ο� �迭�� ����ؼ� �־��ְ� �湮üŷ�� ����
 * �׸��� depth �� n���� �����Ҷ� ����� �������ָ��
 */

package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_10819 {

	static int n;
	static int arr[];
	static boolean check[];
	static int calc[];
	static int answer = Integer.MIN_VALUE;
	
	static void track(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 0 ; i < n-1 ; i++) {
				sum += Math.abs(calc[i] - calc[i+1]);
			}
			answer = Math.max(answer, sum);
		}else {
			
			for(int i = 0 ; i < n ; i++) {
				if(check[i] == false) {
					check[i] = true;
					calc[depth] = arr[i];
					track(depth+1);
					check[i] = false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check = new boolean[n];
		calc = new int[n];
		track(0);
		System.out.println(answer);
	}

}
