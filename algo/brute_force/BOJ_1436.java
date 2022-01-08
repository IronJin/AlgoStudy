package brute_force;

import java.io.*;
import java.util.*;


public class BOJ_1436 {

	static int n;
	static int answer=0;
	
	static void func(int count) {
		
		int a = 666;
		
		while(true) {
			if(String.valueOf(a).contains("666")) {
				count++;
			}
			if(count == n) {
				answer = a;
				break;
			}
			a++;
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		func(0);
	}

}
