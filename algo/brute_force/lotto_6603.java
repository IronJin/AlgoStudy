package brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class lotto_6603 {

	static int n;
	static int arr[];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		while(true) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			if(n == 0) {
				break;
			}
			arr = new int[n];
			check = new boolean[n];
			
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
		}
	}
	
	public static void dfs(int line, int depth) {
		
		if(depth == 6) {
			for(int i = 0 ; i < n ; i++) {
				if(check[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
		}
		
		for(int i = line ; i < n ; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(i+1,depth+1);
				check[i] = false;
			}
		}
	}

	
	
}
