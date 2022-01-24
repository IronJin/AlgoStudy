/*
 * **LIS �˰����� �̿��� ���ؾ���
 * LIS �˰����� ���� �� �κм����� ũ�⸦ ���ϴ� �˰������ν�
 * ����Ʈ�� �� �տ� 0�� �־��ְ� �迭���� ó������ �ϳ��� ���� ����
 * ����Ʈ�� �� ������ ���� ���� ũ�� �׳� �״�� ����Ʈ�� �߰����ְ� �װ� �ƴ϶��
 * ����Ʈ���� �� �ڸ��� INDEX �� ���� �� �ڸ��� ���� �ٲ��ִ� ������� �����س�����.
 */

import java.io.*;
import java.util.*;

public class BOJ_12015 {

	static int n;
	static int arr[];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	static void pro() {
		list.add(0);
		
		for(int i = 0 ; i < n ; i++) {
			int value = arr[i];
			if(value > list.get(list.size()-1)) {
				list.add(value);
			}else {
				int left = 1;
				int right = list.size()-1;
				int index = right;
				while(left <= right) {
					int mid = (left + right)/2;
					if(list.get(mid) < value) {
						left = mid + 1;
					}else {
						right = mid-1;

					}
				}
				list.set(left, value);
			}
		}
		System.out.println(list);
		System.out.println(list.size()-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
	}

}
