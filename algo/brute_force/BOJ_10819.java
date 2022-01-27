
/*
 * 백트래킹으로 해결할 수 있는 문제
 * n개의 숫자를 n번 뽑는것이므로 방문체킹을 하면서 안한것을 새로운 배열에 계속해서 넣어주고 방문체킹을 해줌
 * 그리고 depth 가 n번을 만족할때 계산을 수행해주면됨
 */

package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_10819 {

	static int n;
	static int arr[];
	static boolean check[];
	static int calc[];
	static int answer = Integer.MIN_VALUE;
	
	static void track(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 0 ; i < n-1 ; i++) {
				sum += Math.abs(calc[i] - calc[i+1]);
			}
			answer = Math.max(answer, sum);
		}else {
			
			for(int i = 0 ; i < n ; i++) {
				if(check[i] == false) {
					check[i] = true;
					calc[depth] = arr[i];
					track(depth+1);
					check[i] = false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check = new boolean[n];
		calc = new int[n];
		track(0);
		System.out.println(answer);
	}

}
