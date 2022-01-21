
import java.io.*;
import java.util.*;


public class BOJ_15565 {

	static int n;
	static int k;
	static int arr[];
	static int answer = -1;
	
	static void pro() {

		int right = -1;
		int count = 0;
		
		
		for(int left = 0 ; left < n ; left++) {
			
			
			while(right+1 < n && count < k) {
				right++;
				if(arr[right] == 1) {
					count++;
				}
			}
			
			//내가 틀렸던 부분
			//만약 k 는 2이고 배열내에 1이 하나밖에 없을때 -1 을 출력해야함
			//즉, count == k 를 만족하지 못한다면 answer 는 처음부터 -1 인 상태로 존재해야함
			//만약, count == k 를 만족하는 경우 answer 가 -1 일때는 answer에 처음 length를 설정해줘야함
			//그게 아니라면 최소 집합 크기를 구해야함
			if(count == k) {
				if(answer == -1) {
					answer = right - left + 1;
				}else {
					answer = Math.min(answer, right - left + 1);
				}
			}
			//System.out.println(right +" "+left);
			//System.out.println(answer);
			
			//아직 더 돌아갈수 있는 경우, 즉 left 는 하나 증가해야하는데 현재 위치한 left 에 존재하는 값이 1이라면
			//count에서 하나 빼줘야함
			if(arr[left] == 1) {
				count--;
			}
			
			//right 가 이미 끝까지 도달했고 count 가 k보다 작은경우 더이상 만족하는 집합이 없으므로
			//반복문을 종료하여도 됨
			if(right == n-1 && count < k) {
				break;
			}
	
		}//for문 종료
		
		//답 출력
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		

		
	}

}
