
//간단한 투포인터 문제

import java.io.*;
import java.util.*;

public class BOJ_2003 {

	static int n;
	static int m;
	static int arr[];
	
	static void pro() {
		
		int count = 0;
		int sum = 0;
		
		for(int left = 0 , right = -1 ; left < n ; left++) {
			
			//sum < m 이 중요한 이유는 sum 이 m 을 넘었을때 left 에 있는것을 빼가지고 sum == m 이 될수도 있기 때문
			while(right + 1 < n && sum < m) {
				right++;
				sum += arr[right];
				if(sum > m) {
					break;
				}else if(sum == m) {
					//System.out.println(left+" "+right);
					count++;
				}
			}
			sum -= arr[left];
			if(sum == m) {
				//System.out.println(left+" "+right);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
	}

}
