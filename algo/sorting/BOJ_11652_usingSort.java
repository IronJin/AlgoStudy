import java.io.*;
import java.util.*;

/*
 *  11652 카드 문제는 정렬을 이용해서 풀수도 있고 해쉬맵을 이용해서 풀수도 있다.
 *  이 방법은 정렬을 이용해 푸는 방법이다. 
 *  정렬 후 처음부터 똑같은 값이 나오면 카운트를 해주다가 값이 바뀌게 되면 카운트한 값과 그 전에 저장되어 있던
 *  max 값을 비교하여 크면 그때의 카드의 숫자를 answer 에 넣어주는 방식
 */
public class BOJ_11652_usingSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long arr[] = new long[t];
		
		for(int i = 0 ; i < t ; i++) {
			long l = Long.parseLong(br.readLine());
			arr[i] = l;
		}
		
		Arrays.sort(arr);
		
		long cur = Long.MIN_VALUE;
		int count = 0;
		int max = 0;
		long answer = 0;
		
		for(int i = 0 ; i < t ; i++) {
			if(arr[i] != cur) {
				if(count > max) {
					answer = cur;
					max = count;
				}
				count = 1;
				cur = arr[i];
			}else {
				count++;
			}
		}
		
		//예외처리부분
		//처음부터 배열의 끝까지 똑같은 숫자일 경우 위의 포문에서 answer 에 값이 들어가지 않음
		if(count > max) {
			answer = cur;
			max = count;
		}
		
		
		System.out.println(answer);
	}

}
