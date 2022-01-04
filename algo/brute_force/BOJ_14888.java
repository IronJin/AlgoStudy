package brute_force;

import java.io.*;
import java.util.*;

//연산자 끼워넣기
public class BOJ_14888 {

	static int t;
	static int number[];
	
	//+, -, x, /
	static int operation[] = new int[4];
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void rec_func(int current, int k) {
		if(k == t) {
			if(current >= max) {
				max = current;
			}
			if(current <= min) {
				min = current;
			}
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				if(operation[i] == 0) {
					continue;
				}else {
					int candi = current;
					if(i == 0) {
						current = current + number[k];
					}else if(i == 1) {
						current = current - number[k];
					}else if(i == 2) {
						current = current * number[k];
					}else {
						current = current / number[k];
					}
					operation[i]--;
					rec_func(current, k+1);
					current = candi;
					operation[i]++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//첫째줄 입력
		t = Integer.parseInt(st.nextToken());
		number = new int[t];
		
		//둘째줄 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < number.length ; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		//새번째줄 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < operation.length ; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		
		int current = number[0];
		rec_func(current, 1);
		System.out.println(max);
		System.out.println(min);

	}
}
