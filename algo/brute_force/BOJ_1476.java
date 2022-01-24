package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_1476 {

	static int E;
	static int S;
	static int M;
	
	static void pro() {
		int count = 1;
		int e = 1;
		int s = 1;
		int m = 1;
		while(true) {
			if(E == e && s == S && M == m) {
				break;
			}
			
			if(e+1<=15) {
				e++;
			}else {
				e = 1;
			}
			
			if(s+1 <= 28) {
				s++;
			}else {
				s = 1;
			}
			
			if(m+1 <= 19) {
				m++;
			}else {
				m = 1;
			}
			
			count++;
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pro();
	}

}
