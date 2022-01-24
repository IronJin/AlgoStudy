
/*
 * 에라토스테네스의 체(소수판정 알고리즘) 을 사용했음
 * 에라토스테네스의 체는 꼭 외워야할 알고리즘임
 */

import java.io.*;
import java.util.*;

public class BOJ_1644 {

	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean arr[];
	
	static void che() {
		
		//true 이면 소수가 아님
		for(int i = 2 ; i*i <= n ; i++) {
			for(int j = i*i ; j <= n ; j+=i) {
				arr[j] = true;
			}
		}
		
		for(int i = 2 ; i <= n ; i++) {
			if(arr[i] == false) {
				list.add(i);
			}
		}
		
	}
	
	static void pro() {
		//소수를 구해서 list 에 넣어줌
		che();
		
		int count = 0;
		int sum = 0;
		//투포인터 사용해서 값을 구함.
		for(int left = 0, right = -1 ; left < list.size(); left++) {
			
			while(right + 1 <= list.size()-1 && sum < n) {
				right++;
				sum += list.get(right);
			}
			
			if(sum == n) {
				count++;
			}
			
			sum -= list.get(left);
			
		}
		
		System.out.println(count);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n+1];
		pro();

	}

}
