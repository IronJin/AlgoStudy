/*
 * **LIS 알고리즘을 이용해 구해야함
 * LIS 알고리즘은 가장 긴 부분수열의 크기를 구하는 알고리즘으로써
 * 리스트의 맨 앞에 0을 넣어주고 배열에서 처음부터 하나씩 뽑은 다음
 * 리스트의 맨 마지막 값과 비교해 크면 그냥 그대로 리스트에 추가해주고 그게 아니라면
 * 리스트에서 들어갈 자리의 INDEX 를 구해 그 자리의 값과 바꿔주는 방식으로 진행해나간다.
 */

import java.io.*;
import java.util.*;

public class BOJ_12015 {

	static int n;
	static int arr[];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	static void pro() {
		list.add(0);
		
		for(int i = 0 ; i < n ; i++) {
			int value = arr[i];
			if(value > list.get(list.size()-1)) {
				list.add(value);
			}else {
				int left = 1;
				int right = list.size()-1;
				int index = right;
				while(left <= right) {
					int mid = (left + right)/2;
					if(list.get(mid) < value) {
						left = mid + 1;
					}else {
						right = mid-1;

					}
				}
				list.set(left, value);
			}
		}
		System.out.println(list);
		System.out.println(list.size()-1);
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
