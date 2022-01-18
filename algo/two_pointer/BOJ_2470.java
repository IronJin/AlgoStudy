import java.io.*;
import java.util.*;

//�迭�� ��������� ��
//������ ������(�ִ�) + ���� ������(�ּ�) > 0 --> ������ �����Ͱ� �� ũ�ٴ� ���̹Ƿ� ������ �����͸� --;
//������ ������(�ִ�) + ���� ������(�ּ�) < 0 --> ���� �������� ���� �� ���밪�� ũ�ٴ� ���̹Ƿ� ���� �����͸� ++;

public class BOJ_2470 {

	static int n;
	static int arr[];
	
	static void pro() {
		int left = 0;
		int right = arr.length-1;
		int l = 0;
		int r = 0;
		int best_sum = Integer.MAX_VALUE;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(best_sum > Math.abs(sum)) {
				best_sum = Math.abs(sum);
				l = arr[left];
				r = arr[right];
			}
			
			if(sum > 0) {
				right--;
			}else {
				left++;
			}
		}

		System.out.println(l+" "+r);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		pro();
	}

}
