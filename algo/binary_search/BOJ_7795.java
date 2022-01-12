
/*
 * 
 */
import java.io.*;
import java.util.*;

public class BOJ_7795 {

	static int A[];
	static int B[];
	//testcase 개수
	static int t;
	
	static int bin_sear(int left, int right, int x) {
		//result 는 B의 몇개의 요소를 먹을 수 있는지를 저장할 변수
		int result = 0;
		
		//이분탐색의 성격상 왼쪽 인덱스가 오른쪽 인덱스를 넘어가면 종료
		while(left <= right) {
			//B배열의 가운데 인덱스를 조사
			int mid = (left+right)/2;
			//B배열의 가운데보다 A의 요소가 큰경우 left의 인덱스를 mid 보다 1증가
			//result 는 몇개의 요소를 먹을 수 있는지 선택하는것이므로 B의 인덱스는 0부터 시작하므로
			//mid +1 해줘야함
			if(B[mid] < x) {
				result = mid + 1;
				left = mid + 1;
			//B배열의 mid 보다 작다면 맨 오른쪽 index 를 mid-1 해줌
			}else {
				right = mid - 1;
			}
		}
		//몇개의 요소를먹을 수 있는지를 담은 배열을 return 해주면
		//pro() 함수에 존재하는 ans 변수에 저장됨
		return result;
	}
	
	static void pro() {
		//B배열을 정렬해줌
		Arrays.sort(B);
		int ans = 0;
		//모든 A배열요소에 대해 B배열에 대해서 이분탐색 진행
		for(int i = 0 ; i < A.length ; i++) {
			ans += bin_sear(0, B.length-1, A[i]);
		}
		//출력
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while(t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int asize = Integer.parseInt(st.nextToken());
			int bsize = Integer.parseInt(st.nextToken());
			A = new int[asize];
			B = new int[bsize];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < asize ; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < bsize ; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			pro();
			
			t--;
		}

	}

}
