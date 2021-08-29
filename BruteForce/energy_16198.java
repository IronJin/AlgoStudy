package brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class energy_16198 {

	static int n;
	static boolean check[];
	static int[] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(0,n);
		
		System.out.println(pq.poll());
	}
	
	public static void dfs(int sum ,int length) {
		if(length == 2) {
			pq.add(sum);
		}
		
		for(int i = 1 ; i < list.size()-1 ; i++) {
			int a = list.get(i-1);
			int b = list.get(i+1);
			int c = list.get(i);
			list.remove(i);
			dfs(sum+a*b,length -1);
			list.add(i, c);
		}
	}

}
