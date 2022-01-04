package brute_force;

import java.util.*;
import java.io.*;

//1부터 n 까지의 자연수 중에서 m 개를 선택해 오름차순 출력하고 !중복을 허용!
public class BOJ_15651 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int m;
	static int selected[];
	
	
	static void rec_func(int k) {
		if(k == m+1) {
			for(int i = 1 ; i <= m ; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		}else {
			for(int i = 1 ; i <=n ; i++) {
				selected[k] = i;
				rec_func(k+1);
				selected[k]=0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m+1];
		
		//실행
		rec_func(1);
		System.out.println(sb.toString());
	}

}
