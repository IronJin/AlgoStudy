import java.io.*;
import java.util.*;

//어떤 길이를 이분탐색으로 결정했을때 랜선 n개를 만들 수 있는지를 검사
//2^23-1 == Integer.MAX_VALUE;
public class BOJ_1654 {

	static int n;
	static int k;
	static int A[];
	
	static boolean parametric(long l) {
		int count = 0;
		for(int i = 0 ; i < k ; i++) {
			count += A[i]/l;
		}
		return count >= n;
	}
	
	static void pro() {
		long left = 1;
		long right = Integer.MAX_VALUE;
		while(left <= right) {
			long mid = (left + right)/2;
			if(parametric(mid)) {
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		A = new int[k];
		for(int i = 0 ; i < k ; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		pro();
		
	}
}
