package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_2231 {

	static int n;
	static int answer = 0;
	
	static void rec_func(int k) {
		int rec_number = k;
		if(k == n) {
			answer = 0;
		}else {
			int sum = 0;
			sum += k;
			while(k > 0) {
				sum += k % 10;
				k = k /10;
			}
			if(sum == n) {
				answer = rec_number;
				return;
			}else {
				rec_func(rec_number+1);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		rec_func(1);
		System.out.println(answer);
	}

}
