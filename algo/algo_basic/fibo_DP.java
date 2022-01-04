package algoprac;

import java.io.*;

//������ȹ��(memoization) ����� ����Ͽ� �Ǻ���ġ �������
public class fibo_DP {

	static int[] data;
	
	public static void fibo(int n) {
		data[0] = 0;
		data[1] = 1;
		for(int i = 2 ; i < n+1 ; i++) {
			data[i] = data[i-1] + data[i-2];
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�Է� : ");
		int n = Integer.parseInt(br.readLine());
		
		data = new int[n+1];
		
		if(n == 0) {
			System.out.println(0);
		}else if(n==1) {
			System.out.println(1);
		}else {
			fibo(n);
			System.out.println(data[n]);
		}
	}

}
