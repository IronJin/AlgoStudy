
//상한액을 컨트롤 하는 것이 주가 되는 문제
//생각보다 쉬운 문제지만 para 함수를 구현하지 못해 틀린 문제 ㅠㅠ
//right 는 배열중에서 가장 큰값부터 시작하면됨

/*
 * 틀렸던 부분 종합
 * left 와 right 의 범위는 left는 문제에서 n<= left 라고 정해주었으므로 n부터 시작함
 * max 값을 설정해주지 않고 right를 m부터 시작함
 * para함수의 기본로직을 계산하지 않았음
 */


import java.io.*;
import java.util.*;

public class BOJ_2512 {

	static int n;
	static int arr[];
	static int m;
	static int max = 0;
	
	//x가 의미하는 것은 최대 상한액을 의미함
	static boolean para(int x) {
		
		int sum = 0;
		for(int i = 0  ; i < n ; i++) {
			sum += Math.min(x, arr[i]);
		}
		
		//최대 상한액을 정해놓고 그 값이 정해진 예산액을 넘지않으면 true를 반납하면됨
		return sum <= m;
	}
	
	static void pro() {
		int left = 0;
		int right = max;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(para(mid)) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		m = Integer.parseInt(br.readLine());
		pro();
	}

}
