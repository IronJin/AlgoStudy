package algoprac;

import java.util.*;

/*
 * ���������̶� n-1 �� ���� ������ ��ҵ��� ���ذ��� �ڸ��� �ٲ��ش�.
 * �� �� outer for���� �ѹ� ����ɶ����� �迭�� �� ������ index �� �̹� ������ ������
 * ���� ū ���� ���� �ǹǷ� ��ĭ�� �ٿ������� ���� ������ ������.
 */
public class bubble_sort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < 10 ; i++) {
			list.add((int) (Math.random()*100));
		}
		
		//���������� �ٽ�
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
		
		//ArrayList �� ��� ����� �޼ҵ��� Collections.sort(); �� ����ص� ��
		Collections.sort(list);
		
		
		System.out.println(list);
	}

}
