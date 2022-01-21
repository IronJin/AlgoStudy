
//�������ͷε� Ǯ �� �ְ� �̺�Ž�����ε� Ǯ �� �ִ�.
//�� Ǯ�̴� �̺�Ž������ Ǭ Ǯ��

//Ʋ������ : ����� ������ 10���̰� ������ ����� ���ҽ� 30���̴�. ��, int ������ �ʰ��ϰ� �ȴ�.
//�̶� �� ����� ���� ��� ������ ������ ������ ������ int ���ε� int ���� ���� long �� �������� �Ҷ� ������ ����.
//���� int ���� ���� long ������ �־��ٶ����� int ���� �տ� (long)�� �ٿ� ������ �ϵ��� �Ѵ�.

import java.io.*;
import java.util.*;

public class BOJ_2473 {

	static int n;
	static int arr[];
	
	static void pro() {
		
		long answer = Long.MAX_VALUE;
		int leftvalue = 0;
		int middle = 0;
		int rightvalue = 0;
		
		for(int i = 0 ; i < n-2 ; i++) {
			for(int j = i+1 ; j < n-1 ; j++) {
				int left = j+1;
				int right = n-1;
				while(left <= right) {
					int mid = (left + right)/2;
					if(arr[mid] < -(arr[i]+arr[j])) {
						left = mid + 1;
					}else {
						right = mid - 1;
					}
				}
				
				if(j+1 <= left && left <= n-1 && answer >= Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left])) {
					answer = Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left]);
					leftvalue = arr[i];
					middle = arr[j];
					rightvalue = arr[left];
				}
				
				if(left - 1 >= j+1 && left - 1 <= n-1 && answer >= Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left-1])) {
					answer = Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left-1]);
					leftvalue = arr[i];
					middle = arr[j];
					rightvalue = arr[left-1];
				}
				
			}
			
		}
		System.out.println(leftvalue+" "+middle+" "+rightvalue);
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		pro();
	}

}
