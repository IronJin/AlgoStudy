
/*
 * �����佺�׳׽��� ü(�Ҽ����� �˰���) �� �������
 * �����佺�׳׽��� ü�� �� �ܿ����� �˰�����
 */

import java.io.*;
import java.util.*;

public class BOJ_1644 {

	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean arr[];
	
	static void che() {
		
		//true �̸� �Ҽ��� �ƴ�
		for(int i = 2 ; i*i <= n ; i++) {
			for(int j = i*i ; j <= n ; j+=i) {
				arr[j] = true;
			}
		}
		
		for(int i = 2 ; i <= n ; i++) {
			if(arr[i] == false) {
				list.add(i);
			}
		}
		
	}
	
	static void pro() {
		//�Ҽ��� ���ؼ� list �� �־���
		che();
		
		int count = 0;
		int sum = 0;
		//�������� ����ؼ� ���� ����.
		for(int left = 0, right = -1 ; left < list.size(); left++) {
			
			while(right + 1 <= list.size()-1 && sum < n) {
				right++;
				sum += list.get(right);
			}
			
			if(sum == n) {
				count++;
			}
			
			sum -= list.get(left);
			
		}
		
		System.out.println(count);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n+1];
		pro();

	}

}
