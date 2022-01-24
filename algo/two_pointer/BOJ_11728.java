//A배열과 B배열에 포인터를 하나씩 두고 비교하며 새로운 배열에 넣어주면됨

import java.io.*;
import java.util.*;

public class BOJ_11728 {

	static int n;
	static int m;
	static int A[];
	static int B[];
	//static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void pro() {
		int Apointer = 0;
		int Bpointer = 0;
		
		while(Apointer <= n-1 && Bpointer <= m-1) {
			if(A[Apointer] <= B[Bpointer]) {
				sb.append(A[Apointer]).append(" ");
				Apointer++;
			}else {
				sb.append(B[Bpointer]).append(" ");
				Bpointer++;
			}
		}
		
		if(Apointer <= n-1) {
			for(int i = Apointer ; i < n ; i++) {
				sb.append(A[i]).append(" ");
			}
		}
		
		if(Bpointer <= m-1) {
			for(int i = Bpointer ; i < m ; i++) {
				sb.append(B[i]).append(" ");
			}
		}
		
		//for(int i = 0 ; i < list.size() ;i++) {
		//	System.out.print(list.get(i)+" ");
		//}
		System.out.print(sb.toString());
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n];
		B = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B);

		pro();
		
	}

}
