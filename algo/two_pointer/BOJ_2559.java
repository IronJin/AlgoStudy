
import java.io.*;
import java.util.*;

public class BOJ_2559 {

	static int n;
	static int k;
	static int arr[];
	
	static void pro() {
		int answer = 0;
		int left = 0;
		int sum = 0;
		for(int i = 0 ; i <= k-1 ; i++) {
			answer += arr[i];
			sum += arr[i];
		}
		for(int right = k ; right < n ; right++) {
			sum += arr[right];
			sum -= arr[left];
			left++;
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
		
	}

}
