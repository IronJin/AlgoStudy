package brute_force;

import java.util.*;
import java.io.*;

//1부터 n 까지의 숫자를 선택
//m개의 숫자를 선택
public class BOJ_15649 {

	static int n;
	static int m;
	static int selected[];
	static boolean used[];
	static StringBuilder sb = new StringBuilder();
	
	static void rec_func(int k) {
		if(k == m+1) {
			for(int i = 1 ; i <= m ; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		}else {
			for(int i = 1 ; i <= n ;i++) {
				if(used[i]) {
					continue;
				}
				selected[k] = i;
				used[i] = true;
				rec_func(k+1);
				used[i] = false;
				selected[k] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m+1];
		used = new boolean[n+1];
		rec_func(1);
		System.out.println(sb);
	}

}
