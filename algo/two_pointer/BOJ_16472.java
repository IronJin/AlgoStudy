
/*
 * 문제풀이 방법
 * 1. count 변수는 현재 서로다른 문자가 몇개인지 세어주는 변수이다.
 * 2. a는 97부터 시작하므로 배열을 26개 선언해놓음
 * 3. 두포인터를 사용하고 오른쪽 포인터의 + 1 이 입력된 문자열의 범위에 속하는지 확인
 * 4. 속한다면 오른쪽 포인터의 + 1 이 가르키는 문자가 배열에 존재하고 있는 값인지 확인
 * 4-1. 만약 존재하고 있다면 그냥 그대로 right++ 해주고 알파벳을 다루는 배열을 하나 증가시킴
 * 4-2. 만약 존재하지 않는다면 일단 카운트 변수를 하나 증가시켜보고 n보다 작거나 같으면 오른쪽 포인터를 증가시키고 해당 문자를 관리하는 배열을 1 증가시킴
 * 4-3. 카운트 변수를 하나 증가시켰는데 n을 넘어간다면 증가시킨 카운트를 원래대로 돌려주고 더이상 right 를 늘릴 필요없이 반복문 탈출
 * 5. right - left + 1 이 n개의 서로다른 알파벳을 선택햇을때의 길이고 최대를 answer와 비교해 구함
 * 6. 그다음 left 포인터를 하나 증가시켜야 하므로 현재 left 포인터가 가르키고 있는 알파벳의 배열을 하나 감소시킴
 * 6-1. 감소시켰는데 그 배열의 값이 0이라면 count를 빼줌(0이 아니라는것은 아직 똑같은 문자가 남아있으므로 서로다른 알파벳의 개수를 가리키는 count 변수는 빼줄 필요가 없음)
 */

import java.io.*;
import java.util.*;

public class BOJ_16472 {

	static int n;
	static String str;
	static int arr[] = new int[26];
	
	static void pro() {
		int answer = Integer.MIN_VALUE;
		int right = -1;
		int count = 0;
		for(int left = 0 ; left < str.length() ; left++) {

			while(right+1 <= str.length()-1) {
				if(arr[str.charAt(right+1)-97] == 0) {
					count++;
					if(count <= n) {
						right++;
						arr[str.charAt(right)-97]++;
					}else {
						count--;
						break;
					}
				}else {
					right++;
					arr[str.charAt(right)-97]++;
				}
			}
			
			int length = right - left + 1;
			answer = Math.max(answer, length);
			arr[str.charAt(left)-97]--;
			if(arr[str.charAt(left)-97] == 0) {
				count--;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		pro();
		
		
	}
}
