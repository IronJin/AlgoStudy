
/*
 * 
 */
import java.io.*;
import java.util.*;

public class BOJ_7795 {

	static int A[];
	static int B[];
	//testcase ����
	static int t;
	
	static int bin_sear(int left, int right, int x) {
		//result �� B�� ��� ��Ҹ� ���� �� �ִ����� ������ ����
		int result = 0;
		
		//�̺�Ž���� ���ݻ� ���� �ε����� ������ �ε����� �Ѿ�� ����
		while(left <= right) {
			//B�迭�� ��� �ε����� ����
			int mid = (left+right)/2;
			//B�迭�� ������� A�� ��Ұ� ū��� left�� �ε����� mid ���� 1����
			//result �� ��� ��Ҹ� ���� �� �ִ��� �����ϴ°��̹Ƿ� B�� �ε����� 0���� �����ϹǷ�
			//mid +1 �������
			if(B[mid] < x) {
				result = mid + 1;
				left = mid + 1;
			//B�迭�� mid ���� �۴ٸ� �� ������ index �� mid-1 ����
			}else {
				right = mid - 1;
			}
		}
		//��� ��Ҹ����� �� �ִ����� ���� �迭�� return ���ָ�
		//pro() �Լ��� �����ϴ� ans ������ �����
		return result;
	}
	
	static void pro() {
		//B�迭�� ��������
		Arrays.sort(B);
		int ans = 0;
		//��� A�迭��ҿ� ���� B�迭�� ���ؼ� �̺�Ž�� ����
		for(int i = 0 ; i < A.length ; i++) {
			ans += bin_sear(0, B.length-1, A[i]);
		}
		//���
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while(t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int asize = Integer.parseInt(st.nextToken());
			int bsize = Integer.parseInt(st.nextToken());
			A = new int[asize];
			B = new int[bsize];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < asize ; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < bsize ; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			pro();
			
			t--;
		}

	}

}
