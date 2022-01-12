import java.io.*;
import java.util.*;

/*
 * 문제풀이 방법
 * 1. 점의 위치와 색깔을 입력으로 받으므로 이를 2차원배열로 저장한다.
 * 2. 같은 색에대해서만 확인을 하면되므로 2차원 배열을 색깔 순으로 정리한 후 같은색에 대해서는 위치순으로 정렬한다.
 * 3. 한 점을 선택하고 그 양 옆의 점만 확인해주면된다. 그게 가장 가까운 점이기 때문이다.
 * 4-1. 양 옆에 똑같은 색의 점을 가지고 있는지 확인하고 똑같은 색을 가지고 있는경우 둘 중 더 가까운것을 answer변수에 넣어준다
 * 4-2. 다음 배열에 오는 점은 색이 다른 경우 그냥 그 전 인덱스에 위치한 배열의 위치와 현재 점의 위치를 빼주고 answer 에 넣어준다.
 * 4-3. 다음 인덱스의 배열과 현재 인덱스의 배열의 색이 같지만 그 전의 인덱스 배열의 색과는 다른경우 다음 인덱스와 현재 인덱스 점의 위치만 빼서 answer에 더해준다.
 * 5. 맨 처음 인덱스의 점과 맨 마지막 인덱스의 점은 그 다음 점과 그 전의 점과의 거리를 구해주면 되므로 위의 연산을 다 하고난 후 마지막에 그냥 answer에 더해준다. 
 */

public class BOJ_15970 {

	static int t;
	static int arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		arr = new int[t][2];
		
		for(int i = 0 ; i < t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
			
		});

		int answer = 0;
		
		for(int i = 1 ; i < t-1 ; i++) {
			if(arr[i+1][1] == arr[i][1] && arr[i][1] == arr[i-1][1]) {
				answer += Math.min(Math.abs(arr[i][0] - arr[i+1][0]), Math.abs(arr[i-1][0] - arr[i][0]));
			}else if(arr[i][1] != arr[i+1][1]) {
				answer += arr[i][0] - arr[i-1][0];
			}else {
				answer += arr[i+1][0] - arr[i][0];
			}
		}
		answer += arr[1][0] - arr[0][0];
		answer += arr[t-1][0] - arr[t-2][0];
		
		System.out.println(answer);
	}

}
