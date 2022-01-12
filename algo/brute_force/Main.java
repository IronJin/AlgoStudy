package brute_force;
import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int arr[][];
	static int used[];
	static int red;
	static int blue;
	static int answer = Integer.MAX_VALUE;
	
	static void rec1(int depth, int k) {
		if(depth == n/2) {
			red = 0;
			blue = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(used[i] == 1 && used[j] == 1) {
						red += arr[i][j];
					}else if(used[i] == 0 && used[j] == 0) {
						blue += arr[i][j];
					}
				}
			}
			answer = Math.min(answer, Math.abs(red- blue));
			return;
			//System.out.println(red);
		}
		for(int i = k ; i < n ; i++) {
			if(used[i] == 0) {
				used[i] = 1;
				rec1(depth+1, i+1);
				used[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		used = new int[n];
		used[0] = 1;
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rec1(1,1);
		System.out.println(answer);
		
		
	}

}
