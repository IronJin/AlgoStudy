//�����̸� : �� ���
/*
 * Ǯ�̹��
 * 1. A[i] �� �������, -A[i] �� ���� ����� ���� �ִ��� ������ ã�°� �߿���
 * 2. -A[i]�� ã�����ؼ��� �̺�Ž���� �̿�
 * 3. -A[i] �� ���� ����� ���Ҵ� left �� left-1 �� �����ϰԵ�
 * 3-1. ���� : -A[i] �� ������ ��ġ���� A[left] �� A[left-1] �� �����ϱ� ����
 * (���⼭ ���ϴ� left �� �̺�Ž���� �������� left �� ����)
 */
import java.io.*;
import java.util.*;

public class BOJ_2470 {

	static int n;
	static int arr[];
	
	static void pro() {
		int leftvalue = 0;
		int rightvalue = 0;
		int answer = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i = 0 ; i < n ; i++) {
			int index = bin(arr, i+1, n-1, -arr[i]);
			
			
			//����ó�� ���� : index �� 1��° index �� ����Ű�� ���
			//--> arr[index - 1] �� arr[0] �̶� �������� ����
			//����ó�� ���� : index �� n��° index �� ����Ű�� ���
			//--> arr[index] �� 0���� n-1 index���� �����ϴ� �迭���� ��������
			
			//����ó���� index-1 ���� �����ϴ� ����
			if(i+1 <= index-1 && index-1 <= n-1 && Math.abs(arr[i]+arr[index-1]) < answer) {
				answer = Math.abs(arr[i]+arr[index-1]);
				leftvalue = arr[i];
				rightvalue = arr[index-1];
			}
			
			if(i+1 <= index && index <= n-1 && Math.abs(arr[i]+arr[index])<answer) {
				answer = Math.abs(arr[i] + arr[index]);
				leftvalue = arr[i];
				rightvalue = arr[index];
			}
			
		}
		System.out.println(leftvalue+" "+rightvalue);

	}
	
	static int bin(int A[], int left, int right, int x) {
		
		//�̺�Ž�� ����
		while(left <= right) {
			int mid = (left + right) /2;
			if(A[mid] < x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
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
