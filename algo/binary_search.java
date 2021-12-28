package algoprac;

import java.util.ArrayList;
import java.util.Collections;

/*
 * ��ü �����͸� ������ �������� ã���� �ϴ� �����ͺ��� ũ�� ����
 * ������ ���� �迭�� �̵��Ѵ��� �װ����� �� �����γ����� �ݺ��س� ã�Ƴ��� ����
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
