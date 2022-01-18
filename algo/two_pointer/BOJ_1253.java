
/*
 *	정렬을 하고 시작한다.
 *	pro 함수에서 인덱스를 하나씩 two_pointer 함수에 보낸다
 *	모든 배열을 검사하는데 두개를 집어야 하므로 투포인터를 사용한다.
 *	왼쪽과 오른쪽 끝에서 시작하며 왼쪽포인터나 오른쪽 포인터가 이미 선택된 인덱스를 가르키면 안된므로 이를 if문으로 걸러낸다
 *	그다음 둘이 더한 값이 내가 보낸 인덱스가 가르키는 값보다 크다면 오른쪽 포인터의 인덱스를 하나 내려주면서 검사한다.
 *	반대로 둘이 더한 값이 내가 보낸 인덱스가 가르키는 값보다 작다면 왼쪽 포인터의 인덱스를 하나 늘린다.
 *	둘이 더한 값이 같다면 바로 return 을 해주도록 하고 모든 while 문을 빠져나왔는데도 찾지 못했다면 false 를 리턴해준다.
 *	
 *	추가로 배열의 모든 값을 확인하고 하나 확인할때마다 n의 시간이 걸리므로 총 n^2 의 시간이 걸리게된다.
 *	배열의 길이는 2000 이므로 4000000 의 시간복잡도를 가지며 이는 시간제한 2초를 넘지 않는다.  
 */

import java.io.*;
import java.util.*;

public class BOJ_1253 {

	static int n;
	static int arr[];
	
	static boolean two_pointer(int index) {
		int left = 0;
		int right = arr.length-1;
		
		while(left < right) {
			
			if(left == index) {
				left++;
			}else if(right == index) {
				right --;
			}else if(arr[left]+arr[right] == arr[index]) {
				return true;
			}else if(arr[left]+arr[right] > arr[index]) {
				right --;
			}else {
				left++;
			}
			
		}
		return false;
	}
	
	static void pro() {
		
		int answer = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(two_pointer(i)) {
				answer++;
			}
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
		Arrays.sort(arr);
		pro();
		
		
		
	}
}
