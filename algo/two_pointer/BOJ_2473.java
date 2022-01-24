
//투포인터로도 풀 수 있고 이분탐색으로도 풀 수 있다.
//이 풀이는 이분탐색으로 푼 풀이

//틀린이유 : 용액의 범위는 10억이고 세개의 용액을 더할시 30억이다. 즉, int 범위를 초과하게 된다.
//이때 세 용액의 합을 담는 변수를 제외한 나머지 변수는 int 형인데 int 형을 더해 long 에 담으려고 할때 오류가 난다.
//따라서 int 끼리 더해 long 변수에 넣어줄때에는 int 변수 앞에 (long)을 붙여 연산을 하도록 한다.

import java.io.*;
import java.util.*;

public class BOJ_2473 {

	static int n;
	static int arr[];
	
	static void pro() {
		
		long answer = Long.MAX_VALUE;
		int leftvalue = 0;
		int middle = 0;
		int rightvalue = 0;
		
		for(int i = 0 ; i < n-2 ; i++) {
			for(int j = i+1 ; j < n-1 ; j++) {
				int left = j+1;
				int right = n-1;
				while(left <= right) {
					int mid = (left + right)/2;
					if(arr[mid] < -(arr[i]+arr[j])) {
						left = mid + 1;
					}else {
						right = mid - 1;
					}
				}
				
				if(j+1 <= left && left <= n-1 && answer >= Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left])) {
					answer = Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left]);
					leftvalue = arr[i];
					middle = arr[j];
					rightvalue = arr[left];
				}
				
				if(left - 1 >= j+1 && left - 1 <= n-1 && answer >= Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left-1])) {
					answer = Math.abs((long)arr[i] + (long)arr[j] + (long)arr[left-1]);
					leftvalue = arr[i];
					middle = arr[j];
					rightvalue = arr[left-1];
				}
				
			}
			
		}
		System.out.println(leftvalue+" "+middle+" "+rightvalue);
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		pro();
	}

}
