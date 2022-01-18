
import java.io.*;
import java.util.*;

public class BOJ_1806 {

	static int n;
	static int s;
	static int A[];
	
	static void pro() {
		int left = 0;
		int right = 0;
		//�ʱⰪ --> left�� right �� ó������ �����ϹǷ�
		int sum = A[0];
		int length = Integer.MAX_VALUE;
		while(left <= A.length-1 && right <= A.length-1) {
			if(sum >= s) {
				length = Math.min(right - left + 1, length);
				//���̰� 1���� ������ �����Ƿ� �׳� �ٷ� break �ϰ� ���� ���
				if(length == 1) {
					break;
				//�װ� �ƴ϶�� left �����Ϳ� ��ġ�� ���� sum���� ����	
				}else {
					sum -= A[left];
				}
				left++;
			}else {
				right++;
				//������ �����Ͱ� �迭�� ������ ������ ���Ḧ ����� 32��° ���� �����
				if(right > A.length-1) {
					break;
				}
				//�����ʴ´ٸ� ������ �����Ͱ� ����Ű�� �迭�� ���� sum�� �����־����
				sum += A[right];
			}
		}
		if(length == Integer.MAX_VALUE) {
			length = 0;
		}
		System.out.println(length);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		
	}
}
