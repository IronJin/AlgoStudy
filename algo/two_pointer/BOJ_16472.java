
/*
 * ����Ǯ�� ���
 * 1. count ������ ���� ���δٸ� ���ڰ� ����� �����ִ� �����̴�.
 * 2. a�� 97���� �����ϹǷ� �迭�� 26�� �����س���
 * 3. �������͸� ����ϰ� ������ �������� + 1 �� �Էµ� ���ڿ��� ������ ���ϴ��� Ȯ��
 * 4. ���Ѵٸ� ������ �������� + 1 �� ����Ű�� ���ڰ� �迭�� �����ϰ� �ִ� ������ Ȯ��
 * 4-1. ���� �����ϰ� �ִٸ� �׳� �״�� right++ ���ְ� ���ĺ��� �ٷ�� �迭�� �ϳ� ������Ŵ
 * 4-2. ���� �������� �ʴ´ٸ� �ϴ� ī��Ʈ ������ �ϳ� �������Ѻ��� n���� �۰ų� ������ ������ �����͸� ������Ű�� �ش� ���ڸ� �����ϴ� �迭�� 1 ������Ŵ
 * 4-3. ī��Ʈ ������ �ϳ� �������״µ� n�� �Ѿ�ٸ� ������Ų ī��Ʈ�� ������� �����ְ� ���̻� right �� �ø� �ʿ���� �ݺ��� Ż��
 * 5. right - left + 1 �� n���� ���δٸ� ���ĺ��� ������������ ���̰� �ִ븦 answer�� ���� ����
 * 6. �״��� left �����͸� �ϳ� �������Ѿ� �ϹǷ� ���� left �����Ͱ� ����Ű�� �ִ� ���ĺ��� �迭�� �ϳ� ���ҽ�Ŵ
 * 6-1. ���ҽ��״µ� �� �迭�� ���� 0�̶�� count�� ����(0�� �ƴ϶�°��� ���� �Ȱ��� ���ڰ� ���������Ƿ� ���δٸ� ���ĺ��� ������ ����Ű�� count ������ ���� �ʿ䰡 ����)
 */

import java.io.*;
import java.util.*;

public class BOJ_16472 {

	static int n;
	static String str;
	static int arr[] = new int[26];
	
	static void pro() {
		int answer = Integer.MIN_VALUE;
		int right = -1;
		int count = 0;
		for(int left = 0 ; left < str.length() ; left++) {

			while(right+1 <= str.length()-1) {
				if(arr[str.charAt(right+1)-97] == 0) {
					count++;
					if(count <= n) {
						right++;
						arr[str.charAt(right)-97]++;
					}else {
						count--;
						break;
					}
				}else {
					right++;
					arr[str.charAt(right)-97]++;
				}
			}
			
			int length = right - left + 1;
			answer = Math.max(answer, length);
			arr[str.charAt(left)-97]--;
			if(arr[str.charAt(left)-97] == 0) {
				count--;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		pro();
		
		
	}
}
