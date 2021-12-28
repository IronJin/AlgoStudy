package algoprac;

import java.util.*;

/*
 * 버블정렬이란 n-1 번 서로 인접한 요소들을 비교해가며 자리를 바꿔준다.
 * 이 때 outer for문이 한번 진행될때마다 배열의 맨 마지막 index 는 이미 정렬이 끝나서
 * 가장 큰 값이 오게 되므로 한칸씩 줄여나가며 정렬 범위를 좁힌다.
 */
public class bubble_sort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < 10 ; i++) {
			list.add((int) (Math.random()*100));
		}
		
		//버블정렬의 핵심
		for(int j = list.size()-1 ; j >= 1 ; j--) {
			boolean swap = false;
			for(int i = 0 ; i < j ; i++) {
				if(list.get(i) > list.get(i+1)) {
					Collections.swap(list, i, i+1);
					swap = true;
				}
			}
			if(swap == false) {
				break;
			}
		}
		
		//ArrayList 의 경우 내장된 메소드인 Collections.sort(); 를 사용해도 됨
		Collections.sort(list);
		
		
		System.out.println(list);
	}

}
