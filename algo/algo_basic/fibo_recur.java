package algoprac;

import java.util.*;

//����Լ��� �̿��Ͽ� �Ǻ���ġ ������ Ǯ���
//fibo(0) = 0
//fibo(1) = 1
public class fibo_recur {

	public static int fibo(int n) {
		
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			return fibo(n-1) + fibo(n-2);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = fibo(5);
		System.out.println(answer);
	}

}
