import java.io.*;
import java.util.*;

public class BOJ_2230 {

	static int n;
	static int m;
	static int arr[];
	
	static void pro() {
		int answer = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		
		//right < n 으로써 right 가 n이 넘어가면 투포인터탐색을 종료하도록 설정해줬어야 하나
		//이 부분을 간과하고 for문으로 해결하려고 함
		while(right < n) {
			if(arr[right] - arr[left] < m) {
				right++;
			}else {
				answer = Math.min(answer, arr[right] - arr[left]);
				//right 와 left 가 같다는것은 0을 의미하고 이는 더이상 작은게 나오지 않는다는 뜻을 의미하므로
				//더이상 투포인터 탐색을 진행하지 않아도 됨
				if(right == left) {
					break;
				//그게 아니라면 left 를 증가시키고 right 와 left 를 뺀 값을 비교하여 반복문에 맞게 진행하도록함
				}else {
					left++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		pro();
		
	}

}
