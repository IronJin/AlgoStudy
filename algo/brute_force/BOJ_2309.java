package brute_force;

import java.io.*;
import java.util.*;
public class BOJ_2309 {

	static int height[] = new int[9];
	static boolean used[] = new boolean[9];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	static void rec_func(int sum, int depth) {
		
		if(sum > 100) {
			return;
		}else if(depth > 8) {
			return;
		}else if(depth < 8 && sum == 100) {
			return;
		}
		
		if(sum == 100 && depth == 8) {
			for(int i = 0 ; i < 9 ; i ++) {
				if(used[i] == true) {
					list.add(height[i]);
				}
				Collections.sort(list);
			}
			for(int j = 0 ; j < list.size(); j++) {
				System.out.println(list.get(j));
			}
			System.exit(0);
		}else {
			for(int i = 0 ; i < 9 ; i++) {
				if(used[i]) {
					continue;
				}else {
					sum += height[i];
					used[i] = true;
					rec_func(sum, depth+1);
					used[i] = false;
					sum -= height[i];
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		rec_func(0, 1);
	}
}
