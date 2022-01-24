package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_1759 {

	static int l;
	static int c;
	static String[] str;
	static String[] answer;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	
	static void rec_func(int k, int start, int mo, int ja) {
		if(k == l) {
			if(mo >= 1 && ja >= 2) {
				for(int i = 0 ; i < l ; i++) {
					sb.append(answer[i]);
				}
				sb.append("\n");
			}
		}else {
			for(int i = start ; i < c ;i++) {
				if(visited[i] == false) {
					answer[k] = str[i];
					
					boolean a = false;
					
					if(answer[k].contains("a")) {
						mo++;
					}else if(answer[k].contains("e")) {
						mo++;
					}else if(answer[k].contains("i")) {
						mo++;
					}else if(answer[k].contains("o")) {
						mo++;
					}else if(answer[k].contains("u")) {
						mo++;
					}else {
						ja++;
						a = true;
					}
					visited[i] = true;
					rec_func(k+1,i+1, mo, ja);
					visited[i] = false;
					if(a) {
						ja--;
						a = false;
					}else {
						mo--;
					}
					
				}
			}
		}
	}
	
	static void pro() {
		Arrays.sort(str);
		rec_func(0,0,0,0);
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		str = new String[c];
		answer = new String[l];
		visited = new boolean[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < c ; i++) {
			str[i] = st.nextToken();
		}
		pro();
		
	}

}
