//문제이름 : 두 용액
/*
 * 풀이방법
 * 1. A[i] 를 골랐을때, -A[i] 랑 가장 가까운 값을 최대한 빠르게 찾는게 중요함
 * 2. -A[i]를 찾기위해서는 이분탐색을 이용
 * 3. -A[i] 랑 가장 가까운 원소는 left 와 left-1 에 존재하게됨
 * 3-1. 이유 : -A[i] 가 들어가야할 위치옆에 A[left] 와 A[left-1] 이 존재하기 때문
 * (여기서 말하는 left 는 이분탐색이 끝난후의 left 를 말함)
 */
import java.io.*;
import java.util.*;

public class BOJ_2470 {

	static int n;
	static int arr[];
	
	static void pro() {
		int leftvalue = 0;
		int rightvalue = 0;
		int answer = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i = 0 ; i < n ; i++) {
			int index = bin(arr, i+1, n-1, -arr[i]);
			
			
			//예외처리 사항 : index 가 1번째 index 를 가리키는 경우
			//--> arr[index - 1] 은 arr[0] 이랑 같은값을 가짐
			//예외처리 사항 : index 가 n번째 index 를 가리키는 경우
			//--> arr[index] 는 0부터 n-1 index까지 존재하는 배열에서 에러가남
			
			//예외처리와 index-1 에대 연산하는 과정
			if(i+1 <= index-1 && index-1 <= n-1 && Math.abs(arr[i]+arr[index-1]) < answer) {
				answer = Math.abs(arr[i]+arr[index-1]);
				leftvalue = arr[i];
				rightvalue = arr[index-1];
			}
			
			if(i+1 <= index && index <= n-1 && Math.abs(arr[i]+arr[index])<answer) {
				answer = Math.abs(arr[i] + arr[index]);
				leftvalue = arr[i];
				rightvalue = arr[index];
			}
			
		}
		System.out.println(leftvalue+" "+rightvalue);

	}
	
	static int bin(int A[], int left, int right, int x) {
		
		//이분탐색 진행
		while(left <= right) {
			int mid = (left + right) /2;
			if(A[mid] < x) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pro();
	}
}
