package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_1120 {

	static String a;
	static String b;
	static int alength;
	static int blength;
	static int diff;
	
	static void pro() {
		int answer = Integer.MAX_VALUE;
		diff = blength - alength;
		for(int i = 0 ; i <= diff ; i++) {
			int count = 0;
			int astart = 0;
			int bstart = i;
			while(astart < alength) {
				if(a.charAt(astart) != b.charAt(bstart)) {
					count++;
				}
				astart++;
				bstart++;
			}
			answer = Math.min(count, answer);
		}
		System.out.println(answer);
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = st.nextToken();
		b = st.nextToken();
		alength = a.length();
		blength = b.length();
		
		pro();
	}

}
