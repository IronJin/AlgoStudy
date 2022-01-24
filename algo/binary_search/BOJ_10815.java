import java.io.*;
import java.util.*;

public class BOJ_10815 {

	static int n;
	static int A[];
	static int m;
	static int B[];
	
	static int bin_sear(int x) {
		int left = 0;
		int right = A.length-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(A[mid] < x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		if(left <= A.length-1 &&A[left] == x) {
			return 1;
		}else {
			return 0;
		}
	}
	
	static void pro() {
		Arrays.sort(A);
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = 0 ; i < m ; i++) {
			answer.add(bin_sear(B[i]));
		}
		
		for(int i = 0 ; i < answer.size() ; i++) {
			System.out.print(answer.get(i) +" ");
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		B = new int[m];
		for(int i = 0 ; i < m ; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();

	}

}
