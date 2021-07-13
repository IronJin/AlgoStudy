package codingtest;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static int function(int a, int b, int c) {

		int ans = a;
		int count = 0;
		if(b>c) {
			return -1;
		}else {
			count = a/(c-b);
			return count+1;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(function(a,b,c));
	}

}
