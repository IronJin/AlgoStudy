
/*
 *	������ �ϰ� �����Ѵ�.
 *	pro �Լ����� �ε����� �ϳ��� two_pointer �Լ��� ������
 *	��� �迭�� �˻��ϴµ� �ΰ��� ����� �ϹǷ� �������͸� ����Ѵ�.
 *	���ʰ� ������ ������ �����ϸ� ���������ͳ� ������ �����Ͱ� �̹� ���õ� �ε����� ����Ű�� �ȵȹǷ� �̸� if������ �ɷ�����
 *	�״��� ���� ���� ���� ���� ���� �ε����� ����Ű�� ������ ũ�ٸ� ������ �������� �ε����� �ϳ� �����ָ鼭 �˻��Ѵ�.
 *	�ݴ�� ���� ���� ���� ���� ���� �ε����� ����Ű�� ������ �۴ٸ� ���� �������� �ε����� �ϳ� �ø���.
 *	���� ���� ���� ���ٸ� �ٷ� return �� ���ֵ��� �ϰ� ��� while ���� �������Դµ��� ã�� ���ߴٸ� false �� �������ش�.
 *	
 *	�߰��� �迭�� ��� ���� Ȯ���ϰ� �ϳ� Ȯ���Ҷ����� n�� �ð��� �ɸ��Ƿ� �� n^2 �� �ð��� �ɸ��Եȴ�.
 *	�迭�� ���̴� 2000 �̹Ƿ� 4000000 �� �ð����⵵�� ������ �̴� �ð����� 2�ʸ� ���� �ʴ´�.  
 */

import java.io.*;
import java.util.*;

public class BOJ_1253 {

	static int n;
	static int arr[];
	
	static boolean two_pointer(int index) {
		int left = 0;
		int right = arr.length-1;
		
		while(left < right) {
			
			if(left == index) {
				left++;
			}else if(right == index) {
				right --;
			}else if(arr[left]+arr[right] == arr[index]) {
				return true;
			}else if(arr[left]+arr[right] > arr[index]) {
				right --;
			}else {
				left++;
			}
			
		}
		return false;
	}
	
	static void pro() {
		
		int answer = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(two_pointer(i)) {
				answer++;
			}
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
		Arrays.sort(arr);
		pro();
		
		
		
	}
}
