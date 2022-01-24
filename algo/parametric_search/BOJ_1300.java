import java.io.*;
import java.util.*;

//� ���� �־������� �װͺ��� ���� ���� ������ B�迭���� K��°�� ��ġ�ϴ� ���� ��

public class BOJ_1300 {

	static int n;
	static int k;
	
	static boolean para(int x) {
		int cnt = 0;
		for(int i = 1 ; i <= n ; i++) {
			cnt += Math.min(x/i, n);
		}
		return cnt >= k;
	}
	
	static void pro() {
		int left = 1;
		int right = k;
		int answer = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(para(mid)) {
				right = mid - 1;
				answer = mid;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		pro();
	}

}
