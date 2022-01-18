//문제풀이 방법
/*
 * 똑같은 원소가 있는지 검사하기 위해서는 right 포인터가 이동할때 가르키는 원소가 
 * 수열 1 부터 100000 사이에 나타나는지 확인해야함
 * 즉, 없으면 1부터 100000 의 인덱스를 가지는 배열에 1을 증가시켜주고 있으면 right 는 이동을 하지 않는다.
	##추가적인 팁 : 수열의 길이가 100000이 최대이고 수는 1부터 10만까지 존재하므로 모두 다 다른 수라고 가정할때
	50억의 경우가 나온다. 즉 답은 int범위를 넘어가므로 long 으로 표현해야한다.
 */


import java.io.*;
import java.util.*;


public class BOJ_13144 {

	static int n;
	static int arr[];
	static int counting[] = new int[100001];
	
	static void pro() {
		long answer = 0;
		
		for(int left = 0, right = -1 ; left < n ; left++) {
			while (right+1 <= n-1 && counting[arr[right+1]] == 0) {
				right ++;
				counting[arr[right]] ++;
			}
			
			answer += right - left + 1;
			
			counting[arr[left]]--;
			
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
		
		
	}
}
