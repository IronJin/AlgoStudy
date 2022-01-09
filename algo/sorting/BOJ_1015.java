import java.io.*;
import java.util.*;

public class BOJ_1015 {

	static int n;
	static int array[][];
	/*
	 * 1. array[i][0] 에 A배열의 값들을 차례대로 넣어주고 array[i][1] 에 그 당시의 index를 기억하고 있어줌
	 * 2. array[i][0] 을 기준으로 정렬을 진행한 후 array[i][2] 에 index를 차례대로 기입
	 * 3. array[i][1] 을 기준으로 다시 오름차순 정렬을 해주면 수열P 에 해당하는 값이 원래 기입된 원소순으로 출력된다.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		array = new int[n][3];
		for(int i = 0 ; i < array.length ;i++) {
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = i;
		}
		
		
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for(int i = 0 ; i < array.length ; i++) {
			array[i][2] = i;
		}
		
		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i][2]+" ");
		}
	}
}
