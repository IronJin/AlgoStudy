package algoprac;

import java.util.*;


//��������
/*
 * ���������̶� �տ���� �ڱ⺸�� ū���� ���������� �����������
 */
public class Insertion_sort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0 ; i < 10 ; i ++) {
			list.add((int) (Math.random()*100));
		}
		
		for(int i = 1 ; i < list.size() ; i++) {
			int min=i;
			for(int j = i-1 ; j  >=0 ;j --) {
				if(list.get(min) < list.get(j)) {
					Collections.swap(list, min, j);
					min = j;
				}else {
					break;
				}
			}
		}
		
		System.out.println(list);
			
	}
}
