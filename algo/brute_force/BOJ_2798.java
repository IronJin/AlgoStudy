package brute_force;

import java.util.*;
import java.io.*;

public class BOJ_2798 {

	static int t;
	static int total;
	static int number[];
	static int answer;
	static int used[];
	static int selected[] = new int[3];
	static int min = Integer.MAX_VALUE;
	
	static void rec_func(int depth) {
		if(depth == 3) {
			int sum = 0;
			for(int i = 0 ; i < 3 ; i++) {
				sum += selected[i];
			}
			if(min >= Math.abs(sum-total) && total >= sum) {
				answer = sum;
				min = total - sum;
			}
		}else {
			for(int i = 0 ; i < t ; i++) {
				if(used[i] == 1) {
					continue;
				}else {
					used[i] = 1;
					selected[depth] = number[i];
					rec_func(depth+1);
					used[i] = 0;
					selected[depth] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		//입력 부분----------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());
		total = Integer.parseInt(st.nextToken());
		number = new int[t];
		used = new int[t];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < t ; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝--------------------
		
		rec_func(0);
		System.out.println(answer);
		
		
		
	}

}
