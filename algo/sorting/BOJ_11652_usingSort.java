import java.io.*;
import java.util.*;

/*
 *  11652 ī�� ������ ������ �̿��ؼ� Ǯ���� �ְ� �ؽ����� �̿��ؼ� Ǯ���� �ִ�.
 *  �� ����� ������ �̿��� Ǫ�� ����̴�. 
 *  ���� �� ó������ �Ȱ��� ���� ������ ī��Ʈ�� ���ִٰ� ���� �ٲ�� �Ǹ� ī��Ʈ�� ���� �� ���� ����Ǿ� �ִ�
 *  max ���� ���Ͽ� ũ�� �׶��� ī���� ���ڸ� answer �� �־��ִ� ���
 */
public class BOJ_11652_usingSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long arr[] = new long[t];
		
		for(int i = 0 ; i < t ; i++) {
			long l = Long.parseLong(br.readLine());
			arr[i] = l;
		}
		
		Arrays.sort(arr);
		
		long cur = Long.MIN_VALUE;
		int count = 0;
		int max = 0;
		long answer = 0;
		
		for(int i = 0 ; i < t ; i++) {
			if(arr[i] != cur) {
				if(count > max) {
					answer = cur;
					max = count;
				}
				count = 1;
				cur = arr[i];
			}else {
				count++;
			}
		}
		
		//����ó���κ�
		//ó������ �迭�� ������ �Ȱ��� ������ ��� ���� �������� answer �� ���� ���� ����
		if(count > max) {
			answer = cur;
			max = count;
		}
		
		
		System.out.println(answer);
	}

}
