package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_7568 {

	static int info[][];
	static int length;
	
	static void func(int currow) {
		if(currow == length-1) {
			return;
		}
		
		for(int i = currow ; i < length; i ++) {
			if(i == currow) {
				continue;
			}
			
			if(info[i][0] > info[currow][0] && info[i][1] > info[currow][1]) {
				info[currow][2] ++;
			}else if(info[i][0] < info[currow][0] && info[i][1] < info[currow][1]) {
				info[i][2]++;
			}
		}
		func(currow+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());
		info = new int[length][3];
		for(int i = 0 ; i < length ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		func(0);
		for(int i = 0 ; i < length ; i++) {
			info[i][2]++;
			System.out.print(info[i][2]+" ");
		}
		
	}
}
