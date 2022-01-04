package algoprac;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 전체 데이터를 반으로 나눈다음 찾고자 하는 데이터보다 크면 위쪽
 * 작으면 앞쪽 배열로 이동한다음 그곳에서 또 반으로나누어 반복해내 찾아내는 과정
 */
public class binary_search {

	public static boolean bin_sear(ArrayList<Integer> list, int n) {
		if(list.size() <= 1 && n == list.get(0)) {
			return true;
		}
		if(list.size() <= 1 && n != list.get(0)) {
			return false;
		}
		if(list.size() == 0) {
			return false;
		}
		
		int mid = list.size()/2;
		
		if(list.get(mid) == n) {
			return true;
		}else if(list.get(mid) < n) {
			return bin_sear(new ArrayList<Integer>(list.subList(mid, list.size())),n);
		}else {
			return bin_sear(new ArrayList<Integer>(list.subList(0, mid)),n);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 100 ; i++) {
			list.add((int)(Math.random()*100));
		}
		
		Collections.sort(list);
		
		boolean answer = bin_sear(list,30);
		
		System.out.println(answer);

	}

}
