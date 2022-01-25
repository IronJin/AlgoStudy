import java.io.*;
import java.util.*;

public class BOJ_1072 {

	static long x;
	static long y;
	static long z;
	
	static void pro() {
		long left = 1;
		long right = 1000000000;
		long answer = 0;
		while(left <= right) {
			long mid = (left + right)/2;
			if(((y+mid)*100)/(x+mid) > z) {
				answer = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());
		z = (y*100)/x;
		//System.out.println(z);
		if(z >= 99) {
			System.out.println(-1);
		}else {
			pro();
		}
	}

}
